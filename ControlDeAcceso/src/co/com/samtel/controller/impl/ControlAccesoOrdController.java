package co.com.samtel.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.samtel.controller.IControlAccesoOrdController;
import co.com.samtel.entities.ControlAcceso;
import co.com.samtel.service.IServiceControlAcceso;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.util.BeanUtil;

public class ControlAccesoOrdController implements IControlAccesoOrdController {

	private IServiceControlAccesoOrd conAccOrdService;
	private IServiceControlAcceso conAccService;
	private List<ControlAcceso> accesos;

	@Override
	public IServiceControlAccesoOrd getControlAccesoOrdService() {
		if (conAccOrdService == null) {
			conAccOrdService = (IServiceControlAccesoOrd) BeanUtil.getBeanName("ControlAccesoBean");
		}
		return null;
	}

	/*
	 * Este metodo me permite generar usar el servicio de controlAcceso.
	 */
	@Override
	public IServiceControlAcceso getControlAccesoService() {
		if (conAccService == null) {
			conAccService = (IServiceControlAcceso) BeanUtil.getBeanName("ControlAccesoBean");
		}

		return conAccService;
	}

	@Override
	public void register(int month) {
         
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		
		if (accesos == null) {
			accesos = getControlAccesoService().findByMonth(month);
		}

		for (ControlAcceso controlAcceso : accesos) {
			// error al capturar la fecha
			 System.out.println("---------------------------------------------------------------------------------");
			System.out.println("conteo del usuario" + controlAcceso.getName() + "en la fecha " + controlAcceso.getId().getDatetime() );
			int numRegistros = getControlAccesoService().countByDay(controlAcceso.getId().getEnno(), controlAcceso.getId().getDatetime());
			System.out.println(numRegistros);
			// System.out.println("usuario: " + controlAcceso.getId().getEnno() + "fecha: " + controlAcceso.getId().getDatetime());
		}

	}

}
