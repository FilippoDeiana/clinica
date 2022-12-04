package com.corso.clinica.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="visita")
@NoArgsConstructor
@AllArgsConstructor
public class VisitaEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name="data_inizio")
	private LocalDate data_inizio;
	@Column (name="tipo_visita")
	private String tipo_visita;
	@ManyToOne 
	@JoinColumn(name = "animale", referencedColumnName = "id")
	private AnimaleEntity animale;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}
	public String getTipo_visita() {
		return tipo_visita;
	}
	public void setTipo_visita(String tipo_visita) {
		this.tipo_visita = tipo_visita;
	}
	public AnimaleEntity getAnimale() {
		return animale;
	}
	public void setAnimale(AnimaleEntity animale) {
		this.animale = animale;
	}
	@Override
	public int hashCode() {
		return Objects.hash(animale, data_inizio, id, tipo_visita);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitaEntity other = (VisitaEntity) obj;
		return Objects.equals(animale, other.animale) && Objects.equals(data_inizio, other.data_inizio)
				&& Objects.equals(id, other.id) && Objects.equals(tipo_visita, other.tipo_visita);
	}
	@Override
	public String toString() {
		return "VisitaEntity [id=" + id + ", data_inizio=" + data_inizio + ", tipo_visita=" + tipo_visita + ", animale="
				+ animale + "]";
	}
	
	
	
}
