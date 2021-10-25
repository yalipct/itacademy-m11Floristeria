package controller;

import java.util.*;

import model.Decoracion.Material;
import model.Floristeria;
import model.Producto;
import model.Ticket;
import persistence.TicketRepository;

public class FloristeriaController {

	private static TicketRepository repositoryTicket = new TicketRepository();

	public Floristeria crearFloristeria(String nomFloristeria) {

		Floristeria floristeria = null;
		try {
			floristeria = new Floristeria(nomFloristeria);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
		return floristeria;
	}

	public void afegirArbre(Floristeria floristeria, String name, double height, double price) {
		try {
			floristeria.addTree(name, height, price);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
	}

	public void afegirFlor(Floristeria floristeria, String name, String color, double price) {
		try {
			floristeria.addFlower(name, color, price);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
	}

	public void afegirDecoracio(Floristeria floristeria, String name, Material type, double price) {
		try {
			floristeria.addDecoration(name, type, price);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		} catch (MaterialException e) {
			System.err.println(e.getMessage());
		}
	}

	// stock obtener tots els arbres, flors i decoració que té la floristeria.
	public void getAllProductsStock(Floristeria floristeria) {
		floristeria.imprimirStock();
	}

	// imprime stock de una floristeria en conceto y un producto en concreto
	public void getProductStock(Floristeria floristeria, String product) {
		floristeria.imprimirProductStock(product);
	}

	// valor total del stock de la floristeria
	public void getStockValue(Floristeria floristeria) {
		floristeria.totalStockValue();
	}

	// eliminar producto(lanza excepción si no existe el producto)
	public void retirarProducto(Floristeria floristeria, int id) {
		try {
			floristeria.eliminarProducto(id);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
	}

	public void crearTicket(Floristeria floristeria, List<Producto> productosTicket) {
		Ticket ticket;
		try {
			ticket = new Ticket(productosTicket);
			repositoryTicket.addTicket(ticket);
			ticket.imprimirTicket();
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("No hay ningún producto con este ID");
		}

	}

	// imprimir tickets
	public void getAllTickets() {

		repositoryTicket.getAllTickets().forEach(Ticket::imprimirTicket);

	}

	public void getAllTicketsValue() {

		double totalVentas = repositoryTicket.getAllTickets().stream().mapToDouble(Ticket::getTotalPrice).sum();

		System.out.println("TOTAL VENTAS REALIZADAS: " + totalVentas);
	}

	/* Controlar NullPointerException y NumberFormatException */

	public boolean comprobarId(Floristeria floristeria, int id) {

		boolean idExists = floristeria.getAllProducts().stream().anyMatch(p -> p.getId() == id);
		return idExists;
	}

	public int comprobarIdExiste(Floristeria floristeria, int id) {

		int index = -1;
		for (int i = 0; i < floristeria.getAllProducts().size(); i++) {
			if (floristeria.getAllProducts().get(i).getId() == id) {
				index = i;
			}
		}
		return index;
	}

}
