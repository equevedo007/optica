package com.corporosoft.optica.bean;

public class LicenciaBean {
	
	private String idLicencia;
	private String tiempo;
	private String licencia;
	
	
	public LicenciaBean(String idLicencia, String tiempo, String licencia) {
		super();
		this.idLicencia = idLicencia;
		this.tiempo = tiempo;
		this.licencia = licencia;
	}
	public String getIdLicencia() {
		return idLicencia;
	}
	public void setIdLicencia(String idLicencia) {
		this.idLicencia = idLicencia;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	
	
	

}
