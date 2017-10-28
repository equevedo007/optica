package com.corporosoft.optica.interfaces;

import java.util.List;

import com.corporosoft.optica.bean.ListaReportaPacientes;

public interface ReportesDAO {

	public abstract List<ListaReportaPacientes> listaReporte(String fecha);
}
