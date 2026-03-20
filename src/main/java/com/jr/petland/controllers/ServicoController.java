package com.jr.petland.controllers;

import com.jr.petland.dto.ServicoDTO;
import com.jr.petland.services.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping(value = "insertServico")
    public ResponseEntity<ServicoDTO> insertServico(@Valid @RequestBody ServicoDTO dto){
        dto = servicoService.insertServico(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/findServicoById/{id}")
    public ResponseEntity<ServicoDTO> findServicoById(@PathVariable Long id) {
        ServicoDTO dto = servicoService.findServicoById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "findAll")
    public ResponseEntity<List> getServicos(){
        return ResponseEntity.ok().body(servicoService.findAll());
    }

    @GetMapping(value = "/findServicoByDescricao/{descricao}")
    public ResponseEntity<List> findServicoByDescricao(@PathVariable String descricao){
        return ResponseEntity.ok().body(servicoService.findServicoByDescricao(descricao));
    }

    @PutMapping(value = "updateServico/{id}")
    public ResponseEntity<ServicoDTO> updateServico(@Valid @PathVariable Long id, @RequestBody ServicoDTO dto){
        return ResponseEntity.ok().body(servicoService.updateServico(id, dto));
    }

    @DeleteMapping(value = "deleteServico/{id}")
    public void deleteServico(@PathVariable Long id){
        servicoService.deleteServico(id);
    }
}
