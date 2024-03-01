package com.example.Fleet.Management.software.API.models;


import jakarta.persistence.*;

@Entity
@Table(name="trajectories")
public class Trajectory {

    @Id
    @Column
    private Long id;

    @Column
    private Long taxiId;

    @Column
    private String date;

    @Column
    private double longitude;

    @Column
    private double latitude;



    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Long taxiId) {
        this.taxiId = taxiId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
}
}