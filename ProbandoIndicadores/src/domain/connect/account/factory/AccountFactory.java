package domain.connect.account.factory;

import domain.connect.account.AccountsLoader;

public class AccountFactory {
	
	public AccountsLoader createAccountConnect() {
		return new AccountsLoader();
	}

}
