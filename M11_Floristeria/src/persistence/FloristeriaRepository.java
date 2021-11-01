package persistence;

import java.util.*;
import java.util.stream.Collectors;
import controller.CampoVacio;
import model.Producto;

public class FloristeriaRepository {

	private static List<Producto> listaProductos = new ArrayList<>();

	public FloristeriaRepository() {

	}

	// lo necesito para imprimir la lista directamente en la parte gráfica.
	public String getListProducts() {

		// Ordenar por tipo de objeto con título.
		String lista = listaProductos.stream().map(p -> p.toString() + "\n").collect(Collectors.joining());
		return lista;

	}

	public List<Producto> getAllProducts() {

		return listaProductos;
	}

	public void addProduct(Producto producto) throws CampoVacio {

		if (producto == null)
			throw new CampoVacio("No se ha añadido producto");

		listaProductos.add(producto);
	}

	// eliminado throws CampoVacio
	public void removeProduct(String producto, int id) {

		if (listaProductos.stream().anyMatch(p -> p.getId() == id)) {
			listaProductos.removeIf(p -> p.getId() == id);
		} else {
			System.out.println("No se ha encontrado ningún producto: " + producto + " con este id.");
		}
	}

}
