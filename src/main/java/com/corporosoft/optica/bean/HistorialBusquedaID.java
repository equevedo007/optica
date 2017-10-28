package com.corporosoft.optica.bean;

public class HistorialBusquedaID {

	private String idHistoria;
	private String idCliente;
	private String nombre1;
	private String nombre2;
	private String apellidoP;
	private String apellidoM;
	private String dni;
	private String fechaNac;
	private String fechaRegistroHistoria;
	public HistorialBusquedaID(String idHistoria, String idCliente, String nombre1, String nombre2, String apellidoP,
			String apellidoM, String dni, String fechaNac, String fechaRegistroHistoria) {
		super();
		this.idHistoria = idHistoria;
		this.idCliente = idCliente;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.fechaRegistroHistoria = fechaRegistroHistoria;
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
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getFechaRegistroHistoria() {
		return fechaRegistroHistoria;
	}
	public void setFechaRegistroHistoria(String fechaRegistroHistoria) {
		this.fechaRegistroHistoria = fechaRegistroHistoria;
	}
	
	
}
