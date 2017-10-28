package com.corporosoft.optica.bean;

import java.io.Serializable;

public class ProductoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idProducto;
	private String idProveedor;
	private String idTipo_producto; 
	private String Marca; 
	private double precio;
	private int cantidad;
	private String descripcion;
	public ProductoBean(String idProducto, String idProveedor, String idTipo_producto, String marca, double precio,
			int cantidad, String descripcion) {
		super();
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
		this.idTipo_producto = idTipo_producto;
		Marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getIdTipo_producto() {
		return idTipo_producto;
	}
	public void setIdTipo_producto(String idTipo_producto) {
		this.idTipo_producto = idTipo_producto;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
