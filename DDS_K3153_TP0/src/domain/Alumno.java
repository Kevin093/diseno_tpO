package domain;

import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno
{
	private String fname;
	private String lname;
	private String code;
	private String gitUser;
	private ArrayList<Tarea> task;

	
	// ********************************************************
	// ** Attributes
	// ********************************************************	
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGitUser() {
		return gitUser;
	}
	public void setGitUser(String gitUser) {
		this.gitUser = gitUser;
	}
	public ArrayList<Tarea> getTask() {
		return task;
	}
	public void setTask(ArrayList<Tarea> task) {
		this.task = task;
	}

	
}