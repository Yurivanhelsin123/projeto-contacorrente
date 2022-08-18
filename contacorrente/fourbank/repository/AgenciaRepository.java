package com.contacorrente.fourbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacorrente.fourbank.entity.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer>{

}
