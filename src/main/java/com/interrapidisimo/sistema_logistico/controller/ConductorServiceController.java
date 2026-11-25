package com.interrapidisimo.sistema_logistico.controller;

import com.interrapidisimo.sistema_logistico.dto.ConductorEnvioDto;
import com.interrapidisimo.sistema_logistico.model.ConductorEnvio;
import com.interrapidisimo.sistema_logistico.service.ConductorEnvioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asignaciones")
public class ConductorServiceController {

    private final ConductorEnvioService conductorEnvioService;

    public ConductorServiceController(ConductorEnvioService conductorEnvioService) {
        this.conductorEnvioService = conductorEnvioService;
    }

    @PostMapping
    public ConductorEnvioDto asignar(@RequestParam Long envioId,
                                     @RequestParam Long conductorId,
                                     @RequestParam String responsable,
                                     @RequestParam(required = false) String observaciones) {
        return ConductorEnvioDto.fromEntity(conductorEnvioService.asignarConductorAEnvio(envioId, conductorId, responsable, observaciones));
    }


}
