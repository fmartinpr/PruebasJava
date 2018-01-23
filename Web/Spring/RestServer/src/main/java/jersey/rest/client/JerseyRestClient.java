package jersey.rest.client;

import rest.beans.Alumno;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status.Family;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyRestClient {
	
	public static void main(String[] args){
		Alumno alumno = new Alumno("44444444E", "Alumno 4", 15, null);
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/RestServer/rest/alumno/");
		resource.type(MediaType.APPLICATION_JSON_TYPE);
		resource.accept(MediaType.APPLICATION_JSON_TYPE);
		
		//ClientResponse response = resource.post(ClientResponse.class, alumno);
		//alumno.setNombre("Alumno Modificado");
		//ClientResponse response = resource.put(ClientResponse.class, alumno);
		
		/*Eliminar
		 * Se utiliza el método path para completar la url con el número de dni del alumno
		 * http://localhost:8080/RestServer/rest/alumno/[dni]
		 */
		//ClientResponse response = resource.path(alumno.getDni()).delete(ClientResponse.class);
		ClientResponse response = resource.get(ClientResponse.class);
		
		if(response.getClientResponseStatus().getFamily() == Family.SUCCESSFUL){
			System.out.println("Success! " + response.getStatus());
			System.out.println(response.getEntity(String.class));
		}else{
			System.out.println("ERROR! " + response.getStatus());
			System.out.println(response.getEntity(String.class));
		}
	}
}
