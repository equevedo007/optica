package com.corporosoft.optica.servicio;

import java.util.List;

import com.corporosoft.optica.bean.ListaReportaPacientes;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.ReportesDAO;
import com.corporosoft.optica.utils.Constante;

public class ServicioReporte {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	
	ReportesDAO objReportesDAO = fabrica.getReportesDAO();
	
	
	public List<ListaReportaPacientes> listaProximoControl(String fecha) throws Exception{
		List<ListaReportaPacientes> lista=null;
		lista=objReportesDAO.listaReporte(fecha);
		return lista;
		
	}
}
