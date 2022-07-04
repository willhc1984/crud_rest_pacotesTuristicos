package com.example.pacotesTuristicos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Double valorDiaria;
	
	private Cidade cidade;
	private List<PacoteTuristico> pacotes = new ArrayList<>();
	
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

	public List<PacoteTuristico> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<PacoteTuristico> pacotes) {
		this.pacotes = pacotes;
	}
	
	public void addPacoteTuristico(PacoteTuristico pacoteTuristico) {
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
		for(PacoteTuristico p : pacotes) {
			sb.append(p.getCidade() + "\n");
			sb.append(p.getDataViagem() + "\n");
		}
		
		
		return sb.toString();
	}
	
	
}
