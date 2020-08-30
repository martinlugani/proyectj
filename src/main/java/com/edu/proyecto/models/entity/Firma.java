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
@Table(name = "firma")
public class Firma implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long idfirma;
	
	@NotEmpty
	private Long idusuario;
	
	@NotEmpty
	private String firma;

	@NotEmpty
	private String refirma;
	
	public Long getIdfirma() {
		return idfirma;
	}

	public void setIdfirma(Long idfirma) {
		this.idfirma = idfirma;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getRefirma() {
		return refirma;
	}

	public void setRefirma(String refirma) {
		this.refirma = refirma;
	}
	
	
	

}
