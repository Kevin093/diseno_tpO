package domain;

import javax.ws.rs.core.MediaType;
import org.uqbar.commons.utils.Observable;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

@Observable
public class NotitasServiceConnect {

	// ********************************************************
	// ** Convierte el alumno desde el formato JSON a un objeto Clase Alumno
	// ********************************************************

	public static Alumno alumnoDesdeWeb(String token) {

		String studentFromNotitas = studentRequest(token);
		String assignmentsFromStudentFromNotitas = studentAssignmentsRequest(token);
//		System.out.print(studentFromNotitas);
//		System.out.print(assignmentsFromStudentFromNotitas);
		Alumno oneStudent = new Gson().fromJson(studentFromNotitas, Alumno.class);
		// Parsear o decodificar el json antes de agregarlo, era medio un chino.
		// Se crea un nuevo objeto con todo entero y
		// despues se agrega solo los assingments al alumno (oneStudent)
		Alumno studentWithAssignments = new Gson().fromJson(assignmentsFromStudentFromNotitas, Alumno.class);
		// Agrega solo los assingments al alumno (oneStudent)
		oneStudent.addAssignments(studentWithAssignments);
		return oneStudent;
	}

	private static String studentAssignmentsRequest(String token) {
		return jerseyRequest(token, "student/assignments");
	}

	private static String studentRequest(String token) {
		return jerseyRequest(token, "student");
	}

	private static String jerseyRequest(String token, String pathToRequest) {
		String stringToReturn = Client.create().resource("http://notitas.herokuapp.com").path(pathToRequest)
				.header("Authorization", "Bearer ".concat(token)).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class).getEntity(String.class);

		return stringToReturn;
	}

	// ********************************************************
	// ** Convierte el alumno desde el formato JSON a un objeto Clase Alumno
	// ********************************************************	
	
	public static void alumnoALaWeb(String token, Alumno student) {
		 Client.create().resource("http://notitas.herokuapp.com").path("student")
				.header("Authorization", "Bearer ".concat(token)).accept(MediaType.APPLICATION_JSON)
				.put(String.class, student.toString());
	}

}
