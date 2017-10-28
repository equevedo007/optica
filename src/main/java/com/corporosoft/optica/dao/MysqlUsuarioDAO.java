package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.corporosoft.optica.interfaces.UsuarioDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MysqlUsuarioDAO implements UsuarioDAO{
	
	Connection cn=null;
	CallableStatement cs=null;
	

	@Override
	public void ActualizarContrasennaUsuario(String idusuario, String password) throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql ="{call sp_actualizarContrasenaUsuario(?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, idusuario);
			cs.setString(2, password);
			cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error Actualizar Contraseña Usuario : " +e.getMessage());
			e.printStackTrace();
	
		}finally {
			try {
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Erorr cerrar Conexion Actualizar Contraseña Usuario : " +e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}
