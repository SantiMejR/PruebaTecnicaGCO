package com.example.PruebaTecnicaFormularioFidelidad.controlador;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Ciudad;
import com.example.PruebaTecnicaFormularioFidelidad.modelos.CiudadModelo;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.CiudadRepositorio;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ciudades")
public class CiudadControlador {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Ciudad ciudad) {
        String nombre = ciudad.getCiudad();

        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la ciudad no puede estar vacío.");
        }

        if (ciudad.getDepartamento() == null || ciudad.getDepartamento().getCodDepartamento() == null) {
            return ResponseEntity.badRequest().body("Debe especificar un departamento válido.");
        }

        if (!departamentoRepositorio.existsById(ciudad.getDepartamento().getCodDepartamento())) {
            return ResponseEntity.badRequest().body("El departamento especificado no existe.");
        }

        if (ciudadRepositorio.existsByCiudad(nombre)) {
            return ResponseEntity.badRequest().body("Ya existe una ciudad con ese nombre.");
        }

        Ciudad nueva = ciudadRepositorio.save(ciudad);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping
    public ResponseEntity<List<CiudadModelo>> listar() {
        List<CiudadModelo> ciudades = ciudadRepositorio.findAll().stream()
                .map(c -> new CiudadModelo(Math.toIntExact(c.getCodCiudad()), c.getCiudad()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(ciudades);
    }
}