package co.com.samtel.service;

import java.util.List;

public interface IServiceRepo<T> {
	
	
	
	void save(T entity);
	Boolean saveAll(List<T> list);
	T findById(Integer id);
	boolean existsById(Integer id);
	List<T> findAll();
	long count();
	public void deleteById(Integer id); 
	void delete(T entity);
	
}
