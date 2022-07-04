package com.example.pacotesTuristicos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_hotel")
public class Hotel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Integer id;
	private String nome;
	private Double valorDiaria;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cidade cidade;
	@Transient
	private List<Pacote> pacotes = new ArrayList<>();
	
	public Hotel() {
	}

	public Hotel(Integer id, String nome, Double valorDiaria, Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorDiaria = valorDiaria;
		this.cidade = cidade;
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

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
	
	public void addPacoteTuristico(Pacote pacoteTuristico) {
		pacotes.add(pacoteTuristico);
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
		Hotel other = (Hotel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(id + "\n");
		sb.append("Nome: ");
		sb.append(nome + "\n");
		sb.append("Valor da Di�ria: ");
		sb.append(valorDiaria + "\n");
		sb.append("Cidade: ");
		sb.append(cidade.getNome() + "\n");
		for(Pacote p : pacotes) {
			sb.append(p.getCidade() + "\n");
			sb.append(p.getDataViagem() + "\n");
		}
		
		
		return sb.toString();
	}
	
	
}
