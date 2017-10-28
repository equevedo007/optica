package com.corporosoft.optica.bean;

import java.io.Serializable;
import java.util.Date;

public class ClienteBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String idCliente;
	private String nombre1;
	private String nombre2;
	private String apellidop;
	private String apellidom;
	private String nombres_apellidos;
	private String dni;
	private Date fechaNacimiento;
	private String estadoCivil;
	private String sexo;
	private Date fechaRegistro;
	private String ocupacion;
	private String direccion;
	private String referencia;
	private String telefono;
	private String celular;
	private String correo;
	private String distrito;
	
	
	
	public ClienteBean (){
		
	}
	public ClienteBean(String idCliente, String nombre1, String nombre2, String apellidop, String apellidom,
			String nombres_apellidos, String dni, Date fechaNacimiento, String estadoCivil, String sexo,
			Date fechaRegistro, String ocupacion, String direccion, String referencia, String telefono, String celular,
			String correo, String distrito) {
		super();
		this.idCliente = idCliente;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.nombres_apellidos = nombres_apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.fechaRegistro = fechaRegistro;
		this.ocupacion = ocupacion;
		this.direccion = direccion;
		this.referencia = referencia;
		this.telefono = telefono;
		this.celular = celular;
		this.correo = correo;
		this.distrito = distrito;
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
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
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
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
}
