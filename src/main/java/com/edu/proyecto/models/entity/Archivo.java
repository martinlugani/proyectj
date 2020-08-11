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


@Entity
@Table(name = "archivo")
public class Archivo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2136804144972451999L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private long idarchivo;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String ruta;
	
	
	public long getIdarchivo() {
		return idarchivo;
	}
	public void setIdarchivo(long idarchivo) {
		this.idarchivo = idarchivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	

}
