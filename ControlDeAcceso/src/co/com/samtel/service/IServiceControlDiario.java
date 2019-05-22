package co.com.samtel.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import co.com.samtel.entities.ControlDiario;

public interface IServiceControlDiario extends IServiceRepo<ControlDiario,Integer> {
	
	int countC();
	List<ControlDiario> findAllRange( int mes, int year, int diaI,  int diaF);
	

}
