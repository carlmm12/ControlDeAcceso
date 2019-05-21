package co.com.samtel.controller.impl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.samtel.controller.IControlDiarioController;
import co.com.samtel.dto.ControlDiarioAlertaDto;
import co.com.samtel.dto.ControlDiarioDto;
import co.com.samtel.entities.CodigoUsuario;
import co.com.samtel.entities.ControlDiario;
import co.com.samtel.entities.Usuario;
import co.com.samtel.service.IServiceCodigoUsuario;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.service.IServiceControlDiario;
import co.com.samtel.util.BeanUtil;
import co.com.samtel.util.convertDate;

public class ControlDiarioController implements IControlDiarioController {

	private IServiceControlDiario conAccDiarService;
	private IServiceControlAccesoOrd conAccOrdService;
	private IServiceCodigoUsuario codUserService;

	@Override
	public IServiceControlDiario getControlDiarioService() {
		if (conAccDiarService == null) {
			conAccDiarService = (IServiceControlDiario) BeanUtil.getBeanName("ControlDiarioBean");
		}
		return conAccDiarService;
	}

	/*
	 * Este metodo me permite generar usar el servicio de codigoUsuario.
	 */

	@Override
	public IServiceCodigoUsuario getCodigoUsuarioService() {
		if (codUserService == null) {
			codUserService = (IServiceCodigoUsuario) BeanUtil.getBeanName("codigoUsuarioBean");
		}
		return codUserService;
	}

	/*
	 * Este metodo me permite generar usar el servicio de controlAccesoOrd.
	 */

	@Override
	public IServiceControlAccesoOrd getControlAccesoOrdService() {
		if (conAccOrdService == null) {
			conAccOrdService = (IServiceControlAccesoOrd) BeanUtil.getBeanName("ControlAccesoOrdBean");
		}
		return conAccOrdService;
	}
	
	

//	@Override
//	public Date convertToDate(String date) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date converDate;
//		try {
//			converDate = formatter.parse(date);
//			return converDate;
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	

	/*
	 * Este metodo es la alarma de horas que se realiza por día se tomada por dia
	 * cantidad de horas laboradas, fecha de inicio, fecha final de sus horas de
	 * trabajo.
	 */
	@Override
	public void alarmaControlDiario() {

		// lamado a todas las fechas registradas en la tabla controlAccessoOrd
		List<String> fechas = getControlAccesoOrdService().countDate();

		// llamado a todos los codigos de usuario de acuerdo a la fecha estipulada

		for (String fechasDia : fechas) {
			System.out.println("fecha: " + fechasDia);
			List<Integer> codUsers = getControlAccesoOrdService().usersDate(fechasDia);
			for (Integer codUser : codUsers) {

				// carga del codigo de usuario de acuerdo al codigo
				CodigoUsuario codigoUser = getCodigoUsuarioService().findByCodigo(codUser);

				// cargo el DTO que me permite traer el conteo de horas trabajadas y la fecha de
				// entrada y salida de acuerdo a una fecha y un codigo de usuario
				ControlDiarioDto controlDto = getControlAccesoOrdService().controlDia(fechasDia, codUser);

				// asignación de valores a el control de dia lista para registrar
				ControlDiario controlDia = new ControlDiario(getControlDiarioService().countC() + 1,
						codigoUser.getCodigo(), controlDto.getEntrada(), convertDate.convertToDate(fechasDia),
						codigoUser.getTblusuario().getNombre(), controlDto.getSalida(), controlDto.getTiempo());
				System.out.println(controlDia.toString());

				// metodo que me permitira registrar el control diario de cada usuario por fecha
				// especifica
				getControlDiarioService().save(controlDia);
			}
		}

	}

	@Override
	public List<ControlDiarioAlertaDto> convertEntityMenorH() {

		List<ControlDiarioAlertaDto> controlAlertas = new ArrayList<ControlDiarioAlertaDto>();

		try {

			SimpleDateFormat format = new SimpleDateFormat("hh:mm"); // if 24 hour format
			Date d1;
			Time ppstime;

			d1 = (java.util.Date) format.parse("09:00:00");

			ppstime = new java.sql.Time(d1.getTime());

			// System.out.println(d1);
			// System.out.println(ppstime);

			List<ControlDiario> controlD = getControlDiarioService().findAll();
			String alerta = "";
			ControlDiarioAlertaDto controlDA = null;
			for (ControlDiario controlDiario : controlD) {
				if (controlDiario.getTiempo().getHours() < 9 ) {
					alerta = "EL USUARIO NO CUMPLE CON LAS 9 HORAS ESTABLECIDAS";
					// System.out.println("EL usuario :" + controlDiario.getNombre() + " no cumplio
					// las 9 horas correspondietes");
					controlDA = new ControlDiarioAlertaDto(controlDiario.getFecha().toString(),
							String.valueOf(controlDiario.getCodigoUsuario()), controlDiario.getNombre(),
							controlDiario.getEntrada().toString(), controlDiario.getSalida().toString(),
							controlDiario.getTiempo().toString(), alerta);
					controlAlertas.add(controlDA);

				} else {
					alerta = "";
				}

				// System.out.println(controlDA.toString());
				
			}

			return controlAlertas;

		} catch (Exception e) {

			System.out.println(e);

		}

		return controlAlertas;
	}

	@Override
	public List<ControlDiarioAlertaDto> convertEntityMayorH() {
		List<ControlDiarioAlertaDto> controlAlertas = new ArrayList<ControlDiarioAlertaDto>();
		List<ControlDiario> controlD = getControlDiarioService().findAll();
		String alerta = "";
		
		ControlDiarioAlertaDto controlDA = null;
		for (ControlDiario controlDiario : controlD) {
			if (controlDiario.getTiempo().getHours() >= 9) {
				alerta = "EL USUARIO COLABORO CON MAS DE LAS 9 HORAS ESTABLECIDAS ";
				// System.out.println("EL usuario :" + controlDiario.getNombre() + " no cumplio
				// las 9 horas correspondietes");
				controlDA = new ControlDiarioAlertaDto(controlDiario.getFecha().toString(),
						String.valueOf(controlDiario.getCodigoUsuario()), controlDiario.getNombre(),
						controlDiario.getEntrada().toString(), controlDiario.getSalida().toString(),
						controlDiario.getTiempo().toString(), alerta);
				
				controlAlertas.add(controlDA);
			}

			
		}

		return controlAlertas;
	}

	@Override
	public List<ControlDiarioAlertaDto> convertEntityHoraLlegada() {
		
		List<ControlDiarioAlertaDto> controlAlertas = new ArrayList<ControlDiarioAlertaDto>();
		List<ControlDiario> controlD = getControlDiarioService().findAll();
		String alerta = "";
		
		ControlDiarioAlertaDto controlDA = null;
		for (ControlDiario controlDiario : controlD) {
			if (controlDiario.getEntrada().getHours() >= 8  && controlDiario.getEntrada().getMinutes() > 15) {
				alerta = "LA HORA DE ENTRADA ES MAYOR A LAS  8:00 AM ";
				// System.out.println("EL usuario :" + controlDiario.getNombre() + " no cumplio
				// las 9 horas correspondietes");
				controlDA = new ControlDiarioAlertaDto(controlDiario.getFecha().toString(),
						String.valueOf(controlDiario.getCodigoUsuario()), controlDiario.getNombre(),
						controlDiario.getEntrada().toString(), controlDiario.getSalida().toString(),
						controlDiario.getTiempo().toString(), alerta);
				
				controlAlertas.add(controlDA);
			}

			
		}

		return controlAlertas;
	}
	
	
	
	
	
	

} // fin de la clase
