package model;

import controller.CampoVacio;
import controller.MaterialException;

public class Decoracion extends Producto{
	
	public Decoracion(String name, Material tipoMaterial, double price) throws CampoVacio, MaterialException {
		super(name, price);	
				
		if(!tipoMaterial.equals(Material.MADERA) && !tipoMaterial.equals(Material.PLASTICO)) throw new MaterialException("Error- Tipo de decoración: madera ó plástico");
		
		this.tipoMaterial = tipoMaterial;
	}
	
	
	public Material getTipoMaterial() {
		return tipoMaterial;
	}


	public void setTipoMaterial(Material tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	
	public enum Material {
		MADERA, PLASTICO;
	}


	@Override
	public String toString() {
		return "Id=" + getId() + " Name:" + getName() + ", Material:" + tipoMaterial + ", Precio:" + getPrice();
	}
	
	
	private Material tipoMaterial;

}
