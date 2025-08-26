package com.example.PruebaTecnicaFormularioFidelidad.modelos;

public class DepartamentoModelo {
    private Integer id;
    private String nombre;

    public DepartamentoModelo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}