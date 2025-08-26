package com.example.PruebaTecnicaFormularioFidelidad.controlador;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.TipoIdentificacion;
import com.example.PruebaTecnicaFormularioFidelidad.modelos.TipoIdentificacionModelo;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.TipoIdentificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos-identificacion")
public class TipoIdentificacionControlador {

    @Autowired
    private TipoIdentificacionRepositorio tipoIdentificacionRepositorio;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TipoIdentificacion tipo) {
        String nombre = tipo.getTipo();

        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del tipo de identificación no puede estar vacío.");
        }

        if (tipoIdentificacionRepositorio.existsByTipo(nombre)) {
            return ResponseEntity.badRequest().body("Ya existe un tipo de identificación con ese nombre.");
        }

        TipoIdentificacion nuevo = tipoIdentificacionRepositorio.save(tipo);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TipoIdentificacionModelo>> listar() {
        List<TipoIdentificacionModelo> tipos = tipoIdentificacionRepositorio.findAll().stream()
                .map(t -> new TipoIdentificacionModelo(Math.toIntExact(t.getCodIdentificacion()), t.getTipo()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(tipos);
    }
}