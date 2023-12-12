package com.CMEPPS.listatareas.repository.drivenports;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Tarea;

public interface ITareaRepository  {
	
	List < Tarea > findByPrioridad(int Prioridad);
	List < Tarea > findByOrdenar(String Ordenar);
    List < Tarea > findByNombre(String Nombre);
    List < Tarea > findByOrdenar(int tipo);
    List < Tarea > findAll();
    Optional<Tarea> findById(long id);
    void save (Tarea tarea);
    void delete (Tarea tarea);
    
}