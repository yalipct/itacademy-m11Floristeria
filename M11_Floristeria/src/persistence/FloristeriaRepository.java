package persistence;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import controller.CampoVacio;
import model.Producto;

public class FloristeriaRepository {
	
	private static List<Producto> listaProductos = new ArrayList<>();

	public FloristeriaRepository() {
		
	}
	
	//lo necesito para imprimir la lista directamente en la parte gráfica.
	public String getListProducts() {
		
		//Ordenar por tipo de objeto con título.	
	    String lista = listaProductos.stream()
	                                 .map(p -> p.toString() + "\n")
	                                 .collect(Collectors.joining());
			return lista;
			
		}

	public List<Producto> getAllProducts(){
		
		return listaProductos;
	}
	
	public void addProduct(Producto producto) throws CampoVacio{
		
		if(producto == null) throw new CampoVacio("No se ha añadido producto");
		listaProductos.add(producto);
	}

	//lanza excepción si el producto no existe
	public void removeProduct(int id) throws CampoVacio{		
		
		Predicate<Producto> product = p -> p.getId() == id;
		
		if(listaProductos.stream().anyMatch(product)) {
			listaProductos.removeIf(product);
			//System.out.println("Producto id:" + id + " eliminado correctamente");
		}else {
			throw new CampoVacio("No se ha encontrado el producto con id: " + id);
		}
		
	}
	
}
