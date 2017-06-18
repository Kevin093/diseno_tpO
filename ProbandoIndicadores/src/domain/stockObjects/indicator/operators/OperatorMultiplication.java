package domain.stockObjects.indicator.operators;

import domain.stockObjects.indicator.operatings.Operating;

public class OperatorMultiplication implements Operator{


	@Override
	public int getPrecedencia() {
		return 1;
	}

	@Override
	public Integer calculate(Operating operando1, Operating operando2) {
		return  operando1.getValue() * operando2.getValue();
	}

}

