package com.example.Fleet.Management.software.API.repositories;
import com.example.Fleet.Management.software.API.models.Trajectory; // Importación de la clase Trajectory
import org.springframework.data.domain.Page; // Importación de la clase Page de Spring Data
import org.springframework.data.domain.Pageable; // Importación de la clase Pageable de Spring Data
import org.springframework.data.jpa.repository.Query; // Importación de la anotación Query de Spring Data
import org.springframework.data.repository.PagingAndSortingRepository; // Importación de la interfaz PagingAndSortingRepository de Spring Data
import org.springframework.data.repository.query.Param; // Importación de la anotación Param de Spring Data
import java.util.List; // Importación de la clase List de Java




// Definición de la interfaz TrajectoriesRepository que extiende PagingAndSortingRepository
public interface TrajectoriesRepository extends PagingAndSortingRepository<Trajectory, Long> {

        // Consulta personalizada para buscar trayectorias por ID de taxi y fecha
        @Query(value = "SELECT * FROM trajectories t WHERE t.taxi_id = :taxi_id AND TO_CHAR(t.date, 'YYYY-MM-DD') = :date", nativeQuery = true)
        Page<Trajectory> findByTaxiIdAndDate(@Param("taxi_id") int taxi_id, @Param("date") String date, Pageable pageable);

        // Consulta personalizada para encontrar la última ubicación reportada de cada taxi
        @Query(value = "SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE FROM (SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE, ROW_NUMBER() OVER (PARTITION BY TAXI_ID ORDER BY date DESC) AS rn FROM TRAJECTORIES ) AS subquery WHERE rn = 1", nativeQuery = true)
        List<Trajectory> findLastLocation();


}