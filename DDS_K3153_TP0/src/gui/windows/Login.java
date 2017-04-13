package gui.windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import gui.viewModel.LoginVM;
import domain.*;

@SuppressWarnings("serial")
public class Login extends SimpleWindow<LoginVM> {

	public Login(WindowOwner parent) {
		super(parent, new LoginVM());
	}

	@Override
	public void createContents(Panel LoginPanel) {
//		New Panel for Token Authentication	
		this.configureLayout(LoginPanel);
		this.createMainTemplate(LoginPanel);
		this.setTitle("Lector de Notas");
		LoginPanel.setLayout(new VerticalLayout());
		new Label(LoginPanel).setText("Login de usuario");
		new Label(LoginPanel).setText("Ingrese el token");
		new TextBox(LoginPanel).setWidth(350).bindValueToProperty("token");
		new Button(LoginPanel).setCaption("Validar el token").onClick(() -> this.getModelObject().validar());
//		New Panel for Student Data		
		Panel dataForm = new Panel(LoginPanel);
		dataForm.setLayout(new ColumnLayout(2));
		new Label(dataForm).setText("Bienvenido");
		new Label(dataForm).bindValueToProperty("nameAndLastName");
		new Label(dataForm).setText("Legajo: ");
		new Label(dataForm).bindValueToProperty("codeOfStudent");
		new Label(dataForm).setText("Git User: ");
		new Label(dataForm).bindValueToProperty("gitUserOfStudent");
		new Label(dataForm).setText(" ");
		new Label(dataForm).setText(" ");
//		New Panel for Assignments		
		new Button(dataForm).setCaption("Mis Asignaciones").onClick(() -> this.getModelObject().misAsignaciones());
		new Label(dataForm).setText(" ");
		new Label(dataForm).setText("Asignacion");
		Selector<Asignacion> selectorAsignaciones = new Selector<Asignacion>(dataForm).allowNull(true);
		selectorAsignaciones.bindItemsToProperty("asignaciones");
		selectorAsignaciones.bindValueToProperty("asignacionElegida");
		new Label(dataForm).setText("Nombre de la asignacion: ");
		new Label(dataForm).bindValueToProperty("asignacionElegida");
		new Label(dataForm).setText("Descripcion de la asignacion: ");
		new Label(dataForm).bindValueToProperty("descripcionDeAsignacionElegida");
//		New Panel for Grades	
		new Label(dataForm).setText("Notas");
		Selector<Calificacion> selectorNotas = new Selector<Calificacion>(dataForm).allowNull(true);
		selectorNotas.bindItemsToProperty("notasDeAsignacionElegida");
		selectorNotas.bindValueToProperty("notaElegida");
		new Label(dataForm).setText("Valor Nota: ");
		new Label(dataForm).bindValueToProperty("valorNotaElegida");
		new Label(dataForm).setText("Aprueba: ");
		new Label(dataForm).bindValueToProperty("condicion");
//		New Panel for Add Student Data		
		new Label(LoginPanel).setText("Modificar Datos Alumno");
		Panel addStudent = new Panel(LoginPanel);		
		addStudent.setLayout(new ColumnLayout(2));
		new Label(addStudent).setText("Nombre: ");
		new TextBox(addStudent).setWidth(250).bindValueToProperty("fnameOfStudentMod");
		new Label(addStudent).setText("Apellido: ");
		new TextBox(addStudent).setWidth(250).bindValueToProperty("lastNameOfStudentMod");
		new Label(addStudent).setText("Legajo: ");
		new TextBox(addStudent).setWidth(250).bindValueToProperty("codeOfStudentMod");
		new Label(addStudent).setText("GitUser: ");
		new TextBox(addStudent).setWidth(250).bindValueToProperty("gitUserOfStudentMod");
		new Button(LoginPanel).setCaption("Modificar datos").onClick(() -> this.getModelObject().modificarAlumno());
	}

	@Override
	protected void addActions(Panel actionsPanel) {
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
	}
}
