package com.CMEPPS.listatareas.repository.drivenports;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Usuario;

public interface  IUsuarioAcceso extends JpaRepository < Usuario , Long > {
	
	//Para registrar un usuario
	List <Usuario> findByNombre(String Usuario);
}
