package com.corporosoft.optica.managed;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.corporosoft.optica.bean.ClienteBean;
import com.corporosoft.optica.bean.DetalleBoletaBean;
import com.corporosoft.optica.bean.ProductoBean;
import com.corporosoft.optica.bean.TipoProductoBean;
import com.corporosoft.optica.servicio.ServicioCliente;
import com.corporosoft.optica.servicio.ServicioProducto;

@ViewScoped
@ManagedBean(name="RealizarVenta")
public class RealizarVenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String DNI;
	private String Nombres_Cliente;
	private List<ClienteBean> listaCliente;
	private ClienteBean objClienteBean = new ClienteBean();
	private String idTipoProducto;
	private List<TipoProductoBean> listaTipoProducto;
	private List<ProductoBean> listaProducto;
	private String idProducto;
	private int cantidad;
	private BigDecimal precio;
	private BigDecimal subTotal;
	private BigDecimal total;
	private BigDecimal totalIGVBoleta;
	private List<DetalleBoletaBean> listaDetalleProducto = new ArrayList<DetalleBoletaBean>();
	ServicioProducto objServicioProducto= new ServicioProducto();
	
	
	
	
	public List<DetalleBoletaBean> getListaDetalleProducto() {
		return listaDetalleProducto;
	}
	public void setListaDetalleProducto(List<DetalleBoletaBean> listaDetalleProducto) {
		this.listaDetalleProducto = listaDetalleProducto;
	}
	public BigDecimal getTotalIGVBoleta() {
		return totalIGVBoleta;
	}
	public void setTotalIGVBoleta(BigDecimal totalIGVBoleta) {
		this.totalIGVBoleta = totalIGVBoleta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public List<ProductoBean> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<ProductoBean> listaProducto) {
		this.listaProducto = listaProducto;
	}
	public List<TipoProductoBean> getListaTipoProducto() {
		ServicioProducto servicio = new ServicioProducto();
		listaTipoProducto=servicio.listaTipoProducto();
		return listaTipoProducto;
	}
	public void setListaTipoProducto(List<TipoProductoBean> listaTipoProducto) {
		this.listaTipoProducto = listaTipoProducto;
	}
	public String getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(String idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}	
	public ClienteBean getObjClienteBean() {
		return objClienteBean;
	}
	public void setObjClienteBean(ClienteBean objClienteBean) {
		this.objClienteBean = objClienteBean;
	}
	public List<ClienteBean> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<ClienteBean> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombres_Cliente() {
		return Nombres_Cliente;
	}
	public void setNombres_Cliente(String nombres_Cliente) {
		Nombres_Cliente = nombres_Cliente;
	}
	
	public void buscarCliente() throws Exception{		
		FacesContext context = FacesContext.getCurrentInstance();
		ServicioCliente servicio = new ServicioCliente();
		
		if(Nombres_Cliente.equals("") && DNI.equals("")){
			context.addMessage(null, new FacesMessage("Se debe de ingresar",  "Nombres o Apellidos para la bÃƒÂºsqueda") );
			
		}else if		
		(Nombres_Cliente.equals("")){
			listaCliente= servicio.buscarClienteDNI(DNI);
			if(listaCliente.size()==0){
				context.addMessage(null, new FacesMessage("DNI",  "No se Encuentra Registrado") );
			}			
		}else if(DNI.equals("")){
			listaCliente= servicio.buscarClienteNombres(Nombres_Cliente);
			
			
			System.out.println("Nombre para mostar: "+Nombres_Cliente);
			if(listaCliente.size()==0){
				context.addMessage(null, new FacesMessage("Nombres y Apellidos",  "No se Encuentra Registrado") );
			}
		}	else if(Nombres_Cliente.equals("") && DNI.equals("")){
			context.addMessage(null, new FacesMessage("Debe de ingresas",  "Nombre o DNI para la bÃƒÂºsqueda") );
		}else if(Nombres_Cliente!=null && DNI!=null){
			context.addMessage(null, new FacesMessage("Se debe de ingresar",  "Solo un criterio de BÃƒÂºsqueda") );
			
		}
	}
	
	public void CalcularCosto()throws Exception{
		
	}
	
	public void buscarClienteID(ActionEvent e){
		
		try {
			ServicioCliente servicio = new ServicioCliente();
			String idCliente =e.getComponent().getAttributes().get("idCliente").toString();
			objClienteBean = servicio.buscarClienteID(idCliente);
			System.out.println("Id Cliente ha Buscar: " + idCliente);
			Nombres_Cliente= objClienteBean.getNombres_apellidos();
			
			
		} catch (Exception e2) {
			System.out.println("Error buscar Cliente ID : " + e2.getMessage());
			e2.printStackTrace();
		}
		
	}
	
	public void buscarProducto() throws Exception {
		
		
		System.out.println("ID Tipo de Producto a buscar: " + idTipoProducto.trim());
		System.out.println("ID Producto a buscar: " + idProducto.trim());
		
		if(idTipoProducto.equals("seleccione") && !idProducto.equals("")){
			
			listaProducto=objServicioProducto.busquedaProductoID(idProducto.trim());
		}else if(idProducto.equals("") && !idTipoProducto.equals("seleccione")){
			listaProducto=objServicioProducto.busquedaProductoTipoID(idTipoProducto.trim());			
		}

	}

	public void buscarProductoID(ActionEvent e) throws Exception{
		
	}
	
	public void EliminarProductoDetalle(ActionEvent e){		
		
	}
}

