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
		f1.addTree("Castaño", 1, 12);
		f1.addFlower("Lirio", "rosa", 2);
		
		//material de la decoración
		Material material = Material.MADERA;
		f1.addDecoration("Jarrón", material, 2.5);
		
		//imprimir stock
		f1.imprimirStock();
		
		
		
		//menú principal para crear floristeria y las opciones(añadir productos/salir)
		
		//menú añadir cada producto
	}

}
