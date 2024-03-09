// TaxisController.java
package com.example.Fleet.Management.software.API.controllers;
import com.example.Fleet.Management.software.API.services.TaxisServices;
import com.example.Fleet.Management.software.API.models.Taxi;
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
@RequestMapping("/api/taxis")
public class TaxisController {

    @Autowired
    private TaxisServices taxisServices;

    @Operation(summary = "Obtener todos los taxis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontraron todos los taxis",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Taxi.class)) }) })

    @GetMapping
    public List<Taxi> getAllTaxis() {
        return taxisServices.getAllTaxis();
}
}