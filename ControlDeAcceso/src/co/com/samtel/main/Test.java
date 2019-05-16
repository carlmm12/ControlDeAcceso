package co.com.samtel.main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.samtel.controller.IControlAccesoOrdController;
import co.com.samtel.controller.IControlAccessoController;
import co.com.samtel.controller.IControlDiarioController;
import co.com.samtel.controller.IUserController;
import co.com.samtel.controller.impl.ControlAccesoController;
import co.com.samtel.controller.impl.ControlAccesoOrdController;
import co.com.samtel.controller.impl.ControlDiarioController;
import co.com.samtel.controller.impl.UserController;
import co.com.samtel.entities.Usuario;
import co.com.samtel.repository.IControlDiario;
import co.com.samtel.service.IServiceUsuario;
import co.com.samtel.util.AlarmaControlDiarios;
import co.com.samtel.util.BeanUtil;

public class Test {

	public static IUserController uc = new UserController();
	public static IControlAccessoController cac = new ControlAccesoController();
	public static IControlAccesoOrdController caoc = new ControlAccesoOrdController();
	public static IControlDiarioController cdi = new ControlDiarioController();
	public static AlarmaControlDiarios alertaCD = new AlarmaControlDiarios();

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse("2019-04-01 18:57:42");
		System.out.println(new Timestamp(date.getTime()));

		// METODO QUE ME LEE EL ARCHIVO CSV Y ME REGISTRA LOS DATOS EN LA TABLA
		// TBLCONTROL_ACCESOS TAL COMO VIENE DESDE EL ARCHIVO

		// cac.CSVReader();

		// METODO QUE ME ORDENA Y ME HACE EL REGISTRO ACTUALIZADO DE LOS DATOS BRUTOS
		// QUE SE ALOJARON EN LA TABLA TBLCONTROL_ACCESOS

		// caoc.register();

		// METODO QUE ME PERMITE REGISTRAR EL LA TABLA CONTROL DIARIO TOMADO COMO
		// REFERENCIA A LA ALERTA 1. CONTROL DIARIO POR USUARIO.

		// cdi.alarmaControlDiario();

		// METODO QUE ME PERMITIRA CRAER EL REPORTE CON LAS ALERTAS (ALERTA CONTROL
		// DIARIO)
		
		alertaCD.reporteAlarma();

	}

}
