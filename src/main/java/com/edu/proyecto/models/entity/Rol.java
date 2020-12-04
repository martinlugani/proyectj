package com.edu.proyecto.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long idrol;	
	
	private String rol;
	
	private String descripcion;
	
	private Long visible;
	
	@OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Usuario> usuario;
	
	public List<Usuario> getUsuario() {
		return usuario;
	}
	

	public Long getIdrol() {
		return idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Long getVisible() {
		return visible;
	}


	public void setVisible(Long visible) {
		this.visible = visible;
	}
	
	
}
