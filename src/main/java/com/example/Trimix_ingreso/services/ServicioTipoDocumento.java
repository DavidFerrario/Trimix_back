package com.example.Trimix_ingreso.services;

import com.example.Trimix_ingreso.models.TipoDocumento;
import com.example.Trimix_ingreso.repositories.RepositorioTipoDocumneto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTipoDocumento {
    @Autowired
    RepositorioTipoDocumneto repositorioTipoDocumento;

    public List<TipoDocumento> tiposDeDocumentos() throws Exception{
        try{
            List<TipoDocumento> listaDocumentos = repositorioTipoDocumento.findAll();
            if(!listaDocumentos.isEmpty()){
                return listaDocumentos;
            }
        }catch (Exception e){
            throw new Exception("No se encontraron tipos de documentos", e);
        }
        return null;
    }
}
