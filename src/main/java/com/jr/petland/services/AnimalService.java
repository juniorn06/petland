package com.jr.petland.services;

import com.jr.petland.dto.AnimalDTO;
import com.jr.petland.entities.Animal;
import com.jr.petland.repositories.AnimalRepository;
import com.jr.petland.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Transactional(readOnly = true)
    public AnimalDTO findAnimalById(Long id){
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado"));
        return new AnimalDTO(animal);
    }

    @Transactional(readOnly = true)
    public List<Animal> findAnimalByNome(String nome){
        List<Animal> animalList = animalRepository.findAnimalByNomeIgnoreCase(nome);
        if (animalList.isEmpty()){
            throw new RuntimeException("Animal não encontrado!");
        }
        return animalList;
    }

    @Transactional(readOnly = true)
    public List<Animal> findAll(){
        List<Animal> findAll = animalRepository.findAll();
        return findAll;
    }

    @Transactional
    public AnimalDTO insertAnimal(AnimalDTO dto){
        Animal animal = new Animal();
        copyDtoToEntity(dto, animal);
        animalRepository.save(animal);
        return new AnimalDTO(animal);
    }

    @Transactional()
    public AnimalDTO updataAnimal(Long id, AnimalDTO dto){
        try {
            Animal animal = animalRepository.getReferenceById(id);
            copyDtoToEntity(dto, animal);
            animalRepository.save(animal);
            return new AnimalDTO(animal);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Animal não encontrado!");
        }
    }

    @Transactional
    public void deleteAnimal(Long id){
        if (!animalRepository.existsById(id)){
            throw new ResourceNotFoundException("Animal não encontrado!");
        }
    }

    private void copyDtoToEntity(AnimalDTO dto, Animal animal){
        animal.setTipoAnimal(dto.getTipoAnimal());
        animal.setNome(dto.getNome());
        animal.setSexo(dto.getSexo());
        animal.setDataNascimento(dto.getDataNascimento());
        animal.setRaca(dto.getRaca());
    }
}
