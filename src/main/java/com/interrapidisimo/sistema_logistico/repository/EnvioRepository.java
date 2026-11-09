package com.interrapidisimo.sistema_logistico.repository;

import com.interrapidisimo.sistema_logistico.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio,Long> {
    //PREFIJO +PROPIEDAD +PALABRA CLAVE


    List<Envio> findByEstado(String estado);
    List<Envio> findByCliente(String cliente);
    List<Envio> findByClienteAndEstado(String cliente, String estado);
}
