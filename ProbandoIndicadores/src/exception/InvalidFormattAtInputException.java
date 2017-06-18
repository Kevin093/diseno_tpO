package exception;

import javax.swing.JOptionPane;

public class InvalidFormattAtInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFormattAtInputException(String message) {
		super(message);
		System.out.println(message);
		JOptionPane.showMessageDialog(null, message, message, JOptionPane.INFORMATION_MESSAGE);
	}

	public InvalidFormattAtInputException() {
		super();
	}

	public InvalidFormattAtInputException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public InvalidFormattAtInputException(Throwable throwable) {
		super(throwable);
	}


}