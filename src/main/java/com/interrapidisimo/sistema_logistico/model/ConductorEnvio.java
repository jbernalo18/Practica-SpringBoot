package com.interrapidisimo.sistema_logistico.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "conductor_envio")
public class ConductorEnvio {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envio_id", nullable = false)
    private Envio envio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductor;

    @Column(name="fecha_asignacion", nullable = false)
    private LocalDate fechaAsignacion;

    @Column(nullable = false)
    private String responsable;

    @Column(length = 500)
    private String observaciones;



    public ConductorEnvio(){

    }

    public ConductorEnvio(Envio envio, Conductor conductor, LocalDate fechaAsignacion, String responsable, String observaciones) {
        this.envio = envio;
        this.conductor = conductor;
        this.fechaAsignacion = fechaAsignacion;
        this.responsable = responsable;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
