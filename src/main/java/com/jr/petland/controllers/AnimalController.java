package com.jr.petland.controllers;

import com.jr.petland.dto.AnimalDTO;
import com.jr.petland.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping(value = "insertAnimal")
    public ResponseEntity<AnimalDTO> insertAnimal(@RequestBody AnimalDTO dto){
        dto = animalService.insertAnimal(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/findAnimalById/{id}")
    public ResponseEntity<AnimalDTO> findAnimalById(@PathVariable Long id) {
        AnimalDTO dto = animalService.findAnimalById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "findAll")
    public ResponseEntity<List> getAnimais(){
        return ResponseEntity.ok().body(animalService.findAll());
    }

    @GetMapping(value = "/findAnimalByNome/{nome}")
    public ResponseEntity<List> findAnimalByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(animalService.findAnimalByNome(nome));
    }

    @PutMapping(value = "updateAnimal/{id}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long id, @RequestBody AnimalDTO dto){
        return ResponseEntity.ok().body(animalService.updataAnimal(id, dto));
    }

    @DeleteMapping(value = "deleteAnimal/{id}")
    public void deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
    }
}
