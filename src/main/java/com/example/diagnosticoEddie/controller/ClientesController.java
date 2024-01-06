package com.example.diagnosticoEddie.controller;

import com.example.diagnosticoEddie.model.dto.ClientesDto;
import com.example.diagnosticoEddie.model.entity.ClientesBean;
import com.example.diagnosticoEddie.service.IClientes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final IClientes clientesService;

    public ClientesController(IClientes clientesService) {
        this.clientesService = clientesService;
    }

    @PostMapping
    public ResponseEntity<ClientesBean> createCliente(@RequestBody ClientesDto clientesDto) {
        ClientesBean nuevoCliente = clientesService.save(clientesDto);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesBean> getClienteById(@PathVariable Integer id) {
        ClientesBean cliente = clientesService.findById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientesBean>> getAllClientes() {
        List<ClientesBean> clientes = clientesService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesBean> updateCliente(@PathVariable Integer id, @RequestBody ClientesDto clientesDto) {
        ClientesBean existingCliente = clientesService.findById(id);

        if (existingCliente != null) {
            existingCliente.setApellido(clientesDto.getApellido());
            existingCliente.setCurp(clientesDto.getCurp());
            existingCliente.setNombre(clientesDto.getNombre());

            ClientesBean updatedCliente = clientesService.save(existingCliente);

            return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        ClientesBean clienteToDelete = clientesService.findById(id);

        if (clienteToDelete != null) {
            clientesService.delete(clienteToDelete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
