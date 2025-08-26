package com.example.PruebaTecnicaFormularioFidelidad.modelos;

public class ClienteModelo {
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String nombres;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;
    private String ciudad;
    private String departamento;
    private String pais;

    public ClienteModelo(String numeroIdentificacion, String tipoIdentificacion, String nombres,
                         String apellido, String fechaNacimiento, String direccion,
                         String ciudad, String departamento, String pais) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombres = nombres;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getPais() {
        return pais;
    }
}