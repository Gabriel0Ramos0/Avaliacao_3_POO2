package com.poo.Prova3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Passageiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@ManyToOne
	private Aviao aviao;
	
	public Passageiro() {

	}

	public Passageiro(Integer id, String nome, Aviao aviao) {
		super();
		this.id = id;
		this.nome = nome;
		this.aviao = aviao;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", aviao=" + aviao + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
}