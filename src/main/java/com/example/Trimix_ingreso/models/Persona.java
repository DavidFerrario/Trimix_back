package com.example.Trimix_ingreso.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "personas")
public class Persona {
    private static final long serialVersionID = 1L;

    @Column(name = "perapellido")
    private String perApellido;

    @Column(name = "perfechanacimiento")
    private Date perFechaNacimiento;

    @Column(name = "perid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perId;

    @Column(name = "pernombre")
    private String perNombre;

    @Column(name = "pernumerodocumento")
    private Long perNumeroDocumento;

    @Column(name = "pertipodocumento")
    private String perTipoDocumento;

}
