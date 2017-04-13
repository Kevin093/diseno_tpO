package domain;

import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno {
	private String code;
	private String first_name;
	private String last_name;
	private String github_user;
	private ArrayList<Asignacion> assignments;

	// ********************************************************
	// ** Attributes
	// ********************************************************

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Asignacion> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Asignacion> assignments) {
		this.assignments = assignments;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGithub_user() {
		return github_user;
	}

	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}
	// ********************************************************
	// ** Actions
	// ********************************************************

	public void addAssignments(Alumno studentWithAssignments) {
		this.setAssignments(studentWithAssignments.getAssignments());
	}

	//Convierte al Alumno a String que reconoce JSon
	
	public String toString() {
		return "{\"code\":\"" + code + "\",\"first_name\":\""  + first_name + "\",\"last_name\":\"" + last_name + "\",\"github_user\":\"" + github_user + "\"}";}	
}