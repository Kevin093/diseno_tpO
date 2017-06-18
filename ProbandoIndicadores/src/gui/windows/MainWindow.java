package gui.windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import gui.vm.MainVM;

@SuppressWarnings("serial")
public class MainWindow extends SimpleWindow<MainVM> {

	public MainWindow(WindowOwner parent) {
		super(parent, new MainVM());
	}

	@Override
	public void createContents(Panel Master) {
		this.configureLayout(Master);
		this.createMainTemplate(Master);
		this.setTitle("La Bolsa");
//	this.setIconImage(System.getProperty("user.dir") + "\\resources\\icon.ico");
		Master.setLayout(new VerticalLayout());
		new Label(Master).setText("La Bolsa").setFontSize(20);
		// New Panel main
		Panel dataForm = new Panel(Master);
		dataForm.setLayout(new ColumnLayout(3));
		new Label(dataForm).setText("");
		new Button(dataForm).setCaption("Cuentas").onClick(() -> new AccountWindow(this).open());
		new Label(dataForm).setText("");
//		new Button(dataForm).setCaption("Indicadores").onClick(() -> new IndicatorWindow(this,0).open());
		new TextBox(dataForm).bindValueToProperty("calcSentence");
		new Button(dataForm).setCaption("Calc").onClick(() ->this.getModelObject().calcu());
		new Label(dataForm).bindValueToProperty("result");
		new Button(dataForm).setCaption("Calc").onClick(() ->this.getModelObject().calcu2());
		new Label(dataForm).bindValueToProperty("syntacticValidatedFunction");

	}

	@Override
	protected void addActions(Panel actionsPanel) {
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
	}
}
