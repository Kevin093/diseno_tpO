import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import gui.windows.Login;

public class LectorNotas extends Application {

	public static void main(String[] args) {
		new LectorNotas().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new Login(this);
	}

}
