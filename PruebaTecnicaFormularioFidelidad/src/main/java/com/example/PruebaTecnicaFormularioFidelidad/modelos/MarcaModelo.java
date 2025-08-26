package com.example.PruebaTecnicaFormularioFidelidad.modelos;

public class MarcaModelo {

    private Long idMarca;
    private String marca;

    // Constructor
    public MarcaModelo(Long idMarca, String marca) {
        this.idMarca = idMarca;
        this.marca = marca;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}