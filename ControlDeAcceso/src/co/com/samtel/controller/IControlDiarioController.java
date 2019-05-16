package co.com.samtel.controller;


import java.text.ParseException;
import java.util.Date;

import co.com.samtel.service.IServiceCodigoUsuario;
import co.com.samtel.service.IServiceControlAcceso;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.service.IServiceControlDiario;

public interface IControlDiarioController {

	
	IServiceControlDiario getControlDiarioService();
	IServiceControlAccesoOrd getControlAccesoOrdService();
	IServiceCodigoUsuario getCodigoUsuarioService();
	void alarmaControlDiario();
	Date convertToDate(String date ) ;
}
