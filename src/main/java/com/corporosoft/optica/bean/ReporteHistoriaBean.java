package com.corporosoft.optica.bean;

import java.sql.Date;

public class ReporteHistoriaBean {

	private Date Fecha;
	private int cantidad;
	public ReporteHistoriaBean(Date fecha, int cantidad) {
		super();
		Fecha = fecha;
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
