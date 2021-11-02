package view;


import controller.FloristeriaController;
import model.Decoracion.Material;
import model.Floristeria;

public class FloristeriaApp {

	public static void main(String[] args) {

		FloristeriaController controller = new FloristeriaController();
		Floristeria floristeria = controller.crearFloristeria("Floristeria IT Academy");
		controller.afegirArbre(floristeria, "Castaño", 1.40, 1.50);
		controller.afegirFlor(floristeria, "rosa", "roja", 1.50);
		controller.afegirDecoracio(floristeria, "mesa", Material.MADERA, 1.50);
		controller.afegirDecoracio(floristeria, "silla", Material.PLASTICO, 1.30);

		FloristeriaSwing Swing = new FloristeriaSwing(floristeria, controller);

	}

}