package com.carolina.students.web.service;

import java.util.List;

import com.carolina.students.web.entity.Alumno;

public interface AlumnoService {
	
	public List<Alumno> buscarTodos();
	
	public Alumno buscarAlumnoPorId(Long id);
	
	public Alumno guardarAlumno(Alumno alumno);
	
	public Alumno borrarAlumno(Long id);
}
