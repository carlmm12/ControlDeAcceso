package co.com.samtel.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.samtel.entities.ControlAcceso;

@Repository
public interface IControlAcceso  extends JpaRepository<ControlAcceso, Integer> {

	
	/*
	 * Metodo que me permite registrar los controles de accesos.
	 */
	@Modifying
	@Query(value = "INSERT INTO controlacceso.tblcontrol_accesos" + 
			"(tmno, enno, name, `inout`, mode, `datetime`)" + 
			"VALUES(:tmno,:enno,:name ,:inout,:mode,:datatime)", nativeQuery = true)
	@Transactional
    public int insertControlAcc(@Param("tmno")int tmno, @Param("enno")int enno, @Param("name")String name,@Param("inout")int inout,@Param("mode")int mode ,@Param("datatime")Date datatime);
	
	
	/*
	 * Metodo que me permite traer todo el control acceso ardenados por fecha y por usuario de acuerdo al mes especificado
	 */
	
	@Query(value="select * from controlacceso.tblcontrol_accesos where month(DATE(`datetime`)) = :month order by enno, DATE(`datetime`), TIME('datetime') asc", nativeQuery = true)
	public List<ControlAcceso> findByMonth(@Param("month")int month);
	
	/*
	 * metodo que me permite traer el numero de registros de un usuario for una fecha especifica
	 */
	
	@Query(value="select count(*) from controlacceso.tblcontrol_accesos where enno = :enno and  DATE(`datetime`) = :date ",nativeQuery = true )
	public int countByDay(@Param("enno")int enno, @Param("date") Date date);
	
}
