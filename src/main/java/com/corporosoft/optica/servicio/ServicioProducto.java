package com.corporosoft.optica.servicio;

import java.util.List;

import com.corporosoft.optica.bean.ProductoBean;
import com.corporosoft.optica.bean.TipoProductoBean;
import com.corporosoft.optica.dao.DAOFactory;
import com.corporosoft.optica.interfaces.ProductoDAO;
import com.corporosoft.optica.utils.Constante;

public class ServicioProducto {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constante.ORIGEN_DE_DATOS);
	ProductoDAO objProductoDAO=fabrica.getProductoDAO();
	
	public List<TipoProductoBean> listaTipoProducto(){
		List<TipoProductoBean>lista=null;
		lista=objProductoDAO.listaTipoProducto();
		return lista;
		
	}
	
	public List<ProductoBean>busquedaProductoTipoID(String idTipo){
		List<ProductoBean> lista=null;
		lista=objProductoDAO.busquedaProductoTipoID(idTipo);
		return lista;
	}
	
	public List<ProductoBean>busquedaProductoID(String idProd){
		List<ProductoBean> lista=null;
		lista=objProductoDAO.busquedaProductoID(idProd);
		return lista;
	}
	
}
