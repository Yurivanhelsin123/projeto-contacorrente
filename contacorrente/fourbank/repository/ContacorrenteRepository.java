package com.contacorrente.fourbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contacorrente.fourbank.entity.ContaCorrente;




@Transactional(readOnly = false)
@Repository
public interface ContacorrenteRepository extends JpaRepository<ContaCorrente, Integer>{
	
	
	@Modifying
	@Query("update ContaCorrente c set c.saldocontacorrente= c.saldocontacorrente + ?1 where c.idcontacorrente = ?2")
	void setFixedSaldoFor(double quantidade,Integer idcontacorrente);
	
	ContaCorrente findByIdcontacorrente(Integer idcontacorrente);
	
	
	@Modifying
	@Query("update ContaCorrente c set c.saldocontacorrente= c.saldocontacorrente - ?1 where c.idcontacorrente = ?2")
	void setFixedSaldo(double quant ,Integer idcontacorrente);
	
	
	
	
	
	

}
