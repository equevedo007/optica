package com.corporosoft.optica.servicio;

import java.util.List;

import com.corporosoft.optica.bean.DetalleHistorialBean;
import com.corporosoft.optica.bean.HistorialmedicoBean;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.HistoriaDAO;
import com.corporosoft.optica.utils.Constante;

public class ServicioHistoria {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	
	HistoriaDAO objHistoriaDAO=fabrica.getHistoriaDAO();
	
	
	public void RegistarHistoria(HistorialmedicoBean objHistorialmedicoBean,String IdCliente) throws Exception{
		objHistoriaDAO.registarHistoria(objHistorialmedicoBean,IdCliente);
	}
	
	public HistorialmedicoBean UltimaHistoria(String idCleinte) throws Exception{
		
		HistorialmedicoBean obj = null;
		obj=objHistoriaDAO.UltimaHistoria(idCleinte);
		return obj;
	}
	
	public void RegistrarHistoriaDetalle(String optometra,String idHistoria)throws Exception{
		objHistoriaDAO.registarHistoriaDetalle(optometra,idHistoria);
		
	}
	
	public List<DetalleHistorialBean> consultahistorial(String idCliente) throws Exception{
		List<DetalleHistorialBean> lista=null;
		lista=objHistoriaDAO.consultahistorial(idCliente);
		return lista;
	}
	
	public HistorialmedicoBean buscarHistoriaID(String idHistoria)throws Exception{
		HistorialmedicoBean objHistorialmedicoBean=null;
		objHistorialmedicoBean=objHistoriaDAO.buscarHistoriaID(idHistoria);		
		return objHistorialmedicoBean;
	}

}
