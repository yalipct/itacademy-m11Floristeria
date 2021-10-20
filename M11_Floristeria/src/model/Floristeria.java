package model;


import controller.CampoVacio;

public class Floristeria {

	private String nomFloristeria;	
	
	public Floristeria(String name) throws CampoVacio {
		
		if(name.equals("")) throw new CampoVacio("Debe introducir el nombre de la Floristeria"); 
		
		this.nomFloristeria = name;
	}

	public String getNomFloristeria() {
		return nomFloristeria;
	}
		
}
