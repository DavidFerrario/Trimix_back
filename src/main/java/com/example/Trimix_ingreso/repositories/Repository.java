package com.example.Trimix_ingreso.repositories;

import com.example.Trimix_ingreso.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends  JpaRepository<Persona, Long>{

    public Optional<List<Persona>> findByPerNombreAndPerTipoDocumento(String nombre, String tipoDocumento);

}
