package com.jr.petland.repositories;

import com.jr.petland.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAnimalByNomeIgnoreCase(String nome);
}
