package view;

import javax.swing.JFrame;
import controller.CampoVacio;
import controller.FloristeriaController;
import model.Arbol;
import model.Floristeria;
import persistence.FloristeriaRepository;

public class FloristeriaApp {

	public static void main(String[] args) throws CampoVacio {

FloristeriaController controller = new FloristeriaController();
Floristeria floristeria = controller.crearFloristeria("Floristeria IT Academy");
controller.afegirArbre(floristeria,"Castaño", 1.40, 1.50);
controller.afegirArbre(floristeria,"Limonero", 1.20, 1.30);

FloristeriaSwing Swing = new FloristeriaSwing(floristeria, controller);

	}
	
}