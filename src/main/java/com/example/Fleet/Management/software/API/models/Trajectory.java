package com.example.Fleet.Management.software.API.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "trajectories")

public class Trajectory {


    //Atributos de la entidad o clase
    @Id
    // @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name= "taxi_id")
    private Taxi taxi; //tipo taxi join colum manyToOne ManyToOne - OneToMany - JoinColumn

    // @Column (name= "date")
    private OffsetDateTime date;

    // @Column (name="latitude")
    private double latitude;

    // @Column (name="longitude")
    private double longitude;


    //constructor vacío jpa
    public Trajectory() {}

    //constructor con parámetros
    public Trajectory(long id, Taxi taxi, OffsetDateTime date, double latitude, double longitude) {
        this.id = id;
        this.date=date;
        this.latitude= latitude;
        this.longitude=longitude;
        this.taxi= taxi;
    }

    //Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Taxi getTaxi() { return taxi;}
    public void setTaxi(Taxi taxi) {this.taxi = taxi;}

    public OffsetDateTime getDate() { return date;}

    public void setDate(OffsetDateTime date) {this.date = date;}

    public double getLatitude() {return latitude;}

    public void setLatitude(double latitude) {this.latitude = latitude;}

    public double getLongitude() {return longitude;}

    public void setLongitude(double longitude) {this.longitude = longitude;}
}