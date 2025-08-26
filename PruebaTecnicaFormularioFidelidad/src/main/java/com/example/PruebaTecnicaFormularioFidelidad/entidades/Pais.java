package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Pais")
public class Pais {

    @Id
    @Column(name = "Cod_Pais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPais;

    @Column(name = "Pais", nullable = false)
    private String pais;

    public Long getCodPais() {
        return codPais;
    }

    public void setCodPais(Long codPais) {

        this.codPais = codPais;
    }

    public String getPais() {

        return pais;
    }

    public void setPais(String pais) {

        this.pais = pais;
    }

}