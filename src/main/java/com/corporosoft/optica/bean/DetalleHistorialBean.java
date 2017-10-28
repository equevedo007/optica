package com.corporosoft.optica.bean;

import java.io.Serializable;
import java.sql.Date;

public class DetalleHistorialBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idOptometra;
	private String idHistorial;
	private String idCliente;
	private String Optometra;
	private String Cliente;
	private Date Fecha;
	private String Local;
	public String getIdOptometra() {
		return idOptometra;
	}
	public void setIdOptometra(String idOptometra) {
		this.idOptometra = idOptometra;
	}
	public String getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(String idHistorial) {
		this.idHistorial = idHistorial;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getOptometra() {
		return Optometra;
	}
	public void setOptometra(String optometra) {
		Optometra = optometra;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	
	
	

}
