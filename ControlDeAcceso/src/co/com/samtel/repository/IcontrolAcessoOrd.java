package co.com.samtel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.samtel.entities.ControlAccesosOrd;

public interface IcontrolAcessoOrd  extends JpaRepository<ControlAccesosOrd, Integer>{

	@Query(value="SELECT count(*) FROM tblcontrol_accesos_ord", nativeQuery = true )
	int countOrd();
	
}
