package com.example.Fleet.Management.software.API.models;

import jakarta.persistence.*; // Importaciones de JPA

import java.time.OffsetDateTime; // Importación para trabajar con fechas y hora

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "trajectories") // Especifica el nombre de la tabla en la base de datos

public class Trajectory {


    // Atributos de la clase
    @Id // Indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente valores únicos para la clave primaria
    private long id; // Identificador único de la trayectoria

    @ManyToOne() // Relación many-to-one con la clase Taxi
    @JoinColumn(name= "taxi_id") // Especifica la columna en la tabla para la clave foránea
    private Taxi taxi; // Taxi asociado a esta trayectoria

    // @Column (name= "date")
    private OffsetDateTime date; // Fecha y hora de la trayectoria

    // @Column (name="latitude")
    private double latitude; // Latitud de la ubicación de la trayectoria

    // @Column (name="longitude")
    private double longitude; // Longitud de la ubicación de la trayectoria


    //constructor vacío REQUERIDO jpa
    public Trajectory() {}

    //constructor con parámetros PARA INICIALIZAR TODOS LOS ATRIBUTOS
    public Trajectory(long id, Taxi taxi, OffsetDateTime date, double latitude, double longitude) {
        this.id = id;
        this.date=date;
        this.latitude= latitude;
        this.longitude=longitude;
        this.taxi= taxi;
    }

    //Getters y setters PARA ACCEDER Y MODIFICAR LOS ATRIBUTOS
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

    public void setLongitude(double longitude) {this.longitude=longitude;}
}