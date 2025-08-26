package com.example.PruebaTecnicaFormularioFidelidad.repositorios;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad, Long> {
    boolean existsByCiudad(String ciudad);
}