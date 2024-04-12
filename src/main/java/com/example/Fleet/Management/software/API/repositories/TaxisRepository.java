package com.example.Fleet.Management.software.API.repositories;
import com.example.Fleet.Management.software.API.models.Taxi; // Importación de la clase Taxi
import org.springframework.data.repository.PagingAndSortingRepository; // Importación de la interfaz PagingAndSortingRepository de Spring Data

// Definición de la interfaz TaxisRepository que extiende PagingAndSortingRepository

public interface TaxisRepository extends PagingAndSortingRepository<Taxi, Long> {



}