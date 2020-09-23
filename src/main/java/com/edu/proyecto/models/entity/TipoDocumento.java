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
@Table(name = "tipodocumento")

public class TipoDocumento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long idtipodocumento;
	
	
	private String descripcion;
	
	
	private String abreviacion;
	
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Usuario> usuario;
	
	public List<Usuario> getUsuario() {
		return usuario;
	}
	
	
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public void Tipodocumento() {
		usuario = new ArrayList<Usuario>();
	}
	
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
	@Override
	public String toString() {
		return  abreviacion +" " ;
	}
	
	
}
