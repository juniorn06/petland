package com.jr.petland.controllers;

import com.jr.petland.dto.ClienteRequestDTO;
import com.jr.petland.dto.ClienteResponseDTO;
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

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> insertCliente(@Valid @RequestBody ClienteRequestDTO dto){
        ClienteResponseDTO responseDTO = clienteService.insertCliente(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(responseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> findClienteById(@PathVariable Long id) {
        ClienteResponseDTO dto = clienteService.findClienteById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getClientes(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List> findClienteByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(clienteService.findClienteByNome(nome));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@Valid @PathVariable Long id, @RequestBody ClienteRequestDTO dto){
        return ResponseEntity.ok().body(clienteService.updateCliente(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
