package com.corporosoft.optica.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corporosoft.optica.bean.DetalleHistorialBean;
import com.corporosoft.optica.bean.HistorialmedicoBean;
import com.corporosoft.optica.interfaces.HistoriaDAO;
import com.corporosoft.optica.utils.ConexionBD;
import com.corporosoft.optica.utils.Operaciones;
public class MysqlHistoriaDAO implements HistoriaDAO{
	
	Connection cn=null;
	CallableStatement cs=null;
	ResultSet rs=null;
	HistorialmedicoBean objHistorialmedicoBean=null;
	PreparedStatement pt=null;
	HistorialmedicoBean objHistoriaMedicaBean=null;
	DetalleHistorialBean objDetalleHistorialBean=null;

	@Override
	public void registarHistoria(HistorialmedicoBean objHistorialmedicoBean,String IdCliente) throws Exception {
		try {
			Operaciones op = new Operaciones();
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_registarHistoria(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, objHistorialmedicoBean.getIdHistorialMedico());
			cs.setString(2, IdCliente);
			cs.setDate(3, new java.sql.Date(objHistorialmedicoBean.getFechaRegistro().getTime()));
			cs.setDate(4, new java.sql.Date(objHistorialmedicoBean.getFechaProximocontrol().getTime()));
			cs.setString(5, objHistorialmedicoBean.getMesesProxControl());
			
			cs.setString(6, objHistorialmedicoBean.getAgudezaODSC());
			cs.setString(7, objHistorialmedicoBean.getAgudezaODPH());
			cs.setString(8, objHistorialmedicoBean.getAgudezaODCC());
			cs.setString(9, objHistorialmedicoBean.getAgudezaOISC());
			cs.setString(10, objHistorialmedicoBean.getAgudezaOIPH());
			cs.setString(11, objHistorialmedicoBean.getAgudezaOICC());
			
			cs.setString(12, op.formatDecimal(objHistorialmedicoBean.getRefracicionFinalODESF()));
			cs.setString(13, op.formatDecimal(objHistorialmedicoBean.getRefracicionFinalODCIL()));			
			cs.setString(14, objHistorialmedicoBean.getRefracicionFinalODEJE());			
			cs.setString(15, objHistorialmedicoBean.getRefracicionFinalODPD());
			cs.setString(16, objHistorialmedicoBean.getRefracicionFinalOIPD());
			cs.setString(17, op.formatDecimal(objHistorialmedicoBean.getRefracicionFinalODADD()));			
			cs.setString(18, op.formatDecimal(objHistorialmedicoBean.getRefracicionFinalOIESF()));			
			cs.setString(19, op.formatDecimal(objHistorialmedicoBean.getRefracicionFinalOICIL()));
			cs.setString(20, objHistorialmedicoBean.getRefracicionFinalOIEJE());
			cs.setString(21, op.formatDecimal(objHistorialmedicoBean.getRefracicionFinalOIADD()));
			
			cs.setString(22, op.formatDecimal(objHistorialmedicoBean.getAnteojosenUsoODESF()));
			cs.setString(23, op.formatDecimal(objHistorialmedicoBean.getAnteojosenUsoODCIL()));
			cs.setString(24, objHistorialmedicoBean.getAnteojosenUsoODEJE());
			cs.setString(25, op.formatDecimal(objHistorialmedicoBean.getAnteojosenUsoODADD()));
			cs.setString(26, op.formatDecimal(objHistorialmedicoBean.getAnteojosenUsoOIESF()));
			cs.setString(27, op.formatDecimal(objHistorialmedicoBean.getAnteojosenUsoOICIL()));
			cs.setString(28, objHistorialmedicoBean.getAnteojosenUsoOIEJE());
			cs.setString(29, op.formatDecimal(objHistorialmedicoBean.getAnteojosenUsoOIADD()));
			cs.setString(30, objHistorialmedicoBean.getObservaciones());
			cs.setString(31, objHistorialmedicoBean.getComentarios());
			
			cs.executeUpdate();
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("Error en Registrar Historia : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				cs.close();
				cn.close();				
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion Registrar Historia : " + e.getMessage());
				e.printStackTrace();
			} 
		}
		
	}


	@Override
	public HistorialmedicoBean UltimaHistoria(String idCleinte) throws Exception {
		
		try {
			
			ConexionBD c = new ConexionBD();
			cn=c.getConeccionBD();
			String sql="select * from HistorialMedico h where IdCliente = ? order by h.idHistorialMedico desc  limit 1";
			pt=cn.prepareStatement(sql);
			pt.setString(1, idCleinte);
			rs=pt.executeQuery();
			if(rs.next()){
				objHistoriaMedicaBean = new HistorialmedicoBean(rs.getString(1), rs.getString(2), rs.getDate(3),rs.getDate(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30),rs.getString(31));
			}	else{
			
				System.out.println("El Pasiente no Tiene Historia Registrada");
			}
			
		} catch (Exception e) {
			System.out.println("Error en Genererar Ultima Historia");
		}finally{
			try {
				rs.close();
				pt.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return objHistoriaMedicaBean;
	}


	@Override
	public void registarHistoriaDetalle(String optometra,String idHistoria) throws Exception {
		
		try {
			
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_Registardetalle_historialmedico(?,?,?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, optometra.trim());
			cs.setString(2, idHistoria);
			cs.setString(3, "LOS OLIVOS".trim());
			cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en Registrar Historia Detalle: " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				cs.close();
				cn.close();				
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conexion Registrar Historia Detalle: " + e.getMessage());
				e.printStackTrace();
			} 
		}
		
	}


	@Override
	public List<DetalleHistorialBean> consultahistorial(String idCliente) throws Exception {
		
		List<DetalleHistorialBean> lista= new ArrayList<DetalleHistorialBean>();
		try {
			ConexionBD x = new ConexionBD();
			cn=x.getConeccionBD();
			String sql="{call sp_consutlaDetalle(?)}";
			cs=cn.prepareCall(sql);
			cs.setString(1, idCliente);
			rs=cs.executeQuery();
			while(rs.next()){
				objDetalleHistorialBean= new DetalleHistorialBean();
				objDetalleHistorialBean.setIdOptometra(rs.getString(1));
				objDetalleHistorialBean.setIdHistorial(rs.getString(2));
				objDetalleHistorialBean.setIdCliente(rs.getString(3));
				objDetalleHistorialBean.setOptometra(rs.getString(4));
				objDetalleHistorialBean.setCliente(rs.getString(5));
				objDetalleHistorialBean.setFecha(rs.getDate(6));
				objDetalleHistorialBean.setLocal(rs.getString(7));;
				lista.add(objDetalleHistorialBean);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en Liscar Detalle Historial: "+ e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				cs.close();
				cn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return lista;
		
	}


	@Override
	public HistorialmedicoBean buscarHistoriaID(String idHistoria) throws Exception {
		
		try {
			ConexionBD cnx = new ConexionBD();
			cn=cnx.getConeccionBD();
			String sql="{call sp_buscarHistoriaID(?)}";		
			cs=cn.prepareCall(sql);
			cs.setString(1, idHistoria);
			rs=cs.executeQuery();
			if(rs.next()){
				objHistorialmedicoBean = new HistorialmedicoBean(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23),
						rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31));
			}
			
		} catch (Exception e) {
			System.out.println("Error en Buscar Historia ID : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				cs.close();
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error en Cerrar Conxion Buscar Historia ID : " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return objHistorialmedicoBean;
	}


	
}
