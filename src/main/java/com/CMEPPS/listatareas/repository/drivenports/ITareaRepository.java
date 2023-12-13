package com.CMEPPS.listatareas.repository.drivenports;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Tarea;

public interface ITareaRepository  {
	
	List < Tarea > findByPrioridad(int Prioridad);
    List < Tarea > findByNombre(String Nombre);
    List < Tarea > findByOrdenar(int tipo);
    
    List < Tarea > findByPrioridadAndUser(int Prioridad,String User);
    List < Tarea > findByOrdenarAndUser(int tipo,String User);
    List < Tarea > findAllByUser(String User);
    
    List < Tarea > findAll();
    Optional<Tarea> findById(long id);
    void save (Tarea tarea);
    void delete (Tarea tarea);
    
}