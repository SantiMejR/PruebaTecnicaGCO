package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @Column(name = "Cod_Departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codDepartamento;

    @Column(name = "Departamento", nullable = false)
    private String departamento;

    @ManyToOne
    @JoinColumn(name = "Cod_Pais", nullable = false)
    private Pais pais;

    public Long getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Long codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getDepartamento() {

        return departamento;
    }

    public void setDepartamento(String departamento) {

        this.departamento = departamento;
    }

    public Pais getPais() {

        return pais;
    }

    public void setPais(Pais pais) {

        this.pais = pais;
    }

}