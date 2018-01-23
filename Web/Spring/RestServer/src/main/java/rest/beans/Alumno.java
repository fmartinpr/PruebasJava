package rest.beans;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="alumno")
public class Alumno{
	
	private String dni;
	private String nombre;
	private int edad;
	private Date fechaIngreso;
	
	public Alumno(){
		
	}
	
	public Alumno(String dni, String nombre, int edad, Date fechaIngreso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}
