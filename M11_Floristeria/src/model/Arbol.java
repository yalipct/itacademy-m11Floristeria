package model;

import controller.CampoVacio;

public class Arbol extends Producto{
	
	public Arbol(String name, double height, double price) throws CampoVacio {
		super(name, price);
		
		this.height = height;
	}

	
	@Override
	public String toString() {
		return "Id=" + getId() + " Name:" + getName() + ", Height:" + height + ", Precio:" + getPrice();
	}

	private double height;
}