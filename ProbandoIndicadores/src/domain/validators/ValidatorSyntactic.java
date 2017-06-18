package domain.validators;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import domain.validators.syntactic.ExpressionValidator;

public class ValidatorSyntactic {
	static ExpressionValidator syntacticValidatorChecker = null;

	public boolean validateFunction(String function){
		String sentence = "(" + function + ")";
		InputStream is = new ByteArrayInputStream(sentence.getBytes());
		if (syntacticValidatorChecker == null)
			syntacticValidatorChecker = new ExpressionValidator(is);
		else
			ExpressionValidator.ReInit(is);
		try {
			ExpressionValidator.validate();{}
			return true;
		} catch (Exception e) {
			System.out.println(e);
		} catch (Error e) {
			System.out.println(e);
			// Windows.showWarningMessage("Error de calculo de indicador, mal
			// escrito. Revisar.", "Advertencia");
			// System.out.println(e);
		}
		return false;

	}

}
