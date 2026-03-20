package com.jr.petland.services;

import com.jr.petland.dto.ServicoDTO;
import com.jr.petland.entities.Servico;
import com.jr.petland.repositories.ServicoRepository;
import com.jr.petland.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public ServicoDTO findServicoById(Long id){
        Servico servico = servicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Servico não encontrado"));

        return new ServicoDTO(servico);
    }

    @Transactional(readOnly = true)
    public List<ServicoDTO> findServicoByDescricao(String nome){
        List<Servico> servicoList = servicoRepository.findByDescricaoContainingIgnoreCase(nome);

        if (servicoList.isEmpty()){
            throw new RuntimeException("Serviço não encontrado!");
        }

        return servicoList.stream().map(ServicoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<Servico> findAll(){
        List<Servico> findAll = servicoRepository.findAll();

        return findAll;
    }

    @Transactional
    public ServicoDTO insertServico(ServicoDTO dto){
        Servico servico = new Servico();

        copyDtoToEntity(dto, servico);

        servicoRepository.save(servico);

        return new ServicoDTO(servico);
    }

    @Transactional()
    public ServicoDTO updateServico(Long id, ServicoDTO dto){
        try {
            Servico servico = servicoRepository.getReferenceById(id);

            copyDtoToEntity(dto, servico);

            servicoRepository.save(servico);

            return new ServicoDTO(servico);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Servico não encontrado!");
        }
    }

    @Transactional
    public void deleteServico(Long id){

        if (!servicoRepository.existsById(id)){
            throw new ResourceNotFoundException("Servico não encontrado!");
        }

        servicoRepository.deleteById(id);
    }

    private void copyDtoToEntity(ServicoDTO dto, Servico servico){

        servico.setDescricao(dto.getDescricao());
        servico.setPreco(dto.getPreco());
        servico.setTempoServico(dto.getTempoServico());
    }
}