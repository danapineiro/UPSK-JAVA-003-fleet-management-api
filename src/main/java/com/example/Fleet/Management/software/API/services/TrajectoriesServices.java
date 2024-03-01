package com.example.Fleet.Management.software.API.services;

import com.example.Fleet.Management.software.API.models.Trajectory;
import com.example.Fleet.Management.software.API.repositories.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrajectoriesServices {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public List<Trajectory> getAllTrajectories() {
        return trajectoriesRepository.findAll();
    }
}
