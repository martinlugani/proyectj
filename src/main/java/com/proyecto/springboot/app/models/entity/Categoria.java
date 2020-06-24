package com.proyecto.springboot.app.models.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categoria")

public class Categoria implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long idcategoria;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private Long porcentaje;
	
	@NotEmpty
	private Boolean tipo;

	public Long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Long porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
	
	
}
