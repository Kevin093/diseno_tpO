package domain.stockObjects.accounts;

import java.util.ArrayList;
import java.util.List;

import domain.stockObjects.indicator.operatings.Operating;

public class Account implements Operating {
	private String name;
	private List<AccountPeriod> accountPeriod;
	
	//Constructors
	public Account() {
		this.name = "";
		this.accountPeriod = new ArrayList<AccountPeriod>();
	}
	
	public Account(String name, List<AccountPeriod> listAccountPeriod) {
		this.setName(name);
		this.setAccountPeriod(listAccountPeriod);
	}
	
	// Setters - getters Attributes

	public String getName() {
		return name;
	}

	public List<AccountPeriod> getAccountPeriod() {
		return accountPeriod;
	}

	public void setAccountPeriod(List<AccountPeriod> accountPeriod) {
		this.accountPeriod = accountPeriod;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNameEmpty() {
		return this.getName() == "";
	}
	
	public boolean isAccountPeriodListIsEmpty() {
		return this.getAccountPeriod().isEmpty();
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
