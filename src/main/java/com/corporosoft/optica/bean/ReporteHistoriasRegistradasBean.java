package com.corporosoft.optica.bean;

import java.io.Serializable;

public class ReporteHistoriasRegistradasBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String Mes;
	private int Cantidad;
	
	
	
	public ReporteHistoriasRegistradasBean(String mes, int cantidad) {
		super();
		Mes = mes;
		Cantidad = cantidad;
	}
	public String getMes() {
		return Mes;
	}
	public void setMes(String mes) {
		Mes = mes;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

}
