package com.example.PruebaTecnicaFormularioFidelidad.repositorios;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {
    boolean existsByNumeroIdentificacion(String numeroIdentificacion);
}