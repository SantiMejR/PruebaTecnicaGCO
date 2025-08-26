package com.example.PruebaTecnicaFormularioFidelidad.repositorios;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoIdentificacionRepositorio extends JpaRepository<TipoIdentificacion, Long> {
    boolean existsByTipo(String tipo);
}