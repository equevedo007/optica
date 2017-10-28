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

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public LoginDAO getLoginDAO() {
		// TODO Auto-generated method stub
		return new MysqlLoginDAO();
	}

	@Override
	public validarLicenciaDAO getvalidarLicenciaDAO() {
		// TODO Auto-generated method stub
		return new MysqlValidarLicenciaDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new MysqlClienteDAO();
	}

	@Override
	public ReporteHistoriaDAO getReporteHistoriaDAO() {
		// TODO Auto-generated method stub
		return new MySQLReporteHistoriaDAO();
	}

	@Override
	public HistoriaDAO getHistoriaDAO() {
		// TODO Auto-generated method stub
		return new MysqlHistoriaDAO();
	}

	@Override
	public ReportesDAO getReportesDAO() {
		// TODO Auto-generated method stub
		return new MysqlReportesDAO();
	}

	@Override
	public OptometraDAO getOptometraDAO() {
		// TODO Auto-generated method stub
		return new MysqlOptometraDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MysqlUsuarioDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new MysqlProductoDAO();
	}

	

}
