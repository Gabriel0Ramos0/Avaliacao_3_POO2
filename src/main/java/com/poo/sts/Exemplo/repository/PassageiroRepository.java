package com.poo.sts.Exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.sts.Exemplo.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Integer>{
	
}
