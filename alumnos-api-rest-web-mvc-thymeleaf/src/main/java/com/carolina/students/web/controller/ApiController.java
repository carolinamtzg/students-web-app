package com.carolina.students.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.students.web.entity.Alumno;
import com.carolina.students.web.entity.Proyecto;
import com.carolina.students.web.service.AlumnoService;
import com.carolina.students.web.service.ProyectoService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private AlumnoService service;
	
	@Autowired
	private ProyectoService serviceProject;
	
	
	//metodos para Alumnos:
	
	@GetMapping("/alumnos")
	public List<Alumno> index(){
		return service.buscarTodos();
	}
	
	@GetMapping("/alumnos/{id}")
	public Alumno show(@PathVariable Long id) {
		return service.buscarAlumnoPorId(id);
	}
	
	@PostMapping("/alumnos")
	public Alumno create(@RequestBody Alumno alumno) {
		return service.guardarAlumno(alumno);
	}
	
	@PutMapping("/alumnos/{id}")
	public Alumno update(@PathVariable Long id, @RequestBody Alumno new_alumno) {
		
		Alumno alumnoUpdate = service.buscarAlumnoPorId(id);
		
		alumnoUpdate.setNombre(new_alumno.getNombre());
		alumnoUpdate.setApellido(new_alumno.getApellido());
		alumnoUpdate.setTelefono(new_alumno.getTelefono());
		alumnoUpdate.setEmail(new_alumno.getEmail());
		alumnoUpdate.setDni(new_alumno.getDni());
		alumnoUpdate.setFecha_nac(new_alumno.getFecha_nac());
		
		return service.guardarAlumno(alumnoUpdate);
	}
	
	@DeleteMapping("/alumnos/{id}")
	public Alumno delete(@PathVariable Long id) {
		return service.borrarAlumno(id);
	}
	
	//metodos para Proyectos:
	
	@GetMapping("/proyectos")
	public List<Proyecto> indexProyecto() {
		return serviceProject.buscarProyectos();
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto showProject(@PathVariable Long id) {
		return serviceProject.buscarProyectoPorId(id);
	}
	
}
