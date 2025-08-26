package com.example.PruebaTecnicaFormularioFidelidad.controlador;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Departamento;
import com.example.PruebaTecnicaFormularioFidelidad.modelos.DepartamentoModelo;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.DepartamentoRepositorio;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoControlador {

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Autowired
    private PaisRepositorio paisRepositorio;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Departamento departamento) {
        String nombre = departamento.getDepartamento();

        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del departamento no puede estar vacío.");
        }

        if (departamento.getPais() == null || departamento.getPais().getCodPais() == null) {
            return ResponseEntity.badRequest().body("Debe especificar un país válido.");
        }

        if (!paisRepositorio.existsById(departamento.getPais().getCodPais())) {
            return ResponseEntity.badRequest().body("El país especificado no existe.");
        }

        if (departamentoRepositorio.existsByDepartamento(nombre)) {
            return ResponseEntity.badRequest().body("Ya existe un departamento con ese nombre.");
        }

        Departamento nuevo = departamentoRepositorio.save(departamento);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DepartamentoModelo>> listar() {
        List<DepartamentoModelo> departamentos = departamentoRepositorio.findAll().stream()
                .map(dep -> new DepartamentoModelo(Math.toIntExact(dep.getCodDepartamento()), dep.getDepartamento()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(departamentos);
    }
}