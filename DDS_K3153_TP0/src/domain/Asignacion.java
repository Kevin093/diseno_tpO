package domain;

import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

@Observable

public class Asignacion {
	private int id;
	private String title;
	private String description;
	private ArrayList<Calificacion> grades;

	public Asignacion() {
	}

	// ********************************************************
	// ** Attributes
	// ********************************************************

	public ArrayList<Calificacion> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Calificacion> grades) {
		this.grades = grades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return title;
	}

}
