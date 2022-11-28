package com.example.Trimix_ingreso.controllers;

import com.example.Trimix_ingreso.models.DTO.PersonaDto;
import com.example.Trimix_ingreso.models.Persona;
import com.example.Trimix_ingreso.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/nombre/{nombre}/{tipoDocumento}")
    public Optional<List<Persona>> filtro(@PathVariable String nombre, @PathVariable String tipoDocumento){

        try {
            return service.buscarPorNombreYTipoDocumento(nombre, tipoDocumento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/")
    private ResponseEntity<?> crearPersona(@RequestBody PersonaDto persona){
        try {
            return new ResponseEntity<>(this.service.crearPersona(persona), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage() ,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPersona(@RequestBody PersonaDto persona, @PathVariable Long id){
        try {
            return new ResponseEntity<>(this.service.modificarPersona(id,persona), HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Long id){
        return new ResponseEntity<>(this.service.eliminarPersona(id), HttpStatus.OK);
    }

}
