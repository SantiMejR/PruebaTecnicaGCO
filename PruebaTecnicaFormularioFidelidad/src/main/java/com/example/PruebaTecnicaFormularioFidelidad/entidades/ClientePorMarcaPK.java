package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import java.io.Serializable;
import java.util.Objects;

public class ClientePorMarcaPK implements Serializable {

    private String numeroIdentificacion;
    private Long idMarca;

    public ClientePorMarcaPK() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientePorMarcaPK)) return false;
        ClientePorMarcaPK that = (ClientePorMarcaPK) o;
        return Objects.equals(numeroIdentificacion, that.numeroIdentificacion) &&
                Objects.equals(idMarca, that.idMarca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroIdentificacion, idMarca);
    }
}