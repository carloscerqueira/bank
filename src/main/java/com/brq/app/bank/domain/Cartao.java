package com.brq.app.bank.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "cartao")
public class Cartao implements Serializable {

	private static final long serialVersionUID = 5952867783687052984L;

	public Cartao(Long id, String nomeCartao, String numeroCartao, BigDecimal limiteCartao) {
		this.id = id;
		this.nomeCartao = nomeCartao;
		this.numeroCartao = numeroCartao;
		this.limiteCartao = limiteCartao;
	}
	
	public Cartao() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id_cartao")
	private Long id;
	
	@JsonProperty("nome_cartao")
	private String nomeCartao;
	
	@JsonProperty("numero_cartao")
	private String numeroCartao;
	
	@JsonProperty("limite_cartao")
	private BigDecimal limiteCartao;
	
	@JsonIgnore
	private Long idConta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public BigDecimal getLimiteCartao() {
		return limiteCartao;
	}

	public void setLimiteCartao(BigDecimal limiteCartao) {
		this.limiteCartao = limiteCartao;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	
}
