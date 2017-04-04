package domain;

import org.uqbar.commons.utils.Observable;

@Observable

public class Tarea
{
	private Calificacion grade;
	private String typeOfTask;
	private String nameOfTask;
	
	
	// ********************************************************
	// ** Attributes
	// ********************************************************		
	
	
	public Calificacion getgrade() {
		return grade;
	}

	public void setgrade(Calificacion grade) {
		this.grade = grade;
	}

	public String getTypeOfTask() {
		return typeOfTask;
	}

	public void setTypeOfTask(String typeOfTask) {
		this.typeOfTask = typeOfTask;
	}

	public String getNameOfTask() {
		return nameOfTask;
	}

	public void setNameOfTask(String nameOfTask) {
		this.nameOfTask = nameOfTask;
	}
	
}	