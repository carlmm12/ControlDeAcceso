package co.com.samtel.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import co.com.samtel.entities.ControlAcceso;

public interface IServiceControlAcceso extends IServiceRepo<ControlAcceso,Integer> {
  
	public List<ControlAcceso> findByMonth(int month);
	
	public int countByDay(int id, String fecha);
	public List<String> countDate();
	List<ControlAcceso> registroUsers(String fecha , int codigo );
	List<Integer> usersDate(@Param("date") String fecha);
}
