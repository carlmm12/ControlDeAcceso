package co.com.samtel.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.samtel.controller.IControlAccessoController;
import co.com.samtel.controller.IUserController;
import co.com.samtel.controller.impl.ControlAccesoController;
import co.com.samtel.controller.impl.UserController;
import co.com.samtel.entities.Usuario;
import co.com.samtel.repository.impl.IServiceUsuario;
import co.com.samtel.util.BeanUtil;

public class Test {


	public static IUserController uc = new UserController();
	public static IControlAccessoController cac = new ControlAccesoController();
	
	public static void main(String[] args) {
	
//			for (Usuario usuario : uc.usuarios()) {
//				System.out.println(usuario.toString());
//		
//			}
			
			cac.CSVReader();
			
//			Usuario usser = userService.findById(1);
//			System.out.println(usser.toString());
	}

}
