package com.jr.petland.repositories;

import com.jr.petland.entities.Agendamento;
import com.jr.petland.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByAnimalId(Long animalId);

    List<Agendamento> findByStatusAgendamento(StatusAgendamento statusAgendamento);

    List<Agendamento> findByAnimalIdAndStatusAgendamentoNot(Long animalId, StatusAgendamento status);
}
