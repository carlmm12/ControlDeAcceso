package co.com.samtel.service;

import java.util.List;

public interface IServiceRepo<T,PK> {
	
	
	
	void save(T entity);
	Boolean saveAll(List<T> list);
	T findById(Integer id);
	boolean existsById(PK id);
	List<T> findAll();
	long count();
	public void deleteById(PK id); 
	void delete(T entity);
	
}
