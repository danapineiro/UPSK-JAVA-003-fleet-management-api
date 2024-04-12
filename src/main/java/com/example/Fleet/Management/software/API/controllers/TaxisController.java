package com.example.Fleet.Management.software.API.controllers;

import com.example.Fleet.Management.software.API.services.TaxisServices; // Importaciones del servicio TaxisServices
import com.example.Fleet.Management.software.API.models.Taxi; // modelo de taxi
import org.springframework.data.domain.Page; // page para soporte de paginacion
import org.springframework.web.bind.annotation.GetMapping; // maneja las solicitudes GET
import org.springframework.web.bind.annotation.RequestMapping; // mapear las rutas
import org.springframework.web.bind.annotation.RequestParam; // para recibir los parametros de solicitud
import org.springframework.web.bind.annotation.RestController; // para marcar la clase como controlador REST
import org.springframework.data.domain.PageRequest; // para crear objetos pageable
import org.springframework.data.domain.Pageable; // pegeable para soporte de paginacion
import io.swagger.v3.oas.annotations.Operation; // para documentacion de API
import io.swagger.v3.oas.annotations.Parameter; // para descripcion de parametros
import io.swagger.v3.oas.annotations.responses.ApiResponse; // para documentacion de respuesta de API
import io.swagger.v3.oas.annotations.responses.ApiResponses; // para documentacion de respuesta de APi
import io.swagger.v3.oas.annotations.media.Content; // para documentacion de contenido de respuesta de API
import io.swagger.v3.oas.annotations.media.Schema; // para descripcion de esquema de respuesta de API


@RestController
@RequestMapping("/taxi")
public class TaxisController {
    private final TaxisServices taxisServices;
    // Constructor para inyectar el servicio de TaxisServices
    public TaxisController (TaxisServices taxisServices) {

        this.taxisServices = taxisServices;
    }

    //Metodo para obtener todos los taxis con paginacion opcional
    @Operation(summary = "Get all taxis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the taxi",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Taxi.class)) }),
            @ApiResponse(responseCode = "400", description = "Object Taxi invalid",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Taxi not found",
                    content = @Content)
    })


    @GetMapping("/all") // mapeo para solicitudes Get a /taxi/all
    public Page<Taxi> getAllTaxis( @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
                                   @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {


        Pageable pageable = PageRequest.of(page, size); // Crear objeto Pegeable para paginacion
        return taxisServices.getAllTaxis(pageable); // Llamar al servicio para obtener los taxis
    }

}