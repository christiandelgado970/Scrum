package com.CMEPPS.listatareas.controller.driveradapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CMEPPS.listatareas.model.application.Usuario;
import com.CMEPPS.listatareas.service.driverport.IUsuariosServicio;

@Controller
public class WelcomeController {

	@Autowired
    private IUsuariosServicio usuarioService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio(ModelMap model) {
		return "conexion";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(@RequestParam("username") String username ,ModelMap model) {
		
		Usuario user = usuarioService.getUsuarioByName(username).get();
		
		model.put("user", user);
		return "welcome";
	}

}
