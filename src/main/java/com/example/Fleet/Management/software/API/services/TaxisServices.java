package com.example.Fleet.Management.software.API.services;

import com.example.Fleet.Management.software.API.models.Taxi;
import com.example.Fleet.Management.software.API.repositories.TaxisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class TaxisServices {
    private final TaxisRepository taxisRepository;

    @Autowired
    public TaxisServices (TaxisRepository taxiRepository) {
        this.taxisRepository= taxiRepository;
    }

    public Page<Taxi> getAllTaxis(Pageable pageable){

        return taxisRepository.findAll(pageable);
    }
}