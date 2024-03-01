package com.example.Fleet.Management.software.API.controllers;

import com.example.Fleet.Management.software.API.models.Trajectory;
import com.example.Fleet.Management.software.API.services.TrajectoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@RestController
@RequestMapping("/api/trajectories")
public class TrajectoriesController {

    @Autowired
    private TrajectoriesServices trajectoriesServices;

    @Operation(summary = "Obtener todas las trayectorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontraron todas las trayectorias",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Trajectory.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    @GetMapping
    public List<Trajectory> getAllTrajectories() {
        try {
            return trajectoriesServices.getAllTrajectories();
        } catch (Exception e) {
            // Manejo de errores, podrías loguear el error y devolver un mensaje de error adecuado
            throw new RuntimeException("Error al recuperar las trayectorias", e);
        }
    }
}
