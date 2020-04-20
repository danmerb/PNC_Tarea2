package com.uca.capas.ejemplo.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/alumno")
	
	public @ResponseBody String alumno() {
		String alumno="Nombre: Jeniffer Merino ,Carnet: 00030717, Carrera: Ingenieria, Año: 4";
		return alumno ;
	}
	
	@RequestMapping("/diaSemana")

	public@ResponseBody String diaSemana(HttpServletRequest request) {
		Integer day =Integer.parseInt(request.getParameter("day"));
		Integer month =Integer.parseInt(request.getParameter("month"));
		Integer year =Integer.parseInt(request.getParameter("year"));

       
		try {
			 String dateString = String.format("%d-%d-%d", day, month, year);
			 Date date = new SimpleDateFormat("d-M-yyyy").parse(dateString);
			 String dayW = new SimpleDateFormat("EEEE", Locale.getDefault()).format(date);
			 switch(dayW) {
				case "Monday":
					dayW = "Lunes";
					break;
				case "Tuesday":
					dayW = "Martes";
					break;
				case "Wednesday":
					dayW = "Miércoles";
					break;
				case "Thursday":
					dayW = "Jueves";
					break;
				case "Friday":
					dayW = "Viernes";
					break;
				case "Saturday":
					dayW = "Sábado";
					break;
				case "Sunday":
					dayW = "Domingo";
					break;
				}
			 
			 return "Día de la semana en que cayó "+ day +"/" +month+"/"+year +" es: " + dayW ;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "Error";
		
	        
	    
	}
}
