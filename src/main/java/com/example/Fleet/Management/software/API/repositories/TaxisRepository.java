package com.example.Fleet.Management.software.API.repositories;
import com.example.Fleet.Management.software.API.models.Taxi;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TaxisRepository extends PagingAndSortingRepository<Taxi, Long> {



}