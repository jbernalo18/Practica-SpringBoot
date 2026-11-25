package com.interrapidisimo.sistema_logistico.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private String estado;

    @Column(name = "peso_kg", nullable = false)
    private double pesoKg;


    private double costo;

    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConductorEnvio> asignaciones = new ArrayList<>();

    public Envio() {
    }

    public Envio(String cliente, String destino, String estado, double pesoKg, double costo) {
        this.cliente = cliente;
        this.destino = destino;
        this.estado = estado;
        this.pesoKg = pesoKg;
        this.costo = costo;
    }

    public Envio(String cliente, String destino, String estado, double pesoKg) {
        this.cliente = cliente;
        this.destino = destino;
        this.estado = estado;
        this.pesoKg = pesoKg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}