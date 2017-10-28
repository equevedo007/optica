package com.corporosoft.optica.interfaces;

import java.util.List;

import com.corporosoft.optica.bean.ClienteBean;

public interface ClienteDAO {
	
	public abstract void RegistrarCliente(ClienteBean objCliente)throws Exception;

	public abstract List<ClienteBean> buscarClienteDNI(String dni) throws Exception;
	
	public abstract List<ClienteBean> buscarClienteNombres(String nombres) throws Exception;
	
	public abstract ClienteBean buscarClienteID(String idCliente)throws Exception;
	
	public abstract void ActualizarCliente(ClienteBean objClienteBean)throws Exception;
}
