package com.corporosoft.optica.servicio;

import java.util.List;

import com.corporosoft.optica.bean.ReporteHistoriasRegistradasBean;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.ReporteHistoriaDAO;
import com.corporosoft.optica.utils.Constante;



public class ServicioReporteHistoria {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	ReporteHistoriaDAO objReporteHistoriaDAO= fabrica.getReporteHistoriaDAO();
	
	public List<ReporteHistoriasRegistradasBean> HistoriasRegistradas(String anno){
		List<ReporteHistoriasRegistradasBean> lista = null;
		lista=objReporteHistoriaDAO.listaTotalHistorias(anno);
		return lista;
	}

}
