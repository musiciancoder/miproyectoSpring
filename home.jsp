<!-- este taglib es para usar tags de spring-->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- este taglib es para usar el core de jstl, que permite usar loops y condicionales, es decir usar por ejemplo el tag c:foreach que se activa con el prefix c  -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<!-- EN EL VIDEO INTEGRAR PLANTILLA HTML, COPIO Y PEGO ESTE CODIGO  -->

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>CineSite | Bienvenido</title>
    
    <!--  ${urlPublic} se renderiza como cineapp/resources, es decir permite apuntar hacia un directorio en especifico-->
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    
	<!-- Ac� agregamos bootstrap utilizando ${urlPublic} para la ruta de acceso-->
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

  </head>

  <body>

     <!-- MENU -->
<!-- Con esto renderizamos el codigo html que esta en el archivo menu, en el directorio includes  -->
<jsp:include page="includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <!-- Carousel
    ================================================== -->
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>         
          <li data-target="#myCarousel" data-slide-to="3"></li>	
        </ol>
        <!-- Image Size 1140 x 250 -->
        <div class="carousel-inner" role="listbox">
          <div class="item active">         
            <img src="${urlPublic}/images/slide1.jpg" alt="Slide" title="Some text" >
          </div>
          <div class="item">         
            <img src="${urlPublic}/images/slide2.jpg" alt="Slide" title="Some text" >
          </div>
          <div class="item">         
            <img src="${urlPublic}/images/slide3.jpg" alt="Slide" title="Some text" >
          </div>
          <div class="item">         
            <img src="${urlPublic}/images/slide4.jpg" alt="Slide" title="Some text" >
          </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div><!-- /.carousel -->

      <div class="row page-header">          
        <div class="col-lg-12">         
          <h2 class="text text-center"><span class="label label-success">EN CARTELERA</span></h2>          
          <form class="form-inline" action="${urlRoot}search" method="post"> <!-- action="${urlRoot}search" es para que lo encuentre el controlador por medio de @RequestMapping(value="/search", method=RequestMethod.POST) -->
            <div class="form-group">
              <label for="fecha">Fecha: </label>
              <select id="fecha" name="fecha" class="form-control"> <!--name="fecha" es lo que configuramos en el controller con la anotacion @requestparam-->
				<c:forEach items="${fechas}" var="fecha"> <!-- en el controller, model.addAttribute("fechas", listaFechas)  -->
         <c:choose>
  		   <c:when test="${fechaBusqueda eq fecha}" >
			  <option value="${fecha}" selected>${fecha}</option>	
		   </c:when>
		   <c:otherwise>
			  <option value="${fecha}">${fecha}</option>	
		   </c:otherwise>
		</c:choose>	
                </c:forEach>             
              </select>
            </div>            
            <button type="submit" class="btn btn-primary">Filtrar</button>
          </form>
        </div>
      </div>

      <!-- Marketing messaging -->
      <div class="container marketing">

        <div class="row">
        
<!-- en la lista peliculas en el controlador, por cada objeto tipo pelicula , vamos a renderizar el codigo siguiente -->
          
          <c:forEach items="${peliculas}" var="pelicula">
          
          <div class="col-xs-12 col-sm-6 col-md-3">
            <img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}" alt="Generic placeholder image" width="150" height="200">
            <h4>${pelicula.titulo}</h4>
            <h4>
              <span class="label label-default">${pelicula.clasificacion}</span>
              <span class="label label-default">${pelicula.duracion} min</span>
              <span class="label label-default">${pelicula.genero}</span>
            </h4>  
                   
            <%-- 
            <p><a class="btn btn-sm btn-primary" href="detail/${pelicula.id }/${fechaBusqueda}" role="button">Consulta Horarios &raquo;</a></p> //< href="detail/${pelicula.id }/${fechaBusqueda} es para url dinamica utilizando @PathVariable en el controller
            --%>
          	
          	<!-- href="detail?idMovie=${pelicula.id }&fecha=${fechaBusqueda}" es para usar hacer link a una url con parametros tipo get, con requestparam en el controller; The key difference between @RequestParam and @PathVariable is that @RequestParam used for accessing the values of the query parameters where as @PathVariable used for accessing the values from the URI template.    --> 
          	
          <p><a class="btn btn-sm btn-primary" href="detail?idMovie=${pelicula.id }&fecha=${fechaBusqueda}" role="button">Consulta Horarios &raquo;</a></p> 
          
          </div>
          
          </c:forEach>

    

        </div>

        <div class="page-header">
          <h2 class="text text-center"><span class="label label-success">Noticias y novedades</span></h2>
       
        </div>

        <div class="row">

          <div class="col-sm-12 blog-main">

            <div class="blog-post">              
              <h3 class="blog-post-title">Julia Roberts protagonizar� The Bookseller</h3>

              <p class="blog-post-meta"><span class="label label-danger">Publicado: 16-06-2017</span></p>             
              <p>La novela de Cynthia Swanson <span style="color: #0000ff;"><strong>The Bookseller</strong></span> ser&aacute; llevada al cine con <span style="color: #0000ff;">Julia Roberts (Los Pitufos: La aldea Escondida)</span> como protagonista.<br /><br />La historia est&aacute; ambientada en los sesenta y su protagonista es una mujer soltera, Kitty Miller, que lleva una librer&iacute;a. Sue&ntilde;a con una vida alternativa en la que ha encontrado el amor y est&aacute; casada y con hijos, pero la l&iacute;nea que separa realidad y ficci&oacute;n comienza a estar demasiado dispersa para que la distinga.<br /><br />Seg&uacute;n informa <span style="color: #ff0000;"><strong>Moviehole</strong></span> Roberts tambi&eacute;n producir&aacute; la pel&iacute;cula junto a Lisa Gillan y Marisa Yeres Hill.</p>

              <hr class="featurette-divider">
            </div>

            <div class="blog-post">              
              <h3 class="blog-post-title">Bob Esponja: tercera pel�cula y temporada 12</h3>
              <p class="blog-post-meta"><span class="label label-danger">Publicado: 15-06-2017</span></p>              

              <p><strong><span style="color: #ff0000;">Nickelodeon y productor de SpongeBob Square Pants confirman temporada 12 de 52 episodios y tercera pel&iacute;cula pr&oacute;ximamente. </span></strong></p>
              <p><strong>&iexcl;Calamardo est&aacute; enojado!Bob Esponja: tercera pel&iacute;cula y temporada 12</strong></p>
              <p>Nickelodeon y productor de SpongeBob Square Pants confirman temporada 12 de 52 episodios y tercera pel&iacute;cula pr&oacute;ximamente. &iexcl;Calamardo est&aacute; enojado!.</p>
              <p>A lado de cierta Pi&ntilde;a (debajo del mar), Calamardo debe estar de muy mal humor, pues hay Bob Esponja para rato... &iexcl;y por partida doble!. Por un lado, Vincent Waller (The Ren &amp; Stimpy Show), artista, productor, escritor y supervisor creativo de SpongeBob Squarepants anunci&oacute; con un divertido dibujo desde su cuenta de Twitter que, antes de que se estrene siquiera la temporada 11 de la serie animada, se ha confirmado ya la n&uacute;mero 12, &iexcl;que constar&aacute; de 52 episodios (recuerden que cada emisi&oacute;n consta de 2 aventuras)!</p>

              <hr class="featurette-divider">
            </div>

          </div>
        </div>

      </div>

      <!-- FOOTER -->
      <!-- Con esto renderizamos el codigo html que esta en el archivo menu, en el directorio includes  -->
	  <jsp:include page="includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script> 
  </body>
</html>
