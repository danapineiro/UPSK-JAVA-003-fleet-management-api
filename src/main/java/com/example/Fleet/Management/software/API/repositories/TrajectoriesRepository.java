package com.example.Fleet.Management.software.API.repositories;

import com.example.Fleet.Management.software.API.models.Trajectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectory,Long>{
        }
