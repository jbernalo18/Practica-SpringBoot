package com.interrapidisimo.sistema_logistico.dto;

import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.model.Envio;

public class ConductorDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String licencia;
    private String telefono;

    public ConductorDto() {

    }

    public ConductorDto(Long id, String nombre, String apellido, String licencia, String telefono) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.telefono = telefono;
    }


    public static ConductorDto fromEntity(Conductor conductor) {
        return new ConductorDto(
                conductor.getId(),
                conductor.getNombre(),
                conductor.getApellido(),
                conductor.getLicencia(),
                conductor.getTelefono()
        );

    }


    public Conductor toEntity(){
        return new Conductor(this.nombre,this.apellido,this.licencia,this.telefono);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
