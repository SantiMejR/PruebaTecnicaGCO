package com.example.PruebaTecnicaFormularioFidelidad.controlador;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.ClientePorMarca;
import com.example.PruebaTecnicaFormularioFidelidad.modelos.ClientePorMarcaModelo;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.ClientePorMarcaRepositorio;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.ClienteRepositorio;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.MarcaRepositorio;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente-por-marca")
public class ClientePorMarcaControlador {

    private final ClientePorMarcaRepositorio clientePorMarcaRepositorio;
    private final ClienteRepositorio clienteRepositorio;
    private final MarcaRepositorio marcaRepositorio;

    public ClientePorMarcaControlador(
            ClientePorMarcaRepositorio clientePorMarcaRepositorio,
            ClienteRepositorio clienteRepositorio,
            MarcaRepositorio marcaRepositorio
    ) {
        this.clientePorMarcaRepositorio = clientePorMarcaRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.marcaRepositorio = marcaRepositorio;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ClientePorMarcaModelo modelo) {
        if (modelo.getNumeroIdentificacion() == null || modelo.getIdMarca() == null) {
            return ResponseEntity.badRequest().body("Los campos 'numeroIdentificacion' e 'idMarca' son obligatorios.");
        }

        if (!clienteRepositorio.existsById(modelo.getNumeroIdentificacion())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no existe.");
        }

        if (!marcaRepositorio.existsById(modelo.getIdMarca())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La marca no existe.");
        }

        if (clientePorMarcaRepositorio.existsByNumeroIdentificacionAndIdMarca(
                modelo.getNumeroIdentificacion(), modelo.getIdMarca())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe esta relación.");
        }

        ClientePorMarca entidad = new ClientePorMarca();
        entidad.setNumeroIdentificacion(modelo.getNumeroIdentificacion());
        entidad.setIdMarca(modelo.getIdMarca());

        clientePorMarcaRepositorio.save(entidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClientePorMarcaModelo>> listar() {
        List<ClientePorMarcaModelo> lista = clientePorMarcaRepositorio.findAll().stream()
                .map(e -> {
                    ClientePorMarcaModelo m = new ClientePorMarcaModelo();
                    m.setNumeroIdentificacion(e.getNumeroIdentificacion());
                    m.setIdMarca(e.getIdMarca());
                    return m;
                }).toList();

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminar(@RequestBody ClientePorMarcaModelo modelo) {
        if (!clientePorMarcaRepositorio.existsByNumeroIdentificacionAndIdMarca(
                modelo.getNumeroIdentificacion(), modelo.getIdMarca())) {
            return ResponseEntity.notFound().build();
        }

        clientePorMarcaRepositorio.deleteByNumeroIdentificacionAndIdMarca(
                modelo.getNumeroIdentificacion(), modelo.getIdMarca());

        return ResponseEntity.noContent().build();
    }
}