package com.CMEPPS.listatareas.model.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String descripcion;
    private int intduracion;
    private DuracionTipo tipoduracion;
    private EstadoTarea estado;
    private int prioridad;

    public Tarea() {
    	this.nombre = "";
    	this.descripcion = "";
        this.descripcion = "";
    	this.tipoduracion = DuracionTipo.Horas;
    	this.estado = EstadoTarea.En_Curso;
    }
    
    @Autowired
    public Tarea(String nombre, String descripcion,int prioridad,int Intduracion, DuracionTipo tp) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.intduracion = Intduracion;
        this.descripcion = descripcion;
        
        //String aux= String.valueOf(Intduracion);
        
        this.tipoduracion = tp;
        this.estado = EstadoTarea.En_Curso;
        
    	System.out.println("Creado: " +  tipoduracion);
        
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
		return tipoduracion;
	}

	public void setTipoduracion(DuracionTipo tipoduracion) {
		this.tipoduracion = tipoduracion;
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
		return intduracion;
	}
	
	public void setIntduracion(int intduracion) {
		this.intduracion = intduracion;
	}
    
    
}    
