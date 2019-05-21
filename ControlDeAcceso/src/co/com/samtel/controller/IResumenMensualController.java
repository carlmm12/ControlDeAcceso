package co.com.samtel.controller;

import co.com.samtel.service.IServiceCodigoUsuario;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.service.IServiceResumenMensual;

public interface IResumenMensualController {
	
	IServiceResumenMensual getResumenMensualServices();	
	IServiceControlAccesoOrd getControlAccesoOrdService();
	IServiceCodigoUsuario getCodigoUsuarioService();
	void resumenMenRegisterR(int mes,int year , int diaI , int diaF);
	void resumenMenRegisterR1(int diaI , int diaF);
	

}
