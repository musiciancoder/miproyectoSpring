package net.itinajero.app.controller;



import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //señala que es el controlador
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		
		//LinkedList<String>peliculas = new LinkedList<>(); //Esto lo probé yo e igual funciona TODO:PREGUNTAR AL PROFE. 
		
		List<String>peliculas = new LinkedList<>(); //linkedlist implementa la interfaz list.
		
		peliculas.add("Rapido y furioso"); //se agrega a la lista
		peliculas.add("El aro 2");
		peliculas.add("Aliens");
		model.addAttribute("peliculas", peliculas);//clave, valor. Despues se utiliza la clave "peliculas" en el item de jsp, en nuestro caso en el archivo home.jsp
		
		
		
		return "home";
	}
	
	
	
	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {
		
		String tituloPelicula = "Rápidos y furiosos";
		int duracion =136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula); //clave, valor. Las claves se usan en los archivos JSP de las views en carpeta webapp
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio",precioEntrada);
		
		return "detalle";
		
	}
	
	
}

