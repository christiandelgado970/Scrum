package com.CMEPPS.listatareas.repository.drivenports;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Tarea;
import com.CMEPPS.listatareas.model.application.Usuario;

public interface  IUsuarioAcceso {
	
	Optional <Usuario> findByNombre(String Usuario);
    void save (Usuario user);
}
