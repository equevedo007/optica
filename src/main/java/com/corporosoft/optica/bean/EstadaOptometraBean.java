package com.corporosoft.optica.bean;

import java.io.Serializable;

public class EstadaOptometraBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String idEstado; 
	private String descripcion;
	
	public EstadaOptometraBean(){
		
	}

	public EstadaOptometraBean(String idEstado, String descripcion) {
		super();
		this.idEstado = idEstado;
		this.descripcion = descripcion;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}