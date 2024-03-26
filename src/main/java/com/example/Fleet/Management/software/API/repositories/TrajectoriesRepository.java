package com.example.Fleet.Management.software.API.repositories;
import com.example.Fleet.Management.software.API.models.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;



public interface TrajectoriesRepository extends PagingAndSortingRepository<Trajectory, Long> {

        @Query(value = "SELECT * FROM trajectories t WHERE t.taxi_id = :taxi_id AND TO_CHAR(t.date, 'YYYY-MM-DD') = :date", nativeQuery = true)
        Page<Trajectory> findByTaxiIdAndDate(@Param("taxi_id") int taxi_id, @Param("date") String date, Pageable pageable);

        @Query(value = "SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE FROM (SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE, ROW_NUMBER() OVER (PARTITION BY TAXI_ID ORDER BY date DESC) AS rn FROM TRAJECTORIES ) AS subquery WHERE rn = 1", nativeQuery = true)
        List<Trajectory> findLastLocation();


}