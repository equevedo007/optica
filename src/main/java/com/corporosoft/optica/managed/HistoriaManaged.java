package com.corporosoft.optica.managed;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.corporosoft.optica.bean.ClienteBean;
import com.corporosoft.optica.bean.DetalleHistorialBean;
import com.corporosoft.optica.bean.HistorialBusquedaID;
import com.corporosoft.optica.bean.HistorialmedicoBean;
import com.corporosoft.optica.bean.UsuarioBean;
import com.corporosoft.optica.servicio.ServicioCliente;
import com.corporosoft.optica.servicio.ServicioHistoria;
import com.corporosoft.optica.utils.ConexionBD;
import com.corporosoft.optica.utils.GeneradorDeCodigo;
import com.corporosoft.optica.utils.Operaciones;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@ViewScoped
@ManagedBean(name="Historial")
public class HistoriaManaged implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private HistorialmedicoBean objHistorialmedico;
	private ClienteBean objClienteBean;
	private String nombres;
	private String dni;
	private String codigo;
	private String edad;
	private List<ClienteBean> lista;
	private String idCliente;
	private Date fechaHistoria;
	private String spinner_ANTEOJOS_EN_USO;
	private String spinner_REFRACCION_FINAL_EJE_OD;
	private String spinner_REFRACCION_FINAL_EJE_OI;	
	private String spinner_ANTEOJOS_FINAL_EJE_OD;
	private String spinner_ANTEOJOS_FINAL_EJE_OI;
	private int proximoControl;
	private String habiliar_historia;
	private String idHistoria;
	private List<HistorialBusquedaID> listaHistoriaID;
	private List<DetalleHistorialBean> listaDetalle;
	
	public HistoriaManaged() {
		init();
		objHistorialmedico = new HistorialmedicoBean();
		objClienteBean = new ClienteBean();
		listaHistoriaID = new ArrayList<HistorialBusquedaID>();
		proximoControl=0;

	}
	
	@PostConstruct
	public void init() {
		spinner_REFRACCION_FINAL_EJE_OD = "true";
		spinner_REFRACCION_FINAL_EJE_OI = "true";
		spinner_ANTEOJOS_FINAL_EJE_OD = "true";
		spinner_ANTEOJOS_FINAL_EJE_OI = "true";
		habiliar_historia = "true";
		spinner_ANTEOJOS_EN_USO="true";
	}
	
	
	
	public List<DetalleHistorialBean> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<DetalleHistorialBean> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public HistorialmedicoBean getObjHistorialmedico() {
		return objHistorialmedico;
	}
	public void setObjHistorialmedico(HistorialmedicoBean objHistorialmedico) {
		this.objHistorialmedico = objHistorialmedico;
	}
	public ClienteBean getObjClienteBean() {
		return objClienteBean;
	}
	public void setObjClienteBean(ClienteBean objClienteBean) {
		this.objClienteBean = objClienteBean;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public List<ClienteBean> getLista() {
		return lista;
	}
	public void setLista(List<ClienteBean> lista) {
		this.lista = lista;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFechaHistoria() {
		return fechaHistoria;
	}
	public void setFechaHistoria(Date fechaHistoria) {
		this.fechaHistoria = fechaHistoria;
	}
	public String getSpinner_ANTEOJOS_EN_USO() {
		return spinner_ANTEOJOS_EN_USO;
	}
	public void setSpinner_ANTEOJOS_EN_USO(String spinner_ANTEOJOS_EN_USO) {
		this.spinner_ANTEOJOS_EN_USO = spinner_ANTEOJOS_EN_USO;
	}
	public String getSpinner_REFRACCION_FINAL_EJE_OD() {
		return spinner_REFRACCION_FINAL_EJE_OD;
	}
	public void setSpinner_REFRACCION_FINAL_EJE_OD(String spinner_REFRACCION_FINAL_EJE_OD) {
		this.spinner_REFRACCION_FINAL_EJE_OD = spinner_REFRACCION_FINAL_EJE_OD;
	}
	public String getSpinner_REFRACCION_FINAL_EJE_OI() {
		return spinner_REFRACCION_FINAL_EJE_OI;
	}
	public void setSpinner_REFRACCION_FINAL_EJE_OI(String spinner_REFRACCION_FINAL_EJE_OI) {
		this.spinner_REFRACCION_FINAL_EJE_OI = spinner_REFRACCION_FINAL_EJE_OI;
	}
	public String getSpinner_ANTEOJOS_FINAL_EJE_OD() {
		return spinner_ANTEOJOS_FINAL_EJE_OD;
	}
	public void setSpinner_ANTEOJOS_FINAL_EJE_OD(String spinner_ANTEOJOS_FINAL_EJE_OD) {
		this.spinner_ANTEOJOS_FINAL_EJE_OD = spinner_ANTEOJOS_FINAL_EJE_OD;
	}
	public String getSpinner_ANTEOJOS_FINAL_EJE_OI() {
		return spinner_ANTEOJOS_FINAL_EJE_OI;
	}
	public void setSpinner_ANTEOJOS_FINAL_EJE_OI(String spinner_ANTEOJOS_FINAL_EJE_OI) {
		this.spinner_ANTEOJOS_FINAL_EJE_OI = spinner_ANTEOJOS_FINAL_EJE_OI;
	}
	public int getProximoControl() {
		return proximoControl;
	}
	public void setProximoControl(int proximoControl) {
		this.proximoControl = proximoControl;
	}
	public String getHabiliar_historia() {
		return habiliar_historia;
	}
	public void setHabiliar_historia(String habiliar_historia) {
		this.habiliar_historia = habiliar_historia;
	}
	public String getIdHistoria() {
		return idHistoria;
	}
	public void setIdHistoria(String idHistoria) {
		this.idHistoria = idHistoria;
	}
	public List<HistorialBusquedaID> getListaHistoriaID() {
		return listaHistoriaID;
	}
	public void setListaHistoriaID(List<HistorialBusquedaID> listaHistoriaID) {
		this.listaHistoriaID = listaHistoriaID;
	}
	
	
	public void buscarCliente(ActionEvent e) throws Exception {

		System.out.println("Nombres a Buscar: " + nombres);
		System.out.println("DNI a Buscar: " + dni);

		FacesContext context = FacesContext.getCurrentInstance();
		ServicioCliente servicio = new ServicioCliente();

		if (nombres.equals("") && dni.equals("")) {
			context.addMessage(null, new FacesMessage("Se debe de ingresar", "Nombres o Apellidos para la b�squeda"));

		} else if (nombres.equals("")) {
			lista = servicio.buscarClienteDNI(dni);
			if (lista.size() == 0) {
				context.addMessage(null, new FacesMessage("DNI", "No se Encuentra Registrado"));
			}
		} else if (dni.equals("")) {
			lista = servicio.buscarClienteNombres(nombres);
			if (lista.size() == 0) {
				context.addMessage(null, new FacesMessage("Nombres y Apellidos", "No se Encuentra Registrado"));
			}
		} else if (nombres.equals("") && dni.equals("")) {
			context.addMessage(null, new FacesMessage("Debe de ingresas", "Nombre o DNI para la b�squeda"));
		} else if (nombres != null && dni != null) {
			context.addMessage(null, new FacesMessage("Se debe de ingresar", "Solo un criterio de B�squeda"));

		}

	}
	
	public void buscarClientecodigo(ActionEvent e) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Operaciones objOperaciones = new Operaciones();
		String fecha;

		System.out.println("ID a buscar: " + codigo);
		codigo = e.getComponent().getAttributes().get("xid").toString();

		System.out.println("ID a buscar: " + codigo);

		ServicioCliente servicio = new ServicioCliente();

		ServicioHistoria sh = new ServicioHistoria();
		objClienteBean = servicio.buscarClienteID(codigo);
		
		if(objClienteBean !=null){
			habiliar_historia="false";
			spinner_ANTEOJOS_EN_USO = "false";
		}

		fecha = sdf.format(objClienteBean.getFechaNacimiento());
		edad = Integer.toString(objOperaciones.edad(fecha));

		objHistorialmedico = new HistorialmedicoBean();
		HistorialmedicoBean hu = sh.UltimaHistoria(codigo);

		if (hu != null) {
			spinner_ANTEOJOS_EN_USO = "true";
			spinner_ANTEOJOS_FINAL_EJE_OD = "true";
			spinner_ANTEOJOS_FINAL_EJE_OI = "true";
			
			
			objHistorialmedico.setAnteojosenUsoODADD(hu.getRefracicionFinalODADD());
			objHistorialmedico.setAnteojosenUsoODCIL(hu.getRefracicionFinalODCIL());
			objHistorialmedico.setAnteojosenUsoODEJE(hu.getRefracicionFinalODEJE());
			objHistorialmedico.setAnteojosenUsoODESF(hu.getRefracicionFinalODESF());
			objHistorialmedico.setAnteojosenUsoOIEJE(hu.getRefracicionFinalOIEJE());
			objHistorialmedico.setAnteojosenUsoOICIL(hu.getRefracicionFinalOICIL());
			objHistorialmedico.setAnteojosenUsoOIADD(hu.getRefracicionFinalOIADD());
			objHistorialmedico.setAnteojosenUsoOIESF(hu.getRefracicionFinalOIESF());
			

		} else {
			spinner_ANTEOJOS_EN_USO = "false";

		}

		//RequestContext.getCurrentInstance().update("frmHistorial:ANTEOJOSENUSO");

		nombres = objClienteBean.getNombres_apellidos();
		dni = objClienteBean.getDni();

	}
	
	public void ActivarEje_OD() throws Exception {
		
		

		double REFRACCIONFINAL_OD_CIL = Double.parseDouble(objHistorialmedico.getRefracicionFinalODCIL());

		System.out.println("Edinson OD : " + REFRACCIONFINAL_OD_CIL);
		if (REFRACCIONFINAL_OD_CIL == 0) {
			spinner_REFRACCION_FINAL_EJE_OD = "true";
			// spinner_REFRACCION_FINAL_EJE_OI = "true";

		} else {
			spinner_REFRACCION_FINAL_EJE_OD = "false";
			// spinner_REFRACCION_FINAL_EJE_OI = "false";
		}

		if (REFRACCIONFINAL_OD_CIL < -10.0) {
			spinner_REFRACCION_FINAL_EJE_OD = "true";
			// spinner_REFRACCION_FINAL_EJE_OI = "true";
		}

	}

	public void ActivarEje_OI() throws Exception {

		double REFRACCIONFINAL_OI_CIL = Double.parseDouble(objHistorialmedico.getRefracicionFinalOICIL());

		System.out.println("Edinson OI : " + REFRACCIONFINAL_OI_CIL);

		if (REFRACCIONFINAL_OI_CIL == 0) {
			// spinner_REFRACCION_FINAL_EJE_OD = "true";
			spinner_REFRACCION_FINAL_EJE_OI = "true";

		} else {
			// spinner_REFRACCION_FINAL_EJE_OD = "false";
			spinner_REFRACCION_FINAL_EJE_OI = "false";
		}

		if (REFRACCIONFINAL_OI_CIL < -10.0) {
			// spinner_REFRACCION_FINAL_EJE_OD = "true";
			spinner_REFRACCION_FINAL_EJE_OI = "true";
		}
	}
	
	public void ActivarEje_AnteojoEnUso_OD() throws Exception {

		double REFRACCIONFINAL_OD_CIL = Double.parseDouble(objHistorialmedico.getAnteojosenUsoODCIL());

		System.out.println("Edinson OD : " + REFRACCIONFINAL_OD_CIL);
		if (REFRACCIONFINAL_OD_CIL == 0) {
			spinner_ANTEOJOS_FINAL_EJE_OD = "true";
			// spinner_REFRACCION_FINAL_EJE_OI = "true";

		} else {
			spinner_ANTEOJOS_FINAL_EJE_OD = "false";
			// spinner_REFRACCION_FINAL_EJE_OI = "false";
		}

		if (REFRACCIONFINAL_OD_CIL < -10.0) {
			spinner_ANTEOJOS_FINAL_EJE_OD = "true";
			// spinner_REFRACCION_FINAL_EJE_OI = "true";
		}

	}
	
	public void ActivarEje_AnteojoEnUso_OI() throws Exception {

		double REFRACCIONFINAL_OI_CIL = Double.parseDouble(objHistorialmedico.getAnteojosenUsoOICIL());

		System.out.println("Edinson OI : " + REFRACCIONFINAL_OI_CIL);

		if (REFRACCIONFINAL_OI_CIL == 0) {
			// spinner_REFRACCION_FINAL_EJE_OD = "true";
			spinner_ANTEOJOS_FINAL_EJE_OI = "true";

		} else {
			// spinner_REFRACCION_FINAL_EJE_OD = "false";
			spinner_ANTEOJOS_FINAL_EJE_OI = "false";
		}

		if (REFRACCIONFINAL_OI_CIL < -10.0) {
			// spinner_REFRACCION_FINAL_EJE_OD = "true";
			spinner_ANTEOJOS_FINAL_EJE_OI = "true";
		}
	}
	
	public String RegistarHistoria(){
		//System.out.println("Refracicion Final OD ESF :" + objHistorialmedico.getRefracicionFinalODESF());
		//System.out.println("Refracicion Final OD PD :" + objHistorialmedico.getRefracicionFinalODPD());
		//System.out.println("Refracicion Final OD CIL :" + objHistorialmedico.getRefracicionFinalODCIL());
		//System.out.println("Proximo Control: " +objHistorialmedico.getMesesProxControl());		
		//System.out.println("Fecha Luego de 6 MEses: " + sdf.format(Fecha.getTime()));		
		//System.out.println("Fecha Proximo Control: " +proximoControl);
		
		System.out.println("Anteojos en Uso OD CIL: " +objHistorialmedico.getAnteojosenUsoODCIL());
		
		System.out.println("Fecha Proximo Control : " +objHistorialmedico.getFechaRegistro());
		
		FacesContext context = FacesContext.getCurrentInstance();
		String out = "";
		try {
			
			if (objClienteBean.getNombres_apellidos() == null) {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe de seleccionar", "Un Cliente."));
			}else if (proximoControl==0){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Se debe de ingresar", "El Pr�ximo Control del Paciente."));
			}else if(objHistorialmedico.getFechaRegistro()==null){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Por favor de Seleccionar", "La fecha de Registro."));
			}
			
			
			else {
				
				System.out.println("RefracicionFinal OD PD" + objHistorialmedico.getRefracicionFinalODPD());
				System.out.println("RefracicionFinal OD ID" + objHistorialmedico.getRefracicionFinalOIPD());
				
				
				Calendar cal = Calendar.getInstance();
				int cantidadMes = proximoControl;
				//SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				
				Date Fecha =  objHistorialmedico.getFechaRegistro();
				
				
				
				System.out.println("Fecha: " +Fecha);
				
				cal.setTime(Fecha);
				
				cal.add(Calendar.MONTH, cantidadMes);
				Fecha=cal.getTime();
				
			
				
				if (objHistorialmedico.getAgudezaOISC().equals("") || objHistorialmedico.getAgudezaOISC()==null 
						||objHistorialmedico.getAgudezaOISC().equals("null") ||objHistorialmedico.getAgudezaOISC().equals("-Seleccione-")) {
					objHistorialmedico.setAgudezaOISC("-");

				}
				if (objHistorialmedico.getAgudezaODSC().equals("") || objHistorialmedico.getAgudezaODSC().equals("null") 
						|| objHistorialmedico.getAgudezaODSC()==null || objHistorialmedico.getAgudezaODSC().equals("-Seleccione-")) {
					objHistorialmedico.setAgudezaODSC("-");
				}

				if (objHistorialmedico.getAgudezaODPH().equals("") || objHistorialmedico.getAgudezaODPH().equals("null") 
						|| objHistorialmedico.getAgudezaODPH()==null || objHistorialmedico.getAgudezaODPH().equals("-Seleccione-")) {
					objHistorialmedico.setAgudezaODPH("-");
				}

				if (objHistorialmedico.getAgudezaOIPH().equals("") || objHistorialmedico.getAgudezaOIPH().equals("null") || 
						objHistorialmedico.getAgudezaOIPH()==null || objHistorialmedico.getAgudezaOIPH().equals("-Seleccione-")) {
					objHistorialmedico.setAgudezaOIPH("-");
				}

				if (objHistorialmedico.getAgudezaODCC().equals("") || objHistorialmedico.getAgudezaODCC().equals("null") ||
						objHistorialmedico.getAgudezaODCC()==null || objHistorialmedico.getAgudezaODCC().equals("-Seleccione-")) {
					objHistorialmedico.setAgudezaODCC("-");
				}

				if (objHistorialmedico.getAgudezaOICC().equals("") || objHistorialmedico.getAgudezaOICC().equals("null") ||
						objHistorialmedico.getAgudezaOICC()==null || objHistorialmedico.getAgudezaOICC().equals("-Seleccione-")) {
					objHistorialmedico.setAgudezaOICC("-");
				}

				/*if (objHistorialmedico.getAnteojosenUsoODEJE().equals("")) {
					objHistorialmedico.setAnteojosenUsoODEJE("-");
				}

				if (objHistorialmedico.getAnteojosenUsoOIEJE().equals("")) {
					objHistorialmedico.setAnteojosenUsoOIEJE("-");
				}*/
				if(objHistorialmedico.getAnteojosenUsoODCIL().equals("")){
					objHistorialmedico.setAnteojosenUsoODEJE("-");
				}
				
				if(objHistorialmedico.getAnteojosenUsoOICIL().equals("")){
					objHistorialmedico.setAnteojosenUsoOIEJE("-");
				}
				
				
				if(objHistorialmedico.getRefracicionFinalODCIL().equals("")){
					objHistorialmedico.setRefracicionFinalODEJE("-");
				}
				
				if(objHistorialmedico.getRefracicionFinalOICIL().equals("")){
					objHistorialmedico.setRefracicionFinalOIEJE("-");
				}
				
				if(objHistorialmedico.getRefracicionFinalODADD().equals("")){
					objHistorialmedico.setRefracicionFinalODADD("-");
				}
				
				if(objHistorialmedico.getRefracicionFinalOIADD().equals("")){
					objHistorialmedico.setRefracicionFinalOIADD("-");
				}
				if(objHistorialmedico.getRefracicionFinalODPD().equals("")){
					objHistorialmedico.setRefracicionFinalODPD("-");
				}				
				if(objHistorialmedico.getRefracicionFinalOIPD().equals("")){
					objHistorialmedico.setRefracicionFinalOIPD("-");
				}
				
				objHistorialmedico.setFechaProximocontrol(Fecha);
				
				objHistorialmedico.setMesesProxControl(Integer.toString(proximoControl));
				
				
				UsuarioBean usu = (UsuarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
						.get("usuario");

				String codigooptometra = usu.getIdusuario();
				ServicioHistoria servicio = new ServicioHistoria();

				
				GeneradorDeCodigo codigo = new GeneradorDeCodigo();
				
				String idHistoria=codigo.HistoriaMedica();
				objHistorialmedico.setIdHistorialMedico(idHistoria);
				
				servicio.RegistarHistoria(objHistorialmedico,objClienteBean.getIdCliente());
				System.out.println("ID registar : " + usu.getIdusuario());

				servicio.RegistrarHistoriaDetalle(codigooptometra,idHistoria);
				
				context.addMessage(null, new FacesMessage("La Historia Optica ",  "Se registro Correctamente.") );	
				out = "generarHistoria";
				
			}

		} catch (Exception e) {
			System.out.println("Error en Registar la Historia: " + e.getMessage());
			e.printStackTrace();

		}

		return out;
	
	}
		
	public void listar(ActionEvent e) throws Exception {

		FacesContext context = FacesContext.getCurrentInstance();

		idCliente = e.getComponent().getAttributes().get("xid").toString();

		ServicioCliente c = new ServicioCliente();
		objClienteBean = c.buscarClienteID(idCliente);

		ServicioHistoria servicio = new ServicioHistoria();
		listaDetalle = servicio.consultahistorial(idCliente);

		if (listaDetalle.size() == 0) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"No se encuentra registrada una historia para el cliente", ""));
		}

	}
	
	public void BuscarHistoria(ActionEvent e) throws Exception {

		codigo = e.getComponent().getAttributes().get("idHistoria").toString();
		idCliente = e.getComponent().getAttributes().get("xid").toString();

		ServicioCliente sc = new ServicioCliente();
		objClienteBean = sc.buscarClienteID(idCliente);
		ServicioHistoria servicio = new ServicioHistoria();
		objHistorialmedico = servicio.buscarHistoriaID(codigo);
		System.out.println("Codigo de historia Medica a Buscar: " + codigo);

		System.out.println("ANAMNESIS: " + objHistorialmedico.getObservaciones());
		fechaHistoria = objHistorialmedico.getFechaRegistro();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Operaciones objOperaciones = new Operaciones();
		String fecha;
		fecha = sdf.format(objClienteBean.getFechaNacimiento());
		edad = Integer.toString(objOperaciones.edad(fecha));

	}
	
	public void exportarPDF(ActionEvent e) throws JRException, IOException,SQLException,Exception {
		try {
			ServicioCliente servicio = new ServicioCliente();
			
			
			
			codigo = e.getComponent().getAttributes().get("idHistoria").toString();
			idCliente = e.getComponent().getAttributes().get("xid").toString();
			String nombres01 =servicio.buscarClienteID(idCliente).getNombres_apellidos();
			String nombres02 =nombres01.replaceAll(" ", "_").replaceAll("__", "_");
			String nombreFinal = nombres02;
			
			ConexionBD cnx = new ConexionBD(); 
			
			Connection cn =cnx.getConeccionBD();

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("codigoHistoria", codigo);

			File report = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporte/HistoriaOpticaTuOptica.jrxml"));
			JasperReport jasper = JasperCompileManager.compileReport(report.getPath());
			System.out.println("Ruta del Reporte: " + report.getPath());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametros,cn);

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			
			String Exportar= "attachment; filename="+"Historia_"+nombreFinal+".pdf";
			System.out.println("Exportar: " +Exportar );
			response.addHeader("Content-disposition", Exportar);
			
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

			stream.flush();
			stream.close();
			cn.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e2) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error en Generar Historia",  ":" +e2.getMessage()) );
		}
	}
	
	

}
