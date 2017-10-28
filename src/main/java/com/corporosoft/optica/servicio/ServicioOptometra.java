package com.corporosoft.optica.servicio;

import java.util.List;

import com.corporosoft.optica.bean.EstadaOptometraBean;
import com.corporosoft.optica.bean.OptometraBean;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.OptometraDAO;
import com.corporosoft.optica.utils.Constante;

public class ServicioOptometra {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	OptometraDAO objOptometraDAO= fabrica.getOptometraDAO();
	
	public void RegistarOptometra(OptometraBean objOptometraBean)throws Exception{
		objOptometraDAO.RegistarOptometra(objOptometraBean);
	}
	
	public List<EstadaOptometraBean> estadoOPtometra()throws Exception{
		List<EstadaOptometraBean> lista=null;
		lista=objOptometraDAO.EstadoOptometra();
		return lista;
	}
	
	
	public List<OptometraBean>BuscarUsuarioOptometra (String usu) throws Exception{
		List<OptometraBean> lista=null;
		lista=objOptometraDAO.BuscarUsuarioOptometra(usu);
		return lista;
	}
	
	public List<OptometraBean>BuscarDNIOptometra (String dni) throws Exception{
		List<OptometraBean> lista=null;
		lista=objOptometraDAO.BuscarDNIOptometra(dni);
		return lista;
	}
	
	public OptometraBean buscarOptometraID(String idOptometra)throws Exception{
		OptometraBean objOptometraBean=null;
		objOptometraBean=objOptometraDAO.buscarOptometraID(idOptometra);
		return objOptometraBean;
	}
	
	public List<OptometraBean> buscarOptometraNombres(String nombres) throws Exception{
		List<OptometraBean> lista=null;
		lista=objOptometraDAO.BuscarOptometraNombres(nombres);
		return lista;
	}
	
	public String buscarDescripcionEstadoOptometra(String idEstado) throws Exception{
		String out="";
		out=objOptometraDAO.descripcionEstadoOptometra(idEstado);
		return out;
	}
	
	public void ActualizarOptometra(OptometraBean objOptometraBean)throws Exception{
		objOptometraDAO.ActualizarOptmetra(objOptometraBean);
	}
	public void ActualizarContrasenaOptometra(String idusuario, String password)throws Exception{
		objOptometraDAO.ActualizarContrasennaOptometra(idusuario, password);
	}
	
	
	
}
