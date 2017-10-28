package com.corporosoft.optica.interfaces;

import java.util.List;

import com.corporosoft.optica.bean.DetalleHistorialBean;
import com.corporosoft.optica.bean.HistorialmedicoBean;

public interface HistoriaDAO {

	public abstract void registarHistoria(HistorialmedicoBean objHistorialmedicoBean,String IdCliente) throws Exception;
	
	public abstract HistorialmedicoBean UltimaHistoria(String idCleinte) throws Exception;
	
	public abstract void registarHistoriaDetalle(String optometre,String idHistoria)throws Exception;
	
	public abstract List<DetalleHistorialBean> consultahistorial (String idCliente)throws Exception;
	
	public abstract HistorialmedicoBean buscarHistoriaID(String idHistoria)throws Exception;
}
