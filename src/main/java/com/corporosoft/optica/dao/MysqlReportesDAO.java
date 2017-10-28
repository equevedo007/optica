package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corporosoft.optica.bean.ListaReportaPacientes;
import com.corporosoft.optica.interfaces.ReportesDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MysqlReportesDAO implements ReportesDAO{
	
	CallableStatement cs=null;
	ResultSet rs=null;
	Connection cn=null;
	ListaReportaPacientes objListaReportaPacientes=null; 

	@Override
	public List<ListaReportaPacientes> listaReporte(String fecha) {
		
		List<ListaReportaPacientes> lista= new ArrayList<ListaReportaPacientes>();
		ListaReportaPacientes obj = null;
		try {
			ConexionBD cnx = new ConexionBD();
			
			cn=cnx.getConeccionBD();
			
			String sql ="{call sp_consultaPriximoControl(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, fecha);			
			rs=cs.executeQuery();
			while(rs.next()){
				
				obj = new ListaReportaPacientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				lista.add(obj);
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en Lista de Reporte: " +e.getMessage());
		}finally{
			try {
			rs.close();
			cs.close();
			cn.close();
				
			} catch (SQLException ex) {
				
				System.out.println("Error Cerrar Conexion Reporte");
			}
		}
		
		
		return lista;
	}

}
