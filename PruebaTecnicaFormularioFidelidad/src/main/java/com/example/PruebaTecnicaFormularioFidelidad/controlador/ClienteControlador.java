package com.example.PruebaTecnicaFormularioFidelidad.controlador;

import com.example.PruebaTecnicaFormularioFidelidad.entidades.*;
import com.example.PruebaTecnicaFormularioFidelidad.modelos.ClienteModelo;
import com.example.PruebaTecnicaFormularioFidelidad.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private TipoIdentificacionRepositorio tipoIdentificacionRepositorio;

    @Autowired
    private PaisRepositorio paisRepositorio;

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
        if (cliente.getNumeroIdentificacion() == null || cliente.getNumeroIdentificacion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El número de identificación no puede estar vacío.");
        }

        if (clienteRepositorio.existsByNumeroIdentificacion(cliente.getNumeroIdentificacion())) {
            return ResponseEntity.badRequest().body("Ya existe un cliente con ese número de identificación.");
        }

        if (cliente.getNombres() == null || cliente.getNombres().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'Nombres' es obligatorio.");
        }

        if (cliente.getApellido() == null || cliente.getApellido().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'Apellido' es obligatorio.");
        }

        if (cliente.getFechaNacimiento() == null || cliente.getFechaNacimiento().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La fecha de nacimiento es obligatoria.");
        }

        if (cliente.getDireccion() == null || cliente.getDireccion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La dirección es obligatoria.");
        }

        if (cliente.getTipoIdentificacion() == null || !tipoIdentificacionRepositorio.existsById(cliente.getTipoIdentificacion().getCodIdentificacion())) {
            return ResponseEntity.badRequest().body("El tipo de identificación no existe.");
        }

        if (cliente.getPais() == null || !paisRepositorio.existsById(cliente.getPais().getCodPais())) {
            return ResponseEntity.badRequest().body("El país no existe.");
        }

        if (cliente.getDepartamento() == null || !departamentoRepositorio.existsById(cliente.getDepartamento().getCodDepartamento())) {
            return ResponseEntity.badRequest().body("El departamento no existe.");
        }

        if (cliente.getCiudad() == null || !ciudadRepositorio.existsById(cliente.getCiudad().getCodCiudad())) {
            return ResponseEntity.badRequest().body("La ciudad no existe.");
        }

        Cliente nuevo = clienteRepositorio.save(cliente);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModelo>> listar() {
        List<ClienteModelo> clientes = clienteRepositorio.findAll().stream()
                .map(c -> new ClienteModelo(
                        c.getNumeroIdentificacion(),
                        c.getTipoIdentificacion().getTipo(),
                        c.getNombres(),
                        c.getApellido(),
                        c.getFechaNacimiento(),
                        c.getDireccion(),
                        c.getCiudad().getCiudad(),
                        c.getDepartamento().getDepartamento(),
                        c.getPais().getPais()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(clientes);
    }
}