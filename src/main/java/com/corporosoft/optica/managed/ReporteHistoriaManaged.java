package com.corporosoft.optica.managed;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.corporosoft.optica.bean.ReporteHistoriasRegistradasBean;
import com.corporosoft.optica.servicio.ServicioReporteHistoria;

@ManagedBean
public class ReporteHistoriaManaged implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
private BarChartModel barModel;
	
	private String anno;

	
	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	
	
	
	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	@PostConstruct
	public void init(){
		createBarmodels();
		
		
	}
	
	
	
	public  void createBarmodels(){
		createBarmodel();
	}

	private void createBarmodel() {
		//ServicioReporteHistoria servicio = new ServicioReporteHistoria();
		
		//int total=servicio.TotalMayorHistoria(anno);
		
		
		barModel= initBarModel();
		
		barModel.setTitle("Reporte de Historias");
		barModel.setLegendPosition("ne");
		barModel.setStacked(true);
		
		
		
		Axis XAxis = barModel.getAxis(AxisType.X);
		XAxis.setLabel("Periodo del " + anno);
		
		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Historias Registradas");
		//yAxis.setMin('0');
		//yAxis.setMax(total);
		
		
		
	}
	
	
	private BarChartModel initBarModel(){
		
		int Enero =0;
		int Febrero =0;		
		int Marzo =0;
		int Abril =0;
		int Mayo =0;
		int Junio =0;
		int Julio =0;
		int Agosto =0;
		int Septiembre =0;
		int Octubre =0;
		int Noviembre =0;
		int Diciembre =0;	
		
		ServicioReporteHistoria servicio = new ServicioReporteHistoria();
		BarChartModel model = new BarChartModel();
		
		ChartSeries reporte = new ChartSeries();
		reporte.setLabel("Historias Registradas");		
		
		List<ReporteHistoriasRegistradasBean> lista = servicio.HistoriasRegistradas(anno);
		
		
		for (ReporteHistoriasRegistradasBean x : lista) {
			
			if(x.getMes().equals("01")){
				Enero=x.getCantidad();
			}
			
			if(x.getMes().equals("02")){
				Febrero=x.getCantidad();
			}
			
			if(x.getMes().equals("03")){
				Marzo=x.getCantidad();
			}
			if(x.getMes().equals("04")){
				Abril=x.getCantidad();
			}
			if(x.getMes().equals("05")){
				Mayo=x.getCantidad();
			}
			if(x.getMes().equals("06")){
				Junio=x.getCantidad();
			}
			if(x.getMes().equals("07")){
				Julio=x.getCantidad();
			}
			if(x.getMes().equals("08")){
				Agosto=x.getCantidad();
			}
			if(x.getMes().equals("09")){
				Septiembre=x.getCantidad();
			}
			if(x.getMes().equals("10")){
				Octubre=x.getCantidad();
			}
			if(x.getMes().equals("11")){
				Noviembre=x.getCantidad();
			}
			if(x.getMes().equals("12")){
				Diciembre=x.getCantidad();
			}
		}
		
		
		
		
		
		reporte.set("Enero " + Enero, Enero);
		reporte.set("Febrero " + Febrero, Febrero);
		reporte.set("Marzo " + Marzo, Marzo);
		reporte.set("Abril " + Abril, Abril);
		reporte.set("Mayo " + Mayo, Mayo);
		reporte.set("Junio " + Junio, Junio);
		reporte.set("Julio " + Julio, Julio);
		reporte.set("Agosto " + Agosto, Agosto);
		reporte.set("Septiembre " + Septiembre, Septiembre);
		reporte.set("Octubre " + Octubre, Octubre);
		reporte.set("Noviembre " + Noviembre, Noviembre);
		reporte.set("Diciembre " + Diciembre, Diciembre);
		
		
		
		
			
		
		model.addSeries(reporte);
		
		return model;
	}
	
	
	

}
