
public class Multiplicacion implements Operador {

	@Override
	public int getPrecedencia() {
		return 1;
	}

	@Override
	public Integer calculate(Operando operando1, Operando operando2) {
		return  operando1.getValue() * operando2.getValue();
	}

}
