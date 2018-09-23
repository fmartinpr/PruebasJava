package rest.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rest.beans.Alumno;
import rest.dao.IAlumnoDao;

@Controller
@RequestMapping(value="/alumno")
public class AlumnoServiceController {
	
	@Autowired
	private IAlumnoDao alumnoDao;
	
	@RequestMapping(value="/saludo/{nombre}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String saludo(@PathVariable("nombre") String nombre)
	{
		return "Hola mundo " + nombre;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alumno>> obtenerAlumnos(){
		List<Alumno> lista = (java.util.List<Alumno>) this.alumnoDao.obtenerTodosAlumnos();
		ResponseEntity<List<Alumno>> response;
		if (lista == null) {
			response = new ResponseEntity<List<Alumno>>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<List<Alumno>>(lista, HttpStatus.OK);
        }
        return response;
	}
	
	@RequestMapping(value="/{dni}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> obtenerAlumno(@PathVariable("dni") String dni){
		Alumno alumno = this.alumnoDao.obtenerAlumno(dni);
        ResponseEntity<Alumno> response;
        if (alumno == null) {
            response = new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
        }
        return response;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody void insertarAlumno(@RequestBody Alumno alumno){
		this.alumnoDao.insertarAlumno(alumno);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT, headers="Accept=application/json")
	public @ResponseBody void modificarAlumno(@RequestBody Alumno alumno){
		this.alumnoDao.modificarAlumno(alumno);
	}
	
	@RequestMapping(value="/{dni}", method = RequestMethod.DELETE)
	public @ResponseBody void eliminarAlumno(@PathVariable("dni") String dni){
		this.alumnoDao.eliminarAlumno(dni);
	}
	
}
