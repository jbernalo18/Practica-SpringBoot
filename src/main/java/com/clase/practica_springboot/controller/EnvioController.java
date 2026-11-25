package com.clase.practica_springboot.controller;

import com.clase.practica_springboot.model.Envio;
import com.clase.practica_springboot.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/envios")
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

    @PostMapping
    public Envio saveEnvio(@RequestBody Envio envio){
        return envioService.save(envio);
    }


    @PutMapping("/{id}")
    public Envio updateEnvio(@PathVariable String id, @RequestBody Envio envio){
        return envioService.update(id, envio);
    }

    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable String id){
        envioService.deletebyId(id);
    }
    @GetMapping("/estados/{estado}")
    public List<Envio> getEnvioByEstado(@PathVariable String estado){
        return envioService.findByEstado(estado);
    }


}
