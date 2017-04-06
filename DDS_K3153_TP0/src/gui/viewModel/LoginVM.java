package gui.viewModel;

import org.uqbar.commons.utils.Observable;

import domain.*;

@Observable
public class LoginVM {

	private String token;
	private String resultado;
	private Alumno student;

	private String fnameOfStudent;
	
	public Alumno getStudent() {
		return student;
	}

	
	public String nameOfStudent(){
		return fnameOfStudent = student.getFirst_name();
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public void validar() {
		student = NotitasServiceConnect.alumnoDesdeWeb(token);
		this.nameOfStudent();
	}

	public String getFnameOfStudent() {
		return fnameOfStudent;
	}

	public void setFnameOfStudent(String fnameOfStudent) {
		this.fnameOfStudent = fnameOfStudent;
	}


}
