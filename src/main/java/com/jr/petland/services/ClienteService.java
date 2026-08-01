package com.jr.petland.services;

import com.jr.petland.dto.ClienteRequestDTO;
import com.jr.petland.dto.ClienteResponseDTO;
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
    public ClienteResponseDTO findClienteById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return new ClienteResponseDTO(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> findClienteByNome(String nome){
        List<Cliente> clienteList = clienteRepository.findClienteByNomeContainingIgnoreCase(nome);
        if (clienteList.isEmpty()){
            throw new ResourceNotFoundException("Cliente não encontrado!" + nome);
        }
        return clienteList;
    }

    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> findAll(){
        List<Cliente> findAll = clienteRepository.findAll();
        return findAll.stream().map(ClienteResponseDTO::new).toList();
    }

    @Transactional
    public ClienteResponseDTO insertCliente(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();
        copyDtoToEntity(dto, cliente);
        clienteRepository.save(cliente);
        return new ClienteResponseDTO(cliente);
    }

    @Transactional()
    public ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO dto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!" + id));
        copyDtoToEntity(dto, cliente);
        clienteRepository.save(cliente);
        return new ClienteResponseDTO(cliente);
    }

    @Transactional
    public void deleteCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!" + id));
        clienteRepository.delete(cliente);
    }

    private void copyDtoToEntity(ClienteRequestDTO dto, Cliente cliente){
        cliente.setNome(dto.getNome());
        cliente.setEndereco(dto.getEndereco());
        cliente.setBairro(dto.getBairro());
        cliente.setCidade(dto.getCidade());
        cliente.setCpf(dto.getCpf());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
    }
}