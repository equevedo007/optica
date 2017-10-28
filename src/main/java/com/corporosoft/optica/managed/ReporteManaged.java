package com.corporosoft.optica.managed;

import javax.faces.view.ViewScoped;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.corporosoft.optica.bean.ListaReportaPacientes;
import com.corporosoft.optica.servicio.ServicioReporte;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
@ViewScoped
@ManagedBean
public class ReporteManaged implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String mes;
	private String anno;
	private List<ListaReportaPacientes> lista;
	

	@PostConstruct
    public void init() {
		lista = new ArrayList<ListaReportaPacientes>();
    }
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public List<ListaReportaPacientes> getLista() {
		return lista;
	}
	public void setLista(List<ListaReportaPacientes> lista) {
		this.lista = lista;
	}
	public void EjecutarReporte(ActionEvent e) throws Exception {
		ServicioReporte sr = new ServicioReporte();
		String fecha = mes + "-" + anno;
		System.out.println("Fecha: " + fecha);
		lista = sr.listaProximoControl(fecha);
		System.out.println("Total Lista: " + lista.size());
	}
	
	public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException {
		try {
			ServicioReporte sr = new ServicioReporte();
			String fecha = mes + "-" + anno;
			System.out.println("Fecha: " + fecha);
			lista = sr.listaProximoControl(fecha);
			System.out.println("Total de la Lista: " +lista.size());
			

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("txtUsuario", "Edinson Ismael Quevedo Holguin");

			File report = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporte/ReporteProximoControl.jrxml"));
			JasperReport jasper = JasperCompileManager.compileReport(report.getPath());
			System.out.println("Ruta del Reporte: " + report.getPath());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametros,new JRBeanCollectionDataSource(this.lista));

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=Reporte_Proximo_Control.pdf");
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error en Generar Reporte Proximo Control",  ":" +e.getMessage()) );
		}
	}

}
