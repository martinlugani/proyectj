package com.edu.proyecto.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categoria")

public class Categoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7536804144972451999L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long idcategoria;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private String porcentaje;
	
	@Column(nullable = false)
	private Boolean gratificacion;

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

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Boolean getGratificacion() {
		return gratificacion;
	}

	public void setGratificacion(Boolean gratificacion) {
		this.gratificacion = gratificacion;
	}
	
}
