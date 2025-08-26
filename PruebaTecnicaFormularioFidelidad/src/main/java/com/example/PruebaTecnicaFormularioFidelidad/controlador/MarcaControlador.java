package com.example.PruebaTecnicaFormularioFidelidad.controlador;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.Marca;
import com.example.PruebaTecnicaFormularioFidelidad.modelos.MarcaModelo;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marca")
public class MarcaControlador {

    @Autowired
    private MarcaRepositorio marcaRepositorio;

    @PostMapping("/crear")
    public ResponseEntity<String> crearMarca(@RequestBody Marca marca) {
        if (marca.getMarca() == null || marca.getMarca().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'Marca' es obligatorio.");
        }

        marcaRepositorio.save(marca);
        return ResponseEntity.ok("Marca creada correctamente.");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MarcaModelo>> listarMarcas() {
        List<MarcaModelo> marcas = marcaRepositorio.findAll().stream()
                .map(m -> new MarcaModelo(m.getIdMarca(), m.getMarca()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(marcas);
    }
}