package com.poo.Prova3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aviao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@Column
	private String modelo;
	
	@Column
	private Integer anoFabricacao;
	
	@Column
	private String categoria;
	
	@Column
	private String tipoVooAutorizado;
	
	@Column
	private String situacaoDificuldade;
	
	public Aviao() {
		
	}

	public Aviao(Integer id, String modelo, Integer anoFabricacao, String categoria, String tipoVooAutorizado,
			String situacaoDificuldade) {
		this.id = id;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.categoria = categoria;
		this.tipoVooAutorizado = tipoVooAutorizado;
		this.situacaoDificuldade = situacaoDificuldade;
	}

	@Override
	public String toString() {
		return "Aviao [id=" + id + ", modelo=" + modelo + ", anoFabricacao=" + anoFabricacao + ", categoria="
				+ categoria + ", tipoVooAutorizado=" + tipoVooAutorizado + ", situacaoDificuldade="
				+ situacaoDificuldade + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipoVooAutorizado() {
		return tipoVooAutorizado;
	}

	public void setTipoVooAutorizado(String tipoVooAutorizado) {
		this.tipoVooAutorizado = tipoVooAutorizado;
	}

	public String getSituacaoDificuldade() {
		return situacaoDificuldade;
	}

	public void setSituacaoDificuldade(String situacaoDificuldade) {
		this.situacaoDificuldade = situacaoDificuldade;
	}
		
}