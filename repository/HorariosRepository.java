package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.itinajero.app.model.Horario;

/** Marcamos esta clase como un Bean de tipo Repository en nuestro Root ApplicationContext.
	Nota: La anotacion @Repository es opcional ya que al extender la interfaz JpaRepository Spring 
	crea una instancia en nuestro Root ApplicationContext.
*/
@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer>{

	// Horarios por idPelicula. El nombre del metodo query personalizado debe ir en relacion a la clase de modelo (en este caso la clase modelo Horario). En clase Horario, Pelicula.id = Pelicula_Id and fecha=?)
	public List <Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha); //metodo tipo query personalizado
	
	/* mysql.cnf
	 *  [mysqld]
	 * 	sql_mode = "STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" 
	 */
	@Query("select h from Horario h where h.fecha = :fecha and pelicula.estatus='Activa' group by h.pelicula order by pelicula.id asc")
	public List<Horario> findByFecha(@Param("fecha") Date fecha);
}
