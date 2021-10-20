package view;

import controller.FloristeriaController;
import model.Decoracion.Material;
import model.Floristeria;

public class FloristeriaApp {
	
	private static FloristeriaController controller = new FloristeriaController();
	
	
	public static void main(String[] args) {
		
		//pruebas
		Floristeria f1 = controller.crearFloristeria("Jardinets");			
		
		//controlar nulos, si no se crea la florsiteria...(si se introduce un número)
		
		controller.afegirArbre(f1, "Limonero", 1.5, 10.5);
		controller.afegirArbre(f1, "Castaño", 1, 12);
		controller.afegirFlor(f1, "Lirio", "rosa", 2);
		
		//material de la decoración
		Material material = Material.MADERA;
		controller.afegirDecoracio(f1, "Jarrón", material, 2.5);
		
		//imprimir stock		
		controller.getAllProductsStock(f1);
		
		
		//menú principal para crear floristeria y las opciones(añadir productos/salir)
		
		//menú añadir cada producto
		
		//menú para ver el stock de cada floristeria(pasandole esta por parámetro)
	}

}
