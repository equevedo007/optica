package com.corporosoft.optica.interfaces;

import java.util.List;

import com.corporosoft.optica.bean.ProductoBean;
import com.corporosoft.optica.bean.TipoProductoBean;

public interface ProductoDAO {
	
	public abstract List<TipoProductoBean> listaTipoProducto();
	
	public abstract List<ProductoBean> busquedaProductoTipoID(String idTipo);
	
	public abstract List<ProductoBean> busquedaProductoID(String idTipo);
}
