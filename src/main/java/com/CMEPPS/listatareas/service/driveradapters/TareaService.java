package com.CMEPPS.listatareas.service.driveradapters;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CMEPPS.listatareas.model.application.Tarea;
import com.CMEPPS.listatareas.repository.drivenports.ITareaRepository;
import com.CMEPPS.listatareas.service.driverport.ITareaService;

@Service
public class TareaService implements ITareaService {

	@Autowired
	private ITareaRepository iTareaRepository;

	@Override
	public List<Tarea> getTodosByUser(String user) {
		return iTareaRepository.findByNombre(user);
	}

	@Override
	public Optional<Tarea> getTodoById(long id) {
		return iTareaRepository.findById(id);
	}

	@Override
	public void updateTodo(Tarea tarea) {
		iTareaRepository.save(tarea);
	}

	@Override
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		iTareaRepository.save(new Tarea(name, desc, targetDate, isDone));
	}

	@Override
	public void deleteTodo(long id) {
		Optional<Tarea> tarea = iTareaRepository.findById(id);
		if (tarea.isPresent()) {
			iTareaRepository.delete(tarea.get());
		}
	}

	@Override
	public void saveTodo(Tarea tarea) {
		iTareaRepository.save(tarea);
	}
}