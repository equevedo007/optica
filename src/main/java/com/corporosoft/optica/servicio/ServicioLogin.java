package com.corporosoft.optica.servicio;

import com.corporosoft.optica.bean.UsuarioBean;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.LoginDAO;
import com.corporosoft.optica.utils.Constante;

public class ServicioLogin {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);	
	LoginDAO objLoginDAO = fabrica.getLoginDAO();	
	
	public UsuarioBean ValidarUsuario(UsuarioBean obj) throws Exception{
		UsuarioBean objUsuarioBean =null;
		objUsuarioBean= objLoginDAO.ValidarUsuario(obj.getUsuario());
		return objUsuarioBean;
	}
}
