package com.corporosoft.optica.managed;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import com.corporosoft.optica.bean.UsuarioBean;
import com.corporosoft.optica.servicio.ServicioOptometra;
import com.corporosoft.optica.servicio.ServicioUsuario;


@RequestScoped
@ManagedBean
public class cambioContrasennaManaged implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String ContrasennaAnterior;
	private String NuevaContrasenna;
	private String RepetirContrasenna;
	
	
	public String getContrasennaAnterior() {
		return ContrasennaAnterior;
	}
	public void setContrasennaAnterior(String contrasennaAnterior) {
		ContrasennaAnterior = contrasennaAnterior;
	}
	public String getNuevaContrasenna() {
		return NuevaContrasenna;
	}
	public void setNuevaContrasenna(String nuevaContrasenna) {
		NuevaContrasenna = nuevaContrasenna;
	}
	public String getRepetirContrasenna() {
		return RepetirContrasenna;
	}
	public void setRepetirContrasenna(String repetirContrasenna) {
		RepetirContrasenna = repetirContrasenna;
	}
	
	
	public String CambiarContrasenna() throws Exception{
		String out="";
		
		FacesContext context = FacesContext.getCurrentInstance();		
		
		UsuarioBean usu = (UsuarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");		
		ServicioOptometra so= new ServicioOptometra();		
		ServicioUsuario su = new ServicioUsuario();
		
		
		if(usu.getClave().equals(DigestUtils.md5Hex(ContrasennaAnterior))){
			
			if(NuevaContrasenna.equals(RepetirContrasenna)){
				
				
				so.ActualizarContrasenaOptometra(usu.getIdusuario(), DigestUtils.md5Hex(NuevaContrasenna));
				su.ActualizarContrasenaUsuario(usu.getIdusuario(), DigestUtils.md5Hex(NuevaContrasenna));
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				out="login";
				
			}else{
				context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Las Contraseñas  ",  "No son Iguales") );
			}
		}else{
			context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La Contraseña  ",  "No coincide con la anterior ") );
		}
		return out;
	}
	

}
