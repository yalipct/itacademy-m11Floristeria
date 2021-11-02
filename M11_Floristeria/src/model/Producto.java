package model;

import controller.CampoVacio;

public abstract class Producto {

	private int id;
	private static int COUNTER_PRODUCTS = 1;
	private String name;	
	private double price;

	public Producto(String name, double price) throws CampoVacio {
		
		if(name.equals("")) throw new CampoVacio("Debe introducir un valor en el campo nombre");
		
		this.id = COUNTER_PRODUCTS++;
		this.price = price;
		this.name = name;
	}	
	
	
	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}
		
}
