package com.CMEPPS.listatareas.repository.drivenadapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CMEPPS.listatareas.model.application.Tarea;
import com.CMEPPS.listatareas.repository.drivenports.ITareaRepository;

@Component
public class JPATareaRepository implements ITareaRepository  {
   
@Autowired 
private IJPATareaRepository iJPATareaRepository;
    @Override
public List<Tarea> findByNombre(String Nombre) {
    	List<Tarea> tareas = iJPATareaRepository.findByNombre(Nombre);
    	return tareas;
    }
	@Override
	public List<Tarea> findAll() {
		List<Tarea> tareas = iJPATareaRepository.findAll();
		return tareas;
	}
	@Override
	public Optional<Tarea> findById(long id) {
		Optional<Tarea> tareas = iJPATareaRepository.findById(id);
		return tareas;
	}
	@Override
	public List<Tarea> findByPrioridad(int Prioridad) {
		List<Tarea> tareas = iJPATareaRepository.findByPrioridad(Prioridad);
		return tareas;
	}
	@Override
	public List<Tarea> findByOrdenar(String Nombre) {
		List<Tarea> tareas = iJPATareaRepository.findAll();
		return tareas;
	}
	@Override
	public List<Tarea> findByOrdenar (int tipo) {
		
		List<Tarea> tareas  = null;
		if(tipo == 1)//Por duracion
		{
			tareas = iJPATareaRepository.findAllByOrderByTipoduracionDesc();
		}
		else //por prioridad
		{
			tareas = iJPATareaRepository.findAllByOrderByPrioridadDesc();
		}
		
		return tareas;
	}
	@Override
	public void save(Tarea tarea) {
		iJPATareaRepository.save(tarea);
	}
	@Override
	public void delete(Tarea tarea) {
		iJPATareaRepository.delete(tarea);
	}
}