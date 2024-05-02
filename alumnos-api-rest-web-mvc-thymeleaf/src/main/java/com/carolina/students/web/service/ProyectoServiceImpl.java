package com.carolina.students.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carolina.students.web.dao.ProyectoDao;
import com.carolina.students.web.entity.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	ProyectoDao proyectoDao;
	
	
	@Override
	@Transactional(readOnly= true)
	public List<Proyecto> buscarProyectos() {
		return (List<Proyecto>) proyectoDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Proyecto buscarProyectoPorId(Long id) {
		return proyectoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}

	@Override
	@Transactional()
	public Proyecto eliminarProyectoPorId(Long id) {
		
		Proyecto proyectoDelete = proyectoDao.findById(id).orElse(null);
		proyectoDao.deleteById(id);
		
		return proyectoDelete;
	}
	
	

}
