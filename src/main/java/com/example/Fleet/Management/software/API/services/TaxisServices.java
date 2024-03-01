// TaxisServices.java
package com.example.Fleet.Management.software.API.services;

import com.example.Fleet.Management.software.API.models.Taxi;
import com.example.Fleet.Management.software.API.repositories.TaxisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaxisServices {

    @Autowired
    private TaxisRepository taxiRepository;

    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }
}
