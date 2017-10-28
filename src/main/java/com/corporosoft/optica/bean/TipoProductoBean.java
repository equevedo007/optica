package com.corporosoft.optica.bean;

import java.io.Serializable;

public class TipoProductoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String idTipoProdicto;
	
	private String descripcion;
	
	

	public TipoProductoBean(String idTipoProdicto, String descripcion) {
		super();
		this.idTipoProdicto = idTipoProdicto;
		this.descripcion = descripcion;
	}

	public String getIdTipoProdicto() {
		return idTipoProdicto;
	}

	public void setIdTipoProdicto(String idTipoProdicto) {
		this.idTipoProdicto = idTipoProdicto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
