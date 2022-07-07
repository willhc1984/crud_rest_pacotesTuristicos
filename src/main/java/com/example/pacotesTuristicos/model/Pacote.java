package com.example.pacotesTuristicos.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pacote")
public class Pacote implements Serializable{
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataViagem;
	private Integer diasPermanencia;
	private Integer refeicoesPorDia;
	
	@JsonIgnore
	@ManyToOne
	private Cidade cidade;
	@Transient
	private Restaurante restaurante;
	@ManyToOne
	private Hotel hotel;
	
	public Pacote() {
	}

	public Pacote(Integer id, Date dataViagem, Integer diasPermanencia, Integer refeicoesPorDia, Cidade cidade, Restaurante restaurante, Hotel hotel) {
		super();
		this.id = id;
		this.dataViagem = dataViagem;
		this.diasPermanencia = diasPermanencia;
		this.refeicoesPorDia = refeicoesPorDia;
		this.cidade = cidade;
		this.restaurante = restaurante;
		this.hotel = hotel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}

	public Integer getDiasPermanencia() {
		return diasPermanencia;
	}

	public void setDiasPermanencia(Integer diasPermanencia) {
		this.diasPermanencia = diasPermanencia;
	}

	public Integer getRefeicoesPorDia() {
		return refeicoesPorDia;
	}

	public void setRefeicoesPorDia(Integer refeicoesPorDia) {
		this.refeicoesPorDia = refeicoesPorDia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
		Pacote other = (Pacote) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(id + "\n");
		sb.append("Data da viagem: ");
		sb.append(sdf.format(dataViagem) + "\n");
		sb.append("Dias de permanencia: ");
		sb.append(diasPermanencia + "\n");
		sb.append("Refei��es por dia: ");
		sb.append(refeicoesPorDia + "\n");
		sb.append("Cidade: ");
		sb.append(cidade.getNome() + "\n");
		sb.append("Restaurante: ");
		sb.append(restaurante.getNome() + "\n");
		sb.append("Hotel: ");
		sb.append(hotel.getNome() + "\n");
		return sb.toString();
	}
	

}
