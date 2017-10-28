package com.corporosoft.optica.interfaces;

import java.util.List;

import com.corporosoft.optica.bean.ReporteHistoriasRegistradasBean;

public interface ReporteHistoriaDAO {
	
	public abstract  List<ReporteHistoriasRegistradasBean> listaTotalHistorias(String anno);

}
