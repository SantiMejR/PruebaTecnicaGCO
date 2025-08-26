package com.example.PruebaTecnicaFormularioFidelidad.controlador;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Pais;
import com.example.PruebaTecnicaFormularioFidelidad.modelos.PaisModelo;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paises")
public class PaisControlador {

    @Autowired
    private PaisRepositorio paisRepositorio;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Pais pais) {
        String nombre = pais.getPais();

        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del país no puede estar vacío.");
        }

        if (paisRepositorio.existsByPais(nombre)) {
            return ResponseEntity.badRequest().body("Ya existe un país con ese nombre.");
        }

        Pais nuevo = paisRepositorio.save(pais);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<PaisModelo>> listar() {
        List<PaisModelo> paises = paisRepositorio.findAll().stream()
                .map(p -> new PaisModelo(Math.toIntExact(p.getCodPais()), p.getPais()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(paises);
    }
}