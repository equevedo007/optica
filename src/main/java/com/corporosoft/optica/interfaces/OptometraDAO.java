package com.corporosoft.optica.interfaces;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.corporosoft.optica.bean.EstadaOptometraBean;
import com.corporosoft.optica.bean.OptometraBean;

public interface OptometraDAO {
	
	public abstract void RegistarOptometra(OptometraBean objOptometraBean)throws Exception;
	
	public abstract List<EstadaOptometraBean> EstadoOptometra()throws Exception;
	
	public abstract List<OptometraBean> BuscarUsuarioOptometra(String usu)throws Exception;
	
	public abstract List<OptometraBean> BuscarDNIOptometra(String dni)throws Exception;
	
	public abstract List<OptometraBean> BuscarOptometraNombres(String nombres)throws Exception;
	
	public abstract OptometraBean buscarOptometraID(String idOptometra)throws Exception;
	
	public abstract String descripcionEstadoOptometra(String idEstado)throws Exception;
	
	public abstract void ActualizarOptmetra(OptometraBean objOptometraBean)throws ExecutionException;
	

	public abstract void ActualizarContrasennaOptometra(String idusuario, String password)throws Exception;
}
