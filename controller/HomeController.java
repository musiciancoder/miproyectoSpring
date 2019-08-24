package net.itinajero.app.controller;



import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import net.itinajero.app.model.Pelicula;



@Controller //señala que es el controlador
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)  //url en la barra de direcciones
	public String goHome(){
		return "home"; // devuelve la vista (en este caso home.jsp). Es decir de la barra de direcciones pasa al controlador, quien devuelve la vista
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String mostrarPrincipal(Model model){
		
		//LinkedList<String>peliculas = new LinkedList<>(); //Esto lo probé yo e igual funciona TODO:PREGUNTAR AL PROFE. 
		
		List<Pelicula>peliculas = getLista(); //porque getLista() devuelve una lista. Como en home.jsp se llama a {peliculas}, esta linea a su vez ejecuta getLista();
		
		//peliculas.add("Rapido y furioso"); //se agrega a la lista
		//peliculas.add("El aro 2");
		//peliculas.add("Aliens");
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
		
		//Metodo para generar una lista de Objetos de Modelo (Pelicula)
		private List<Pelicula> getLista() {
			
			SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
			
			List <Pelicula>lista=null;
			
			try {
				lista= new LinkedList<>();
				
Pelicula pelicula1 = new Pelicula();
				
				pelicula1.setId(1);//en el setter tenemos: this.id=id, por lo tanto acá queda establecido el atributo pelicula.id=1
				pelicula1.setTitulo("Power Rangers");
				pelicula1.setDuracion(120);
				pelicula1.setClasificacion("B");
				pelicula1.setGenero("Aventura");
				pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
				//imagen="cinema.png", porque esta asi por fefault en clase Pelicula
				//estatus="Activa", porque esta asi por fefault en clase Pelicula
				pelicula1.setEstatus("Activa");
				
Pelicula pelicula2 = new Pelicula();
				
				pelicula2.setId(2); 
				pelicula2.setTitulo("La Bella y la Bestia");
				pelicula2.setDuracion(132);
				pelicula2.setClasificacion("a");
				pelicula2.setGenero("Infantil");
				pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
				pelicula2.setImagen("bella.png");
				pelicula2.setEstatus("Activa");
				
				
				
Pelicula pelicula3 = new Pelicula();
				
				pelicula3.setId(3);
				pelicula3.setTitulo("Contratiempo");
				pelicula3.setDuracion(106);
				pelicula3.setClasificacion("B");
				pelicula3.setGenero("Thriller");
				pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
				pelicula3.setImagen("contratiempo.png");
				pelicula3.setEstatus("Activa");
				
Pelicula pelicula4 = new Pelicula();
				
				pelicula4.setId(4);
				pelicula4.setTitulo("Kong La Isla Calavera");
				pelicula4.setDuracion(118);
				pelicula4.setClasificacion("B");
				pelicula4.setGenero("Aventura");
				pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
				pelicula4.setImagen("kong.png");
				pelicula4.setEstatus("Inactiva");
				
Pelicula pelicula5 = new Pelicula();
				
				pelicula5.setId(5);
				pelicula5.setTitulo("Life: Vida Inteligente");
				pelicula5.setDuracion(104);
				pelicula5.setClasificacion("B");
				pelicula5.setGenero("Drama");
				pelicula5.setFechaEstreno(formatter.parse("10-06-2017"));
				pelicula5.setImagen("estreno5.png"); // Nombre del archivo de imagen
				pelicula5.setEstatus("Activa"); // Esta pelicula estara inactiv
				
				//Agregamos los objetos Pelicula a la lista
				
				lista.add(pelicula1);
				lista.add(pelicula2);
				lista.add(pelicula3);
				lista.add(pelicula4);
				lista.add(pelicula5);
				
				return lista; //que devuelva una lista de peliculas List<pelicula>
				
			} catch (ParseException e) {
				System.out.println("Error: " + e.getMessage());
				
				return null;
			}
		}
	}

	
	


