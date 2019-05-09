package co.com.samtel.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle.Control;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import co.com.samtel.entities.ControlAcceso;
import co.com.samtel.repository.IControlAcceso;
import co.com.samtel.service.IServiceControlAcceso;

@Service("ControlAccesoBean")
public class ControlAccesoImpl implements IServiceControlAcceso {

	

	@Autowired
	public IControlAcceso controlA;
	
	public ControlAccesoImpl() {

	}

	public void save(ControlAcceso entity) {
		// TODO Auto-generated method stub
		
		
		controlA.insertControlAcc(entity.getTmno(),entity.getId().getEnno() , entity.getName(), entity.getInout(),entity.getMode() , entity.getId().getDatetime());
		
	}

	public Boolean saveAll(List<ControlAcceso> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public ControlAcceso findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<ControlAcceso> findAll() {
		// TODO Auto-generated method stub
		return controlA.findAll();
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	public void delete(ControlAcceso entity) {
		// TODO Auto-generated method stub

	}

}
