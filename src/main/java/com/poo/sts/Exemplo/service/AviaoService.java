package com.poo.sts.Exemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.sts.Exemplo.model.Aviao;
import com.poo.sts.Exemplo.repository.AviaoRepository;

@Service
public class AviaoService {
	
	@Autowired
	AviaoRepository repository;
	
	public Aviao insereAviao(Aviao a) {
		return repository.save(a);
	}
	
	public Aviao AlteraAviao (Aviao c) {
		return repository.save(c);
	}
	
	public Aviao buscaPoCodigo(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Aviao buscaPorNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public void excluiAviao (Aviao a) {
		repository.delete(a);
	}
	
	public List<Aviao> listarTodosAvioes(){
		return repository.findAll();
	}
}
