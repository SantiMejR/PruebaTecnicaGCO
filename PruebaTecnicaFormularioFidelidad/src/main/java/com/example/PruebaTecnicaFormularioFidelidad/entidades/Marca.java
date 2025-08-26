package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Marca")
    private Long idMarca;

    @Column(name = "Marca", nullable = false)
    private String marca;

    // Getters y setters
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