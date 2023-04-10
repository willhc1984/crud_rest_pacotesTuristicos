package com.example.pacotesTuristicos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_compra")
public class Compra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Campos obrigatório.")
	private String numeroCartao;
	@NotBlank(message = "Campos obrigatório.")
	private String nomeImpresso;
	private Date validade;
	@NotNull(message = "Campos obrigatório.")
	private Long cvv;
	
	@ManyToOne
	private User user;
	
	public Compra() {
		
	}

	public Compra(Long id, String numeroCartao, String nomeImpresso, Date validade, Long cvv, User user) {
		super();
		this.id = id;
		this.numeroCartao = numeroCartao;
		this.nomeImpresso = nomeImpresso;
		this.validade = validade;
		this.cvv = cvv;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeImpresso() {
		return nomeImpresso;
	}

	public void setNomeImpresso(String nomeImpresso) {
		this.nomeImpresso = nomeImpresso;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Long getCvv() {
		return cvv;
	}

	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", numeroCartao=" + numeroCartao + ", nomeImpresso=" + nomeImpresso + ", validade="
				+ validade + ", cvv=" + cvv + ", user=" + user + "]";
	}
}
