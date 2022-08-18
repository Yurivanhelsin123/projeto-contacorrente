package com.contacorrente.fourbank.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacorrente.fourbank.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
//	Optional<Cliente> findByClientenome(String clientenome);
//	
	

}
