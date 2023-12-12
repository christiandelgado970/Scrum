package com.CMEPPS.listatareas.repository.drivenadapters;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Tarea;

public interface IJPATareaRepository extends JpaRepository < Tarea, Long > {
    List < Tarea > findByNombre(String Nombre);
    List < Tarea > findByPrioridad(int Prioridad);
    List < Tarea > findAllByOrderByTipoduracionDesc();
    List < Tarea > findAllByOrderByPrioridadDesc();
    
}


