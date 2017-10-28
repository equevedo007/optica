package com.corporosoft.optica.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GeneradorDeCodigo {	
	
	
	public  String generaCodigoCliente(){
		
		
		Connection cn = null;
		PreparedStatement pt= null; 
		ResultSet rs= null;
		Integer NuevoCodigo = null;
		String Codigo,codigoNuevo="";
		try {				
			ConexionBD  objoConexion = new ConexionBD();
			cn=objoConexion.getConeccionBD();
			String sql="select idcliente from Cliente order by idcliente desc limit 1";
			pt = cn.prepareStatement(sql);				
			rs = pt.executeQuery();
			if (rs.next()){
				 Codigo= rs.getString(1); 
				 NuevoCodigo= Integer.parseInt(Codigo.substring(2));	
					NuevoCodigo ++;
					 if(  NuevoCodigo <10)					
						 codigoNuevo="CL00000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100)					
						 codigoNuevo="CL0000"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000)					
						 codigoNuevo="CL000"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000)					
						 codigoNuevo="CL00"+(NuevoCodigo);
					 else if ( NuevoCodigo <100000)					
						 codigoNuevo="CL0"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000000)					
						 codigoNuevo="CL"+(NuevoCodigo);
				 
				 }
			else{
				codigoNuevo="CL000001";
			}
			
		} catch (Exception e) {
			System.out.println("Error en Generar Codigo de Cliente");
		}finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codigoNuevo;		
		
	 
}
	
	public  String HistoriaMedica(){
		
		
		Connection cn = null;
		PreparedStatement pt= null; 
		ResultSet rs= null;
		Integer NuevoCodigo = null;
		String Codigo,codigoNuevo="";
		try {				
			ConexionBD  objoConexion = new ConexionBD();
			cn=objoConexion.getConeccionBD();
			String sql="select h.idhistorialmedico from HistorialMedico h order by h.idhistorialmedico desc limit 1";
			pt = cn.prepareStatement(sql);				
			rs = pt.executeQuery();
			if (rs.next()){
				 Codigo= rs.getString(1); 
				 NuevoCodigo= Integer.parseInt(Codigo.substring(2));	
					NuevoCodigo ++;
					 if(  NuevoCodigo <10)					
						 codigoNuevo="HM000000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100)					
						 codigoNuevo="HM00000"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000)					
						 codigoNuevo="HM0000"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000)					
						 codigoNuevo="HM000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100000)					
						 codigoNuevo="HM00"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000000)					
						 codigoNuevo="HM0"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000000)					
						 codigoNuevo="HM"+(NuevoCodigo);
				 
				 }
			else{
				codigoNuevo="HM0000001";
			}
			
		} catch (Exception e) {
			System.out.println("Error en Generar Codigo de Historia");
		}finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codigoNuevo;
	 
}
	
	public  String Optometra(){
		
		
		Connection cn = null;
		PreparedStatement pt= null; 
		ResultSet rs= null;
		Integer NuevoCodigo = null;
		String Codigo,codigoNuevo="";
		try {				
			ConexionBD  objoConexion = new ConexionBD();
			cn=objoConexion.getConeccionBD();
			String sql="select idoptometra from optometra order by idoptometra desc limit 1";
			pt = cn.prepareStatement(sql);				
			rs = pt.executeQuery();
			if (rs.next()){
				 Codigo= rs.getString(1); 
				 NuevoCodigo= Integer.parseInt(Codigo.substring(2));	
					NuevoCodigo ++;
					 if(  NuevoCodigo <10)					
						 codigoNuevo="OP00000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100)					
						 codigoNuevo="OP0000"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000)					
						 codigoNuevo="OP000"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000)					
						 codigoNuevo="OP00"+(NuevoCodigo);
					 else if ( NuevoCodigo <100000)					
						 codigoNuevo="OP0"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000000)					
						 codigoNuevo="OP"+(NuevoCodigo);
				 
				 }
			else{
				codigoNuevo="OP000001";
			}
			
		} catch (Exception e) {
			System.out.println("Error en Generar Codigo de Optometra");
		}finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codigoNuevo;
	 
}
	
	public  String Boleta(){
		
		
		Connection cn = null;
		PreparedStatement pt= null; 
		ResultSet rs= null;
		Integer NuevoCodigo = null;
		String Codigo,codigoNuevo="";
		try {				
			ConexionBD  objoConexion = new ConexionBD();
			cn=objoConexion.getConeccionBD();
			String sql="select idBoleta from Boleta order by idBoleta desc limit 1";
			pt = cn.prepareStatement(sql);				
			rs = pt.executeQuery();
			if (rs.next()){
				 Codigo= rs.getString(1); 
				 NuevoCodigo= Integer.parseInt(Codigo.substring(3));	
					NuevoCodigo ++;
					 if(  NuevoCodigo <10)					
						 codigoNuevo="BV-000000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100)					
						 codigoNuevo="BV-00000"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000)					
						 codigoNuevo="BV-0000"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000)					
						 codigoNuevo="BV-000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100000)					
						 codigoNuevo="BV-00"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000000)					
						 codigoNuevo="BV-0"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000000)					
						 codigoNuevo="BV-"+(NuevoCodigo);
					 
				 
				 }
			else{
				codigoNuevo="BV-0000001";
			}
			
		} catch (Exception e) {
			System.out.println("Error en Generar Codigo de Boleta");
		}finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codigoNuevo;
	 
}
	
	public String Proveedor(){
		Connection cn = null;
		PreparedStatement pt= null; 
		ResultSet rs= null;
		Integer NuevoCodigo = null;
		String Codigo,codigoNuevo="";
		try {				
			ConexionBD  objoConexion = new ConexionBD();
			cn=objoConexion.getConeccionBD();
			String sql="select idProveedor from Proveedor order by idProveedor desc limit 1";
			pt = cn.prepareStatement(sql);				
			rs = pt.executeQuery();
			if (rs.next()){
				 Codigo= rs.getString(1); 
				 NuevoCodigo= Integer.parseInt(Codigo.substring(2));	
					NuevoCodigo ++;
					 if(  NuevoCodigo <10)					
						 codigoNuevo="PR00000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100)					
						 codigoNuevo="PR0000"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000)					
						 codigoNuevo="PR000"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000)					
						 codigoNuevo="PR00"+(NuevoCodigo);
					 else if ( NuevoCodigo <100000)					
						 codigoNuevo="PR0"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000000)					
						 codigoNuevo="PR"+(NuevoCodigo);
				 
				 }
			else{
				codigoNuevo="PR000001";
			}
			
		} catch (Exception e) {
			System.out.println("Error en Generar Codigo de Cliente");
		}finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codigoNuevo;		
	}
	
	public String Producto(){
		Connection cn = null;
		PreparedStatement pt= null; 
		ResultSet rs= null;
		Integer NuevoCodigo = null;
		String Codigo,codigoNuevo="";
		try {				
			ConexionBD  objoConexion = new ConexionBD();
			cn=objoConexion.getConeccionBD();
			String sql="select idProducto from Producto order by idProducto desc limit 1";
			pt = cn.prepareStatement(sql);				
			rs = pt.executeQuery();
			if (rs.next()){
				 Codigo= rs.getString(1); 
				 NuevoCodigo= Integer.parseInt(Codigo.substring(2));	
					NuevoCodigo ++;
					 if(  NuevoCodigo <10)					
						 codigoNuevo="PD00000"+(NuevoCodigo);
					 else if ( NuevoCodigo <100)					
						 codigoNuevo="PD0000"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000)					
						 codigoNuevo="PD000"+(NuevoCodigo);
					 else if ( NuevoCodigo <10000)					
						 codigoNuevo="PD00"+(NuevoCodigo);
					 else if ( NuevoCodigo <100000)					
						 codigoNuevo="PD0"+(NuevoCodigo);
					 else if ( NuevoCodigo <1000000)					
						 codigoNuevo="PD"+(NuevoCodigo);
				 
				 }
			else{
				codigoNuevo="PD000001";
			}
			
		} catch (Exception e) {
			System.out.println("Error en Generar Codigo de Producto");
		}finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codigoNuevo;		
	}
	
	
}
