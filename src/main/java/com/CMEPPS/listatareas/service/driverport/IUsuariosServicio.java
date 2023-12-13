package com.CMEPPS.listatareas.service.driverport;

import java.util.List;
import java.util.Optional;

import com.CMEPPS.listatareas.model.application.Usuario;

public interface IUsuariosServicio {
	

    Optional  <Usuario> getUsuarioByName(String Nombre);

    void addUsuario(String nombre , String contrasena);
    void saveUsuario(Usuario usuario);
}
