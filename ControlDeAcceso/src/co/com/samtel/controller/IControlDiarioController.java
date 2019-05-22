package co.com.samtel.controller;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import co.com.samtel.dto.ControlDiarioAlertaDto;
import co.com.samtel.service.IServiceCodigoUsuario;
import co.com.samtel.service.IServiceControlAcceso;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.service.IServiceControlDiario;

public interface IControlDiarioController {

	
	IServiceControlDiario getControlDiarioService();
	IServiceControlAccesoOrd getControlAccesoOrdService();
	IServiceCodigoUsuario getCodigoUsuarioService();
	void alarmaControlDiario();
	
    List<ControlDiarioAlertaDto> convertEntityMenorH(int mes, int year, int diaI,  int diaF);
    List<ControlDiarioAlertaDto> convertEntityMayorH(int mes, int year, int diaI,  int diaF);
    List<ControlDiarioAlertaDto> convertEntityHoraLlegada(int mes, int year, int diaI,  int diaF);
}
