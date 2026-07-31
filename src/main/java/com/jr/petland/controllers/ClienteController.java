package com.jr.petland.controllers;

import com.jr.petland.dto.ClienteRequestDTO;
import com.jr.petland.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "insertCliente")
    public ResponseEntity<ClienteRequestDTO> insertCliente(@Valid @RequestBody ClienteRequestDTO dto){
        dto = clienteService.insertCliente(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/findClienteById/{id}")
    public ResponseEntity<ClienteRequestDTO> findClienteById(@PathVariable Long id) {
        ClienteRequestDTO dto = clienteService.findClienteById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "findAll")
    public ResponseEntity<List> getAnimais(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping(value = "/findClienteByNome/{nome}")
    public ResponseEntity<List> findClienteByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(clienteService.findClienteByNome(nome));
    }

    @PutMapping(value = "updateCliente/{id}")
    public ResponseEntity<ClienteRequestDTO> updateCliente(@Valid @PathVariable Long id, @RequestBody ClienteRequestDTO dto){
        return ResponseEntity.ok().body(clienteService.updateCliente(id, dto));
    }

    @DeleteMapping(value = "deleteCliente/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
    }
}
