package co.com.samtel.controller;

import java.util.List;

import co.com.samtel.service.IServiceCodigoUsuario;
import co.com.samtel.service.IServiceControlAcceso;
import co.com.samtel.service.IServiceControlAccesoOrd;

public interface IControlAccesoOrdController {

	
	IServiceControlAccesoOrd getControlAccesoOrdService();
	IServiceControlAcceso getControlAccesoService();
	IServiceCodigoUsuario getCodigoUsuarioService();
	void register();
}
