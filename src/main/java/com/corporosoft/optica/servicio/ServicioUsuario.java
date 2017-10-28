package com.corporosoft.optica.servicio;

import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.UsuarioDAO;
import com.corporosoft.optica.utils.Constante;

public class ServicioUsuario {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	
	UsuarioDAO objUsuarioDAO=fabrica.getUsuarioDAO();
	
	public void ActualizarContrasenaUsuario(String idusuario, String password)throws Exception{
		objUsuarioDAO.ActualizarContrasennaUsuario(idusuario, password);
	}

}
