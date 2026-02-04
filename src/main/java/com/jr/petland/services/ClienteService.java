package com.jr.petland.services;

import com.jr.petland.dto.ClienteDTO;
import com.jr.petland.entities.Cliente;
import com.jr.petland.repositories.ClienteRepository;
import com.jr.petland.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public ClienteDTO findClienteById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return new ClienteDTO(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findClienteByNome(String nome){
        List<Cliente> clienteList = clienteRepository.findClienteByNomeIgnoreCase(nome);
        if (clienteList.isEmpty()){
            throw new RuntimeException("Cliente não encontrado!");
        }
        return clienteList;
    }

    @Transactional(readOnly = true)
    public List<Cliente> findAll(){
        List<Cliente> findAll = clienteRepository.findAll();
        return findAll;
    }

    @Transactional
    public ClienteDTO insertCliente(ClienteDTO dto){
        Cliente cliente = new Cliente();
        copyDtoToEntity(dto, cliente);
        clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

    @Transactional()
    public ClienteDTO updateCliente(Long id, ClienteDTO dto){
        try {
            Cliente cliente = clienteRepository.getReferenceById(id);
            copyDtoToEntity(dto, cliente);
            clienteRepository.save(cliente);
            return new ClienteDTO(cliente);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Cliente não encontrado!");
        }
    }

    @Transactional
    public void deleteCliente(Long id){
        if (!clienteRepository.existsById(id)){
            throw new ResourceNotFoundException("Cliente não encontrado!");
        }
        clienteRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClienteDTO dto, Cliente cliente){
        cliente.setNome(cliente.getNome());
        cliente.setEndereco(cliente.getEndereco());
        cliente.setCpf(cliente.getCpf());
        cliente.setCidade(cliente.getCidade());
        cliente.setEmail(cliente.getEmail());
    }
}
