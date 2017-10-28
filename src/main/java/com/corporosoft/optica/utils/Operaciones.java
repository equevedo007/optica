package com.corporosoft.optica.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Operaciones {
	
	public int edad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
		   
	    Date fechaActual = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	    String hoy = formato.format(fechaActual);
	    String[] dat1 = fecha_nac.split("-");
	    String[] dat2 = hoy.split("-");
	    int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
	    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
	    if (mes < 0) {
	      anos = anos - 1;
	    } else if (mes == 0) {
	      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
	      if (dia > 0) {
	        anos = anos - 1;
	      }
	    }
	    return anos;
	  
	}
	
	public String formatDecimal(String numero){
		String out="";
		try {
			
			
		if(numero.equals("") || numero.equals("0") || numero.equals("-"))	{
			out="-";
		}else{
			double nun=	Double.parseDouble(numero);
			DecimalFormat df = new DecimalFormat("#0.00");
			String a=df.format(nun);
			out=a.replace(',', '.');
		}
			
		
			
		} catch (Exception e) {
			System.out.println("Error en dar formato Decimal: "+e.getMessage());
		}
		return out;
	}

	public int dias (Date Fecha){
		
		
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al d�a 
		java.util.Date hoy = new Date(); //Fecha de hoy 
		 
		String calcularFecha = Fecha.toString(); 
		
		int dia = Integer.parseInt(calcularFecha.substring(8)); 
		int mes = Integer.parseInt(calcularFecha.substring(5,7)); 
		int anno = Integer.parseInt(calcularFecha.substring(0,4)); //Fecha anterior 
		Calendar calendar = new GregorianCalendar(anno, mes-1, dia); 
		java.sql.Date fecha = new java.sql.Date(calendar.getTimeInMillis());

		long diferencia = ( fecha.getTime()-hoy.getTime() )/MILLSECS_PER_DAY; 
		Integer i = (int) (long) diferencia;
		
		return i+1;
	}
	
}
