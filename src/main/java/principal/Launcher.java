package principal;

import model.data.DBGenerator;
import view.VentanaBienvenida;

public class Launcher {

	public static void main(String[] args) throws ClassNotFoundException {
		DBGenerator.iniciarBD("Universidad");
		VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
	}
}