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
import co.com.samtel.util.MenorHorasLaboradas;
import co.com.samtel.util.MayorHoraEntrada;
import co.com.samtel.util.MayorHorasLaboradas;

public class Test {

	public static IUserController uc = new UserController();
	public static IControlAccessoController cac = new ControlAccesoController();
	public static IControlAccesoOrdController caoc = new ControlAccesoOrdController();
	public static IControlDiarioController cdi = new ControlDiarioController();
	public static MenorHorasLaboradas menorHL = new MenorHorasLaboradas();
	public static MayorHorasLaboradas mayorHL = new MayorHorasLaboradas();
	public static MayorHoraEntrada retardos = new MayorHoraEntrada();
	public static IResumenMensualController rm = new ResumenMensualController();
    public static ListenProperties prop = new ListenProperties();
    
    
	public static void main(String[] args)  {
		
		
		
	    int mes = 4;
		int year = 2019;
		int diaI = 1;
		int diaF = 2;

		// --------------------------------------------------------------------------------------------------------

		// METODO QUE ME LEE EL ARCHIVO CSV Y ME REGISTRA LOS DATOS EN LA TABLA
		// TBLCONTROL_ACCESOS TAL COMO VIENE DESDE EL ARCHIVO

		
		
		// TRAER EL ARCHIVO CSV DE UN ORIGEN X A UN ORIGEN ESPECIFICO / DOCUMENTOS
		
		 cac.CSVReader();
		 
		// --------------------------------------------------------------------------------------------------------->

		// --------------------------------------------------------------------------------------------------------

		// METODO QUE ME ORDENA Y ME HACE EL REGISTRO ACTUALIZADO DE LOS DATOS BRUTOS
		// QUE SE ALOJARON EN LA TABLA TBLCONTROL_ACCESOS

		// caoc.register();

		// -------------------------------------------------------------------------------------------------------->

		// -------------------------------------------------------------------------------------------------------
		// METODO QUE ME PERMITE REGISTRAR EL LA TABLA CONTROL DIARIO TOMADO COMO
		// REFERENCIA A LA ALERTA 1. CONTROL DIARIO POR USUARIO.

		// cdi.alarmaControlDiario();
		// --------------------------------------------------------------------------------------------------------->

		// --------------------------------------------------------------------------------------------------------

		// METODO QUE HACE EL RESUMEN MENSUAL DE LAS ALERTAS DE ACUERDO A EL MES, AÑO,
		// DIA INICIAL Y FINAL COMO PARAMETROS DE RANGO

		// rm.resumenMenRegisterR(mes, year, diaI, diaF);

		// --------------------------------------------------------------------------------------------------------->

		// --------------------------------------------------------------------------------------------------------->
		// REPORTES
		// 1. Retartos
		// 2. menor numero de horas
		// 3. mayor numero de horas
		//
		// --------------------------------------------------------------------------------------------------------->

		// -------------------------------------------------------------------------------------------------------
		// METODO QUE ME PERMITIRA CREAR EL REPORTE CON LAS ALERTAS (MENOR CANTIDAD DE
		// HORAS LABORADAS)

		// 1. llamdo al metodo para cargar el dto con regferencia al control diario de
		// las alertas.

		//List<ControlDiarioAlertaDto> controlMenorHoras = cdi.convertEntityMenorH(mes, year, diaI, diaF);
		//List<ResumenMensual> resumenesmH = rm.ResumenEntity(2);
		//System.out.println(resumenesmH.size());
		//System.out.println(controlMenorHoras.size());

		// 2. llamado al metodo que me generara el archivo excel.

		//menorHL.reporteMenorHorasLaboradas(controlMenorHoras, resumenesmH);

		// ------------------------------------------------------------------------------------------------------------->

		// -------------------------------------------------------------------------------------------------------
		// METODO QUE ME PERMITIRA CRAER EL REPORTE CON LAS ALERTAS (MAYOR CANTIDAD DE
		// HORAS LABORADAS)

		// 1. llamdo al metodo para cargar el dto con regferencia al control diario de
		// las alertas.

		//List<ControlDiarioAlertaDto> controlMayorHoras = cdi.convertEntityMayorH(mes, year, diaI, diaF);
		//List<ResumenMensual> resumenesMh = rm.ResumenEntity(3);
		//System.out.println(resumenesMh.size());
		//System.out.println(controlMayorHoras.size());

		// 2. llamado al metodo que me generara el archivo excel.

		//mayorHL.reporteMayorHorasLaboradas(controlMayorHoras, resumenesMh);

		// ------------------------------------------------------------------------------------------------------------->

		// -------------------------------------------------------------------------------------------------------
		// METODO QUE ME PERMITIRA CRAER EL REPORTE CON LAS ALERTAS (CANTIDAD DE
		// USUARIOS QUE LLEGAN TARDE AL TRABAJO)

		// 1. llamdo al metodo para cargar el dto con regferencia al control diario de
		// las alertas por llegada tarde.

		// 1. Retartos 2. mayor numero de horas 3. menor numero de horas

		// List<ControlDiarioAlertaDto> controlRetardos = cdi.convertEntityHoraLlegada(mes, year, diaI, diaF);
		// List<ResumenMensual> resumenesR = rm.ResumenEntity(1);
		// System.out.println(resumenesR.size());
		// System.out.println(controlRetardos.size());

		// 2. llamado al metodo que me generara el archivo excel.
		// retardos.reporteHoraEntrada(controlRetardos, resumenesR);

		// ------------------------------------------------------------------------------------------------------------->

	}

}
