package com.jonata.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonata.agenda.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
