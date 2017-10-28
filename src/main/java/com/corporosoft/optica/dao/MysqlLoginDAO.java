package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.corporosoft.optica.bean.UsuarioBean;
import com.corporosoft.optica.interfaces.LoginDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MysqlLoginDAO implements LoginDAO{
	
	CallableStatement cs=null;
	Connection cn=null;
	ResultSet rs=null;
	UsuarioBean objUsuarioBean=null;

	@Override
	public UsuarioBean ValidarUsuario(String usuario) throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();			
			cn=cnx.getConeccionBD();
			String sql ="{call sp_login(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, usuario);
			rs=cs.executeQuery();
			if(rs.next()){
				objUsuarioBean = new UsuarioBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getDate(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
			}
			
		} catch (Exception e) {
			System.out.println("Error en Validar Usuario: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion Valdiar UsuarioDAO : " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return objUsuarioBean;
	}

}
