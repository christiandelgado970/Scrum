package com.CMEPPS.listatareas.repository.drivenports;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Tarea;

public interface ITareaRepository  {
	
    List < Tarea > findByNombre(String Nombre);
    List < Tarea > findAll();
    Optional<Tarea> findById(long id);
    void save (Tarea tarea);
    void delete (Tarea tarea);
    
}