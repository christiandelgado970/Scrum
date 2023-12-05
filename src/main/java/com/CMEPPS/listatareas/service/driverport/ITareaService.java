
package com.CMEPPS.listatareas.service.driverport;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.CMEPPS.listatareas.model.application.Tarea;

public interface ITareaService {

    List < Tarea > getTodosByUser(String user);

    Optional < Tarea > getTodoById(long id);

    void updateTodo(Tarea tarea);

    void addTodo(String name, String desc, Date targetDate, boolean isDone);

    void deleteTodo(long id);

    void saveTodo(Tarea tarea);
}
