package com.corporosoft.optica.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.corporosoft.optica.bean.ClienteBean;
import com.corporosoft.optica.servicio.ServicioCliente;
import com.corporosoft.optica.utils.GeneradorDeCodigo;

@ViewScoped
@ManagedBean(name="clienteManaged")
public class ClienteManaged implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String dni;
	private String nombres;
	private List<ClienteBean> lista = new ArrayList<ClienteBean>();;
	private ClienteBean objClienteBean = new ClienteBean();
	private Date fechaNacimiento;

	
	
	public ClienteBean getObjClienteBean() {
		return objClienteBean;
	}



	public void setObjClienteBean(ClienteBean objClienteBean) {
		this.objClienteBean = objClienteBean;
	}


	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public List<ClienteBean> getLista() {
		return lista;
	}
	public void setLista(List<ClienteBean> lista) {
		this.lista = lista;
	}

	public void buscarCliente() throws Exception{		
		FacesContext context = FacesContext.getCurrentInstance();
		ServicioCliente servicio = new ServicioCliente();
		
		if(nombres.equals("") && dni.equals("")){
			context.addMessage(null, new FacesMessage("Se debe de ingresar",  "Nombres o Apellidos para la bÃƒÂºsqueda") );
			
		}else if		
		(nombres.equals("")){
			lista= servicio.buscarClienteDNI(dni);
			if(lista.size()==0){
				context.addMessage(null, new FacesMessage("DNI",  "No se Encuentra Registrado") );
			}			
		}else if(dni.equals("")){
			lista= servicio.buscarClienteNombres(nombres);
			if(lista.size()==0){
				context.addMessage(null, new FacesMessage("Nombres y Apellidos",  "No se Encuentra Registrado") );
			}
		}	else if(nombres.equals("") && dni.equals("")){
			context.addMessage(null, new FacesMessage("Debe de ingresas",  "Nombre o DNI para la bÃƒÂºsqueda") );
		}else if(nombres!=null && dni!=null){
			context.addMessage(null, new FacesMessage("Se debe de ingresar",  "Solo un criterio de BÃƒÂºsqueda") );
			
		}
	}
	
	public void buscarClienteID(ActionEvent e){
		
		try {
			ServicioCliente servicio = new ServicioCliente();
			String idCliente =e.getComponent().getAttributes().get("idCliente").toString();
			objClienteBean = servicio.buscarClienteID(idCliente);
			System.out.println("Id Cliente ha Buscar: " + idCliente);
			
			
		} catch (Exception e2) {
			System.out.println("Error buscar Cliente ID : " + e2.getMessage());
			e2.printStackTrace();
		}
		
	}
	
	public void ActualizarCliente(ActionEvent e) throws Exception{
		
		ServicioCliente servicio =new ServicioCliente();
		servicio.ActualizarCliente(objClienteBean);
		
		limpiarCampos();
		buscarCliente();
	}
	public String RegistrarCliente(){
			 String out="";
		
		try {
			Date fechaRegistro = new Date();
			
			FacesContext context = FacesContext.getCurrentInstance();	
			
			ServicioCliente servicio = new ServicioCliente();
			GeneradorDeCodigo gencodigo = new GeneradorDeCodigo();			
			String codigloCliente = gencodigo.generaCodigoCliente();					
			String Nombres_apellidos= objClienteBean.getNombre1().toUpperCase().trim()+" "+ objClienteBean.getNombre2().toUpperCase().trim()+" "+objClienteBean.getApellidop().toUpperCase().trim()+" "+objClienteBean.getApellidom().toUpperCase().trim();
			
			objClienteBean.setNombres_apellidos(Nombres_apellidos.replaceAll("  ", " "));
			objClienteBean.setFechaNacimiento(fechaNacimiento);
			objClienteBean.setFechaRegistro(fechaRegistro);
			objClienteBean.setIdCliente(codigloCliente);
			
			
			List<ClienteBean> lista = servicio.buscarClienteDNI(objClienteBean.getDni());
			System.out.println("El sexo: " + objClienteBean.getSexo());
			 if(objClienteBean.getNombre1().equals("") || objClienteBean.getNombre1() ==null){
				context.addMessage(null, new FacesMessage("Primer Nombre",  "Debe de ingresar un valor") );
			}else if(objClienteBean.getApellidop().equals("") || objClienteBean.getApellidop() ==null){
				context.addMessage(null, new FacesMessage("Apellido Paterno",  "Es obligatorio") );
			}else if (objClienteBean.getApellidom().equals("") || objClienteBean.getApellidom() ==null){
				context.addMessage(null, new FacesMessage("Apellido Materno",  "Es obligatorio") );
			}else if(lista.size()>0){
				context.addMessage(null, new FacesMessage("DNI",  "Ya se encontra Registrado") );
			}else if(objClienteBean.getSexo().equals("null") || objClienteBean.getSexo() ==null || objClienteBean.getSexo().equals("") ||
					objClienteBean.getSexo().equals("-Seleccione-")){
				context.addMessage(null, new FacesMessage("Debe de Seleccionar ",  "El Sexo del Cliente") );
			}
			else{
				servicio.RegistrarCliente(objClienteBean);
				context.addMessage(null, new FacesMessage("El Cliente",  "Fue Registrado Satisfactoriamente") );
				out="registrarCliente";
				 
			}
			
			
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "" + e.getMessage()));
			
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		
		return out;
		
	}
	
	public void limpiarCampos(){
		this.objClienteBean.setNombre1("");
		this.objClienteBean.setNombre2("");
		this.objClienteBean.setApellidop("");
		this.objClienteBean.setApellidom("");
		this.objClienteBean.setDni("");
		this.objClienteBean.setFechaNacimiento(null);
		//this.objClienteBean.setEstadoCivil("");
		this.objClienteBean.setSexo("");
		this.objClienteBean.setOcupacion("");
		this.objClienteBean.setCelular("");
		this.objClienteBean.setTelefono("");
		this.objClienteBean.setCorreo("");
		this.objClienteBean.setDireccion("");
		this.objClienteBean.setReferencia("");
		
		
	}
	

}
