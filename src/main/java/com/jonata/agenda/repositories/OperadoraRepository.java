package com.jonata.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonata.agenda.domain.Operadora;

@Repository
public interface OperadoraRepository extends JpaRepository<Operadora, Integer> {

}
