package com.example.Trimix_ingreso.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tipodocumento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column(name = "tipodocumento")
    private  String tipoDocumento;

}
