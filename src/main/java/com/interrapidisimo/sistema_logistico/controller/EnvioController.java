package com.interrapidisimo.sistema_logistico.controller;

import com.interrapidisimo.sistema_logistico.model.Envio;
import com.interrapidisimo.sistema_logistico.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {


    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<Envio> getAllEnvios(){
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    public Envio getEnvioById(@PathVariable String id){
        return envioService.findById(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Envio> getEnviosByEstado(@PathVariable String estado){
        return envioService.findByEstado(estado);
    }

    @PostMapping
    public Envio createEnvio(@RequestBody Envio envio){
        return envioService.save(envio);
    }

    @PutMapping("/{id}")
    public Envio updateEnvio(@PathVariable String id, @RequestBody Envio envio){
        return envioService.update(id,envio);
    }

    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable String id){
        envioService.deleteById(id);
    }



}
