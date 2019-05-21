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
	
    List<ControlDiarioAlertaDto> convertEntityMenorH();
    List<ControlDiarioAlertaDto> convertEntityMayorH();
    List<ControlDiarioAlertaDto> convertEntityHoraLlegada();
}
