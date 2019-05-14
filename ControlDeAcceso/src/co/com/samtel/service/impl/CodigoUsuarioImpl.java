package co.com.samtel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.samtel.entities.CodigoUsuario;
import co.com.samtel.repository.ICodigoUsuario;
import co.com.samtel.service.IServiceCodigoUsuario;

@Service("codigoUsuarioBean")
public class CodigoUsuarioImpl implements IServiceCodigoUsuario {
	
	@Autowired
	public ICodigoUsuario codigoUs;

	@Override
	public void save(CodigoUsuario entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CodigoUsuario> findAll() {
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
	public void delete(CodigoUsuario entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Boolean saveAll(List<CodigoUsuario> list) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<CodigoUsuario> findById(Integer id) {
		// TODO Auto-generated method stub
		return codigoUs.findById(id);
	}


	@Override
	public CodigoUsuario findByCode(Integer codigo) {
		// TODO Auto-generated method stub
		return codigoUs.findByCode(codigo);
	}

}
