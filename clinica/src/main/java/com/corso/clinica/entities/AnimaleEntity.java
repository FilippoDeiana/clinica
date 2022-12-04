package com.corso.clinica.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name="animale")
@NoArgsConstructor
@AllArgsConstructor
public class AnimaleEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name="nome")
	private String nome;
	@Column (name="tipo")
	private String tipo;
	@Column (name="padrone")
	private String padrone;
	@OneToMany (mappedBy = "animale", cascade = CascadeType.ALL)
	private List<VisitaEntity> visite;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPadrone() {
		return padrone;
	}
	public void setPadrone(String padrone) {
		this.padrone = padrone;
	}
	public List<VisitaEntity> getVisite() {
		return visite;
	}
	public void setVisite(List<VisitaEntity> visite) {
		this.visite = visite;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, padrone, tipo, visite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimaleEntity other = (AnimaleEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(padrone, other.padrone) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(visite, other.visite);
	}
	@Override
	public String toString() {
		return "AnimaleEntity [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", padrone=" + padrone + ", visite="
				+ visite + "]";
	}
	
	

}
