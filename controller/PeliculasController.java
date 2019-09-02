package net.itinajero.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private IPeliculasService servicePeliculas; //para inyeccion de dependencias
	
	@GetMapping("/index") 
	public String mostrarIndex (Model model) { //metodo para agregar la lista de peliculas al modelo
		List <Pelicula> lista = servicePeliculas.buscarTodas(); //exactamente lo mismo que en metodo mostrarPrincipal de homecontroller, pero aca le estamos dando otra url y va a renderizar "/peliculas/listaPeliculas" en vez de "/home"
		model.addAttribute("peliculas", lista); //peliculas se usa en  <c:forEach var="pelicula" items="${peliculas}"> en listaPeliculas.jsp  
		return "peliculas/listaPeliculas";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula) { // @ModelAttribute se usa para vincular lo que se escribe en los inputs de las vistas (en nuestro caso formPeliculas.jsp) con el modelo a traves de la clase modelo ( en nuestro caso Pelicula)
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar (@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes, //Aca tenemos databinding para peliculas. el tipo BindingResult es usado es usado por el servidor para dar un informe detallado en caso de errores en el dataBinding
		 @RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) { //Multipart is a container that holds multiple body parts. Multipart provides methods to retrieve and set its subparts.  A ServletRequest object provides data including parameter name and values, attributes, and an input stream. 
		
		
		if(result.hasErrors()) { //para probar
			System.out.println("Existieron errores");
			return "peliculas/formPelicula";	
		}
		
		if (!multiPart.isEmpty()) { //si el contenedor no esta vacio
			String nombreImagen = Utileria.guardarImagen(multiPart,request);
			pelicula.setImagen(nombreImagen);
			}
		
		
		/*for(ObjectError error:result.getAllErrors()) { //esto se usa para dar una mejor descripcion del error
			System.out.println(error.getDefaultMessage());
				
		}*/
		
		System.out.println("Recibiendo pelicula: " + pelicula);
		
		System.out.println("Elementos de la lista antes de la inserción: " + servicePeliculas.buscarTodas().size() ); //size() va a dar el numero de elementos de la lista servicePeliculas.buscarTodas()
		
		servicePeliculas.insertar(pelicula); //por inyeccion de dependencias, para insertar una nueva pelicula escrita en el formulario a la lista de peliculas
		
		System.out.println("Elementos de la lista despues de la inserción: " + servicePeliculas.buscarTodas().size() );
		
		attributes.addFlashAttribute("mensaje", "El registro fue guardado"); //agregamos un mensaje con flashatributes, sera visible en pantalla solo cuando terminamos de agregar una pelicula y se redirecciona a redirect:/peliculas/index
		
		
		return "redirect:/peliculas/index"; //redireccionamiento. el redireccionamiento es siempre tipo get, y aca estamos ocupando post en metodo guardar. addFlashatributes se ocupa para que no se produzcan conflicos .
	}
	


	
	//Esto es para que el formato especificado coincida con el formato del sistema operativo, en este caso la fecha del sistema oper. es dd//MM/aaaa y nosotros debemos forzarla a que sea dd-MM-yyyy
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
