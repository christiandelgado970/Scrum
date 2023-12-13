package com.CMEPPS.listatareas.repository.drivenadapters;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Usuario;

public interface IJPAUsuarioRepository extends JpaRepository < Usuario, Long > {
	Optional < Usuario > findByNombre(String Nombre);
    
}


