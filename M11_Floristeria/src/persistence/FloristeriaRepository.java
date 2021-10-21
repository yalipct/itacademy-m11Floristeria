package persistence;

import java.util.*;

import controller.CampoVacio;
import model.Producto;

public class FloristeriaRepository {
	
	private static List<Producto> listaProductos = new ArrayList<>();

	public FloristeriaRepository() {
		
	}
	
	public List<Producto> getAllProducts(){
		
		return new ArrayList<>(listaProductos);
	}
	
	public void addProduct(Producto producto) throws CampoVacio{
		
		if(producto == null) throw new CampoVacio("No se ha añadido producto");
		listaProductos.add(producto);
	}

	//lanza excepción si el producto no existe
	public void removeProduct(int id) throws CampoVacio{
		
		
	}
	
}
