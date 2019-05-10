package co.com.samtel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.samtel.entities.CodigoUsuario;

public interface ICodigoUsuario extends JpaRepository<CodigoUsuario, Integer> {

}
