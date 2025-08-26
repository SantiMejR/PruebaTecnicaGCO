package com.example.PruebaTecnicaFormularioFidelidad.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @Column(name = "Numero_Identificacion")
    private String numeroIdentificacion;

    @ManyToOne
    @JoinColumn(name = "Cod_Identificacion", nullable = false)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "Nombres", nullable = false)
    private String nombres;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "Fecha_Nacimiento", nullable = false)
    private String fechaNacimiento;

    @Column(name = "Direccion", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "Cod_Ciudad", nullable = false)
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "Cod_Departamento", nullable = false)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "Cod_Pais", nullable = false)
    private Pais pais;

    // Getters y setters

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}