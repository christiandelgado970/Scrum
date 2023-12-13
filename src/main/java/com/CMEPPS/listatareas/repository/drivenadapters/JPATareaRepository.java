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
	public List<Tarea> findByOrdenar (int tipo) {
		
		List<Tarea> tareas  = null;
		if(tipo == 1)//Por duracion
		{
			tareas = iJPATareaRepository.findAllByOrderByTipoduracionDesc();
		}
		else if(tipo == 2) //por prioridad
		{
			tareas = iJPATareaRepository.findAllByOrderByPrioridadDesc();
		}
		else //por usuario
		{
			tareas = iJPATareaRepository.findAllByOrderByUsuarioDesc();
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
	@Override
	public List<Tarea> findByPrioridadAndUser(int Prioridad, String User) {
		List<Tarea> tareas = iJPATareaRepository.findByPrioridadAndUsuario(Prioridad,User);
		return tareas;
	}
	@Override
	public List<Tarea> findByOrdenarAndUser(int tipo, String User) {
		
		List<Tarea> tareas  = null;
		if(tipo == 1)//Por duracion
		{
			tareas = iJPATareaRepository.findAllByUsuarioOrderByTipoduracionDesc(User);
		}
		else //por prioridad
		{
			tareas = iJPATareaRepository.findAllByUsuarioOrderByPrioridadDesc(User);
		}
		
		return tareas;
	}
	@Override
	public List<Tarea> findAllByUser(String User) {
		List<Tarea> tareas = iJPATareaRepository.findByUsuario(User);
		return tareas;
	}
}