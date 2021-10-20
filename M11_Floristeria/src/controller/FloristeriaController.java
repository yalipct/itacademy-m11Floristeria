package controller;

import model.Decoracion.Material;
import model.Floristeria;

public class FloristeriaController {

	public Floristeria crearFloristeria(String nomFloristeria) {
		
		Floristeria floristeria = null;
		try {
			floristeria = new Floristeria(nomFloristeria);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
		return floristeria;
	}
	
	public void afegirArbre (Floristeria floristeria, String name, double height, double price) {
		try {
			floristeria.addTree(name, height, price);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void afegirFlor(Floristeria floristeria, String name, String color, double price) {
		try {
			floristeria.addFlower(name, color, price);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void afegirDecoracio(Floristeria floristeria, String name, Material type, double price) {
		try {
			floristeria.addDecoration(name, type, price);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		} catch (MaterialException e) {
			System.err.println(e.getMessage());
		}
	}	
	
	//stock: imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria. 
	public void getAllProductsStock(Floristeria floristeria) {
		floristeria.imprimirStock();
	}	
	
	//imprime stock de una floristeria en conceto y un producto en concreto
	public void getProductStock(Floristeria floristeria, String product) {
		floristeria.imprimirProductStock(product);
	}
	
}

