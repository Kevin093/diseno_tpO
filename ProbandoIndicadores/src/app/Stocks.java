package app;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import gui.windows.MainWindow;

public class Stocks extends Application {
	public static void main(String[] args) {
		new Stocks().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new MainWindow(this);
	}
}