package co.com.samtel.main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
//			for (Usuario usuario : uc.usuarios()) {
//				System.out.println(usuario.toString());
//		
//			}
			
			//cac.CSVReader();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = formatter.parse("2019-04-01 18:57:42");
			System.out.println(new Timestamp(date.getTime()));
			
			caoc.register(4);
			
//			Usuario usser = userService.findById(1);
//			System.out.println(usser.toString());
			
			
	}

}
