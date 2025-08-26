package com.example.PruebaTecnicaFormularioFidelidad.modelos;

public class ClientePorMarcaModelo {

    private String numeroIdentificacion;
    private Long idMarca;

    public ClientePorMarcaModelo() {}

    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

}