package com.corporosoft.optica.interfaces;

import com.corporosoft.optica.bean.UsuarioBean;

public interface LoginDAO {

	public abstract UsuarioBean ValidarUsuario(String usuario)throws Exception;
}
