package co.com.samtel.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import co.com.samtel.dto.ControlDiarioDto;
import co.com.samtel.entities.ControlAcceso;
import co.com.samtel.entities.ControlAccesosOrd;

public interface IServiceControlAccesoOrd extends IServiceRepo<ControlAccesosOrd,Integer> {

	int countOrd();
	void saveImpar(ControlAccesosOrd entity);
	List<String> countDate();
	List<Integer> usersDate( String fecha);
	List<ControlAccesosOrd> registroUsers(String fecha , int codigo );
	ControlDiarioDto controlDia(String fecha ,  int codigo );
	
}
