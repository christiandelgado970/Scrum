package com.CMEPPS.listatareas.service.driverport;

import java.util.List;
import java.util.Optional;

import com.CMEPPS.listatareas.model.application.Usuario;

public interface IUsuariosServicio {
	
	
    Optional <Usuario> getUsuarioById(long id);
    List <Usuario> getUsuarioByName(String Nombre);

    
    void updateUsuario(Usuario tarea);

    void addUsuario(String nombre , String contrasena);

    void deleteUsuario(long id);

    void saveUsuario(Usuario tarea);
}
