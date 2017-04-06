package gui.viewModel;

import org.uqbar.commons.utils.Observable;

@Observable
public class LoginVM {

	private String token;
	private String resultado;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public void validar() {
		if (token.equals("1234")){
			this.resultado = "Ok";
		}
		else
		{
		this.resultado = "Bad";
		}	
	}


}
