package com.example.PruebaTecnicaFormularioFidelidad.repositorios;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Long> {
    boolean existsByPais(String pais);
}