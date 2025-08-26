package com.example.PruebaTecnicaFormularioFidelidad.repositorios;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.ClientePorMarca;
import com.example.PruebaTecnicaFormularioFidelidad.entidades.ClientePorMarcaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePorMarcaRepositorio extends JpaRepository<ClientePorMarca, ClientePorMarcaPK> {
    boolean existsByNumeroIdentificacionAndIdMarca(String numeroIdentificacion, Long idMarca);
    void deleteByNumeroIdentificacionAndIdMarca(String numeroIdentificacion, Long idMarca);
}