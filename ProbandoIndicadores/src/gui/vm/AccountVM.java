package gui.vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;

import com.google.gson.JsonParseException;

import domain.connect.account.AccountsLoader;
import domain.connect.account.factory.AccountFactory;
import domain.messageWindows.Windows;
import domain.stockObjects.accounts.Account;
import domain.stockObjects.accounts.AccountPeriod;
import domain.stockObjects.accounts.Enterprise;
@Observable
public class AccountVM {

	// Enterprise
	private List<Enterprise> enterprises;
	private Enterprise chosenEnterprise;
	// Enterprise Attributes
	private Account chosenEnterpriseAccount;
	// private AccountPeriod chosenEnterpriseAccountPeriod = new
	// AccountPeriod();
	private AccountPeriod chosenEnterpriseAccountPeriod;
	private AccountFactory accountFactory;
	private int value3;
	public AccountVM() {
		accountFactory = new AccountFactory();

	}
	// Main Methods
		public void loadAccounts() {
			AccountsLoader newAccountConnect = accountFactory.createAccountConnect();
			try {
				enterprises = newAccountConnect.loadEnterprisesAccounts();
			} catch (IllegalArgumentException | JsonParseException e) {
				System.out.println("El Json esta mal formateado");
				Windows.showErrorMessage("Las Cuentas no se cargaron correctamente", "Error de carga");
			}
		}
	
		// Auxiliary Methods

//		private int setAccountPeriodValue(AccountPeriod chosenEnterpriseAccountPeriod2) {
//			return chosenEnterpriseAccountPeriod2.getValue();
//		}
		
		// Enterprise Setters - getters

		public List<Enterprise> getEnterprises() {
			return enterprises;
		}

		public void setEnterprises(List<Enterprise> enterprises) {
			this.enterprises = enterprises;
		}

		public Enterprise getchosenEnterprise() {
			return chosenEnterprise;
		}

		public void setChosenEnterprise(Enterprise chosenEnterprise) {
			this.chosenEnterprise = chosenEnterprise;
		}

		// region Enterprise Account Setters - getters

		public Account getChosenEnterpriseAccount() {
			return chosenEnterpriseAccount;
		}

		public void setChosenEnterpriseAccount(Account chosenEnterpriseAccount) {
			this.chosenEnterpriseAccount = chosenEnterpriseAccount;
		}

		public AccountPeriod getChosenEnterpriseAccountPeriod() {
			return chosenEnterpriseAccountPeriod;
		}

		public void setChosenEnterpriseAccountPeriod(AccountPeriod chosenEnterpriseAccountPeriod) {
			this.chosenEnterpriseAccountPeriod = chosenEnterpriseAccountPeriod;
		}
		public int getValue3() {
			return value3;
		}
		public Action setValue3(int value3) {
			this.value3 = value3;
			return null;
		}
		public Action search() {
			// TODO Auto-generated method stub
			return null;
		}
}
