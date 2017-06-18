package gui.vm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.uqbar.commons.utils.Observable;

import domain.parser.ExpressionParser;
import domain.stockObjects.accounts.Enterprise;
import domain.stockObjects.indicator.Indicator;
import domain.stockObjects.indicator.OperationFactory;
import domain.stockObjects.indicator.operatings.Operation;
import domain.validators.ValidatorSemantic;
import domain.validators.ValidatorSyntactic;
import domain.validators.syntactic.ExpressionValidator;
import exception.InvalidFormattAtInputException;

@Observable
public class MainVM {
	private String calcSentence;
	private double result;
	static ExpressionParser parser = null;
	static ExpressionValidator parser2 = null;
	private String syntacticValidatedFunction;
	private ValidatorSyntactic validatorSyntactic = new ValidatorSyntactic();
	private ValidatorSemantic validatorSemantic = new ValidatorSemantic();
	private OperationFactory newOperationFactory = new OperationFactory();

	public void calulcateNewIndicator(){
		
		if(validatorSyntactic.validateFunction(calcSentence) && validatorSemantic.validateFunction(calcSentence)) {
			Enterprise enterprise = new Enterprise();
			Indicator indicator = new Indicator();
			indicator.setFunction(syntacticValidatedFunction);
			newOperationFactory.setAnio(2017);
			newOperationFactory.setEnterprise(enterprise);
			newOperationFactory.setIndicator(indicator);
			Operation newOperation = newOperationFactory.build();
			result = newOperation.getValue();
			syntacticValidatedFunction = calcSentence;
		
		} else{
			syntacticValidatedFunction = "No esta bien";
		}
	}
		
	
	public void calcu() {
		String sentence = calcSentence + "$";
		InputStream is = new ByteArrayInputStream(sentence.getBytes());
		if (parser == null)
			parser = new ExpressionParser(is);
		else
			ExpressionParser.ReInit(is);
		try {
			result = ExpressionParser.parseOneLine();
			{
			}

		} catch (Exception e) {
			System.out.println(e);
		} catch (Error e) {
			System.out.println(e);
			// Windows.showWarningMessage("Error de calculo de indicador, mal
			// escrito. Revisar.", "Advertencia");
			// System.out.println(e);

		}
	}
	// public void calcu2(){
	// String sentence = "(" + calcSentence + ")";
	// InputStream is = new ByteArrayInputStream(sentence.getBytes());
	// if (parser2 == null)
	// parser2 = new ExpressionValidator(is);
	// else
	// ExpressionValidator.ReInit(is);
	// try {
	// syntacticValidatedFunction = ExpressionValidator.validate(); {
	// }
	//
	// } catch (Exception e) {
	// syntacticValidatedFunction = "";
	// System.out.println(e);
	// } catch (Error e) {
	// syntacticValidatedFunction = "";
	// System.out.println(e);
	//// Windows.showWarningMessage("Error de calculo de indicador, mal escrito.
	// Revisar.", "Advertencia");
	//// System.out.println(e);
	//
	// }
	// }

	public void calcu2() {
		ValidatorSyntactic validator = new ValidatorSyntactic();
		if(validator.validateFunction(calcSentence)) {
			syntacticValidatedFunction = calcSentence;
		} else{
			syntacticValidatedFunction = "No esta bien";
		}
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getSyntacticValidatedFunction() {
		return syntacticValidatedFunction;
	}

	public void setSyntacticValidatedFunction(String syntacticValidatedFunction) {
		this.syntacticValidatedFunction = syntacticValidatedFunction;
	}
	

	public String getCalcSentence() {
		return calcSentence;
	}

	public void setCalcSentence(String calcSentence) {
		this.calcSentence = calcSentence;
	}

	
	

}