package co.com.samtel.controller.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import co.com.samtel.controller.IUserController;
import co.com.samtel.entities.Usuario;
import co.com.samtel.service.IServiceUsuario;
import co.com.samtel.util.BeanUtil;

@Controller
public class UserController implements IUserController {
   
	private IServiceUsuario userService;


	public UserController() {
		
	}
     
	/*
	 * Este metodo me permite generar usar el servicio de Usuario.
	 */
   @Override
	public IServiceUsuario getUserService() {
		if(userService == null ) {
			userService = (IServiceUsuario) BeanUtil.getBeanName("UsuarioBean");
		}
		return userService;
	}
    
	/*
	 * Metodo para obtener todos los usuarios
	 */
   @Override
	public List<Usuario> usuarios(){
		
		return getUserService().findAll();
		
	}

	
	
	
	
	
}
