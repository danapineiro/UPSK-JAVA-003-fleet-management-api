package com.example.Fleet.Management.software.API.controllers;

import com.example.Fleet.Management.software.API.models.Trajectory;
import com.example.Fleet.Management.software.API.services.TrajectoryServices;
import com.example.Fleet.Management.software.API.services.TaxisServices;
import com.example.Fleet.Management.software.API.models.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
@RequestMapping("/taxi")
public class TaxisController {
    private final TaxisServices taxisServices;
    public TaxisController (TaxisServices taxisServices) {

        this.taxisServices = taxisServices;
    }

    //agregar documentación
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


    @GetMapping("/all")
    public Page<Taxi> getAllTaxis( @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
                                   @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {


        Pageable pageable = PageRequest.of(page, size);
        return taxisServices.getAllTaxis(pageable);
    }

}