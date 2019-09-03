package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.itinajero.app.model.Contacto;

@Controller
public class ContactoController {
	
	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute ("instanciaContacto") Contacto contacto) {//@ModelAttribute automaticamente crea una instancia "instanciaContacto" con el constructor por defecto de la clase modelo contacto y la agrega al modelo. 
		//si no le damos un nombre a la instancia contacto (en este caso sí lo hicimos con "instanciaContacto"), por defecto esta instancia toma el nombre de la clase modelo en minuscula (en nuestro caso seria contacto)
		return "formContacto";
	}

}
