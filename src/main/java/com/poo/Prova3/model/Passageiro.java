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
	
	@Column
	private Integer rg;
	
	@Column
	private Integer cpf;

	@ManyToOne
	private Aviao aviao;
	
	public Passageiro() {

	}

	public Passageiro(Integer id, String nome, Integer rg, Integer cpf, Aviao aviao) {
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.aviao = aviao;
	}

	@Override
	public String toString() {
		return "Passageiro [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", aviao=" + aviao + "]";
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

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

}