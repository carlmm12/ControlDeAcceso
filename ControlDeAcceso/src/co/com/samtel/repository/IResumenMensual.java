package co.com.samtel.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.samtel.entities.ControlDiario;
import co.com.samtel.entities.ResumenMensual;

@Repository
public interface IResumenMensual extends JpaRepository<ResumenMensual, Integer> {

	
	@Query(value="SELECT  nro_alertas FROM tblresumenes_mensual WHERE codigo = :codigo AND MONTH(DATE(fecha)) = :mes AND YEAR(DATE(fecha)) = :year AND tipo_alerta = :tp", nativeQuery=true)
	Integer findnumAlertas ( @Param("codigo") int codigo, @Param("mes") int mes,@Param("year") int year ,@Param("tp") int tipoAlerta);
	
	@Modifying
	@Query(value="UPDATE tblresumenes_mensual SET  nro_alertas= :numalertas, porcentaje_alertas= :porcentaje WHERE codigo= :codigo AND MONTH(DATE(fecha)) = :mes AND tipo_alerta = :tp", nativeQuery=true)
	@Transactional
	void updateEntity ( @Param("numalertas") int numalertas, @Param("porcentaje") int porcentaje,@Param("codigo") int codigo,  @Param("mes") int mes, @Param("tp") int tp);
	
	
	
}
