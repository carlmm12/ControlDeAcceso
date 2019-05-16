package co.com.samtel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.samtel.entities.ControlDiario;

public interface IControlDiario extends JpaRepository<ControlDiario, Integer> {

	@Query(value="SELECT * FROM tblcontrol_diario  WHERE fecha = :fecha AND codigo_usuario = :codigo", nativeQuery=true)
	List<ControlDiario> findControlD (@Param("fecha") Date fecha, @Param("codigo") int codigo);
	
	@Query(value="SELECT count(*) FROM tblcontrol_diario",nativeQuery=true)
	int countC();
}
