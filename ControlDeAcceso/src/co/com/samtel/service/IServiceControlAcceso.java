package co.com.samtel.service;

import java.util.Date;
import java.util.List;

import co.com.samtel.entities.ControlAcceso;

public interface IServiceControlAcceso extends IServiceRepo<ControlAcceso,Integer> {
  
	public List<ControlAcceso> findByMonth(int month);
	
	public int countByDay(int id, Date fecha);
}
