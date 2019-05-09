package co.com.samtel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.samtel.entities.Usuario;



@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

	
	@Query("select u from Usuario u  where u.id = :id")
	Usuario findAllByID(@Param("id")int id);
}
