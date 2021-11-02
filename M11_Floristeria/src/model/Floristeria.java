package model;

import java.util.List;
import java.util.stream.Collectors;
import controller.CampoVacio;
import controller.MaterialException;
import model.Decoracion.Material;
import persistence.FloristeriaRepository;

public class Floristeria {

	private String nomFloristeria;
	// repositorio Floristeria
	private FloristeriaRepository repository = new FloristeriaRepository();

	public Floristeria(String name) throws CampoVacio {

		if (name.equals(""))
			throw new CampoVacio("Debe introducir el nombre de la Floristeria");

		this.nomFloristeria = name;
	}

	public String getNomFloristeria() {
		return nomFloristeria;
	}

	public void addTree(String name, double height, double price) throws CampoVacio {

		Arbol arbol = new Arbol(name, height, price);
		repository.addProduct(arbol);
	}

	public void addFlower(String name, String color, double price) throws CampoVacio {

		Flor flor = new Flor(name, color, price);
		repository.addProduct(flor);
	}

	public void addDecoration(String name, Material type, double price) throws CampoVacio, MaterialException {

		Decoracion decor = new Decoracion(name, type, price);
		repository.addProduct(decor);
	}

	// obtener todos los productos
	public List<Producto> getAllProducts() {
		return repository.getAllProducts();
	}

	// muestra todo el stock de productos
	public String imprimirStock() {
		
		String listaProductos = "";
		
		List<String> productStock = repository.getAllProducts().stream().map(p -> p.getClass().getSimpleName())
				.distinct().collect(Collectors.toList());
		
		// llama al método imprimirProductStock
		for (String s : productStock) {
			listaProductos += imprimirProductStock(s) + "\n";
		}
		
		String stock = "------------------------------------------" + "\n" + " Stock de Productos Floristería " 
				+ getNomFloristeria() + "\n" + "------------------------------------------" + "\n" + listaProductos;
		
		return stock;
	}

	// muestra el stock de un producto concreto
	public String imprimirProductStock(String product) {
		String listaOrdenada;

		if (repository.getAllProducts().isEmpty()) {
			listaOrdenada = "No hay productos.";
		}

		listaOrdenada = repository.getAllProducts().stream().filter(p -> p.getClass().getSimpleName().equals(product))
				.map(p -> p.toString() + "\n").collect(Collectors.joining());

		return listaOrdenada;
	}

	// La floristria té un registre del valor total del stock que te.
	public String totalStockValue() {

		Double valor = repository.getAllProducts().stream().mapToDouble(Producto::getPrice).sum();

		String valorString = "------------------------" + "\n" + "Valor total del Stock:" + "\n"
				+ "------------------------" + "\n" + Double.toString(valor) + " €";

		return valorString;
	}

	// eliminar un producto del repository por id
	public void eliminarProducto(String product, int id) {
		repository.removeProduct(product, id);
	}

}
