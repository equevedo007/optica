package com.corporosoft.optica.dao;

import com.corporosoft.optica.interfaces.ClienteDAO;
import com.corporosoft.optica.interfaces.HistoriaDAO;
import com.corporosoft.optica.interfaces.LoginDAO;
import com.corporosoft.optica.interfaces.OptometraDAO;
import com.corporosoft.optica.interfaces.ProductoDAO;
import com.corporosoft.optica.interfaces.ReporteHistoriaDAO;
import com.corporosoft.optica.interfaces.ReportesDAO;
import com.corporosoft.optica.interfaces.UsuarioDAO;
import com.corporosoft.optica.interfaces.validarLicenciaDAO;

public abstract class DAOFactory {

	public static final int MYSQL=1;
	
	public abstract LoginDAO getLoginDAO();
	public abstract validarLicenciaDAO getvalidarLicenciaDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract ReporteHistoriaDAO getReporteHistoriaDAO();
	public abstract HistoriaDAO getHistoriaDAO();
	public abstract ReportesDAO getReportesDAO();
	public abstract OptometraDAO getOptometraDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract ProductoDAO getProductoDAO();
	
	public static DAOFactory getDAOFactory(int edinson){
		
		switch (edinson) {
		case MYSQL:
			
			return new MysqlDAOFactory();

		default:
			return null;
		}
		
	}
}
