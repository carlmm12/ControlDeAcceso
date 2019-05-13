package co.com.samtel.controller;

import co.com.samtel.service.IServiceControlAcceso;
import co.com.samtel.service.IServiceControlAccesoOrd;

public interface IControlAccesoOrdController {

	
	IServiceControlAccesoOrd getControlAccesoOrdService();
	IServiceControlAcceso getControlAccesoService();
	void register(int month);
}
