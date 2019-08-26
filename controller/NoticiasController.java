package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/noticias") //con esto le damos una url a la clase
public class NoticiasController {
	
	@GetMapping(value="/create") //con esto le damos una url al metodo. En la barra de direcciones, entoces es /noticias/create
	public String crear() {
		
		return "noticias/formNoticia"; //renderiza el jsp formNoticia
		
	}
	
	@PostMapping(value="/save") 
	public String guardar(@RequestParam ("titulo") String titulo, @RequestParam ("estatus") String estatus, @RequestParam ("detalle") String detalle){
		//con @RequestParam ("titulo") String titulo, con esto asociamos el parametro name del formulario con un string a ser ocupado en el metodo
		System.out.println("Titulo: " + titulo);
		System.out.println("Estatus: " + estatus);
		System.out.println("Detalle: " + detalle);
		
		
		return "noticias/formNoticia";
		
	}

}
