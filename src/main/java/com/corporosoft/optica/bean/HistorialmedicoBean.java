package com.corporosoft.optica.bean;

import java.io.Serializable;
import java.util.Date;
public class HistorialmedicoBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String idHistorialMedico;
	private String IdCliente; 
	private Date fechaRegistro; 
	private Date FechaProximocontrol; 
	private String mesesProxControl; 
	private String AgudezaODSC; 
	private String AgudezaODPH; 
	private String AgudezaODCC; 
	private String AgudezaOISC; 
	private String AgudezaOIPH; 
	private String AgudezaOICC; 
	private String RefracicionFinalODESF; 
	private String RefracicionFinalODCIL; 
	private String RefracicionFinalODEJE; 
	private String RefracicionFinalODPD; 
	private String RefracicionFinalOIPD; 
	private String RefracicionFinalODADD; 
	private String RefracicionFinalOIESF; 
	private String RefracicionFinalOICIL; 
	private String RefracicionFinalOIEJE; 
	private String RefracicionFinalOIADD; 
	private String AnteojosenUsoODESF; 
	private String AnteojosenUsoODCIL; 
	private String AnteojosenUsoODEJE; 
	private String AnteojosenUsoODADD; 
	private String AnteojosenUsoOIESF; 
	private String AnteojosenUsoOICIL; 
	private String AnteojosenUsoOIEJE; 
	private String AnteojosenUsoOIADD; 
	private String Observaciones; 
	private String comentarios;
	
	public HistorialmedicoBean(){
		
	}
	public HistorialmedicoBean(String idHistorialMedico, String idCliente, Date fechaRegistro, Date fechaProximocontrol,
			String mesesProxControl, String agudezaODSC, String agudezaODPH, String agudezaODCC, String agudezaOISC,
			String agudezaOIPH, String agudezaOICC, String refracicionFinalODESF, String refracicionFinalODCIL,
			String refracicionFinalODEJE, String refracicionFinalODPD, String refracicionFinalOIPD,
			String refracicionFinalODADD, String refracicionFinalOIESF, String refracicionFinalOICIL,
			String refracicionFinalOIEJE, String refracicionFinalOIADD, String anteojosenUsoODESF,
			String anteojosenUsoODCIL, String anteojosenUsoODEJE, String anteojosenUsoODADD, String anteojosenUsoOIESF,
			String anteojosenUsoOICIL, String anteojosenUsoOIEJE, String anteojosenUsoOIADD, String observaciones,
			String comentarios) {
		super();
		this.idHistorialMedico = idHistorialMedico;
		this.IdCliente = idCliente;
		this.fechaRegistro = fechaRegistro;
		this.FechaProximocontrol = fechaProximocontrol;
		this.mesesProxControl = mesesProxControl;
		this.AgudezaODSC = agudezaODSC;
		this.AgudezaODPH = agudezaODPH;
		this.AgudezaODCC = agudezaODCC;
		this.AgudezaOISC = agudezaOISC;
		this.AgudezaOIPH = agudezaOIPH;
		this.AgudezaOICC = agudezaOICC;
		this.RefracicionFinalODESF = refracicionFinalODESF;
		this.RefracicionFinalODCIL = refracicionFinalODCIL;
		this.RefracicionFinalODEJE = refracicionFinalODEJE;
		this.RefracicionFinalODPD = refracicionFinalODPD;
		this.RefracicionFinalOIPD = refracicionFinalOIPD;
		this.RefracicionFinalODADD = refracicionFinalODADD;
		this.RefracicionFinalOIESF = refracicionFinalOIESF;
		this.RefracicionFinalOICIL = refracicionFinalOICIL;
		this.RefracicionFinalOIEJE = refracicionFinalOIEJE;
		this.RefracicionFinalOIADD = refracicionFinalOIADD;
		this.AnteojosenUsoODESF = anteojosenUsoODESF;
		this.AnteojosenUsoODCIL = anteojosenUsoODCIL;
		this.AnteojosenUsoODEJE = anteojosenUsoODEJE;
		this.AnteojosenUsoODADD = anteojosenUsoODADD;
		this.AnteojosenUsoOIESF = anteojosenUsoOIESF;
		this.AnteojosenUsoOICIL = anteojosenUsoOICIL;
		this.AnteojosenUsoOIEJE = anteojosenUsoOIEJE;
		this.AnteojosenUsoOIADD = anteojosenUsoOIADD;
		this.Observaciones = observaciones;
		this.comentarios = comentarios;
	}
	public String getIdHistorialMedico() {
		return idHistorialMedico;
	}
	public void setIdHistorialMedico(String idHistorialMedico) {
		this.idHistorialMedico = idHistorialMedico;
	}
	public String getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaProximocontrol() {
		return FechaProximocontrol;
	}
	public void setFechaProximocontrol(Date fechaProximocontrol) {
		FechaProximocontrol = fechaProximocontrol;
	}
	public String getMesesProxControl() {
		return mesesProxControl;
	}
	public void setMesesProxControl(String mesesProxControl) {
		this.mesesProxControl = mesesProxControl;
	}
	public String getAgudezaODSC() {
		return AgudezaODSC;
	}
	public void setAgudezaODSC(String agudezaODSC) {
		AgudezaODSC = agudezaODSC;
	}
	public String getAgudezaODPH() {
		return AgudezaODPH;
	}
	public void setAgudezaODPH(String agudezaODPH) {
		AgudezaODPH = agudezaODPH;
	}
	public String getAgudezaODCC() {
		return AgudezaODCC;
	}
	public void setAgudezaODCC(String agudezaODCC) {
		AgudezaODCC = agudezaODCC;
	}
	public String getAgudezaOISC() {
		return AgudezaOISC;
	}
	public void setAgudezaOISC(String agudezaOISC) {
		AgudezaOISC = agudezaOISC;
	}
	public String getAgudezaOIPH() {
		return AgudezaOIPH;
	}
	public void setAgudezaOIPH(String agudezaOIPH) {
		AgudezaOIPH = agudezaOIPH;
	}
	public String getAgudezaOICC() {
		return AgudezaOICC;
	}
	public void setAgudezaOICC(String agudezaOICC) {
		AgudezaOICC = agudezaOICC;
	}
	public String getRefracicionFinalODESF() {
		return RefracicionFinalODESF;
	}
	public void setRefracicionFinalODESF(String refracicionFinalODESF) {
		RefracicionFinalODESF = refracicionFinalODESF;
	}
	public String getRefracicionFinalODCIL() {
		return RefracicionFinalODCIL;
	}
	public void setRefracicionFinalODCIL(String refracicionFinalODCIL) {
		RefracicionFinalODCIL = refracicionFinalODCIL;
	}
	public String getRefracicionFinalODEJE() {
		return RefracicionFinalODEJE;
	}
	public void setRefracicionFinalODEJE(String refracicionFinalODEJE) {
		RefracicionFinalODEJE = refracicionFinalODEJE;
	}
	public String getRefracicionFinalODPD() {
		return RefracicionFinalODPD;
	}
	public void setRefracicionFinalODPD(String refracicionFinalODPD) {
		RefracicionFinalODPD = refracicionFinalODPD;
	}
	public String getRefracicionFinalOIPD() {
		return RefracicionFinalOIPD;
	}
	public void setRefracicionFinalOIPD(String refracicionFinalOIPD) {
		RefracicionFinalOIPD = refracicionFinalOIPD;
	}
	public String getRefracicionFinalODADD() {
		return RefracicionFinalODADD;
	}
	public void setRefracicionFinalODADD(String refracicionFinalODADD) {
		RefracicionFinalODADD = refracicionFinalODADD;
	}
	public String getRefracicionFinalOIESF() {
		return RefracicionFinalOIESF;
	}
	public void setRefracicionFinalOIESF(String refracicionFinalOIESF) {
		RefracicionFinalOIESF = refracicionFinalOIESF;
	}
	public String getRefracicionFinalOICIL() {
		return RefracicionFinalOICIL;
	}
	public void setRefracicionFinalOICIL(String refracicionFinalOICIL) {
		RefracicionFinalOICIL = refracicionFinalOICIL;
	}
	public String getRefracicionFinalOIEJE() {
		return RefracicionFinalOIEJE;
	}
	public void setRefracicionFinalOIEJE(String refracicionFinalOIEJE) {
		RefracicionFinalOIEJE = refracicionFinalOIEJE;
	}
	public String getRefracicionFinalOIADD() {
		return RefracicionFinalOIADD;
	}
	public void setRefracicionFinalOIADD(String refracicionFinalOIADD) {
		RefracicionFinalOIADD = refracicionFinalOIADD;
	}
	public String getAnteojosenUsoODESF() {
		return AnteojosenUsoODESF;
	}
	public void setAnteojosenUsoODESF(String anteojosenUsoODESF) {
		AnteojosenUsoODESF = anteojosenUsoODESF;
	}
	public String getAnteojosenUsoODCIL() {
		return AnteojosenUsoODCIL;
	}
	public void setAnteojosenUsoODCIL(String anteojosenUsoODCIL) {
		AnteojosenUsoODCIL = anteojosenUsoODCIL;
	}
	public String getAnteojosenUsoODEJE() {
		return AnteojosenUsoODEJE;
	}
	public void setAnteojosenUsoODEJE(String anteojosenUsoODEJE) {
		AnteojosenUsoODEJE = anteojosenUsoODEJE;
	}
	public String getAnteojosenUsoODADD() {
		return AnteojosenUsoODADD;
	}
	public void setAnteojosenUsoODADD(String anteojosenUsoODADD) {
		AnteojosenUsoODADD = anteojosenUsoODADD;
	}
	public String getAnteojosenUsoOIESF() {
		return AnteojosenUsoOIESF;
	}
	public void setAnteojosenUsoOIESF(String anteojosenUsoOIESF) {
		AnteojosenUsoOIESF = anteojosenUsoOIESF;
	}
	public String getAnteojosenUsoOICIL() {
		return AnteojosenUsoOICIL;
	}
	public void setAnteojosenUsoOICIL(String anteojosenUsoOICIL) {
		AnteojosenUsoOICIL = anteojosenUsoOICIL;
	}
	public String getAnteojosenUsoOIEJE() {
		return AnteojosenUsoOIEJE;
	}
	public void setAnteojosenUsoOIEJE(String anteojosenUsoOIEJE) {
		AnteojosenUsoOIEJE = anteojosenUsoOIEJE;
	}
	public String getAnteojosenUsoOIADD() {
		return AnteojosenUsoOIADD;
	}
	public void setAnteojosenUsoOIADD(String anteojosenUsoOIADD) {
		AnteojosenUsoOIADD = anteojosenUsoOIADD;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	
	
}
