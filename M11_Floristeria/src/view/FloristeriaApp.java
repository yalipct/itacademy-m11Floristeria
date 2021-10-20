package view;

import controller.CampoVacio;
import controller.FloristeriaController;
import controller.MaterialException;
import model.Decoracion.Material;
import model.Floristeria;

public class FloristeriaApp {
	
	private static FloristeriaController controller = new FloristeriaController();
	
	
	public static void main(String[] args) throws CampoVacio, MaterialException {
		
		//pruebas
		Floristeria f1 = controller.crearFloristeria("Jardinets");
		f1.addTree("Limonero", 1.5, 10.5);
		f1.addTree("Casta�o", 1, 12);
		f1.addFlower("Lirio", "rosa", 2);
		
		//material de la decoraci�n
		Material material = Material.MADERA;
		f1.addDecoration("Jarr�n", material, 2.5);
		
		//imprimir stock
		f1.imprimirStock();
		
		
		
		//men� principal para crear floristeria y las opciones(a�adir productos/salir)
		
		//men� a�adir cada producto
	}

}
