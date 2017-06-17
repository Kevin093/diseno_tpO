
public class Suma implements Operador {

	@Override
	public int getPrecedencia() {
		return 0;
	}

	@Override
	public Integer calculate(Operando operando1, Operando operando2) {
		return operando1.getValue() + operando2.getValue();
	}

}
