package com.corporosoft.optica.managed;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.codec.digest.DigestUtils;

import com.corporosoft.optica.bean.EstadaOptometraBean;
import com.corporosoft.optica.bean.OptometraBean;
import com.corporosoft.optica.servicio.ServicioOptometra;
import com.corporosoft.optica.utils.GeneradorDeCodigo;
import com.corporosoft.optica.utils.Operaciones;

@ViewScoped
@ManagedBean(name="optometraManaged")
public class OptometraManaged implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	
	private String codigo;
	private List<OptometraBean> lista;
	private String nombres;
	private OptometraBean objOptometra;
	private String dni;
	private String clave;
	private String Estado;
	private String descripEstado;
	
	private List<EstadaOptometraBean> EstadoOptometra;
	
	
	public OptometraManaged() throws Exception{
		
		objOptometra= new OptometraBean();
		EstadoOptometra= new ArrayList<EstadaOptometraBean>();
		init();
	}
	
	@PostConstruct
	public void init() throws Exception{
		ServicioOptometra servicio = new ServicioOptometra();
		EstadoOptometra=servicio.estadoOPtometra();
	}

	
	
	
	public String getDescripEstado() {
		return descripEstado;
	}

	public void setDescripEstado(String descripEstado) {
		this.descripEstado = descripEstado;
	}

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public List<OptometraBean> getLista() {
		return lista;
	}


	public void setLista(List<OptometraBean> lista) {
		this.lista = lista;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public OptometraBean getObjOptometra() {
		return objOptometra;
	}


	public void setObjOptometra(OptometraBean objOptometra) {
		this.objOptometra = objOptometra;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public List<EstadaOptometraBean> getEstadoOptometra() throws Exception {
		
		return EstadoOptometra;
	}


	public void setEstadoOptometra(List<EstadaOptometraBean> estadoOptometra) {
		EstadoOptometra = estadoOptometra;
	}
	
	public String grabarOptometra() throws Exception{
		
		String out="";
		GeneradorDeCodigo codigo = new GeneradorDeCodigo();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ServicioOptometra servicio = new ServicioOptometra();	
		Operaciones operaciones = new Operaciones();
		
		String fecha=sdf.format(objOptometra.getFechaNacimiento());
		int edad = operaciones.edad(fecha);
		
		System.out.println("Edad es:" +edad);
		
	
		FacesContext context = FacesContext.getCurrentInstance();
		
		List<OptometraBean> listaUsuario=servicio.BuscarUsuarioOptometra(objOptometra.getUsuario());
		List<OptometraBean> listaDNI=servicio.BuscarDNIOptometra(objOptometra.getDni());
		
		
		
		
		if(listaUsuario.size()>0){
			context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Este Usuario ya estÃƒÂ¡ registrado ",  "Por favor de intentar con Otro Usuario") );
			listaUsuario=null;
		}
		
		else if(listaDNI.size()>0){
			context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El NÃƒÂºmero de DNI  ya estÃƒÂ¡ registrado ",  "Por favor de intentar con Otro DNI") );
			listaDNI=null;
		}
		
		else if(edad<18){
			context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El optÃƒÂ³metra Debe de Cumplir la MayorÃƒÂ­a de edad",  "Ingresar una Fecha de nacimiento Valida") );
			
		}
		
		else if(edad>76){
			context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La Edad del OptÃƒÂ³metra",  "No estÃƒÂ¡ permito en el Rango 18 a 75 AÃƒÂ±os") );
			
		}else if(objOptometra.getClave()==null || objOptometra.getClave().equals("")){
			context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Se debe de ingresar ",  "Una Clave para el optÃƒÂ³metra") );
		}
		
		else if(clave.equals(objOptometra.getClave())){
			Date fecha1 = new Date();
			String nombres_apellidos=objOptometra.getNombre1().toUpperCase().trim()+" "+objOptometra.getNombre2().toUpperCase().trim()+" "+objOptometra.getApellidop().toUpperCase().trim()+" "+objOptometra.getApellidom(); 
			
			objOptometra.setIdOptometra(codigo.Optometra());
			objOptometra.setIdEstado(Estado);
			objOptometra.setNombres_apellidos(nombres_apellidos.replaceAll("  ", " "));
			objOptometra.setFechaRegistro(fecha1);
			
			objOptometra.setClave(DigestUtils.md5Hex(clave));
			
			servicio.RegistarOptometra(objOptometra);
			context.addMessage(null, new FacesMessage("El OptÃƒÂ³metra",  "Se Registrado Satisfactoriamente.") );
			out="registrarOptometra";
			
			
			
		}else{
			context.addMessage  (null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Las Claves ingresada",  "No corresponden ") );
		}
		return out;
		
	}
	
	public void buscarID(ActionEvent e) throws Exception{
		
		codigo= e.getComponent().getAttributes().get("idOptometra").toString();
		System.out.println("Codigo Optometra a Buscar: " +codigo);
		ServicioOptometra servicio = new ServicioOptometra();
		objOptometra= servicio.buscarOptometraID(codigo);
		
		descripEstado=servicio.buscarDescripcionEstadoOptometra(objOptometra.getIdEstado());
		
	}
	
	public void buscarOptometra() throws Exception{	
			
		System.out.println("Buscar Optometra");
		FacesContext context = FacesContext.getCurrentInstance();
		ServicioOptometra servicio = new ServicioOptometra();
		
		if(nombres.equals("") && dni.equals("")){
			context.addMessage(null, new FacesMessage("Se debe de ingresar",  "Nombres o Apellidos para la búsqueda.") );
		}else if(nombres.equals("")){
			lista= servicio.BuscarDNIOptometra(dni);
			if(lista.size()==0){
				context.addMessage(null, new FacesMessage("DNI",  "No se Encuentra Registrado") );
			}			
		}else if(dni.equals("")){
			lista= servicio.buscarOptometraNombres(nombres);
			if(lista.size()==0){
				context.addMessage(null, new FacesMessage("Nombres y Apellidos",  "No se Encuentra Registrado") );
			}
		}	else if(nombres.equals("") && dni.equals("")){
			context.addMessage(null, new FacesMessage("Debe de ingresas",  "Nombre o DNI para la búsqueda") );
		}	else if(nombres!=null && dni!=null){
			context.addMessage(null, new FacesMessage("Se debe de ingresar",  "Solo un criterio de Búsqueda") );
			
		}
		

	}
	
	public String actualizar() throws Exception{			
		String out="";
		
		System.out.println("Estado es : " + Estado);
		
		ServicioOptometra servicio= new ServicioOptometra();
		if(!Estado.equals("Seleccione")){
			objOptometra.setIdEstado(Estado);
		}
		servicio.ActualizarOptometra(objOptometra);
		LimpiarCampos();
		buscarOptometra();
		return out;
		
	}
	
	
	
	public void LimpiarCampos(){
		this.objOptometra.setNombre1("");
		this.objOptometra.setNombre2("");
		this.objOptometra.setApellidop("");
		this.objOptometra.setApellidom("");
		this.objOptometra.setNombres_apellidos("");
		this.objOptometra.setDni("");
		this.objOptometra.setFechaNacimiento(null);
		this.objOptometra.setSexo("");
		this.objOptometra.setCelular("");
		this.objOptometra.setTelefono("");
		this.objOptometra.setCorreo("");
		this.objOptometra.setDireccion("");
		this.objOptometra.setReferencia("");
		
		
		System.out.println("Campos Limpiados Personalizado");
	}
	
	
	

}
