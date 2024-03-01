package com.example.Fleet.Management.software.API.models;


import jakarta.persistence.*;


@Entity
@Table(name="taxis")

public class Taxi {

    @Id
    @Column
    private Long id;

    @Column
    private String plate;



    // Getters y setters
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
