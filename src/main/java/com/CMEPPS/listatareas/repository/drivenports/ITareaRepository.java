package com.CMEPPS.listatareas.repository.drivenports;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.application.Tarea;

public interface ITareaRepository extends JpaRepository < Tarea, Long > {
    List < Tarea > findByNombre(String Nombre);
}