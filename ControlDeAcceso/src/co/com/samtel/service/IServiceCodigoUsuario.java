package co.com.samtel.service;

import org.springframework.data.repository.query.Param;

import co.com.samtel.entities.CodigoUsuario;

public interface IServiceCodigoUsuario extends IServiceRepo<CodigoUsuario, Integer> {

	CodigoUsuario findByCode(Integer codigo);
	void insertCodigo( Integer codigo);
}
