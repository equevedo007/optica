package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corporosoft.optica.bean.ReporteHistoriasRegistradasBean;
import com.corporosoft.optica.interfaces.ReporteHistoriaDAO;
import com.corporosoft.optica.utils.ConexionBD;

public class MySQLReporteHistoriaDAO implements ReporteHistoriaDAO {



	CallableStatement cs = null;
	Connection cn = null;
	ResultSet rs = null;
	ReporteHistoriasRegistradasBean objReporteHistoriasRegistradasBean=null;
	
	@Override
	public List<ReporteHistoriasRegistradasBean> listaTotalHistorias(String anno) {
	List<ReporteHistoriasRegistradasBean> lista= new ArrayList<ReporteHistoriasRegistradasBean>();
		
		try {
			
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_historiasRegistradas(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, anno);
			rs=cs.executeQuery();
			while(rs.next()){
				objReporteHistoriasRegistradasBean = new ReporteHistoriasRegistradasBean(rs.getString(1), rs.getInt(2));
				lista.add(objReporteHistoriasRegistradasBean);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en listaTotalHistorias: "+ e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cs.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar Conexicon listaTotalHistorias"+e.getMessage());
				e.printStackTrace();
			}
		}
		
		return lista;
	}

	

}
