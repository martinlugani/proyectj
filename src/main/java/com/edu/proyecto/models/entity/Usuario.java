package com.edu.proyecto.models.entity;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long idusuario;

	
	private String nombre;
	
	
	private String apellido;
	
	
	private String nick;
	
	
	private String email;

	
	private String nrodocumento;
	
/*	 @Column(nullable = false, columnDefinition = "TINYINT(1)") 
	 private boolean administrador; 

	 @Column(nullable = false, columnDefinition = "TINYINT(1)") 
	 private boolean consulta; */
	
	//°°°°FALTA EN FORMULARIO
	@ManyToOne 
	@JoinColumn(name="idtipodocumento")
	public TipoDocumento tipodocumento;
	
/*	@ManyToOne 
	@JoinColumn(name="idfirma")
	public Firma firma;*/
	
	//°°°°FALTA EN FORMULARIO
	@Column(name = "fechaAlta")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaAlta;
	
	
	//https://www.baeldung.com/jpa-one-to-one
	@OneToOne(mappedBy = "usuario" , cascade = CascadeType.ALL)
    private Firma firma;
	
//	private SecureRandom random = new SecureRandom();

	private String contrasena;

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNrodocumento() {
		return nrodocumento;
	}

	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public TipoDocumento getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
