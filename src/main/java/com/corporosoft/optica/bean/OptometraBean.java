package com.corporosoft.optica.bean;

import java.io.Serializable;
import java.util.Date;

public class OptometraBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String idOptometra;
	private String nombre1;
	private String nombre2; 
	private String apellidop;
	private String apellidom;
	private String nombres_apellidos;
	private String dni; 
	private Date FechaNacimiento;
	private String Sexo; 
	private Date FechaRegistro; 
	private String telefono; 
	private String celular; 
	private String correo; 
	private String direccion;
	private String referencia; 
	private String usuario;
	private String clave;
	private String idEstado;

	public OptometraBean(){
		
	}

	public OptometraBean(String idOptometra, String nombre1, String nombre2, String apellidop, String apellidom,
			String nombres_apellidos, String dni, Date fechaNacimiento, String sexo, Date fechaRegistro,
			String telefono, String celular, String correo, String direccion, String referencia, String usuario,
			String clave, String idEstado) {
		super();
		this.idOptometra = idOptometra;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.nombres_apellidos = nombres_apellidos;
		this.dni = dni;
		this.FechaNacimiento = fechaNacimiento;
		this.Sexo = sexo;
		this.FechaRegistro = fechaRegistro;
		this.telefono = telefono;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.referencia = referencia;
		this.usuario = usuario;
		this.clave = clave;
		this.idEstado = idEstado;
	}

	public String getIdOptometra() {
		return idOptometra;
	}

	public void setIdOptometra(String idOptometra) {
		this.idOptometra = idOptometra;
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

	public String getApellidop() {
		return apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getApellidom() {
		return apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public String getNombres_apellidos() {
		return nombres_apellidos;
	}

	public void setNombres_apellidos(String nombres_apellidos) {
		this.nombres_apellidos = nombres_apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	
	
	
}
