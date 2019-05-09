package co.com.samtel.repository;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.samtel.entities.ControlAcceso;

@Repository
public interface IControlAcceso  extends JpaRepository<ControlAcceso, Integer> {

	@Modifying
	@Query(value = "INSERT INTO controlacceso.tblcontrol_accesos" + 
			"(tmno, enno, name, `inout`, mode, `datetime`)" + 
			"VALUES(:tmno,:enno,:name ,:inout,:mode,:datatime)", nativeQuery = true)
	@Transactional
    public int insertControlAcc(@Param("tmno")int tmno, @Param("enno")int enno, @Param("name")String name,@Param("inout")int inout,@Param("mode")int mode ,@Param("datatime")Date datatime);
	
}
