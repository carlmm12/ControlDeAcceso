package co.com.samtel.service;

import co.com.samtel.entities.CodigoUsuario;

public interface IServiceCodigoUsuario extends IServiceRepo<CodigoUsuario, Integer> {

	CodigoUsuario findByCode(Integer codigo);
	void insertCodigo( Integer codigo);
	CodigoUsuario findByCodigo(Integer codigo);
}
	