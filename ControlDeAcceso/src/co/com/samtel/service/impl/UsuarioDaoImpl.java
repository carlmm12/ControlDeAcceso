package co.com.samtel.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.samtel.entities.Usuario;

import co.com.samtel.repository.IUsuarioDao;
import co.com.samtel.service.IServiceUsuario;

@Service("UsuarioBean")
public class UsuarioDaoImpl implements IServiceUsuario {



	@Autowired
	public IUsuarioDao iUS;
	
	
	public UsuarioDaoImpl() {

	}

	public void save(Usuario entity) {
        try {
			iUS.save(entity);
		} catch (Exception e) {
			System.out.println(e);
		}
           
	
	}

	public Boolean saveAll(List<Usuario> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return iUS.findAllByID(id);
	}

	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return iUS.findAll();
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	public void delete(Usuario entity) {
		// TODO Auto-generated method stub

	}

}
