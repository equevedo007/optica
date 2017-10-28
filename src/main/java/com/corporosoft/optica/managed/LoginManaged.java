package com.corporosoft.optica.managed;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import com.corporosoft.optica.bean.UsuarioBean;
import com.corporosoft.optica.servicio.ServicioLicencia;
import com.corporosoft.optica.servicio.ServicioLogin;
import com.corporosoft.optica.utils.Operaciones;


@SessionScoped
@ManagedBean(name="login")
public class LoginManaged implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String clave;
	
	
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
	
	public String validarUsuario() throws Exception{
		ServicioLicencia servicioLicencia = new ServicioLicencia();
		
		String out="";
		ServicioLogin servicio = new ServicioLogin();
		
		UsuarioBean candidato = new UsuarioBean(null, null, null, null, null, null, null, null, null, null, usuario, DigestUtils.md5Hex(clave));
		UsuarioBean validar = servicio.ValidarUsuario(candidato);
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", validar);
		
		Operaciones operacion = new Operaciones();
		
		int dias =operacion.dias(servicioLicencia.validar().getFecha_fin());
		
		System.out.println("Dias es: " + dias);
		
		 if(dias < 0){
			System.out.println("Licencia Vencida");
			out="contacto";
		}else if(dias!=0){
			if(validar!=null){
				if(validar.getClave().equals(DigestUtils.md5Hex(clave))){
					System.out.println("Usuario Registrado...!!! Bienvenidos al Sistema de Opticas");
					
					out="bienvenida";
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido...",validar.getNombres_apellidos()));
					
					if(dias==3){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El tiempo de Prueba caduca en   ",""+dias+" Días"));
					}else if(dias==2){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El tiempo de Prueba caduca en   ",""+dias+" Días"));
					}
					else if(dias==1){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
								(FacesMessage.SEVERITY_WARN, "Estimado Usuario hoy termina el tiempo de prueba a gradecemos ponerse en contacto con CORPOROSOFT",""));
					}
				}
				else{
					System.out.println("Clave es Incorrecto.... por favor vuelva a inentar");
				}
			}else{
				System.out.println("Usuario no Registrado");
				out="login";
			}
		}
		
		else{
			System.out.println("Licencia Vencida");
			out="contacto";
		}
	
		return out;
		
	} 
	

}
