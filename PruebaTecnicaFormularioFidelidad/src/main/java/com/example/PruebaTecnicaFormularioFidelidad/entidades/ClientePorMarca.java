package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Clientes_PorMarca")
@IdClass(ClientePorMarcaPK.class)
public class ClientePorMarca implements Serializable {

    @Id
    @Column(name = "Numero_Identificacion", nullable = false)
    private String numeroIdentificacion;

    @Id
    @Column(name = "Id_Marca", nullable = false)
    private Long idMarca;

    public ClientePorMarca() {

    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

}