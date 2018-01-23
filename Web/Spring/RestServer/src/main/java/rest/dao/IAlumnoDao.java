package rest.dao;

import java.util.List;

import rest.beans.Alumno;

public interface IAlumnoDao {

	List<Alumno> obtenerTodosAlumnos();

	Alumno obtenerAlumno(String dni);

	void insertarAlumno(Alumno alumno);

	void modificarAlumno(Alumno alumno);

	void eliminarAlumno(String dni);

}
