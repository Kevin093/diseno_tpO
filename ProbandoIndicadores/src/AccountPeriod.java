

public class AccountPeriod implements Operando {
	private Integer value;
	private int year;
	public AccountPeriod(){
		this.setValue(0);
		this.setYear(0);
	}
	
	public AccountPeriod(int value, int year) {
		this.setValue(value);
		this.setYear(year);
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getYear() {
		return year;
	}
	public String toString() {
		return String.valueOf(year);
	}

	public void setYear(int year) {
		this.year = year;
	}

}
