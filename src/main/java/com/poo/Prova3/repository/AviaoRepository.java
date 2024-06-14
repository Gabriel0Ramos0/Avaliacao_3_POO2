package com.poo.Prova3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.Prova3.model.Aviao;

public interface AviaoRepository extends JpaRepository<Aviao, Integer>{
	public Aviao findByNome(String nome);
}