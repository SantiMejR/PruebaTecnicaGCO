package com.example.PruebaTecnicaFormularioFidelidad.repositorios;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {
    boolean existsByDepartamento(String departamento);
}