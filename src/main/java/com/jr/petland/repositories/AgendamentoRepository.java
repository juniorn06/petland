package com.jr.petland.repositories;

import com.jr.petland.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
