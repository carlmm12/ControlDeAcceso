package co.com.samtel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.samtel.entities.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

	
	@Query("select u from Usuario u  where u.idUsuarios = ?1")
	Usuario findAllByID(Integer id);
}
