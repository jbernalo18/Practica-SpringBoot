package com.interrapidisimo.sistema_logistico.model;

public class Envio {

    private String id;
    private String cliente;
    private String destino;
    private String estado;
    private double pesoKg;

    public Envio() {
    }

    public Envio(String id, String cliente, String destino, String estado, double pesoKg) {
        this.id = id;
        this.cliente = cliente;
        this.destino = destino;
        this.estado = estado;
        this.pesoKg = pesoKg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}
