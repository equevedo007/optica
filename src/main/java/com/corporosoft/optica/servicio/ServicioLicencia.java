package com.corporosoft.optica.servicio;

import java.util.List;

import com.corporosoft.optica.bean.LicenciaBean;
import com.corporosoft.optica.bean.ValidarLicenciaBean;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.validarLicenciaDAO;
import com.corporosoft.optica.utils.Constante;



public class ServicioLicencia {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	
	validarLicenciaDAO objvalidarLicenciaDAO = fabrica.getvalidarLicenciaDAO();
	
	public List<ValidarLicenciaBean> validarLicencia(String licencia)throws Exception{
		List<ValidarLicenciaBean> lista=null;
		lista=objvalidarLicenciaDAO.validarLicencia(licencia);
		return lista;
		
	}
	
	public void ingresarLicencia(String licencia) throws Exception{
		objvalidarLicenciaDAO.ingressarLicencia(licencia);
	}
	
	public ValidarLicenciaBean validar()throws Exception{
		ValidarLicenciaBean objValidarLicenciaBean=null;
		 objValidarLicenciaBean=objvalidarLicenciaDAO.validar();
		 return objValidarLicenciaBean;
		
	}
	
	public void registrarlicencias(String idLicencia,String tiempo, String licencia) throws Exception{
		objvalidarLicenciaDAO.registrarlicencias(idLicencia, tiempo, licencia);
	}
	
	public List<LicenciaBean> buscarLicencia(String licencia) throws Exception{
		List<LicenciaBean> lista =null;
		lista=objvalidarLicenciaDAO.buscarLicencia(licencia);
		return lista;
	}
}




