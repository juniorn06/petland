package com.jr.petland.repositories;

import com.jr.petland.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findClienteByNomeIgnoreCase(String nome);
}
