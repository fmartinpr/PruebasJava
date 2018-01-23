package rest.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rest.beans.Alumno;

@Service("alumnoDao")
@Transactional
public class AlumnoDao implements IAlumnoDao{

	private static List<Alumno> alumnos;
		
	static{
		alumnos = generarAlumnos();
	}
	
	public List<Alumno> obtenerTodosAlumnos() {
		return alumnos;
	}

	private static List<Alumno> generarAlumnos() {
			List<Alumno> alumnos = new ArrayList<Alumno>();
			alumnos.add(new Alumno("11111111A","Alumno 1", 25, new Date(2015,1,1)));
			alumnos.add(new Alumno("22222222B","Alumno 2", 25, new Date(2015,2,1)));
			alumnos.add(new Alumno("33333333C","Alumno 3", 25, new Date(2015,3,1)));
			return alumnos;
	}

	public Alumno obtenerAlumno(String dni) {
		for (Alumno alumno : alumnos) {
			if(alumno.getDni().equals(dni)){
				return alumno;
			}
		}
		return null;
	}

	public void insertarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}

	public void modificarAlumno(Alumno alumno) {
		Alumno aux = obtenerAlumno(alumno.getDni());
		aux.setDni(alumno.getDni());
		aux.setNombre(alumno.getNombre());
		//aux.setEdad(alumno.getEdad());
		//aux.setFechaIngreso(alumno.getFechaIngreso());
	}

	public void eliminarAlumno(String dni) {
		alumnos.remove(obtenerAlumno(dni));
	}

}
