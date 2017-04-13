package gui.viewModel;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.uqbar.commons.utils.Observable;
import domain.*;

@Observable
public class LoginVM {

	private String token;
	private String resultado;
	private Alumno student;
	private ArrayList<Asignacion> asignaciones;
	private String fnameOfStudent;
	private String lastNameOfStudent;
	private String codeOfStudent;
	private String gitUserOfStudent;
	private String nameAndLastName;
	private Asignacion asignacionElegida;
	private String descripcionDeAsignacionElegida;
	private ArrayList<Calificacion> notasDeAsignacionElegida;
	private Calificacion notaElegida;
	private String valorNotaElegida;
	private String condicion;
	private String fnameOfStudentMod;
	private String lastNameOfStudentMod;
	private String codeOfStudentMod;
	private String gitUserOfStudentMod;
	
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
		this.obtainAlumnoStrings();
	}

	
// Alumno Stuff
	
	public Alumno getStudent() {
		return student;
	}
	
	private void obtainAlumnoStrings() {
		this.nameOfStudent();
		this.lastNameOfStudent();
		this.codeOfStudent();
		this.gitUserOfStudent();
		this.nameAndLastNameConcat();
	}
		
	private String nameAndLastNameConcat(){
		String nameAndLastNameC = fnameOfStudent.concat(" ").concat(lastNameOfStudent);
	return setNameAndLastName(nameAndLastNameC);
	}

	public String getNameAndLastName() {
		return nameAndLastName;
	}

	public String setNameAndLastName(String nameAndLastName) {
		this.nameAndLastName = nameAndLastName;
		return nameAndLastName;
	}	
	
//		Name	
	
	public String getFnameOfStudent() {
		return fnameOfStudent;
	}

	public void setFnameOfStudent(String fnameOfStudent) {
		this.fnameOfStudent = fnameOfStudent;
	}

	public String nameOfStudent(){
		return fnameOfStudent = student.getFirst_name();
	}	

//		Last Name
	
	public String getLastNameOfStudent() {
		return lastNameOfStudent;
	}

	public void setLastNameOfStudent(String lastNameOfStudent) {
		this.lastNameOfStudent = lastNameOfStudent;
	}
	public String lastNameOfStudent(){
		return lastNameOfStudent = student.getLast_name();
	}	
//		Code
	
	public String getCodeOfStudent() {
		return codeOfStudent;
	}

	public void setCodeOfStudent(String codeOfStudent) {
		this.codeOfStudent = codeOfStudent;
	}
	
	public String codeOfStudent(){
		return codeOfStudent = student.getCode();
	}		
//		GitUser

	public String getGitUserOfStudent() {
		return gitUserOfStudent;
	}

	public void setGitUserOfStudent(String gitUserOfStudent) {
		this.gitUserOfStudent = gitUserOfStudent;
	}
	
	public String gitUserOfStudent(){
		return gitUserOfStudent = student.getGithub_user();
	}
//	Asignaciones
	
	public ArrayList<Asignacion> misAsignaciones() {
		return setAsignaciones(student.getAssignments());
	}

	public Asignacion getAsignacionElegida() {
		return asignacionElegida;
	}

	public void setAsignacionElegida(Asignacion laAsignacionElegida) {
		asignacionElegida = laAsignacionElegida;
		descripcionDeAsignacionElegida = asignacionElegida.getDescription();
		setNotasDeAsignacionElegida(asignacionElegida.getGrades());
		verificarSiAproboLaAsignacion();
	}

	public ArrayList<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public ArrayList<Asignacion> setAsignaciones(ArrayList<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
		return asignaciones;
	}
//	Descripcion Asignacion
	
	public String getDescripcionDeAsignacionElegida() {
		return descripcionDeAsignacionElegida;
	}

	public void setDescripcionDeAsignacionElegida(String descripcionDeAsignacionElegida) {
		this.descripcionDeAsignacionElegida = descripcionDeAsignacionElegida;
	}
//	Notas Asignacion
	
	public ArrayList<Calificacion> getNotasDeAsignacionElegida() {
		return notasDeAsignacionElegida;
	}

	public void setNotasDeAsignacionElegida(ArrayList<Calificacion> notasDeAsignacionElegida) {
		this.notasDeAsignacionElegida = notasDeAsignacionElegida;
	}
//	Nota Asignacion

	public Calificacion getNotaElegida() {
		return notaElegida;
	}

	public void setNotaElegida(Calificacion laNotaElegida) {
		if(tieneNotasLaAsignacion()){
			notaElegida = laNotaElegida;
			valorNotaElegida = notaElegida.getValue();	
		}
		else{
			notaElegida = null;
			valorNotaElegida = "no tiene valor";
		}
		//		setNotasDeAsignacionElegida(asignacionElegida.getGrades());
	}
//	Nota Asignacion Valor
	public String getValorNotaElegida() {
		return valorNotaElegida;
	}

	public void setValorNotaElegida(String valorNotaElegida) {
		this.valorNotaElegida = valorNotaElegida;
	}
//	Nota Asignacion Condicion de aprobacion
	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	public void verificarSiAproboLaAsignacion( ) {
	if (notaFinalDeAsignacionElegidaAprobada()){	
		condicion = "Si";}
	else{
		condicion = "No";}
	}

	public boolean notaFinalDeAsignacionElegidaAprobada() {
		return (apruebaLaAsignacion() && tieneNotasLaAsignacion() );
	}

	public boolean tieneNotasLaAsignacion() {
			return (!(asignacionElegida.getGrades().isEmpty()));
	}

	public String notaFinal() {
		if(tieneNotasLaAsignacion()){
		int indexNotaFinal = notasDeAsignacionElegida.size()-1;
		return notasDeAsignacionElegida.get(indexNotaFinal).getValue();}
		else{
			 JOptionPane.showMessageDialog(null, "No hay nota", "InfoBox: No hay nota", JOptionPane.INFORMATION_MESSAGE);
		return "0";
		}
	}

	public boolean apruebaLaAsignacion( ) {
		return apruebaAsignacionNumerica() || apruebaAsignacionConLetra() ;
	}	
	public boolean apruebaAsignacionConLetra( ){
		return  notaFinal().equals("B") || notaFinal().equals("B+") || notaFinal().equals("A") || notaFinal().equals("A+");
	}
	
	public boolean apruebaAsignacionNumerica( ){
		return Integer.parseInt(notaFinal())>= 6;
	}

//	Datos del Alumno Modificado
//	Nombre y Apellido
	
	public String getFnameOfStudentMod() {
		return fnameOfStudentMod;
	}

	public void setFnameOfStudentMod(String fnameOfStudentMod) {
		this.fnameOfStudentMod = fnameOfStudentMod;
	}

	public String getLastNameOfStudentMod() {
		return lastNameOfStudentMod;
	}

	public void setLastNameOfStudentMod(String lastNameOfStudentMod) {
		this.lastNameOfStudentMod = lastNameOfStudentMod;
	}

//	Legajo
	
	public String getCodeOfStudentMod() {
		return codeOfStudentMod;
	}

	public void setCodeOfStudentMod(String codeOfStudentMod) {
		this.codeOfStudentMod = codeOfStudentMod;
	}

//	GitUser
		
	public String getGitUserOfStudentMod() {
		return gitUserOfStudentMod;
	}

	public void setGitUserOfStudentMod(String gitUserOfStudentMod) {
		this.gitUserOfStudentMod = gitUserOfStudentMod;
	}

// Modificar Alumno	
	
	private Alumno modificarAlumnoExistente(Alumno studentMod) {
		studentMod.setFirst_name(fnameOfStudentMod);
		studentMod.setLast_name(lastNameOfStudentMod);
		studentMod.setCode(codeOfStudentMod);
		studentMod.setGithub_user(gitUserOfStudentMod);
		return studentMod;
	}
	
	public void modificarAlumno() {
		Alumno studentMod = modificarAlumnoExistente(student);
//		System.out.print(studentMod.toString());
		NotitasServiceConnect.alumnoALaWeb(token,studentMod);
	}

}
