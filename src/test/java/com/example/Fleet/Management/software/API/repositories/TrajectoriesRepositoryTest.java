package com.example.Fleet.Management.software.API.repositories;
import com.example.Fleet.Management.software.API.models.Trajectory; // Importa la clase Trajectory
import org.junit.jupiter.api.Test; // Importa la anotación Test de JUnit
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired de Spring
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // Importa la anotación AutoConfigureMockMvc de Spring Boot
import org.springframework.boot.test.context.SpringBootTest; // Importa la anotación SpringBootTest de Spring Boot
import org.springframework.boot.test.mock.mockito.MockBean; // Importa la anotación MockBean de Spring Boot
import org.springframework.data.domain.Pageable; // Importa la clase Pageable de Spring Data
import org.springframework.test.web.servlet.MockMvc; // Importa la clase MockMvc de Spring Test
import java.util.ArrayList; // Importa la clase ArrayList de Java
import java.util.List; // Importa la clase List de Java
import static org.mockito.Mockito.when; // Importa el método when() de Mockito
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Importa el método get() de MockMvc para realizar solicitudes HTTP GET
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Importa el método jsonPath() de MockMvc para verificar el contenido JSON en las respuestas
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Importa el método status() de MockMvc para verificar el estado de las respuestas HTTP

@SpringBootTest // Indica que este es un test de Spring Boot
@AutoConfigureMockMvc // Configura automáticamente MockMvc
class TrajectoriesRepositoryTest {

    @Autowired // Inyecta MockMvc
    private MockMvc mvc;

    @MockBean // Crea un mock de TrajectoriesRepository
    private TrajectoriesRepository trajectoriesRepository;

    @Test // Marca el siguiente método como un método de prueba
    void testLastTrajectories() throws Exception{
        Pageable pageable = Pageable.ofSize(1).withPage(1); // Crea una instancia de Pageable con un tamaño de página de 1 y una página de 1
        List<Trajectory> trajectories = new ArrayList<>(); // Crea una lista de trayectorias vacía
        trajectories.add(new Trajectory()); // Agrega una trayectoria a la lista
        trajectories.add(new Trajectory()); // Agrega otra trayectoria a la lista
        trajectories.add(new Trajectory()); // Agrega una tercera trayectoria a la lista
        when(trajectoriesRepository.findLastLocation()).thenReturn(trajectories); // Configura el comportamiento del mock: cuando se llame a findLastLocation(), devuelve la lista de trayectorias

        this.mvc.perform(get("/trajectory/last-Location") // Realiza una solicitud HTTP GET a la ruta /trajectory/last-Location
                        .param("Page", "1") // Agrega el parámetro Page con el valor 1
                        .param("Size", "1")) // Agrega el parámetro Size con el valor 1
                .andExpect(status().isOk()) // Espera que el estado de la respuesta sea OK (200)
                .andExpect(jsonPath("$.content").isArray()) // Espera que el contenido de la respuesta tenga la propiedad "content" que es un array
                .andExpect(jsonPath("$.content.length()").value(trajectories.size())) // Espera que la longitud del array "content" en la respuesta sea igual al tamaño de la lista de trayectorias
                .andReturn(); // Devuelve el resultado de la solicitud



    }

}