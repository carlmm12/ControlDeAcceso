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
import co.com.samtel.controller.IUserController;
import co.com.samtel.controller.impl.ControlAccesoController;
import co.com.samtel.controller.impl.ControlAccesoOrdController;
import co.com.samtel.controller.impl.UserController;
import co.com.samtel.entities.Usuario;
import co.com.samtel.service.IServiceUsuario;
import co.com.samtel.util.BeanUtil;

public class Test {

	public static IUserController uc = new UserController();
	public static IControlAccessoController cac = new ControlAccesoController();
	public static IControlAccesoOrdController caoc = new ControlAccesoOrdController();

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse("2019-04-01 18:57:42");
		System.out.println(new Timestamp(date.getTime()));

		/*
		 * llamdo al metodo que me registra en la tabla de controlAccesos los registros
		 * CSV
		 */

		// cac.CSVReader();
            
		
		/*
		 * llamado al metodo que me trae el rango de fechas por lo cual se registro en el
		 * control de horas
		 */
		caoc.register(4);
		
		

	}

}
