package co.com.samtel.controller;

import java.util.List;

import co.com.samtel.entities.Usuario;
import co.com.samtel.repository.impl.IServiceUsuario;

public interface IUserController {

IServiceUsuario getUserService();
List<Usuario> usuarios();


}
