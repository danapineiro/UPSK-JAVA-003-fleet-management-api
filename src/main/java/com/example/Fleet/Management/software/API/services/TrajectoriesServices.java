package com.example.Fleet.Management.software.API.services;

import org.springframework.data.domain.Page;
import com.example.Fleet.Management.software.API.models.Trajectory;
import com.example.Fleet.Management.software.API.repositories.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TrajectoriesServices {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public Page<Trajectory> getAllTrajectories(int page, int size) {
        return trajectoriesRepository.findAll(PageRequest.of(page,size));
}
}