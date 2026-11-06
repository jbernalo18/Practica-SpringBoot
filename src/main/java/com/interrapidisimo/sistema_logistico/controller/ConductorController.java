package com.interrapidisimo.sistema_logistico.controller;


import com.interrapidisimo.sistema_logistico.model.Conductor;
import com.interrapidisimo.sistema_logistico.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping ("/api/conductores")
public class ConductorController {
    private final ConductorService conductorService;

    @Autowired
    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @GetMapping
    public List<Conductor> getAllConductors(){
    return conductorService.findAll();
    }

    @GetMapping ("/{id}")
    public Conductor getConductorById(@PathVariable String id){
        return conductorService.findById(id);
    }

    @GetMapping ("/licencias/{licencia}")
    public List<Conductor> getConductorByLicencia(@PathVariable String licencia){
        return conductorService.findByLicencia(licencia);
    }

    @DeleteMapping("/{id}")
    public String deleteConductorById(@PathVariable String id){
        conductorService.deleteById(id);
        return "Borrado correctamente";
    }

    @PostMapping
    public Conductor agregarNuevoConductor(@RequestBody Conductor conductorNuevo){
        return conductorService.save(conductorNuevo);
    }

    @PutMapping("/{id}")
    public Conductor actualizarConductor(@PathVariable String id, @RequestBody Conductor conductorAct){
        return conductorService.update(id,conductorAct);
    }




}
