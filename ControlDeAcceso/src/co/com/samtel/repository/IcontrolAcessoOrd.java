package co.com.samtel.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.samtel.dto.ControlDiarioDto;
import co.com.samtel.entities.ControlAcceso;
import co.com.samtel.entities.ControlAccesosOrd;
import co.com.samtel.entities.ControlAccesosOrdPK;

public interface IcontrolAcessoOrd  extends JpaRepository<ControlAccesosOrd, Integer>{

	/*
	 * metodo que me permite traer todo el conteo de los registros en la tabla
	 */
	
	@Query(value="SELECT count(*) FROM tblcontrol_accesos_ord", nativeQuery = true )
	int countOrd();
	 
	/*
	 * query que me permite traer el control de acceso de acuerdo a un a fecha y usuario determinado
	 */
	
	@Query(value="SELECT * FROM tblcontrol_accesos_ord WHERE fecha = :fecha AND tblcodigo_usuarios_codigo = :id", nativeQuery = true )
	ControlAccesosOrd findControlAcc(@Param("fecha") Date fecha, @Param("id") int id  );
	
	/*
	 * metodo que me trae todos los controles de acceso de acuerdo a una fecha y un usario determinado
	 */
	@Query(value="SELECT * FROM tblcontrol_accesos_ord WHERE fecha = :fecha AND tblcodigo_usuarios_codigo = :id", nativeQuery = true )
	List<ControlAccesosOrd> findAllControlAcc(@Param("fecha") Date fecha, @Param("id") int id  );
	
	
	/*
	 * metodo para traer todas las fechas 
	 */
	
	@Query(value="select DATE(fecha) AS fechas FROM tblcontrol_accesos_ord GROUP BY fechas", nativeQuery = true )
	public List<String> countDate();
	
	/*
	 * Metodo que me trae todos los usuarios que se registraron en la fecha determinada 
	 */
	@Query(value="SELECT tblcodigo_usuarios_codigo FROM tblcontrol_accesos_ord WHERE DATE(fecha) = :fecha GROUP BY tblcodigo_usuarios_codigo", nativeQuery = true )
	public List<Integer> usersDate(@Param("fecha") String fecha);
	
	
	/*
	 * Metodo que me trae todos los registros que se realizdo de acuerdo al usuario y a la fecha determinada
	 */
	@Query(value="SELECT * FROM tblcontrol_accesos_ord WHERE DAte(fecha) = fecha AND tblcodigo_usuarios_codigo = id ORDER BY fecha asc", nativeQuery = true )
	public List<ControlAccesosOrd> registroUsers(@Param("date") String fecha , @Param("id") int codigo );
	
	/*
	 * Metodo que me trae la hora de entrada y salida además del tiempo laborado por fecha y  usuario especifico
	 */
	@Query(value="SELECT MIN(TIME(fecha)) AS entrada, max(TIME(fecha)) AS salida, TIMEDIFF(MAX(fecha), MIN(fecha)) AS tiempo  FROM tblcontrol_accesos_ord  WHERE DAte(fecha) = :fecha AND tblcodigo_usuarios_codigo = :codigo ", nativeQuery = true )
	public List<Object[]> controlDia(@Param("fecha") String fecha , @Param("codigo") int codigo );
	
	@Query(value="SELECT MIN(TIME(fecha)) AS entrada, max(TIME(fecha)) AS salida, TIMEDIFF(TIMEDIFF(MAX(fecha), MIN(fecha)) , '01:00:00') AS tiempo  FROM tblcontrol_accesos_ord  WHERE DAte(fecha) = :fecha AND tblcodigo_usuarios_codigo = :codigo", nativeQuery = true )
	public List<Object[]> controlDias(@Param("fecha") String fecha , @Param("codigo") int codigo );
	
	
}
