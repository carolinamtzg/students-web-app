package com.carolina.students.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carolina.students.web.service.ProyectoService;

@Controller
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping({"/proyectos", "/"})
	public String listarProyectos(Model modelo) {
		modelo.addAttribute("lista_proyectos", proyectoService.buscarProyectos());
		
		return "proyectos";
	}

}
