package restTemplate.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.beans.Alumno;

public class RestTemplateClient {
	
	public static void main(String[] args){
		try{
			String url = "http://localhost:8080/RestServer/rest/alumno/";
			URI uri = new URI(url);
			//add(uri,new Alumno("4444444F","Alumno 4",21,null));
			List<Alumno> alumnos = getForEntity(uri);
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.getNombre());
			}
			Alumno alumno = getForEntity(url, "22222222B");
			alumno.setNombre("Alumno modificado");
			update(uri, alumno );
			delete(url,"4444444F");
			//System.out.println(getForEntity(url, "22222222B").getNombre());
		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	public static void update(URI uri, Alumno alumno){
		new RestTemplate().put(uri, alumno);
	}
	
	public static void delete(String uri, String dni){
		Map<String, String>  mapa= new HashMap<String, String>();
		mapa.put("dni", dni);
		new RestTemplate().delete(uri+"{dni}", mapa);
	}
	
	public static void add(URI uri,Alumno alumno){
		new RestTemplate().postForObject(uri,alumno,Alumno.class);
	}
	
	public static List<Alumno> getForEntity(URI uri){
		ResponseEntity<Alumno[]> lista = new RestTemplate().getForEntity(uri, Alumno[].class);
		return Arrays.asList(lista.getBody());
	}
	
	public static Alumno getForEntity(String uri, String dni){
		Map<String, String>  mapa= new HashMap<String, String>();
		mapa.put("dni", dni);
		return new RestTemplate().getForEntity(uri+"{dni}", Alumno.class, mapa).getBody();
	}
}
