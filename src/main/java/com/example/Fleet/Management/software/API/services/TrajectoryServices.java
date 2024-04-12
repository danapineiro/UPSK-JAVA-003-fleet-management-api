package com.example.Fleet.Management.software.API.services;
import com.example.Fleet.Management.software.API.models.Trajectory; // Importación de la clase Trajectory
import com.example.Fleet.Management.software.API.repositories.TrajectoriesRepository; // Importación de la interfaz TrajectoriesRepository
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación Autowired de Spring
import org.springframework.data.domain.Page; // Importación de la clase Page de Spring Data
import org.springframework.data.domain.PageRequest; // Importación de la clase PageRequest de Spring Data
import org.springframework.stereotype.Service; // Importación de la anotación Service de Spring
import org.springframework.data.domain.PageImpl; // Importación de la clase PageImpl de Spring Data
import org.springframework.data.domain.Pageable; // Importación de la clase Pageable de Spring Data
import java.util.List; // Importación de la clase List de Java

@Service // Indica que esta clase es un servicio de Spring
public class TrajectoryServices {

    private final TrajectoriesRepository trajectoriesRepository; // Inyección de dependencia de TrajectoriesRepository

    @Autowired // Indica que Spring debe inyectar una instancia de TrajectoriesRepository en este servicio
    public TrajectoryServices(TrajectoriesRepository trajectoriesRepository ) {
        this.trajectoriesRepository = trajectoriesRepository; // Inicializa el repositorio de trayectorias con la instancia proporcionada por Spring
    }

    // Método para obtener todas las trayectorias paginadas
    public Page<Trajectory> getAllTrajectories(Pageable pageable){
        return trajectoriesRepository.findAll(pageable); // Utiliza el método findAll del repositorio para obtener todas las trayectorias paginadas
    }
    // Método para buscar trayectorias por ID de taxi y fecha
    public Page<Trajectory> findByDateAndId(int taxi_id, String dateString, Pageable pageable) {
        return trajectoriesRepository.findByTaxiIdAndDate(taxi_id, dateString, pageable); // Utiliza el método findByTaxiIdAndDate del repositorio para buscar trayectorias por ID de taxi y fecha
    }

    // Método auxiliar para crear una solicitud de página
    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }

    // Método para obtener la última ubicación reportada de cada taxi
    public Page<Trajectory> getLastLocation(int page, int size) {
        Pageable pageRequest = createPageRequestUsing(page, size); // Crea una solicitud de página utilizando el número de página y el tamaño especificados

        List<Trajectory> allCustomers = trajectoriesRepository.findLastLocation(); // Obtiene todas las trayectorias que representan la última ubicación de cada taxi

        int start = (int) pageRequest.getOffset(); // Calcula el índice de inicio para la página actual
        int end = Math.min((start + pageRequest.getPageSize()), allCustomers.size()); // Calcula el índice de fin para la página actual

        List<Trajectory> pageContent = allCustomers.subList(start, end); // Obtiene el contenido de la página actual

        // Método auxiliar para crear una solicitud de página
        List<Trajectory> lastLocation = trajectoriesRepository.findLastLocation();
        return new PageImpl<>( pageContent, pageRequest, lastLocation.size()); // Crea y devuelve una solicitud de página utilizando el número de página y el tamaño especificados
    }
}