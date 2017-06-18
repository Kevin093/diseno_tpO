package domain.stockObjects.indicator;

import domain.parser.IndicatorParser;
import domain.stockObjects.accounts.Enterprise;
import domain.stockObjects.indicator.operatings.Operation;

public class OperationFactory {

	private Integer anio;
	private Enterprise enterprise;
	private Indicator indicator;
	
	// Main Methods
	
	public Operation build(){
		IndicatorParser parser = new IndicatorParser();
		return parser.parse(indicator.getFunction());
	}

	// Setters - Getters
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	public Indicator getIndicator() {
		return indicator;
	}

	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

}
