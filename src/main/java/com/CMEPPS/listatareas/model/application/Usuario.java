package com.CMEPPS.listatareas.model.application;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private String nombre;
	private String contrasena;
	private boolean admin;
	
	@OneToMany(mappedBy = "nombre", cascade = CascadeType.ALL)
    private List<Tarea> Tareas;
	
	public Usuario() {
		super();
		admin = false;
	}
	
	public Usuario(String Nombre, String Contrasena) {
		super();
		this.nombre = Nombre;
		this.contrasena = Contrasena;
		admin = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		nombre = nombre;
	}
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		contrasena = contrasena;
	}

	public List<Tarea> getTareas() {
		return Tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		Tareas = tareas;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
