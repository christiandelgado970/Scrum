package com.CMEPPS.listatareas.controller.driveradapters;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CMEPPS.listatareas.model.application.Usuario;
import com.CMEPPS.listatareas.service.driverport.IUsuariosServicio;

@Controller
public class ConexionController {
	
	@Autowired
    private IUsuariosServicio usuarioService;
	
	@RequestMapping(value = "/conexion", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,ModelMap model) {
		//Crear admin admin si no esta creado
		Optional<Usuario> admin = usuarioService.getUsuarioByName("admin");
		 if(admin.isEmpty()) {
			 Usuario administrador = new Usuario("admin","admin");
			 administrador.setAdmin(true);
		    	System.out.println(administrador.isAdmin());
			 usuarioService.saveUsuario(administrador);
		 }
		 //Comprobar si el usuario esta registrado
		 Optional<Usuario> user = usuarioService.getUsuarioByName(username);
		 if(user.isEmpty()) {
			 return "conexion";
		 }
		 Usuario usuario =  user.get();
		 if(!usuario.getContrasena().equals(password)) {
			 return "conexion";
		 }
		 
		 usuario = new Usuario(username,password);
		 model.put("user", usuario);
		 return "welcome";
	}
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String register(Model model) {	
		return "registro";
	}
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,ModelMap model) {	
		 Optional<Usuario> user = usuarioService.getUsuarioByName(username);
		 if(user.isPresent()) {
			 return "/registro";
		 }
		 Usuario usuario = new Usuario(username,password);
		 usuarioService.saveUsuario(usuario);
		 model.put("user", usuario);
		 return "welcome";
	}
	
}