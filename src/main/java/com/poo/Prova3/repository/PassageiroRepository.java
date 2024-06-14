package com.poo.Prova3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.Prova3.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Integer>{
	
}