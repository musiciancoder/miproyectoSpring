package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Pelicula;

public interface IPeliculasService {
	
	void insertar (Pelicula pelicula);//metodo3
	
	List <Pelicula> buscarTodas (); //metodo1
	
	Pelicula buscarPorId(int idPelicula);//metodo2
	
	List <String> buscarGeneros();

}
