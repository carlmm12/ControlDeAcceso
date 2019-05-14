package co.com.samtel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.samtel.entities.CodigoUsuario;

public interface ICodigoUsuario extends JpaRepository<CodigoUsuario, Integer> {
	
	@Query (value="SELECT * FROM tblcodigo_usuarios WHERE codigo = :codigo", nativeQuery=true)
	CodigoUsuario findByCode(@Param("codigo") Integer codigo);
	
	
	

}
