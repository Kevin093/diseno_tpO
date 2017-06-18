package gui.vm;

import java.util.List;
import java.util.Vector;

import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import domain.connect.indicator.IndicatorIO;
import domain.connect.indicator.factory.IndicatorFactory;
import domain.messageWindows.Windows;
import domain.parser.IndicatorParser;
import domain.stockObjects.accounts.Account;
import domain.stockObjects.accounts.AccountPeriod;
import domain.stockObjects.indicator.*;
import domain.stockObjects.indicator.operatings.Operation;
import exception.InvalidFormattAtInputException;
import gui.windows.AccountWindow;
import gui.windows.IndicatorWindow;

@Observable
public class IndicatorVM {
	// AccountPeriod();
	private IndicatorFactory indicatorIO;
	private List<Indicator> indicators;
	private Indicator chosenIndicator = null;
	private List<Indicator> indicators2;
	private Indicator chosenIndicator2 = new Indicator();
	private int accountValue;
	private String indicatorValue;
	private String indicatorCalculateValue;
	private String indicatorName = "";
	private String indicatorFunction = "";
	private Indicator newIndicator = new Indicator();
	private String newIndicatorValue = "";
	private WindowOwner parent;
	private WindowOwner parent1;
	private IndicatorWindow indicatorWindowThis;
	private Account receivedAccount;
	private AccountPeriod receivedAccountPeriod;

	public IndicatorVM() {
		indicatorIO = new IndicatorFactory();
	}

	// Main Methods

	public void loadIndicators() {
		IndicatorIO newIndicatorReader = indicatorIO.createIndicatorReader();
		try {
			indicators = newIndicatorReader.readIndicators();
		} catch (IllegalArgumentException | NullPointerException e) {
			Windows.showErrorMessage("Los Indicadores no se cargaron correctamente NPE", "Error de carga");
		}
	}

	public void calcIndicatorValue() {
		if (chosenIndicator != null) {
			try {
				calculateValueOfIndicator();
			} catch (Exception e) {
				Windows.showWarningMessage("Falta cargar una cuenta", "Advertencia");
			}
		} else {
			Windows.showWarningMessage("Falta elegir un indicador", "Advertencia");
		}
	}

	public void calcNewIndicator() {
		parseAndCalculateIndicator();
	}

	public void saveNewIndicators() {
		if (nameAndIndicatorFieldsComplete()) {
			saveNewIndicator();
		} else {
			Windows.showWarningMessage("Falta agregar un indicador en texto o un nombre", "Advertencia");
		}
	}

	// Auxiliary Methods

	private void parseAndCalculateIndicator() {
		if (indicatorFunctionIsNotEmpty()) {
			initializeNewIndicator();
			String sentence = indicatorFunction.trim();
			try {
				parseNewIndicator(sentence);
			} catch (InvalidFormattAtInputException e) {
				Windows.showWarningMessage("Error de calculo de indicador, mal escrito. Revisar.", "Advertencia");
				System.out.println(e);
			}
			try {
				calculateValueOfNewIndicator();
			} catch (Exception e) {
				// Windows.showWarningMessage("Error de calculo de indicador,
				// mal escrito. Revisar.", "Advertencia");
			}
		} else {
			Windows.showWarningMessage("Debe escribir una funcion", "Advertencia");
		}
	}

	private void initializeNewIndicator() {
		List<Operation> operations = new Vector<Operation>();
		newIndicator.setOperations(operations);
	}

	private void calculateValueOfNewIndicator() {
	//	newIndicator.setAccountValue(accountValue);
		newIndicatorValue = String.valueOf(newIndicator.calculateValue());
	}

	private void calculateValueOfIndicator() {
		chosenIndicator.setAccountValue(accountValue);
		indicatorCalculateValue = String.valueOf(chosenIndicator.calculateValue());
	}

	private void parseNewIndicator(String sentence) {
		IndicatorParser parser = new IndicatorParser();

		parser.parseImputText(sentence, newIndicator, accountValue, chosenIndicator, indicatorWindowThis);
		newIndicator.setFunction(sentence);
		newIndicator.setName(indicatorName);
	}

	// private void initializeChosenIndicator() {
	// chosenIndicator2 = new Indicator();
	// newIndicator = new Indicator();
	// }

	private boolean nameAndIndicatorFieldsComplete() {
		return (indicatorNameIsComplete() && indicatorFunctionIsNotEmpty());
	}

	private boolean indicatorNameIsComplete() {
		return indicatorName != "";
	}

	private boolean indicatorFunctionIsNotEmpty() {
		return indicatorFunction != "";
	}

	private void saveNewIndicator() {
		List<Indicator> indicatorsList = new Vector<Indicator>();
		IndicatorIO newIndicatorReader = indicatorIO.createIndicatorReader();
		IndicatorIO newIndicatorWritter = new IndicatorIO();
		try {
			indicatorsList = newIndicatorReader.readIndicators();
		} catch (IllegalArgumentException e) {
			Windows.showErrorMessage("Los Indicadores no se cargaron correctamente", "Error de carga");
		}
		try {
			calcNewIndicator();
			indicatorsList.add(newIndicator);
			newIndicatorWritter.writeIndicators(indicatorsList);

		} catch (Exception e) {

		}
	}

	///////////////////////////////////////////////////////////////////////////////
	// Setters - getters //

	// Indicators Setters - getters

	public List<Indicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}

	public Indicator getChosenIndicator() {
		return chosenIndicator;
	}

	public void setChosenIndicator(Indicator chosenIndicator) {
		this.chosenIndicator = chosenIndicator;
	}

	// Indicators Save Setters - getters

	public String getIndicatorName() {
		return indicatorName;
	}

	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}

	public String getIndicatorValue() {
		return indicatorValue;
	}

	public void setIndicatorValue(String indicatorValue) {
		this.indicatorValue = indicatorValue;
	}

	// Indicators Value Setters - getters

	public String getIndicatorCalculateValue() {
		return indicatorCalculateValue;
	}

	public void setIndicatorCalculateValue(String indicatorCalculateValue) {
		this.indicatorCalculateValue = indicatorCalculateValue;
	}

	// New Indicators Setters - getters

	public String getIndicatorFunction() {
		return indicatorFunction;
	}

	public void setIndicatorFunction(String indicatorFunction) {
		this.indicatorFunction = indicatorFunction;
	}

	public Indicator getNewIndicator() {
		return newIndicator;
	}

	public void setNewIndicator(Indicator newIndicator) {
		this.newIndicator = newIndicator;
	}

	public String getNewIndicatorValue() {
		return newIndicatorValue;
	}

	public void setNewIndicatorValue(String newIndicatorValue) {
		this.newIndicatorValue = newIndicatorValue;
	}

	public Indicator getChosenIndicator2() {
		return chosenIndicator2;
	}

	public void setChosenIndicator2(Indicator chosenIndicator2) {
		this.chosenIndicator2 = chosenIndicator2;
	}

	public List<Indicator> getIndicators2() {
		return indicators2;
	}

	public void setIndicators2(List<Indicator> indicators2) {
		this.indicators2 = indicators2;
	}

	public int getAccountValue() {
		return accountValue;
	}

	public void setAccountValue(int accountValue) {
		this.accountValue = accountValue;
	}

	public WindowOwner getParent() {
		return parent;
	}

	public void setParent(WindowOwner parent) {
		this.parent = parent;
	}

	// public void calcNew(int value2) {
	// Indicator indicator = new Indicator();
	// indicator.setName("Test2");
	// indicator.setFunction("test");
	// int value = 0;
	// value = value2;
	//
	// // ind2
	// Indicator indicator2 = new Indicator();
	// indicator2.setName("Test");
	// indicator2.setFunction("test");
	// List<Operation> operations2 = new Vector<Operation>(45);
	// OperationAccount opac2 = new OperationAccount();
	// opac2.setValue(0);
	// operations2.add(opac2);
	// OperatorAddition sum2 = new OperatorAddition();
	// operations2.add(sum2);
	// OperationValue opva2 = new OperationValue();
	// opva2.setValue(333);
	// operations2.add(opva2);
	// indicator2.setOperations(operations2);
	// indicator2.setAccountValue(value);
	//
	// ProgramParser parser = new ProgramParser();
	// // OperationValue opva = new OperationValue();
	// // opva.setValue(333);
	// // Sum sum = new Sum();
	// List<Operation> operations = new Vector<Operation>(45);
	// // operations.add(opac);
	// // operations.add(sum);
	// // operations.add(opva);
	// indicator.setOperations(operations);
	//
	// String sentence = indicatorFunction.trim();
	// try {
	// parser.parseImputText(sentence, indicator, value, indicator2);
	// } catch (InvalidFormattAtInputException e) {
	// Windows.showWarningMessage("Error de calculo de indicador, mal escrito.
	// Revisar.", "Advertencia");
	// System.out.println(e);
	// }
	// newIndicatorValue = String.valueOf(indicator.calculateValue());
	// indicatorCalculateValue = String.valueOf(indicator.calculateValue());
	// indicatorName = String.valueOf(chosenIndicator.calculateValue());
	// // saveNewIndicator(indicator);
	// }
	//
	// private void saveNewIndicator2(Indicator indicator) {
	// List<Indicator> indicatorsList = new Vector<Indicator>();
	// IndicatorIO newIndicatorReader = indicatorReader.createIndicatorReader();
	// try {
	// indicatorsList = newIndicatorReader.readIndicators();
	// newIndicatorValue = String.valueOf(chosenIndicator.calculateValue());
	// } catch (IllegalArgumentException | JsonParseException e) {
	// Windows.showErrorMessage("Los Indicadores no se cargaron correctamente",
	// "Error de carga");
	// }
	// IndicatorIO newIndicatorWritter = new IndicatorIO();
	//
	// indicatorsList.add(indicator);
	// newIndicatorWritter.writeIndicators(indicatorsList);
	//
	// // parseNewIndicator();
	// }

	IndicatorWindow algo() {
		return (IndicatorWindow) this.getParent();

	}

	public WindowOwner getParent1() {
		return parent1;
	}

	public void setParent1(WindowOwner parent1) {
		this.parent1 = parent1;
	}

	public IndicatorWindow getIndicatorWindowThis() {
		return indicatorWindowThis;
	}

	public void setIndicatorWindowThis(IndicatorWindow indicatorWindowThis) {
		this.indicatorWindowThis = indicatorWindowThis;
	}

	public Account getReceivedAccount() {
		return receivedAccount;
	}

	public void setReceivedAccount(Account receivedAccount) {
		this.receivedAccount = receivedAccount;
	}

	public AccountPeriod getReceivedAccountPeriod() {
		return receivedAccountPeriod;
	}

	public void setReceivedAccountPeriod(AccountPeriod receivedAccountPeriod) {
		this.receivedAccountPeriod = receivedAccountPeriod;
	}

}