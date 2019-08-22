<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- el siguiente taglib es para usar jstl, es decir usar por ejemplo el tag c:foreach que se activa con el prefix c  --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a Cineapp</title>
</head>
<body>
	<h1>Lista de Películas</h1>
	
	<ol>
	
	<c:forEach items="${peliculas}" var="pelicula"> <!--  {peliculas} es el nombre de la lista definida en HomeController. var="pelicula" es como se usa aca en el html -->
		<li>${pelicula}</li>
	</c:forEach>
	</ol>
	
	Tabla de peliculas
	<table border="1">
	<thread>
		<tr>
			<th>Id</th>
			<th>Titulo</th>
			<th>Duracion</th>
			<th>Clasificacion</th>
			<th>Genero</th>
		</tr>
	</thread>
	<tbody>
	
		<c:forEach items="${ peliculas }" var="pelicula"> <!--  {peliculas} es el nombre de la lista definida en HomeController. var="pelicula" es como se usa aca en el html;
		(continuacion) en el fondo quiere decir que para cada objeto perteneciente a la clase <Pelicula> de la lista peliculas, ejecute el codigo que sigue a continuacion -->
		<tr>
			<td>${pelicula.id }</td>
			<td>${pelicula.titulo }</td>
			<td>${pelicula.duracion } min</td> <!-- se puede agregar texto, como en este caso min -->
			<td>${pelicula.clasificacion }</td>
			<td>${pelicula.genero }</td>
		</tr>
	</c:forEach>
	
	</tbody>
	
	</table>
	
</body>
</html>