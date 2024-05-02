package com.carolina.students.web.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carolina.students.web.entity.Alumno;

@Repository
public interface AlumnoDao extends CrudRepository<Alumno, Long>{

}
