package com.edu.proyecto.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "recibos")

public class Recibo implements Serializable{
	
	private static final long serialVersionUID = 7536804169972451999L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long id;
	
	@CsvBindByName(column = "idrecibo")
	private String idrecibo;
	
	
	@CsvBindByName(column = "nrorecibo")
	private String nrorecibo;
	
	@CsvBindByName(column = "idusuario")
	private String idusuario;
	
	@CsvBindByName(column = "concepto")
	private String concepto;
	
	@CsvBindByName(column = "tipoconcepto")
	private String tipoconcepto;
	
	@CsvBindByName(column = "importe")
	private int importe;
	
	@CsvBindByName(column = "importetotal")
	private int importetotal;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdrecibo() {
		return idrecibo;
	}

	public void setIdrecibo(String idrecibo) {
		this.idrecibo = idrecibo;
	}

	public String getNrorecibo() {
		return nrorecibo;
	}

	public void setNrorecibo(String nrorecibo) {
		this.nrorecibo = nrorecibo;
	}



	public String getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}



	public String getConcepto() {
		return concepto;
	}



	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}



	public String getTipoconcepto() {
		return tipoconcepto;
	}



	public void setTipoconcepto(String tipoconcepto) {
		this.tipoconcepto = tipoconcepto;
	}



	public int getImporte() {
		return importe;
	}



	public void setImporte(int importe) {
		this.importe = importe;
	}



	public int getImportetotal() {
		return importetotal;
	}



	public void setImportetotal(int importetotal) {
		this.importetotal = importetotal;
	}
	

}
