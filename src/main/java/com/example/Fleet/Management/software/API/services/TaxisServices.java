package com.example.Fleet.Management.software.API.services;

import com.example.Fleet.Management.software.API.models.Taxi; // Importación de la clase Taxi
import com.example.Fleet.Management.software.API.repositories.TaxisRepository; // Importación de la interfaz TaxisRepository
import org.springframework.beans.factory.annotation.Autowired; // Importación de la anotación Autowired de Spring
import org.springframework.data.domain.Page; // Importación de la clase Page de Spring Data
import org.springframework.data.domain.Pageable; // Importación de la clase Pageable de Spring Data
import org.springframework.stereotype.Service; // Importación de la anotación Service de Spring




@Service // Indica que esta clase es un servicio de Spring
public class TaxisServices {
    private final TaxisRepository taxisRepository; // Inyección de dependencia de TaxisRepository

    @Autowired // Indica que Spring debe inyectar una instancia de TaxisRepository en este servicio
    public TaxisServices (TaxisRepository taxiRepository) {
        this.taxisRepository= taxiRepository; // Inicializa el repositorio de taxis con la instancia proporcionada por Spring
    }
    // Método para obtener todos los taxis paginados
    public Page<Taxi> getAllTaxis(Pageable pageable){

        return taxisRepository.findAll(pageable); // Utiliza el método findAll del repositorio para obtener todos los taxis paginados
    }
}