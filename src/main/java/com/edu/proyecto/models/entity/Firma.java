package com.edu.proyecto.models.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "firma")
public class Firma implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "usuarioid")
	private Long usuarioid;
		
	private String firma;

	private String refirma;
	
	@Null
	@Column(name = "creafecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date creafecha;
	
	//https://www.baeldung.com/jpa-one-to-one
	@OneToOne
    @MapsId
    private Usuario usuario;

	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
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

	public Date getCreafecha() {
		return creafecha;
	}

	public void setCreafecha(Date creafecha) {
		this.creafecha = creafecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
 
	
}