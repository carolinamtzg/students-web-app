package com.carolina.students.web.service;

import java.util.List;

import com.carolina.students.web.entity.Proyecto;

public interface ProyectoService {

	public List<Proyecto> buscarProyectos();
	
	public Proyecto buscarProyectoPorId(Long id);
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public Proyecto eliminarProyectoPorId(Long id);
}
