package com.corporosoft.optica.bean;

import java.io.Serializable;
import java.sql.Date;

public class UsuarioBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String idusuario;
	private String nombre1;
	private String nombre2;
	private String apellidop;
	private String apellidom;
	private String dni;
	private String nombres_apellidos;
	private Date FechaRegistro;
	private String cargo;
	private String estado;
	private String usuario;
	private String clave;
	public UsuarioBean(String idusuario, String nombre1, String nombre2, String apellidop, String apellidom, String dni,
			String nombres_apellidos, Date fechaRegistro, String cargo, String estado, String usuario, String clave) {
		super();
		this.idusuario = idusuario;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.dni = dni;
		this.nombres_apellidos = nombres_apellidos;
		FechaRegistro = fechaRegistro;
		this.cargo = cargo;
		this.estado = estado;
		this.usuario = usuario;
		this.clave = clave;
	}
	public String getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres_apellidos() {
		return nombres_apellidos;
	}
	public void setNombres_apellidos(String nombres_apellidos) {
		this.nombres_apellidos = nombres_apellidos;
	}
	public Date getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	
	
	
	

}
