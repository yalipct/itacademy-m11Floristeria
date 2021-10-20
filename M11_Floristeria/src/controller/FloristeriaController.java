package controller;

import model.Decoracion.Material;
import model.Floristeria;

public class FloristeriaController {

	public Floristeria crearFloristeria(String nomFloristeria) throws CampoVacio {
		
		return new Floristeria(nomFloristeria);
	}
	
	public void afegirArbre (Floristeria floristeria, String name, double height, double price) {
		
	}
	
	public void afegirFlor(Floristeria floristeria, String name, String color, double price) {
		
	}
	
	public void afegirDecoracio(Floristeria floristeria, String name, Material type, double price) {
		
	}	
	
	//stock: imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria. 
	public void getAllProductsStock(Floristeria floristeria) {
		
	}	
	
	
}

