package gui.windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

import domain.messageWindows.Windows;
import domain.stockObjects.accounts.Account;
import domain.stockObjects.indicator.Indicator;
import gui.vm.AccountVM;
import gui.vm.IndicatorVM;

@SuppressWarnings("serial")
public class IndicatorWindow extends Dialog<IndicatorVM> {
	public int accountValue;
	public WindowOwner parent;
	public IndicatorWindow(WindowOwner parent, int accValue) {
		super(parent, new IndicatorVM());
		this.getModelObject().setIndicatorWindowThis(this);
		this.setValue(accValue);
	}

//	private void setThis(IndicatorWindow iw) {
//		this.getModelObject().setIndicatorWindowThis(iw);
//		
//	}

	public void setValue(int value) {
		this.accountValue = value;
		this.getModelObject().setAccountValue(value);
	}

	public void createContents(Panel Master) {

		this.configureLayout(Master);
		this.createMainTemplate(Master);
		this.setTitle("La Bolsa - Indicadores");
		this.setIconImage(System.getProperty("user.dir") + "\\resources\\icon.ico");
		Master.setLayout(new VerticalLayout());
		new Label(Master).setText("La Bolsa - Indicadores").setFontSize(20);
		// // Panel - load indicators
		Panel dataFormIndicador = new Panel(Master);
		dataFormIndicador.setLayout(new ColumnLayout(2));
		new Label(dataFormIndicador).setText("Carga de indicadores").setFontSize(15);
		new Label(dataFormIndicador).setText("");
		new Button(dataFormIndicador).setCaption("Cargar indicadores")
				.onClick(() -> this.getModelObject().loadIndicators());
		new Label(dataFormIndicador).setText("");
		new Label(dataFormIndicador).setText("Seleccionar indicador ");
		Selector<Indicator> indicatorSelect = new Selector<Indicator>(dataFormIndicador).allowNull(true);
		indicatorSelect.bindItemsToProperty("indicators");
		indicatorSelect.bindValueToProperty("chosenIndicator");
		new Label(dataFormIndicador).setText("Funcion: ");
		new Label(dataFormIndicador).bindValueToProperty("chosenIndicator.function");
		new Button(dataFormIndicador).setCaption("Calcular indicador")
				.onClick(() -> this.getModelObject().calcIndicatorValue());
		new Label(dataFormIndicador).setText("");
		new Label(dataFormIndicador).setText("Valor Indicador: ");
		new Label(dataFormIndicador).bindValueToProperty("indicatorCalculateValue");
		// Panel - calc & save indicators
		Panel dataFormIndicadorGrabar = new Panel(Master);
		dataFormIndicadorGrabar.setLayout(new ColumnLayout(2));
		// new Label(dataFormIndicadorGrabar).setText("Grabar Indicadores
		// Personalizados").setFontSize(15);
		// new Label(dataFormIndicadorGrabar).setText("");
		new Label(dataFormIndicadorGrabar).setText("Funcion: ");
		new TextBox(dataFormIndicadorGrabar).bindValueToProperty("indicatorFunction");
		new Button(dataFormIndicadorGrabar).setCaption("Calcular indicador")
				.onClick(() -> this.getModelObject().calcNewIndicator());
		new Label(dataFormIndicadorGrabar).setText("");
		new Label(dataFormIndicadorGrabar).setText("Resultado: ");
		new Label(dataFormIndicadorGrabar).bindValueToProperty("newIndicatorValue");
		new Label(dataFormIndicadorGrabar).setText("Nombre: ");
		new TextBox(dataFormIndicadorGrabar).bindValueToProperty("indicatorName");
		new Button(dataFormIndicadorGrabar).setCaption("Grabar")
				.onClick(() -> this.getModelObject().saveNewIndicators());
	//	new Button(dataFormIndicadorGrabar).setCaption("Cerrar").onClick(() -> ((AccountWindow) parent).getModelObject().setValue3(5));
		new Button(dataFormIndicadorGrabar).setCaption("Cerrar").onClick(() -> this.close());
	//	new Button(dataFormIndicadorGrabar).setCaption("Open").onClick(() -> this.openIndicatorWindow());
		
		new Label(dataFormIndicadorGrabar).bindValueToProperty("receivedAccount.name");
		new Label(dataFormIndicadorGrabar).bindValueToProperty("receivedAccountPeriod.year");
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub

	}
	
	public void closeWindow(){

		((AccountWindow) parent).getModelObject().setValue3(5);
		this.close();
	}
	public Action hello(){

		return null;
		
	}

	public Account openIndicatorWindow() {
		this.openDialog(new AccountForIndicatorWindow(this));
		return this.getModelObject().getReceivedAccount();
		}
	
		protected void openDialog(SimpleWindow<?> dialog) {

	   dialog.open();
	}
	
}
