package net.itinajero.app.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Utileria;



@Controller //señala que es el controlador
public class HomeController {
	
	 private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET)  //url en la barra de direcciones
	public String goHome(){
		return "home"; // devuelve la vista (en este caso home.jsp). Es decir de la barra de direcciones pasa al controlador, quien devuelve la vista
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)  
	public String buscar(@RequestParam ("fecha") String fecha){ //metodo que recibe la fecha que selecciona el usuario en name=fecha y por medio de @RequestParam lo asocia a String fecha, que es lo que se usa en el metodo
		System.out.println("Buscando peliculas en exibicion para la fecha: " + fecha );
		return "home"; 
	}
	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String mostrarPrincipal(Model model){
		
		List<String> listaFechas = Utileria.getNextDays(4); //Utileria (en paquete util) es  static
		//System.out.println(listaFechas); //para probar en consola
		
		//LinkedList<String>peliculas = new LinkedList<>(); //Esto lo probé yo e igual funciona TODO:PREGUNTAR AL PROFE. 
		
		List<Pelicula>peliculas = getLista(); //porque getLista() devuelve una lista. Como en home.jsp se llama a {peliculas}, esta linea a su vez ejecuta getLista();
		
		//peliculas.add("Rapido y furioso"); //se agrega a la lista
		//peliculas.add("El aro 2");
		//peliculas.add("Aliens");;
		model.addAttribute("fechas", listaFechas);//"fechas" se ocupa en el home.jsp
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));// "fechaBusqueda" es lo que se utiliza en el jsp para invocar a  dateFormat.format(new Date())); new Date() da la fecha de hoy 
		model.addAttribute("peliculas", peliculas);//clave, valor. Despues se utiliza la clave "peliculas" en el item de jsp, en nuestro caso en el archivo home.jsp	
		
		return "home";
	}
	
	
	
	//@RequestMapping(value="/detail/{id}/{fecha}",method=RequestMethod.GET) //aca se reconoce la url dinamica, que es escrita en la barra de direcciones al presionar el boton del ConsultaHorario archivo jsp
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha){ //@PathVariable une los parametros dinamicos en en argumento de RequestMapping a la variable local, es decir une id con int idPelicula
	
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) { //idMovie y fecha en azul vienen del jsp en la linea href="detail?idMovie=${pelicula.id }&fecha=${fechaBusqueda}
		
		System.out.println("Buscando horarios de peliculas " + idPelicula); //esto es solo para probar que funciona pathvariable, la idea es ocuparlo con un idPelicula que venga desde BBDD
		System.out.println("Para la fecha: " + fecha); 
		
		//TODO: BUSCAR EN LA BBDD LOS HORARIOS
		
		//String tituloPelicula = "Rápidos y furiosos";
		//int duracion =136;
		//double precioEntrada = 50;
		
		//model.addAttribute("titulo", tituloPelicula); //clave, valor. Las claves se usan en los archivos JSP de las views en carpeta webapp
		//model.addAttribute("duracion", duracion);
		//model.addAttribute("precio",precioEntrada);
		
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

	
	


