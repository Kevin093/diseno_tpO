package gui.windows;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import domain.messageWindows.Windows;
import domain.stockObjects.accounts.Enterprise;
import gui.vm.AccountVM;

@SuppressWarnings("serial")
public class AccountWindow extends SimpleWindow<AccountVM> {
	public WindowOwner parentWO;
	public AccountWindow(WindowOwner parent) {
		super(parent, new AccountVM());
		parentWO = parent;
	}

	@Override
	public void createContents(Panel Master) {
		this.configureLayout(Master);
		this.createMainTemplate(Master);
		this.setTitle("La Bolsa - Cuentas");
		this.setIconImage(System.getProperty("user.dir") + "\\resources\\icon.ico");
		Master.setLayout(new VerticalLayout());
		new Label(Master).setText("Cuentas").setFontSize(20);
		new Button(Master).setCaption("Cargar cuentas").onClick(() -> this.getModelObject().loadAccounts());
		// New Panel for Enterprises
		Panel dataForm = new Panel(Master);
		dataForm.setLayout(new ColumnLayout(2));
		new Label(dataForm).setText("Selector de empresas");
		Selector<Enterprise> enterpriseSelect = new Selector<Enterprise>(dataForm).allowNull(true);
		enterpriseSelect.bindItemsToProperty("enterprises");
		enterpriseSelect.bindValueToProperty("chosenEnterprise");
		new Label(dataForm).setText("Empresa: ");
		new Label(dataForm).bindValueToProperty("chosenEnterprise.title");
		new Label(dataForm).setText("Descripcion: ");
		new Label(dataForm).bindValueToProperty("chosenEnterprise.description");
		new Label(dataForm).setText("Cuentas: ");
		Selector<Enterprise> accountSelect = new Selector<Enterprise>(dataForm).allowNull(true);
		accountSelect.bindItemsToProperty("chosenEnterprise.accounts");
		accountSelect.bindValueToProperty("chosenEnterpriseAccount");
		new Label(dataForm).setText("Cuenta: ");
		new Label(dataForm).bindValueToProperty("chosenEnterpriseAccount.name");
		new Label(dataForm).setText("Periodo: ");
		Selector<Enterprise> accountPeriodSelect = new Selector<Enterprise>(dataForm).allowNull(true);
		accountPeriodSelect.bindItemsToProperty("chosenEnterpriseAccount.accountPeriod");
		accountPeriodSelect.bindValueToProperty("chosenEnterpriseAccountPeriod");
		new Label(dataForm).setText("Valor: ");
		new Label(dataForm).bindValueToProperty("chosenEnterpriseAccountPeriod.value");
		new Button(dataForm).setCaption("Indicadores").onClick(() -> this.openIndicatorWindow());
		new Label(dataForm).bindValueToProperty("value3");
		new Button(dataForm).setCaption("Cerrar").onClick(() -> this.closeWindow());
	}
	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

	public void openIndicatorWindow() {
		try{
		this.openDialog(new IndicatorWindow(this, this.getModelObject().getChosenEnterpriseAccountPeriod().getValue()));
		}catch(Exception e){
			Windows.showErrorMessage("Debe seleccionar una cuenta primero", "Error");
		}
		}
	
		protected void openDialog(Dialog<?> dialog) {
	   dialog.onAccept(null);
	   dialog.open();
	}

		public void closeWindow(){

			//((IndicatorWindow) parentWO).getModelObject().setReceivedAccount(this.getModelObject().getChosenEnterpriseAccountPeriod().getValue());
			this.close();
		}

	

}
