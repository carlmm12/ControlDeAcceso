package co.com.samtel.controller.impl;

import co.com.samtel.controller.ICodigoUsuarioController;
import co.com.samtel.service.IServiceCodigoUsuario;
import co.com.samtel.util.BeanUtil;

public class CodigoUsuarioController implements ICodigoUsuarioController {

	private IServiceCodigoUsuario codUsService;
	
	@Override
	public IServiceCodigoUsuario getCodUsuarioService() {
		if (codUsService == null ) {
			
			codUsService = (IServiceCodigoUsuario) BeanUtil.getBeanName("CodigoUsuarioBean");
		}
		
		return codUsService;
	}

}
