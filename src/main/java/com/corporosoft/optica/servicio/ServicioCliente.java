package com.corporosoft.optica.servicio;

import java.util.List;

import com.corporosoft.optica.bean.ClienteBean;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.ClienteDAO;
import com.corporosoft.optica.utils.Constante;

public class ServicioCliente {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	ClienteDAO objClienteDAO = fabrica.getClienteDAO();
	
	public void RegistrarCliente(ClienteBean objClientebean)throws Exception{
		objClienteDAO.RegistrarCliente(objClientebean);
	}
	
	
	public List<ClienteBean> buscarClienteDNI(String dni) throws Exception{		
		List<ClienteBean> lista=null;
		lista=objClienteDAO.buscarClienteDNI(dni);
		return lista;
	}
	
	public List<ClienteBean> buscarClienteNombres(String nombres) throws Exception{		
		List<ClienteBean> lista=null;
		lista=objClienteDAO.buscarClienteNombres(nombres);
		return lista;
	}
	
	public ClienteBean buscarClienteID(String idcliente)throws Exception{
		ClienteBean objClienteBean=null;
		objClienteBean=objClienteDAO.buscarClienteID(idcliente);
		return objClienteBean;
	}
	
	public void ActualizarCliente(ClienteBean objClientebean)throws Exception{
		objClienteDAO.ActualizarCliente(objClientebean);
	}
	
}
