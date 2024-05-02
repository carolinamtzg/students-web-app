package com.carolina.students.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carolina.students.web.dao.AlumnoDao;
import com.carolina.students.web.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	private AlumnoDao alumnoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> buscarTodos() {
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno buscarAlumnoPorId(Long id) {
		return alumnoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Alumno guardarAlumno(Alumno alumno) {
		return alumnoDao.save(alumno);
	}

	@Override
	@Transactional
	public Alumno borrarAlumno(Long id) {
		Alumno alumnoEliminado = alumnoDao.findById(id).orElse(null);
		
		alumnoDao.deleteById(id);
		
		return alumnoEliminado;
	}

}
