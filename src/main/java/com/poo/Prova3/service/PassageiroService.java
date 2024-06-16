package com.poo.Prova3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.Prova3.model.Passageiro;
import com.poo.Prova3.repository.PassageiroRepository;

@Service
public class PassageiroService {
	
	@Autowired
	PassageiroRepository repository;
	
	public Passageiro inserePassageiro (Passageiro p) {
		return repository.save(p);
	}
	
	public Passageiro alteraPassageiro (Passageiro p) {
		return repository.save(p);
	}
	
	public Passageiro buscaPorCodigo(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public void excluiPassageiro (Integer id) {
		repository.deleteById(id);
	}
	
	public List<Passageiro> listaTodosPassageiros(){
		return repository.findAll();
	}
}