package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private IPeliculasService servicePeliculas; //para inyeccion de dependencias
	
	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar (Pelicula pelicula, BindingResult result) { //Aca tenemos databinding para peliculas. el tipo BindingResult es usado es usado por el servidor para dar un informe detallado en caso de errores en el dataBinding
		
		if(result.hasErrors()) { //para probar
			System.out.println("Existieron errores");
			return "peliculas/formPelicula";
			
		}
		
		/*for(ObjectError error:result.getAllErrors()) { //esto se usa para dar una mejor descripcion del error
			System.out.println(error.getDefaultMessage());
			
			
		}*/
		
		System.out.println("Recibiendo pelicula: " + pelicula);
		
		System.out.println("Elementos de la lista antes de la inserción: " + servicePeliculas.buscarTodas().size() ); //size() va a dar el numero de elementos de la lista servicePeliculas.buscarTodas()
		
		servicePeliculas.insertar(pelicula); //por inyeccion de dependencias para insertar nueva pelicula a la lista
		
		System.out.println("Elementos de la lista despues de la inserción: " + servicePeliculas.buscarTodas().size() );
		
		return "peliculas/formPelicula";
	}
	
	//Esto es para que el formato especificado coincida con el formato del sistema operativo, en este caso la fecha del sistema oper. es dd//MM/aaaa y nosotros debemos forzarla a que sea dd-MM-yyyy
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
