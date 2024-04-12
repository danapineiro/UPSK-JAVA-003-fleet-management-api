package com.example.Fleet.Management.software.API.models;


import jakarta.persistence.*; // Importación de las anotaciones de JPA



@Entity // indica que esta clase es una entidad JPA
@Table(name = "taxis") // Especifica el nombre de la tabla en la base de datos
public class Taxi {


    @Id // Indica que este atributo es la clave primaria
    @Column(name= "id") // Especifica el nombre de la columna en la tabla
    private Long id; // Identificador único del taxi

    @Column(name= "plate") // Especifica el nombre de la columna en la tabla
    private String plate; // Matrícula del taxi


    // Constructor vacío requerido por JPA
    public Taxi() {}

    // Constructor con parámetros para inicializar todos los atributos
    public Taxi(Long id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    // Getters y setters para acceder y modificar los atributos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}