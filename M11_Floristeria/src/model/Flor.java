package model;

import controller.CampoVacio;

public class Flor extends Producto{
	
	public Flor(String name, String color, double price) throws CampoVacio {
		super(name, price);
		if(color.equals("")) throw new CampoVacio("Debe introducir un valor en el campo color");
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "Id=" + getId() + " Name:" + getName() + ", Color:" + color + ", Precio:" + getPrice();
	}


	private String color;
}
