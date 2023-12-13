package com.CMEPPS.listatareas.repository.drivenadapters;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;

import com.CMEPPS.listatareas.model.application.Tarea;
import com.CMEPPS.listatareas.model.application.Usuario;
import com.CMEPPS.listatareas.repository.drivenports.ITareaRepository;
import com.CMEPPS.listatareas.repository.drivenports.IUsuarioAcceso;

@Component
public class JPAUsuarioRepository implements IUsuarioAcceso  {
   
@Autowired 
private IJPAUsuarioRepository iJPAUsuarioRepository;

    @Override
    public Optional<Usuario> findByNombre(String Nombre) {
    	Optional<Usuario> usuario = iJPAUsuarioRepository.findByNombre(Nombre);
    	return usuario;

}
	@Override
	public void save(Usuario user) {
		iJPAUsuarioRepository.save(user);
	}
}