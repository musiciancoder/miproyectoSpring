package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticias") //con esto le damos una url a la clase
public class NoticiasController {
	
	@GetMapping(value="/create") //con esto le damos una url al metodo. En la barra de direcciones, entoces es /noticias/create
	public String crear() {
		
		return "noticias/formNoticia";
		
	}

}
