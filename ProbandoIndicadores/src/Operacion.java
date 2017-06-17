
public class Operacion implements Operando{
	public Operador operador;
	public Operando operando1;
	public Operando operando2;
	

	public Operacion() {
	}
	
	@Override
	public Integer getValue() {
		
		return operador.calculate(operando1, operando2);
	}
}