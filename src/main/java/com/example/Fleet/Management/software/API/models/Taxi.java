package com.example.Fleet.Management.software.API.models;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="taxis")

public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String plate;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private LocalDateTime timestamp;


    // Getters y setters constructor
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @ManyToOne
    @JoinColumn(name = "taxi_id")
    private Taxi taxi;
}

