package com.interrapidisimo.sistema_logistico.dto;

import com.interrapidisimo.sistema_logistico.model.Envio;

public class EnvioDto {
    private Long id;
    private String cliente;
    private String destino;
    private String estado;
    private double pesoKg;
    private Double costo;

    public EnvioDto(){

    }

    public EnvioDto(Long id, String cliente, String destino, String estado, double pesoKg, Double costo) {
        this.id = id;
        this.cliente = cliente;
        this.destino = destino;
        this.estado = estado;
        this.pesoKg = pesoKg;
        this.costo = costo;
    }

    public static EnvioDto fromEntity(Envio envio){
        return new EnvioDto(
                envio.getId(),
                envio.getCliente(),
                envio.getDestino(),
                envio.getEstado(),
                envio.getPesoKg(),
                envio.getCosto()
        );

    }

    public Envio toEntity(){
    return new Envio(this.cliente,this.destino,this.estado,this.pesoKg);
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


    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
