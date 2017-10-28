package com.corporosoft.optica.bean;

import java.io.Serializable;

public class DetalleBoletaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String idBoleta;
	private String idProducto;
	private int cantidad;
	private double precioUnidad;
	private double SubTotal;
	private double total;
	public DetalleBoletaBean(String idBoleta, String idProducto, int cantidad, double precioUnidad, double subTotal,
			double total) {
		super();
		this.idBoleta = idBoleta;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnidad = precioUnidad;
		SubTotal = subTotal;
		this.total = total;
	}
	public String getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public double getSubTotal() {
		return SubTotal;
	}
	public void setSubTotal(double subTotal) {
		SubTotal = subTotal;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
