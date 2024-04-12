package com.example.Fleet.Management.software.API.controllers;
// Importaciones de clases
import com.example.Fleet.Management.software.API.models.Trajectory; // Importación del modelo Trajectory
import com.example.Fleet.Management.software.API.services.TrajectoryServices; // Importación del servicio TrajectoryServices
import io.swagger.v3.oas.annotations.Parameter; // Importación de Parameter para descripción de parámetros en Swagger
import org.springframework.beans.factory.annotation.Autowired; // Importación para la anotación Autowired
import org.springframework.data.domain.Page; // Importación de Page para soporte de paginación
import org.springframework.web.bind.annotation.GetMapping; // Importación de GetMapping para manejar solicitudes GET
import org.springframework.web.bind.annotation.RequestMapping; // Importación de RequestMapping para mapear rutas
import org.springframework.web.bind.annotation.RequestParam; // Importación de RequestParam para recibir parámetros de solicitud
import org.springframework.web.bind.annotation.RestController; // Importación de RestController para marcar la clase como controlador REST
import io.swagger.v3.oas.annotations.Operation; // Importación de Operation para documentación de API en Swagger
import io.swagger.v3.oas.annotations.responses.ApiResponse; // Importación de ApiResponse para documentación de respuestas de API en Swagger
import io.swagger.v3.oas.annotations.responses.ApiResponses; // Importación de ApiResponses para documentación de respuestas de API en Swagger
import io.swagger.v3.oas.annotations.media.Content; // Importación de Content para documentación de contenido de respuesta de API en Swagger
import io.swagger.v3.oas.annotations.media.Schema; // Importación de Schema para descripción de esquema de respuesta de API en Swagger
import org.springframework.data.domain.Pageable; // Importación de Pageable para soporte de paginación
import org.springframework.data.domain.PageRequest; // Importación de PageRequest para crear objetos Pageable

// Indica que esta clase es un controlador REST y su ruta base
@RestController
@RequestMapping("/trajectory")
public class TrajectoriesController {
    // Inyección de dependecia del servicio de trayectorias
    @Autowired
    private final TrajectoryServices trajectoriesServices;

    // Constructor que recibe una instancia de TrajectoryServices
    public TrajectoriesController (TrajectoryServices trajectoriesServices) {
        this.trajectoriesServices= trajectoriesServices;
    }

    // Documentación y mapeo para obtener todas las trayectorias paginadas
    @Operation(summary = "Get-All-Trajectory") // descripcion de la operacion para swagger
    @ApiResponses(value = { // definicion de posibles respuestas de la API para documentacion de swagger
            @ApiResponse(responseCode = "200", description = "Found the trajectories", // respuesta exitosa
                    content = { @Content(mediaType = "application/json", // tipo de contenido
                            schema = @Schema(implementation = Trajectory.class)) }), // esquema de la respuesta
            @ApiResponse(responseCode = "400", description = "Object trajectories invalid", // error de solicitud invalida
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Trajectories not found", // trayectorias no encontradas
                    content = @Content)
    })


    @GetMapping("/all") // mapeo para solicitudes GET a trajectory all
    public Page<Trajectory> getAllTrajectories (@Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
                                                @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {


        Pageable pageable = PageRequest.of(page, size); //  creacion de objeto pageable para paginacion
        return trajectoriesServices.getAllTrajectories (pageable); // llamada al servicio para obtener todas trayectorias
    }
// Documentación y mapeo para obtener trayectorias por ID de taxi y fecha
    @Operation(summary = "Get-Locations-Of-A-Taxi-By-ID-And-Date") // descripcion de la operacion para documentacion en swagger
    @ApiResponses(value = { // Definición de posibles respuestas de la API para documentación en Swagger
            @ApiResponse(responseCode = "200", description = "Found the taxi locations", // Respuesta exitosa
                    content = { @Content(mediaType = "application/json", // Tipo de contenido
                            schema = @Schema(implementation = Trajectory.class)) }), // Esquema de la respuesta

            @ApiResponse(responseCode = "404", description = "Taxi locations not found", // Ubicaciones de taxi no encontradas
                    content = @Content)
    })

    //mapeo para solicitudes GET por id y fecha
    @GetMapping ("byDateAndId")
    public Page<Trajectory> findByDateAndId (

            @Parameter(description = "Taxi ID") @RequestParam(name = "taxi_id") int taxi_id, // parametro por ID
            @Parameter(description = "Date in format YYYY-MM-DD") @RequestParam (name = "date") String dateString , // parametro de fecha
            @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page, // parametro por numero de pagina
            @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) { // parametro tamaño de pagina
// creación de objeto pageable para paginación
        Pageable pageable = PageRequest.of(page, size);
        // llamada al servicio para obtener trayectorias por ID de taxi y fecha
        return trajectoriesServices.findByDateAndId (taxi_id, dateString,pageable);
    }

    //Documentación y mapeo para obtener la última ubicación reportada de cada taxi
    @Operation(summary = "Get-Last-Locations ") // Descripción de la operación para documentación en Swagger
    @ApiResponses(value = { // Definición de posibles respuestas de la API para documentación en Swagger
            @ApiResponse(responseCode = "200", description = "Found the taxi last locations", // Respuesta exitosa
                    content = { @Content(mediaType = "application/json", // Tipo de contenido
                            schema = @Schema(implementation = Trajectory.class)) }), // Esquema de la respuesta

            @ApiResponse(responseCode = "404", description = "Taxi last locations not found", // Últimas ubicaciones de taxi no encontradas
                    content = @Content)
    })


    @GetMapping ("last-Location")
    public Page<Trajectory> getLastLocation (


            @Parameter(description = "Page number, default is 0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page, default is 10") @RequestParam(defaultValue = "10") int size) {


        return trajectoriesServices.getLastLocation(page, size);
}


}