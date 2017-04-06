package gui.windows;

import java.awt.Color;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

import gui.viewModel.LoginVM;


@SuppressWarnings("serial")
public class Login extends SimpleWindow<LoginVM>{

	public Login(WindowOwner parent) {
		super(parent, new LoginVM());
	}

	@Override
	public void createContents(Panel LoginPanel) {
		this.setTitle("Lector de Notas");
		LoginPanel.setLayout(new VerticalLayout());
		new Label(LoginPanel).setText("Login");
		new Label(LoginPanel).setText("Ingrese el token");

		new TextBox(LoginPanel).bindValueToProperty("token");
		new Button(LoginPanel)
			.setCaption("Validar token")
			.onClick(()-> this.getModelObject().validar());
		new TextBox(LoginPanel).bindValueToProperty("resultado");
		new Label(LoginPanel).setText(" v1");
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}	
	
	
}
