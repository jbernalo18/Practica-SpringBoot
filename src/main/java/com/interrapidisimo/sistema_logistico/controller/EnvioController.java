package com.interrapidisimo.sistema_logistico.controller;

import com.interrapidisimo.sistema_logistico.dto.EnvioDto;
import com.interrapidisimo.sistema_logistico.model.Envio;
import com.interrapidisimo.sistema_logistico.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {


    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<EnvioDto> getAllEnvios(@PageableDefault(size = 5,sort="id") Pageable pageable){
        return envioService.findAll(pageable)
                .getContent()
                .stream()
                .map(EnvioDto::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EnvioDto getEnvioById(@PathVariable Long id){
        return EnvioDto.fromEntity(envioService.findById(id));
    }

    @GetMapping("/estado/{estado}")
    public List<EnvioDto> getEnviosByEstado(@PathVariable String estado, Pageable pageable){
        return envioService.findByEstado(estado, pageable)
                .getContent()
                .stream()
                .map(EnvioDto::fromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping
    public EnvioDto createEnvio(@RequestBody EnvioDto envioDto){
        Envio envio= envioDto.toEntity();
        return EnvioDto.fromEntity(envioService.save(envio));
    }

    @PutMapping("/{id}")
    public EnvioDto updateEnvio(@PathVariable Long id, @RequestBody EnvioDto envioDto){
        Envio envio= envioDto.toEntity();
        return EnvioDto.fromEntity(envioService.update(id,envio));
    }

    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Long id){
        envioService.deleteById(id);
    }



}
