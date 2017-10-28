package com.corporosoft.optica.bean;

public class ListaReportaPacientes {
	
	String idHistoria,idCliente,nombres, dni, telefono, celular, fechaRegistro, mesProximoControl,fechaPrxControl;

	public ListaReportaPacientes(String idHistoria, String idCliente, String nombres, String dni, String telefono,
			String celular, String fechaRegistro, String mesProximoControl, String fechaPrxControl) {
		super();
		this.idHistoria = idHistoria;
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.dni = dni;
		this.telefono = telefono;
		this.celular = celular;
		this.fechaRegistro = fechaRegistro;
		this.mesProximoControl = mesProximoControl;
		this.fechaPrxControl = fechaPrxControl;
	}

	public String getIdHistoria() {
		return idHistoria;
	}

	public void setIdHistoria(String idHistoria) {
		this.idHistoria = idHistoria;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getMesProximoControl() {
		return mesProximoControl;
	}

	public void setMesProximoControl(String mesProximoControl) {
		this.mesProximoControl = mesProximoControl;
	}

	public String getFechaPrxControl() {
		return fechaPrxControl;
	}

	public void setFechaPrxControl(String fechaPrxControl) {
		this.fechaPrxControl = fechaPrxControl;
	}
	
	
	

}
