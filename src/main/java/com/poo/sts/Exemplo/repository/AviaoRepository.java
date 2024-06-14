package com.poo.sts.Exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poo.sts.Exemplo.model.Aviao;

public interface AviaoRepository extends JpaRepository<Aviao, Integer>{
	public Aviao findByNome(String nome);
}
