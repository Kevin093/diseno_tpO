package domain.stockObjects.indicator.operators;

import domain.stockObjects.indicator.operatings.Operating;

public class OperatorSubstraction implements Operator{

	@Override
	public int getPrecedencia() {
		return 0;
	}

	@Override
	public Integer calculate(Operating operando1, Operating operando2) {
		return operando1.getValue() - operando2.getValue();
	}

}
