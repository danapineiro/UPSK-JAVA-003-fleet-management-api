package com.example.Fleet.Management.software.API.controllers;

import com.example.Fleet.Management.software.API.models.Trajectory;
import com.example.Fleet.Management.software.API.services.TrajectoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/trajectories")
public class TrajectoriesController {

    @Autowired
    private TrajectoriesServices trajectoriesServices;

    @Operation(summary = "Obtener todas las trayectorias con paginación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontraron todas las trayectorias",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectory.class)) }),
            @ApiResponse(responseCode = "404", description = "No se encontraron trayectorias"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") })
    @GetMapping
    public ResponseEntity<Page<Trajectory>> getAllTrajectories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Trajectory> trajectories = trajectoriesServices.getAllTrajectories(page, size);
        if (!trajectories.isEmpty()) {
            return ResponseEntity.ok(trajectories);
        } else {
            return ResponseEntity.notFound().build();
        }
}
}