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
		//System.out.println("�rbol a�adido correctamente");

	}

	public void addFlower(String name, String color, double price) throws CampoVacio {

		Flor flor = new Flor(name, color, price);
		repository.addProduct(flor);
		//System.out.println("Flor a�adida correctamente");

	}

	public void addDecoration(String name, Material type, double price) throws CampoVacio, MaterialException {

		Decoracion decor = new Decoracion(name, type, price);
		repository.addProduct(decor);
		//System.out.println("Decoraci�n a�adida correctamente");

	}

	// obtener todos los productos
	public List<Producto> getAllProducts() {
		return repository.getAllProducts();
	}

	// muestra todo el stock de productos
	public void imprimirStock() {

		List<String> productStock = repository.getAllProducts().stream().map(p -> p.getClass().getSimpleName())
				.distinct().collect(Collectors.toList());

		System.out.println("------------------------------------------");
		System.out.println(" Stock de Productos Florister�a " + getNomFloristeria());
		System.out.println("------------------------------------------");

		// llama al m�todo imprimirProductStock
		for (String s : productStock) {
			imprimirProductStock(s);
		}
	}	

	// muestra el stock de un producto concreto
	public String imprimirProductStock(String product) {
	 String listaOrdenada;
	 
		if(repository.getAllProducts().isEmpty()) {
			listaOrdenada = "No hay productos.";
		}
		       
		listaOrdenada = repository.getAllProducts().stream()
		                                           .filter(p -> p.getClass().getSimpleName().equals(product))
		                                           .map(p -> p.toString() + "\n")
		                                           .collect(Collectors.joining());
		
		
		return listaOrdenada;
	}
	
	//La floristria t� un registre del valor total del stock que te. 
	public String totalStockValue() {
		
		Double valor = repository.getAllProducts().stream()
		.mapToDouble(Producto::getPrice)
		.sum();
		
		String valorString = "------------------------" + "\n" + "Valor total del Stock:" 
		+ "\n" + "------------------------" + "\n" + Double.toString(valor) + " �";
	
		return valorString;
	}

	//eliminar un producto del repositorypor id
	public void eliminarProducto(int id) throws CampoVacio{		
		repository.removeProduct(id);
	}

}
