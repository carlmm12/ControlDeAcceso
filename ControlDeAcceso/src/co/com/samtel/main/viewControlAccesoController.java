package co.com.samtel.main;

import java.util.List;

import co.com.samtel.controller.IControlAccesoOrdController;
import co.com.samtel.controller.IControlAccessoController;
import co.com.samtel.controller.IControlDiarioController;
import co.com.samtel.controller.IResumenMensualController;
import co.com.samtel.controller.IUserController;
import co.com.samtel.controller.impl.ControlAccesoController;
import co.com.samtel.controller.impl.ControlAccesoOrdController;
import co.com.samtel.controller.impl.ControlDiarioController;
import co.com.samtel.controller.impl.ResumenMensualController;
import co.com.samtel.controller.impl.UserController;
import co.com.samtel.dto.ControlDiarioAlertaDto;
import co.com.samtel.entities.ResumenMensual;
import co.com.samtel.properties.ListenProperties;
import co.com.samtel.util.MayorHoraEntrada;
import co.com.samtel.util.MayorHorasLaboradas;
import co.com.samtel.util.MenorHorasLaboradas;

public class viewControlAccesoController {
	public static IUserController uc = new UserController();
	public static IControlAccessoController cac = new ControlAccesoController();
	public static IControlAccesoOrdController caoc = new ControlAccesoOrdController();
	public static IControlDiarioController cdi = new ControlDiarioController();
	public static MenorHorasLaboradas menorHL = new MenorHorasLaboradas();
	public static MayorHorasLaboradas mayorHL = new MayorHorasLaboradas();
	public static MayorHoraEntrada retardos = new MayorHoraEntrada();
	public static IResumenMensualController rm = new ResumenMensualController();
	public static ListenProperties prop = new ListenProperties();

	public Boolean cargarData(String name_file) {
		// --------------------------------------------------------------------------------------------------------

		// METODO QUE ME LEE EL ARCHIVO CSV Y ME REGISTRA LOS DATOS EN LA TABLA
		// TBLCONTROL_ACCESOS TAL COMO VIENE DESDE EL ARCHIVO

		// TRAER EL ARCHIVO CSV DE UN ORIGEN X A UN ORIGEN ESPECIFICO / DOCUMENTOS

		Boolean val = cac.CSVReader(name_file);
		if (val == true) {
			System.out.println("el archivo se cargo correctamente");
			// --------------------------------------------------------------------------------------------------------->

			// --------------------------------------------------------------------------------------------------------

			// METODO QUE ME ORDENA Y ME HACE EL REGISTRO ACTUALIZADO DE LOS DATOS BRUTOS
			// QUE SE ALOJARON EN LA TABLA TBLCONTROL_ACCESOS

			caoc.register();

			// -------------------------------------------------------------------------------------------------------->

			// -------------------------------------------------------------------------------------------------------
			// METODO QUE ME PERMITE REGISTRAR EL LA TABLA CONTROL DIARIO TOMADO COMO
			// REFERENCIA A LA ALERTA 1. CONTROL DIARIO POR USUARIO.

			cdi.alarmaControlDiario();
			// --------------------------------------------------------------------------------------------------------->
			return true;
		} else {
			System.out.println("el archivo no puede ser registrado verifique que es el correcto");
		}

		return false;
	}

	public List<Integer> findbyRequer(int year, int mes, int opcion) {

		List<Integer> data = null;

		switch (opcion) {
		case 1:
			data = caoc.getControlAccesoOrdService().findYear();
			break;
		case 2:
			data = caoc.getControlAccesoOrdService().findMes(year);

			break;
		case 3:
			data = caoc.getControlAccesoOrdService().findDay(year, mes);
			break;
		}

		return data;
	}

	public static void createResumen(int mes, int year, int diaI, int diaF) {
		// METODO QUE HACE EL RESUMEN MENSUAL DE LAS ALERTAS DE ACUERDO A EL MES, A�O,
		// DIA INICIAL Y FINAL COMO PARAMETROS DE RANGO

		rm.resumenMenRegisterR(mes, year, diaI, diaF);

		// --------------------------------------------------------------------------------------------------------->

		// --------------------------------------------------------------------------------------------------------->
		// REPORTES
		// 1. Retartos
		// 2. menor numero de horas
		// 3. mayor numero de horas
		//
		// --------------------------------------------------------------------------------------------------------->
	}

	public void AlertaMenorHorasLaboradas(int mes, int year, int diaI, int diaF) {

		createResumen(mes, year, diaI, diaF);

		// -------------------------------------------------------------------------------------------------------
		// METODO QUE ME PERMITIRA CREAR EL REPORTE CON LAS ALERTAS (MENOR CANTIDAD DE
		// HORAS LABORADAS)

		// 1. llamdo al metodo para cargar el dto con regferencia al control diario de
		// las alertas.

		List<ControlDiarioAlertaDto> controlMenorHoras = cdi.convertEntityMenorH(mes, year, diaI, diaF);
		List<ResumenMensual> resumenesmH = rm.ResumenEntity(2);
		System.out.println(resumenesmH.size());
		System.out.println(controlMenorHoras.size());

		// 2. llamado al metodo que me generara el archivo excel.

		menorHL.reporteMenorHorasLaboradas(controlMenorHoras, resumenesmH);

		// ------------------------------------------------------------------------------------------------------------->
	}

	public void AlertaMayorHorasLaboradas(int mes, int year, int diaI, int diaF) {
		
		
		System.out.println("los valores son:" + " a�o: " + year + " mes: " + mes + " dia inicial: " + diaI
				+ " dia final " + diaF);

		createResumen(mes, year, diaI, diaF);

		// -------------------------------------------------------------------------------------------------------
		// METODO QUE ME PERMITIRA CRAER EL REPORTE CON LAS ALERTAS (MAYOR CANTIDAD DE
		// HORAS LABORADAS)

		// 1. llamdo al metodo para cargar el dto con regferencia al control diario de
		// las alertas.

		List<ControlDiarioAlertaDto> controlMayorHoras = cdi.convertEntityMayorH(mes, year, diaI, diaF);
		List<ResumenMensual> resumenesMh = rm.ResumenEntity(3);
		System.out.println(resumenesMh.size());
		System.out.println(controlMayorHoras.size());

		// 2. llamado al metodo que me generara el archivo excel.

		mayorHL.reporteMayorHorasLaboradas(controlMayorHoras, resumenesMh);

		// ------------------------------------------------------------------------------------------------------------->

	}

	public void AlertaRetardos(int mes, int year, int diaI, int diaF) {

		createResumen(mes, year, diaI, diaF);

		// -------------------------------------------------------------------------------------------------------
		// METODO QUE ME PERMITIRA CRAER EL REPORTE CON LAS ALERTAS (CANTIDAD DE
		// USUARIOS QUE LLEGAN TARDE AL TRABAJO)

		// 1. llamdo al metodo para cargar el dto con regferencia al control diario de
		// las alertas por llegada tarde.

		// 1. Retartos 2. mayor numero de horas 3. menor numero de horas

		List<ControlDiarioAlertaDto> controlRetardos = cdi.convertEntityHoraLlegada(mes, year, diaI, diaF);
		List<ResumenMensual> resumenesR = rm.ResumenEntity(1);
		System.out.println(resumenesR.size());
		System.out.println(controlRetardos.size());

		// 2. llamado al metodo que me generara el archivo excel.
		retardos.reporteHoraEntrada(controlRetardos, resumenesR);

		// ------------------------------------------------------------------------------------------------------------->

	}

}
