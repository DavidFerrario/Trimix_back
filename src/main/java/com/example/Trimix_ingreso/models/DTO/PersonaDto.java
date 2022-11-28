package com.example.Trimix_ingreso.models.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaDto {
    private String perApellido;
    private Date perFechaNacimiento;
    private String perNombre;
    private Long perNumeroDocumento;
    private String perTipoDocumento;
}
