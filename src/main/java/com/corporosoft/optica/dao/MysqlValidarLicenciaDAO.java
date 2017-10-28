package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corporosoft.optica.bean.LicenciaBean;
import com.corporosoft.optica.bean.ValidarLicenciaBean;
import com.corporosoft.optica.interfaces.validarLicenciaDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MysqlValidarLicenciaDAO implements validarLicenciaDAO{
	
	Connection cn=null;
	CallableStatement cs=null;
	ResultSet rs=null;
	ValidarLicenciaBean objValidarLicenciaBean=null;
	PreparedStatement pt =null;
	LicenciaBean objLicenciaBean= null;
	

	@Override
	public List<ValidarLicenciaBean> validarLicencia(String licencia) throws Exception {
		
		List<ValidarLicenciaBean> lista= new ArrayList<ValidarLicenciaBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn= cnx.getConeccionBD();
			
			String sql ="{call sp_validarLicencia(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, licencia);
			rs=cs.executeQuery();
			if (rs.next()) {
				objValidarLicenciaBean = new ValidarLicenciaBean(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5));
				lista.add(objValidarLicenciaBean);
			}
			
		} catch (Exception e) {
			System.out.println("Error en Valdiar Licencia: " +e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error Cerrar Conexion Valdar Licencia: " + e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public void ingressarLicencia(String licencia) throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();
			cn= cnx.getConeccionBD();
			
			String sql ="{call sp_ingresarLicencia(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, licencia);
			cs.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error en Ingresar Licencia: " +e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				cs.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error Cerrar Conexion Ingresar Licencia: " + e.getMessage());
			}
		}
		
		
	}

	@Override
	public ValidarLicenciaBean validar() throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();			
			cn= cnx.getConeccionBD();
			String sql ="select * from validar_licencia order by idvalidar_licencia desc";
			pt=cn.prepareStatement(sql);
			rs=pt.executeQuery();
			if(rs.next()){
				objValidarLicenciaBean = new ValidarLicenciaBean(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5));
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en Cerrar Conexion:");
		}finally {
			try {
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error en Cerrar Conexion Validar ");
			}
		}
		
		return objValidarLicenciaBean;
	}

	@Override
	public void registrarlicencias(String idLicencia,String tiempo, String licencia) throws Exception {

		
		try {
			ConexionBD cnx = new ConexionBD();
			cn= cnx.getConeccionBD();
			
			String sql ="insert into licencia values (?,?,?)";
			pt=cn.prepareCall(sql);
			pt.setString(1, idLicencia);
			pt.setString(2, tiempo);
			pt.setString(3, licencia);
			pt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error en registrarlicencias Licencia: " +e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error Cerrar Conexion registrarlicencias Licencia: " + e.getMessage());
			}
		}
		
	}

	@Override
	public List<LicenciaBean> buscarLicencia(String licencia) throws Exception {
		
		List<LicenciaBean> lista = new ArrayList<LicenciaBean>();
		try {
			ConexionBD cnx = new ConexionBD();
			cn= cnx.getConeccionBD();
			
			String sql ="select * from licencia l where l.licencia=?";
			pt=cn.prepareStatement(sql);
			pt.setString(1, licencia);
			rs=pt.executeQuery();
			if(rs.next()){
				objLicenciaBean = new LicenciaBean(rs.getString(1), rs.getString(2), rs.getString(3));
				lista.add(objLicenciaBean);
			}
			
		} catch (Exception e) {
			System.out.println("Error en Buscar Licencia: " +e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error Cerrar Conexion Buscar  Licencia: " + e.getMessage());
			}
		}
		return lista;
	}

}
