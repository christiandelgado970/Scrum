
package com.CMEPPS.listatareas.service.driverport;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.CMEPPS.listatareas.model.application.DuracionTipo;
import com.CMEPPS.listatareas.model.application.EstadoTarea;
import com.CMEPPS.listatareas.model.application.Tarea;

public interface ITareaService {

    List < Tarea > getTodosByUser(String user);
    
    List < Tarea > getTodos();

    Optional < Tarea > getTodoById(long id);

    void updateTodo(Tarea tarea);

    void addTodo(String nombre, String descripcion, int prioridad ,int Intduracion, DuracionTipo tp);

    void deleteTodo(long id);

    void saveTodo(Tarea tarea);
}
