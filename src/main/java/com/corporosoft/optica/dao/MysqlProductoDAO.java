package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corporosoft.optica.bean.ProductoBean;
import com.corporosoft.optica.bean.TipoProductoBean;
import com.corporosoft.optica.interfaces.ProductoDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MysqlProductoDAO implements ProductoDAO{
	
	CallableStatement cs=null;
	Connection cn =null;
	ResultSet rs=null;
	TipoProductoBean objTipoProductoBean=null;
	List<TipoProductoBean> lista=null;
	List<ProductoBean> listaProducto=null;
	ProductoBean objProductoBean=null;

	@Override
	public List<TipoProductoBean> listaTipoProducto() {
		
		lista = new ArrayList<TipoProductoBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call listaTipoProducto()}";	
			cs=cn.prepareCall(sql);
			rs=cs.executeQuery();
			while (rs.next()) {
				objTipoProductoBean= new TipoProductoBean(rs.getString(1), rs.getString(2));
				lista.add(objTipoProductoBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Lista Tipo de Producto");
		}
		finally {
			try {
				rs.close();
				cs.close();
				cn.close();				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al Cerrar Conexcion ListaProducto");
			}
		}
		
		return lista;
	}

	@Override
	public List<ProductoBean> busquedaProductoTipoID(String idTipo) {
		
		listaProducto = new ArrayList<ProductoBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarTipoProductoID(?)}";	
			cs=cn.prepareCall(sql);
			cs.setString(1, idTipo);
			rs=cs.executeQuery();
			while (rs.next()) {
				objProductoBean= new ProductoBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
				listaProducto.add(objProductoBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error busquedaProductoTipoID");
		}
		finally {
			try {
				rs.close();
				cs.close();
				cn.close();				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al Cerrar Conexcion busquedaProductoTipoID");
			}
		}
		
		return listaProducto;
	}

	@Override
	public List<ProductoBean> busquedaProductoID(String idTipo) {
		listaProducto = new ArrayList<ProductoBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarProductoID(?)}";	
			cs=cn.prepareCall(sql);
			cs.setString(1, idTipo);
			rs=cs.executeQuery();
			while (rs.next()) {
				objProductoBean= new ProductoBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7));
				listaProducto.add(objProductoBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error busquedaProductoTipoID");
		}
		finally {
			try {
				rs.close();
				cs.close();
				cn.close();				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al Cerrar Conexcion busquedaProductoTipoID");
			}
		}
		
		return listaProducto;
	}

}
