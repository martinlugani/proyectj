package com.edu.proyecto.models.entity;

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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tipodocumento")

public class TipoDocumento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long idtipodocumento;
	
	
	private String descripcion;
	
	
	private String abreviacion;
	
	public Long getIdtipodocumento() {
		return idtipodocumento;
	}
	public void setIdtipodocumento(Long idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAbreviacion() {
		return abreviacion;
	}
	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}
	
	

}
