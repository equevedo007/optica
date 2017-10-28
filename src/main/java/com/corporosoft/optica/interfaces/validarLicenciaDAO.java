package com.corporosoft.optica.interfaces;

import java.util.List;

import com.corporosoft.optica.bean.LicenciaBean;
import com.corporosoft.optica.bean.ValidarLicenciaBean;

public interface validarLicenciaDAO {
	
public abstract List<ValidarLicenciaBean> validarLicencia (String licencia) throws Exception;
	
	public abstract void ingressarLicencia(String licencia) throws Exception;
	
	public abstract ValidarLicenciaBean validar()throws Exception;
	
	public abstract void registrarlicencias(String idLicencia,String tiempo, String licencia)throws Exception;
	
	public abstract List<LicenciaBean> buscarLicencia(String licencia) throws Exception;

}
