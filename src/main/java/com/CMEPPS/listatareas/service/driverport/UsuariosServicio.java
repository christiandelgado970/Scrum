package com.CMEPPS.listatareas.service.driverport;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMEPPS.listatareas.repository.drivenports.IUsuarioAcceso;
import com.CMEPPS.listatareas.model.application.Usuario;
import com.CMEPPS.listatareas.service.driverport.IUsuariosServicio;

@Service
public class UsuariosServicio implements IUsuariosServicio{

	@Autowired
	private IUsuarioAcceso iUsuarioAcceso;
	
	@Override
	public Optional<Usuario> getUsuarioByName(String Nombre) {
		return iUsuarioAcceso.findByNombre(Nombre);
	}


	@Override
	public void addUsuario(String nombre, String contrasena) {
		iUsuarioAcceso.save(new Usuario(nombre,contrasena));
	}


	@Override
	public void saveUsuario(Usuario usuario) {
		iUsuarioAcceso.save(usuario);
		
	}

}
