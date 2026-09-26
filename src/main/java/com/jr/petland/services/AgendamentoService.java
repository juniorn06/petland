package com.jr.petland.services;

import com.jr.petland.dto.AgendamentoResponseDTO;
import com.jr.petland.entities.Agendamento;
import com.jr.petland.repositories.AgendamentoRepository;
import com.jr.petland.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoResponseDTO findAgendamentoById(Long id){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado"));
        return new AgendamentoResponseDTO(agendamento);
    }
}
