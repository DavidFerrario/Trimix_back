package com.example.Trimix_ingreso.services;

import com.example.Trimix_ingreso.models.DTO.PersonaDto;
import com.example.Trimix_ingreso.models.Persona;
import com.example.Trimix_ingreso.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repository;

    public void altaPersona(Persona persona){
        repository.save(persona);
    }
    public Optional<List<Persona>> buscarPorNombreYTipoDocumento(String nombre, String tipoDocumento) throws Exception {
       try{
           Optional<List<Persona>> listaPersonas = repository.findByPerNombreAndPerTipoDocumento(nombre, tipoDocumento);
            if (listaPersonas.isPresent()){
                return listaPersonas;
            }
       }catch (Exception e){
           throw new Exception("no hay coincidencias", e);
       }
       return null;
    }
    public Persona crearPersona (PersonaDto persona){
        Persona personaNueva = new Persona();
        personaNueva.setPerApellido(persona.getPerApellido());
        personaNueva.setPerFechaNacimiento(persona.getPerFechaNacimiento());
        personaNueva.setPerNombre(persona.getPerNombre());
        personaNueva.setPerNumeroDocumento(persona.getPerNumeroDocumento());
        personaNueva.setPerTipoDocumento(persona.getPerTipoDocumento());
        return repository.save(personaNueva);
    }
    public Persona modificarPersona(Long id, PersonaDto persona) throws Exception {
        Optional<Persona> personaEncontrada = this.repository.findById(id);
        if (personaEncontrada.isPresent()) {
            personaEncontrada.get().setPerId(id);
            personaEncontrada.get().setPerApellido(persona.getPerApellido());
            personaEncontrada.get().setPerFechaNacimiento(persona.getPerFechaNacimiento());
            personaEncontrada.get().setPerNombre(persona.getPerNombre());
            personaEncontrada.get().setPerNumeroDocumento(persona.getPerNumeroDocumento());
            personaEncontrada.get().setPerTipoDocumento(persona.getPerTipoDocumento());
            return repository.save(personaEncontrada.get());
        } else {
            throw new Exception("None Element found with id:" + id);
        }
    }

    public boolean eliminarPersona(Long id) {
        boolean response = false;
        Optional<Persona> persona = this.repository.findById(id);
        if (persona.isPresent()) {
            Persona personaEliminar = new Persona();
            personaEliminar.setPerId(id);
            this.repository.delete(personaEliminar);
            response = true;
        }
        return response;
    }
}
