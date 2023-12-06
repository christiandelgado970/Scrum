package com.CMEPPS.listatareas.model.application;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String descripcion;
    private int Intduracion;
    private DuracionTipo Tipoduracion;
    private EstadoTarea estado;
    private int prioridad;

    public Tarea() {
        super();
    }

    public Tarea(String nombre, String descripcion,int prioridad,int Intduracion) {
        super();
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.Intduracion = Intduracion;
        this.descripcion = descripcion;
        
        this.Tipoduracion = DuracionTipo.Horas;
        this.estado = EstadoTarea.En_Curso;
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
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public DuracionTipo getTipoduracion() {
		return Tipoduracion;
	}

	public void setTipoduracion(DuracionTipo tipoduracion) {
		Tipoduracion = tipoduracion;
	}

	public EstadoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	public int getIntduracion() {
		return Intduracion;
	}
	
	public void setIntduracion(int intduracion) {
		Intduracion = intduracion;
	}
    
    
}    
