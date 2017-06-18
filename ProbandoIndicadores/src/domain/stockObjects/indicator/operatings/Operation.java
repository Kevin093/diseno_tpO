package domain.stockObjects.indicator.operatings;

import domain.stockObjects.indicator.operators.Operator;

public class Operation implements Operating {
	public Operator operador;
	public Operating operando1;
	public Operating operando2;

	public Operation() {
	}

	@Override
	public Integer getValue() {
		return operador.calculate(operando1, operando2);
	}
}