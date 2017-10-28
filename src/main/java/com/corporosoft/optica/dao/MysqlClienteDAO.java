package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corporosoft.optica.bean.ClienteBean;
import com.corporosoft.optica.interfaces.ClienteDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MysqlClienteDAO implements ClienteDAO{
	
	CallableStatement cs=null;
	Connection cn =null;
	ClienteBean objClienteBean =null;
	ResultSet rs = null;
	
	
	@Override
	public void RegistrarCliente(ClienteBean objCliente) throws Exception {
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_registrarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, objCliente.getIdCliente().trim());
			cs.setString(2, objCliente.getNombre1().toUpperCase().trim());
			cs.setString(3, objCliente.getNombre2().toUpperCase().trim());
			cs.setString(4, objCliente.getApellidop().toUpperCase().trim());
			cs.setString(5, objCliente.getApellidom().toUpperCase().trim());
			cs.setString(6, objCliente.getNombres_apellidos().trim());
			cs.setString(7, objCliente.getDni().trim());
			cs.setDate(8, new java.sql.Date(objCliente.getFechaNacimiento().getTime()));
			cs.setString(9, objCliente.getEstadoCivil().trim());
			cs.setString(10, objCliente.getSexo().trim());
			cs.setDate(11, new java.sql.Date(objCliente.getFechaRegistro().getTime()));
			cs.setString(12, objCliente.getOcupacion().trim());
			cs.setString(13, objCliente.getDireccion().trim());
			cs.setString(14, objCliente.getReferencia().trim());
			cs.setString(15, objCliente.getTelefono().trim());
			cs.setString(16, objCliente.getCelular().trim());
			cs.setString(17, objCliente.getCorreo().trim());
			cs.setString(18, objCliente.getDistrito().trim());
			cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en registar Cliente: " + e.getMessage());
			e.printStackTrace();
		}finally {
			{
				try {
					cs.close();
					cn.close();					
				} catch (SQLException e) {
					System.out.println("Error en Cerrar Conexion Registar Cliente: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	@Override
	public List<ClienteBean> buscarClienteDNI(String dni) throws Exception {
		List<ClienteBean> lista = new ArrayList<ClienteBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarclientedni(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, dni);
			rs=cs.executeQuery();
			while (rs.next()) {
				objClienteBean = new ClienteBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8),
						rs.getString(9), rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), 
						rs.getString(17), rs.getString(18));
				lista.add(objClienteBean);
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar Cliente DNI: " + e.getMessage());
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion : "  + e.getMessage());
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<ClienteBean> buscarClienteNombres(String nombres) throws Exception {
		List<ClienteBean> lista = new ArrayList<ClienteBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarclienteNombre(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, "%"+nombres+"%");
			rs=cs.executeQuery();
			while (rs.next()) {
				objClienteBean = new ClienteBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8),
						rs.getString(9), rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), 
						rs.getString(17), rs.getString(18));
				lista.add(objClienteBean);
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar Cliente DNI: " + e.getMessage());
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion : "  + e.getMessage());
				e.printStackTrace();
			}
		}
		return lista;
	}


	@Override
	public ClienteBean buscarClienteID(String idCliente) throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarClienteID(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, idCliente);
			rs=cs.executeQuery();
			if(rs.next()) {
				objClienteBean = new ClienteBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8),
						rs.getString(9), rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), 
						rs.getString(17), rs.getString(18));
				
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en Buscar Clientre ID : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cn.close();
				
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return objClienteBean;
	}


	@Override
	public void ActualizarCliente(ClienteBean objClienteBean) throws Exception {
		try {
			ConexionBD cnx = new ConexionBD();
			cn= cnx.getConeccionBD();
			String sql="{call sp_actualizarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, objClienteBean.getNombre1().toUpperCase().trim());
			cs.setString(2, objClienteBean.getNombre2().toUpperCase().trim());
			cs.setString(3, objClienteBean.getApellidop().toUpperCase().trim());
			cs.setString(4, objClienteBean.getApellidom().toUpperCase().trim());
			cs.setString(5, objClienteBean.getNombres_apellidos().toUpperCase().trim());
			cs.setString(6, objClienteBean.getDni().toUpperCase().trim());
			cs.setDate(7, new java.sql.Date(objClienteBean.getFechaNacimiento().getTime()));
			cs.setString(8, objClienteBean.getEstadoCivil().trim());
			cs.setString(9, objClienteBean.getSexo().trim());
			cs.setString(10, objClienteBean.getOcupacion().trim());
			cs.setString(11, objClienteBean.getDireccion().trim());
			cs.setString(12, objClienteBean.getReferencia().trim());
			cs.setString(13, objClienteBean.getTelefono().trim());
			cs.setString(14, objClienteBean.getCelular().trim());
			cs.setString(15, objClienteBean.getCorreo().trim());
			cs.setString(16, objClienteBean.getDistrito().trim());
			cs.setString(17, objClienteBean.getIdCliente().trim());
			cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en Actulziar Cliente: " +e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion : "+ e.getMessage());
				e.printStackTrace();
			} 
		}
		
	}

	

}
