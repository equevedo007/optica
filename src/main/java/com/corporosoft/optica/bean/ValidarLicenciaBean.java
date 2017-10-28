package com.corporosoft.optica.bean;

import java.util.Date;

public class ValidarLicenciaBean {
	
	private String idLicencia ;
	private Date fecha_registro;
	private Date fecha_fin;
	private String tiempo_renovacion;
	private String licencia;
	public ValidarLicenciaBean(String idLicencia, Date fecha_registro, Date fecha_fin, String tiempo_renovacion,
			String licencia) {
		super();
		this.idLicencia = idLicencia;
		this.fecha_registro = fecha_registro;
		this.fecha_fin = fecha_fin;
		this.tiempo_renovacion = tiempo_renovacion;
		this.licencia = licencia;
	}
	public String getIdLicencia() {
		return idLicencia;
	}
	public void setIdLicencia(String idLicencia) {
		this.idLicencia = idLicencia;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getTiempo_renovacion() {
		return tiempo_renovacion;
	}
	public void setTiempo_renovacion(String tiempo_renovacion) {
		this.tiempo_renovacion = tiempo_renovacion;
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	
	
	
	
}
