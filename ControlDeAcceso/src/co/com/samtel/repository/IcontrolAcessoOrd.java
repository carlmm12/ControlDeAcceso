package co.com.samtel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.samtel.entities.ControlAccesosOrd;
import co.com.samtel.entities.ControlAccesosOrdPK;

public interface IcontrolAcessoOrd  extends JpaRepository<ControlAccesosOrd, Integer>{

	@Query(value="SELECT count(*) FROM tblcontrol_accesos_ord", nativeQuery = true )
	int countOrd();
	
	
	@Query(value="SELECT * FROM tblcontrol_accesos_ord WHERE fecha = :fecha AND tblcodigo_usuarios_codigo = :id", nativeQuery = true )
	ControlAccesosOrd findControlAcc(@Param("fecha") Date fecha, @Param("id") int id  );
	
	@Query(value="SELECT * FROM tblcontrol_accesos_ord WHERE fecha = :fecha AND tblcodigo_usuarios_codigo = :id", nativeQuery = true )
	List<ControlAccesosOrd> findAllControlAcc(@Param("fecha") Date fecha, @Param("id") int id  );
	
}
