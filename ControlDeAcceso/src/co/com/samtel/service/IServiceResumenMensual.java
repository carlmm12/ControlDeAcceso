package co.com.samtel.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import co.com.samtel.entities.ResumenMensual;

public interface IServiceResumenMensual extends IServiceRepo<ResumenMensual, Integer> {

	
	Integer findnumAlertas (int codigo, int mes, int year, int tipoAlerta);
    void updateEntity(ResumenMensual entity);
    void deleteRegistros ( int mes, int year);
    List<ResumenMensual> findbyAlertType (int tipoAlerta);
}
