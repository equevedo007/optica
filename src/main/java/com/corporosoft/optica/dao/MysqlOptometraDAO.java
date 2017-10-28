package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.corporosoft.optica.bean.EstadaOptometraBean;
import com.corporosoft.optica.bean.OptometraBean;
import com.corporosoft.optica.interfaces.OptometraDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MysqlOptometraDAO implements OptometraDAO{
	
	CallableStatement cs=null;
	Connection cn =null;
	ResultSet rs=null;
	EstadaOptometraBean objEstadaOptometraBean=null;
	OptometraBean objOptometraBean=null;

	@Override
	public void RegistarOptometra(OptometraBean objOptometraBean) throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_registrarOptometra(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, objOptometraBean.getIdOptometra().trim());
			cs.setString(2, objOptometraBean.getNombre1().toUpperCase().trim());
			cs.setString(3, objOptometraBean.getNombre2().toUpperCase().trim());
			cs.setString(4, objOptometraBean.getApellidop().toUpperCase().trim());
			cs.setString(5, objOptometraBean.getApellidom().toUpperCase().trim());
			cs.setString(6, objOptometraBean.getNombres_apellidos().toUpperCase().trim());
			cs.setString(7, objOptometraBean.getDni().toUpperCase().trim());
			cs.setDate(8, new java.sql.Date(objOptometraBean.getFechaNacimiento().getTime()));
			cs.setString(9, objOptometraBean.getSexo().toString());
			cs.setDate(10, new java.sql.Date(objOptometraBean.getFechaRegistro().getTime()));
			cs.setString(11,objOptometraBean.getTelefono().trim());
			cs.setString(12, objOptometraBean.getCelular().trim());
			cs.setString(13, objOptometraBean.getCorreo().trim());
			cs.setString(14, objOptometraBean.getDireccion().trim());
			cs.setString(15, objOptometraBean.getReferencia().trim());
			cs.setString(16, objOptometraBean.getUsuario().trim());
			cs.setString(17, objOptometraBean.getClave().trim());
			cs.setString(18, objOptometraBean.getIdEstado());
			cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al Registar Optometra: "+e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				cs.close();
				cn.close();
				
			} catch (SQLException e) {
				System.out.println("Error al Cerrar Conexion Registar Optometra: "+e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<EstadaOptometraBean> EstadoOptometra() throws Exception {
		List<EstadaOptometraBean> lista = new ArrayList<EstadaOptometraBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_listaEstadoOptometra()}";
			cs=cn.prepareCall(sql);
			rs=cs.executeQuery();
			while (rs.next()) {
				objEstadaOptometraBean = new EstadaOptometraBean(rs.getString(1), rs.getString(2));
				lista.add(objEstadaOptometraBean);
				
			}
			
		} catch (Exception e) {
			System.out.println("Error al Listar Estado Optometra : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar Conexion : " +e.getMessage());
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<OptometraBean> BuscarUsuarioOptometra(String usu) throws Exception {
		List<OptometraBean> lista = new ArrayList<OptometraBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarUsuarioOptometra(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, usu);
			rs=cs.executeQuery();
			while (rs.next()) {
				objOptometraBean = new OptometraBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getDate(8), rs.getString(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
						rs.getString(16), rs.getString(17), rs.getString(18));
			lista.add(objOptometraBean);	
							
			}
			
		} catch (Exception e) {
			System.out.println("Error al Listar Buscar Usuario Optometra : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar Conexion : " +e.getMessage());
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<OptometraBean> BuscarDNIOptometra(String dni) throws Exception {
		List<OptometraBean> lista = new ArrayList<OptometraBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscardniOptometra(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, dni);
			rs=cs.executeQuery();
			while (rs.next()) {
				objOptometraBean = new OptometraBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getDate(8), rs.getString(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
						rs.getString(16), rs.getString(17), rs.getString(18));
			lista.add(objOptometraBean);	
							
			}
			
		} catch (Exception e) {
			System.out.println("Error al Listar Buscar Usuario Optometra : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar Conexion : " +e.getMessage());
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<OptometraBean> BuscarOptometraNombres(String nombres) throws Exception {
		
		List<OptometraBean> lista = new ArrayList<OptometraBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarOptometraNombres(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, "%"+nombres+"%");
			rs=cs.executeQuery();
			while (rs.next()) {
				objOptometraBean = new OptometraBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getDate(8), rs.getString(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
						rs.getString(16), rs.getString(17), rs.getString(18));
			lista.add(objOptometraBean);	
							
			}
			
		} catch (Exception e) {
			System.out.println("Error al  Buscar  Optometra nombres: " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar Conexion Optometra nombres: " +e.getMessage());
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public OptometraBean buscarOptometraID(String idOptometra) throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();
			cn= cnx.getConeccionBD();
			String sql ="{call sp_buscarOptometraID(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, idOptometra);
			rs=cs.executeQuery();
			if(rs.next()){
				objOptometraBean = new OptometraBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getDate(8), rs.getString(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
						rs.getString(16), rs.getString(17), rs.getString(18));
			}
			
		} catch (Exception e) {
			System.out.println("Error Buscar Optometra ID : "+e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrrar Conexion Buscar Optometra ID : "+e.getMessage());
				e.printStackTrace();
			}
		}
		
		return objOptometraBean;
	}

	@Override
	public String descripcionEstadoOptometra(String idEstado) throws Exception {
		String out="";
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarEstadoOptometraDescrip(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, idEstado);
			rs=cs.executeQuery();
			if(rs.next()){
				out=rs.getString(1);
			}
			
		} catch (Exception e) {
			System.out.println("Error descripcionEstadoOptometra " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion descripcionEstadoOptometra :"+e.getMessage() );
				e.printStackTrace();
			}
		}
		return out;
	}

	@Override
	public void ActualizarOptmetra(OptometraBean objOptometraBean) throws ExecutionException {
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_actualizarOptometra(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, objOptometraBean.getNombre1().toUpperCase().trim());
			cs.setString(2, objOptometraBean.getNombre2().toUpperCase().trim());
			cs.setString(3, objOptometraBean.getApellidop().toUpperCase().trim());
			cs.setString(4, objOptometraBean.getApellidom().toUpperCase().trim());
			cs.setString(5, objOptometraBean.getNombres_apellidos().toUpperCase().trim());
			cs.setString(6, objOptometraBean.getDni().toUpperCase().trim());
			cs.setDate(7, new java.sql.Date(objOptometraBean.getFechaNacimiento().getTime()));
			cs.setString(8, objOptometraBean.getSexo().toString());
			cs.setDate(9, new java.sql.Date(objOptometraBean.getFechaRegistro().getTime()));
			cs.setString(10,objOptometraBean.getTelefono().trim());
			cs.setString(11, objOptometraBean.getCelular().trim());
			cs.setString(12, objOptometraBean.getCorreo().trim());
			cs.setString(13, objOptometraBean.getDireccion().trim());
			cs.setString(14, objOptometraBean.getReferencia().trim());
			cs.setString(15, objOptometraBean.getUsuario().trim());
			cs.setString(16, objOptometraBean.getClave().trim());
			cs.setString(17, objOptometraBean.getIdEstado());
			cs.setString(18, objOptometraBean.getIdOptometra().trim());
			cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al Registar Optometra: "+e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				cs.close();
				cn.close();
				
			} catch (SQLException e) {
				System.out.println("Error al Cerrar Conexion Registar Optometra: "+e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void ActualizarContrasennaOptometra(String idusuario, String password) throws Exception {
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql ="{call sp_actualizarContrasenaOptometra(?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, idusuario);
			cs.setString(2, password);
			cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error Actualizar Contraseña Optometra : " +e.getMessage());
			e.printStackTrace();
	
		}finally {
			try {
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Erorr cerrar Conexion Actualizar Contraseña Optometra : " +e.getMessage());
				e.printStackTrace();
			}
		}
		
	}


}
