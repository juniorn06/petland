package com.jr.petland.controllers;

import com.jr.petland.dto.AnimalDTO;
import com.jr.petland.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> insertAnimal(@Valid @RequestBody AnimalDTO dto){
        dto = animalService.insertAnimal(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnimalDTO> findAnimalById(@PathVariable Long id) {
        AnimalDTO dto = animalService.findAnimalById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> findAll(){
        List<AnimalDTO> list = animalService.findAll();
        return ResponseEntity.ok(list);
    }

   ; @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List<AnimalDTO>> findAnimalByNome(@PathVariable String nome){
        List<AnimalDTO> list = animalService.findAnimalByNome(nome);
        return ResponseEntity.ok().body(list
        );
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnimalDTO> updateAnimal(@Valid @PathVariable Long id, @RequestBody AnimalDTO dto){
        return ResponseEntity.ok().body(animalService.updateAnimal(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id){
       animalService.deleteAnimal(id);
       return ResponseEntity.noContent().build();
    }
}
