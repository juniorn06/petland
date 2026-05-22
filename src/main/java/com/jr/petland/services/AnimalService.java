package com.jr.petland.services;

import com.jr.petland.dto.AnimalDTO;
import com.jr.petland.entities.Animal;
import com.jr.petland.entities.Cliente;
import com.jr.petland.repositories.AnimalRepository;
import com.jr.petland.repositories.ClienteRepository;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public AnimalDTO findAnimalById(Long id){
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado"));
        return new AnimalDTO(animal);
    }

    @Transactional(readOnly = true)
    public List<AnimalDTO> findAnimalByNome(String nome){
        List<Animal> animalList = animalRepository.findByNomeContainingIgnoreCase(nome);
        return animalList.stream().map(AnimalDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<AnimalDTO> findAll(){
        List<Animal> findAll = animalRepository.findAll();
        return findAll.stream().map(AnimalDTO::new).toList();
    }

    @Transactional
    public AnimalDTO insertAnimal(AnimalDTO dto){
        Animal animal = new Animal();
        copyDtoToEntity(dto, animal);
        Cliente dono = clienteRepository.getReferenceById(dto.getDonoId());
        dono.adicionarAnimal(animal);
        animalRepository.save(animal);
        return new AnimalDTO(animal);
    }

    @Transactional()
    public AnimalDTO updateAnimal(Long id, AnimalDTO dto){
        try {
            Animal animal = animalRepository.getReferenceById(id);
            copyDtoToEntity(dto, animal);
            return new AnimalDTO(animal);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Animal não encontrado!");
        }
    }

    @Transactional
    public void deleteAnimal(Long id){
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado!"));
        if (animal.getDono() != null) {
            animal.getDono().getAnimais().remove(animal);
        }
        animalRepository.delete(animal);
    }

    private void copyDtoToEntity(AnimalDTO dto, Animal animal){
        animal.setTipoAnimal(dto.getTipoAnimal());
        animal.setNome(dto.getNome());
        animal.setSexo(dto.getSexo());
        animal.setDataNascimento(dto.getDataNascimento());
        animal.setRaca(dto.getRaca());
        animal.setPeso(dto.getPeso());
        animal.setObservacoes(dto.getObservacoes());

        if (dto.getDonoId() != null){
            Cliente dono = clienteRepository.getReferenceById(dto.getDonoId());
            animal.setDono(dono);
        }
    }
}
