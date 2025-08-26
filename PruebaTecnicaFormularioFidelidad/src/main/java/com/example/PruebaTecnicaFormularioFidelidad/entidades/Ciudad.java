package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Ciudad")
public class Ciudad {

    @Id
    @Column(name = "Cod_Ciudad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCiudad;

    @Column(name = "Ciudad", nullable = false)
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "Cod_Departamento", nullable = false)
    private Departamento departamento;

    public Long getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Long codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}