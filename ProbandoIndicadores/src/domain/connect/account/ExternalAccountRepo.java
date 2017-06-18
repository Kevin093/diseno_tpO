package domain.connect.account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import exception.InvalidFormattAtInputException;

// Clase donde se agregan los repositorios externos
public class ExternalAccountRepo {
	//
	public ExternalAccountRepo() {
		super();
	}

	// Método que después va a ser reemplazado por lo que se defina en el TP
	public String enterprisesFromService() {
		try {
			String projectDir = System.getProperty("user.dir");
			return readFile(projectDir + "\\resources\\enterprises.json");
		} catch (IOException e) {
			throw new InvalidFormattAtInputException("Archivo enterprises.json no encontrado");
		}
	}

	// Read File Method
	protected String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

}
