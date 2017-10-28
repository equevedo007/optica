package com.corporosoft.optica.managed;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name="prueba")
public class pruebaManageg implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String nombres;
	
	private String apellidos;
	
	
	
	
	public String getNombres() {
		return nombres;
	}




	public void setNombres(String nombres) {
		this.nombres = nombres;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public void Prueba(){
		
		FacesContext context = FacesContext.getCurrentInstance();	
		context.addMessage(null, new FacesMessage( "Nombres", ":"+ nombres) );
		context.addMessage(null, new FacesMessage( "Nombres", ":"+ apellidos) );
		
	}

}
