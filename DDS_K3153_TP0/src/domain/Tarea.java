package domain;

import org.uqbar.commons.utils.Observable;

@Observable

public class Tarea
{
	public int id;
	private String title;
	private TipoCalificacion typeOfgrade;
	private String typeOfTask;
	
	
	// ********************************************************
	// ** Attributes
	// ********************************************************		
	
	
	public TipoCalificacion getTypeOfgrade() {
		return typeOfgrade;
	}

	public void setTypeOfgrade(TipoCalificacion typeOfgrade) {
		this.typeOfgrade = typeOfgrade;
	}

	public String getTypeOfTask() {
		return typeOfTask;
	}

	public void setTypeOfTask(String typeOfTask) {
		this.typeOfTask = typeOfTask;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}	