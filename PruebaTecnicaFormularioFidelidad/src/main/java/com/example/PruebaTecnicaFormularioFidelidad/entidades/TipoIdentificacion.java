package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_Identificacion")
public class TipoIdentificacion {

    @Id
    @Column(name = "Cod_Identificacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codIdentificacion;

    @Column(name = "Tipo", nullable = false)
    private String tipo;

    public Long getCodIdentificacion() {
        return codIdentificacion;
    }

    public void setCodIdentificacion(Long codIdentificacion) {
        this.codIdentificacion = codIdentificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}