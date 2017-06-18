package domain.stockObjects.indicator.operators;

import domain.stockObjects.indicator.operatings.Operating;

public interface Operator {

	public int getPrecedencia();
	
	public Integer calculate(Operating operando1, Operating operando2);

}
