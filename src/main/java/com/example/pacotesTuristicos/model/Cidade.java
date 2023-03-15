package com.example.pacotesTuristicos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "*Campo obrigatório.")
	private String nome;
	@NotBlank(message = "*Campo obrigatório.")
	private String estado;
	@NotBlank(message = "*Campo obrigatório.")
	private String website;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Hotel> hoteis = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Restaurante> restaurantes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Pacote> pacotes = new ArrayList<>();
	
	public Cidade() {
	}

	public Cidade(Integer id, String nome, String estado, String website) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.website = website;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}
	
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void addRestaurante(Restaurante restaurante) {
		restaurantes.add(restaurante);
	}

	public void addHotel(Hotel hotel) {
		hoteis.add(hotel);
	}
	
	public void addPacote(Pacote pacote) {
		pacotes.add(pacote);
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
		Cidade other = (Cidade) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("ID: ");
		sb.append(id + "\n");
		sb.append("Nome: ");
		sb.append(nome + "\n");
		sb.append("Estado: ");
		sb.append(estado + "\n");
		sb.append("Website: ");
		sb.append(website + "\n");
		sb.append("Hot�is: ");
		for(Hotel h : hoteis) {
			sb.append(h.getNome() + " - ");
		}
		sb.append("\n");
		sb.append("Restaurantes: ");
		for(Restaurante r : restaurantes) {
			sb.append(r.getNome() + " - ");
		}
		
		sb.append("\n\n");
		
		sb.append("Pacotes vendidos: ");
		sb.append("\n");
		sb.append("ID do pacote: ");
		sb.append(id + " - ");
		sb.append("Data de Viagem: ");
		for(Pacote p : pacotes) {
			sb.append(p.getDataViagem() + " - ");
		}
		
		return sb.toString();
		
	}

	

}
