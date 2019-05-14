package co.com.samtel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.samtel.entities.ControlDiario;
import co.com.samtel.repository.IControlDiario;
import co.com.samtel.service.IServiceControlDiario;

@Service("ControlDiarioBean")
public class ControlDiarioImpl implements IServiceControlDiario {
	
	@Autowired
	public IControlDiario controDiario;

	@Override
	public void save(ControlDiario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean saveAll(List<ControlDiario> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ControlDiario> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ControlDiario> findAll() {
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
	public void delete(ControlDiario entity) {
		// TODO Auto-generated method stub
		
	}



	
}
