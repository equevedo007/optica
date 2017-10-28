package com.corporosoft.optica.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	public static final String Driver="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/optica";
	public static final String usuario="root";
	public static final String clave="P@ssw0rd";
	
	public  Connection getConeccionBD(){
		
		Connection cn=null;
		
		
		try {
			
			Class.forName(Driver);
			cn=DriverManager.getConnection(URL,usuario,clave);
			//System.out.println("Conexion Exitosa");
		} catch (Exception e) {
			System.out.println("Error de Conexion");
		}
		
		return cn;
		
	}

}
