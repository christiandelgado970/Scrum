
package com.CMEPPS.listatareas.service.driverport;

import java.util.List;
import java.util.Optional;

import com.CMEPPS.listatareas.model.application.DuracionTipo;
import com.CMEPPS.listatareas.model.application.Tarea;

public interface ITareaService {

    List < Tarea > getTodoByName(String name);
    
    List < Tarea > getTodosByUser(String user);
    
    List < Tarea > getTodos();
    
    List < Tarea > getTodosFiltro(int prioridad);
    
    List < Tarea > getTodosOrdenar(int tipo);
    
    List < Tarea > getTodosFiltro(int prioridad,String user);
    
    List < Tarea > getTodosOrdenar(int tipo,String user);

    Optional < Tarea > getTodoById(long id);

    void updateTodo(Tarea tarea);

    void addTodo(String nombre, String descripcion, int prioridad ,int Intduracion, DuracionTipo tp, String usuario);

    void deleteTodo(long id);

    void saveTodo(Tarea tarea);
}
