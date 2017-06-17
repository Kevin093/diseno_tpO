
public interface Operador {

	public int getPrecedencia();
	
	public Integer calculate(Operando operando1, Operando operando2);

}
