package com.example.Trimix_ingreso.controllers;


import com.example.Trimix_ingreso.models.TipoDocumento;
import com.example.Trimix_ingreso.services.ServicioTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerTipoDocumento {

    @Autowired
    ServicioTipoDocumento servicioTipoDocumento;

    @GetMapping("/tipodocumento")
    public List<TipoDocumento> tiposDeDocumentos() throws Exception{
        return servicioTipoDocumento.tiposDeDocumentos();
    }

}
