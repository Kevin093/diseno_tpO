package domain.messageWindows;

import javax.swing.JOptionPane;

public abstract class Windows {
	
	public static void showErrorMessage(String message, String title){
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.ERROR_MESSAGE);
	}
	public static void showOkMessage(String message, String title){
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.INFORMATION_MESSAGE);
	}
	public static void showWarningMessage(String message, String title){
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.WARNING_MESSAGE);
	}
		
}
