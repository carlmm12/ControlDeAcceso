package co.com.samtel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.samtel.entities.ControlAccesosOrd;
import co.com.samtel.repository.IcontrolAcessoOrd;
import co.com.samtel.service.IServiceControlAccesoOrd;

@Service("ControlAccesoOrdBean")
public class ControlAccesoOrdImpl implements IServiceControlAccesoOrd {
	
	@Autowired
	public IcontrolAcessoOrd controlAccesoOrd;

	@Override
	public void save(ControlAccesosOrd entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean saveAll(List<ControlAccesosOrd> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ControlAccesosOrd findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ControlAccesosOrd> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ControlAccesosOrd entity) {
		// TODO Auto-generated method stub
		
	}

}
