package com.example.pacotesTuristicos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_restaurante")
public class Restaurante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "*Campo obrigatório.")
	private String nome;
	@NotNull(message = "Valor não pode ser nulo.")
	private Double valorRefeicao;
	
	@ManyToOne
	@NotNull(message = "*Campo obrigatório.")
	private Cidade cidade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurante")
	private List<Pacote> pacotes = new ArrayList<>();
	
	public Restaurante() {
	}

	public Restaurante(Integer id, String nome, Double valorRefeicao, Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorRefeicao = valorRefeicao;
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

	public Double getValorRefeicao() {
		return valorRefeicao;
	}

	public void setValorRefeicao(Double valorRefeicao) {
		this.valorRefeicao = valorRefeicao;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public List<Pacote> getPacotes() {
		return pacotes;
	}
	
	public void addPacotes(Pacote pacote) {
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
		Restaurante other = (Restaurante) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(id + "\n");
		sb.append("Nome: ");
		sb.append(nome + "\n");
		sb.append("Valor da Refei��o: ");
		sb.append(valorRefeicao + "\n");
		sb.append("Cidade: ");
		sb.append(cidade.getNome() + "\n");
		sb.append("Data de viagem: ");
		sb.append("\n");
		for(Pacote p : pacotes) {
			sb.append(p.getDataViagem());
		}
		
		return sb.toString();
	}
	
}
