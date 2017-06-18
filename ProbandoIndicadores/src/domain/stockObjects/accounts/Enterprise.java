package domain.stockObjects.accounts;

import java.util.ArrayList;
import java.util.List;

public class Enterprise {
	private String title;
	private String description;
	private List<Account> accounts;
	
	// Constructor
	public Enterprise() {
		this.title = "";
		this.description = "";
		this.accounts = new ArrayList<Account>();
	}

	// Setters - getters Attributes

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		return title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setTitle(String title) {
		this.title = title;
		
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
		
	}

	public boolean isTitleEmpty() {
		return this.getTitle() == "";
	}
	public boolean isDescriptionIsEmpty() {
		return this.getDescription() == "";
	}
	public boolean isAccountsIsEmpty() {
		return this.getAccounts().isEmpty();
	}
}
