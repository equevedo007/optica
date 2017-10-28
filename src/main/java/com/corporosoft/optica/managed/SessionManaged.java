package com.corporosoft.optica.managed;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.corporosoft.optica.bean.UsuarioBean;


@Named
@SessionScoped
@ManagedBean
public class SessionManaged implements Serializable{

	
	private static final long serialVersionUID = 1L;
	public void verificarSession(){
		
		try {
			UsuarioBean usu = (UsuarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			
			if(usu==null){
				FacesContext.getCurrentInstance().getExternalContext().redirect("../../ui/error/permisos.xhtml");
				System.out.println("No cuenta con permisos");
				
			}
		} catch (Exception e) {
			System.out.println("Error en Verificar Session...");
		}
	}
	
	public String cerrarSession(){
		String out="";
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		out="login";
		return out;
	}
	
	
	

}
