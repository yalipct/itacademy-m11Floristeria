package controller;

import java.util.*;
import java.util.stream.Collectors;

import model.Decoracion.Material;
import model.Floristeria;
import model.Producto;
import model.Ticket;
import persistence.TicketRepository;

public class FloristeriaController {

	private static TicketRepository repositoryTicket = new TicketRepository();
			
	public TicketRepository getTicketRepository () {

		return repositoryTicket;
		
	}

	public Floristeria crearFloristeria(String nomFloristeria) {
		
		Floristeria floristeria = null;
		try {
			floristeria = new Floristeria(nomFloristeria);
		} catch (CampoVacio e) {
			System.err.println(e.getMessage());
		}
		return floristeria;
	}
	
	public void afegirArbre (Floristeria floristeria, String name, double height, double price){
		
		try {
			floristeria.addTree(name, height, price);
		} catch (CampoVacio e) {
			e.getMessage();
		}
		
	}
	
	public void afegirFlor(Floristeria floristeria, String name, String color, double price) {
		try {
			floristeria.addFlower(name, color, price);
		} catch (CampoVacio e) {
			e.getMessage();
		}
	}
	
	public void afegirDecoracio(Floristeria floristeria, String name, Material type, double price) {
		try {
			floristeria.addDecoration(name, type, price);
		} catch (CampoVacio e) {
			e.getMessage();
		} catch (MaterialException e) {
			e.getMessage();
		}
	}	
	
	//stock obtener tots els arbres, flors i decoració que té la floristeria. 
	public void getAllProductsStock(Floristeria floristeria) {
		floristeria.imprimirStock();
	}	
	
	//imprime stock de una floristeria en conceto y un producto en concreto
	public String getProductStock(Floristeria floristeria, String product) {
		String listaOrdenada = floristeria.imprimirProductStock(product);
		return listaOrdenada;
		
	}
	
	//valor total del stock de la floristeria
	public String getStockValue(Floristeria floristeria) {
		String valor = floristeria.totalStockValue();
		return valor;
	}
	
	//eliminar producto()
	public void retirarProducto(Floristeria floristeria, String product, int id) {

			floristeria.eliminarProducto(product, id);
	}

	public void crearTicket(Floristeria floristeria, List<Producto> productosTicket) {
		Ticket ticket;
		try {
			ticket = new Ticket(productosTicket);
			repositoryTicket.addTicket(ticket);
		} catch (CampoVacio e) {
			e.getMessage();
		} catch (Exception e) {
			System.err.println("No hay ningún producto con este ID");
		}

	}

	// imprimir tickets
	public String getAllTickets() {

		String listaTickets;

		if (repositoryTicket.getAllTicketsList().size() == 0) {
			listaTickets = "-------------- - ------------------" + "\n" + "No se encontraron tickets" + "\n"
					+ "------------- - -------------------" + "\n";
		} else {

			listaTickets = repositoryTicket.getAllTicketsList().stream().map(t -> t.toString() + "\n")
					.collect(Collectors.joining());
		}
		
		return listaTickets;

	}

	//valor total del ticket
	public String getAllTicketsValue() {

		String valorString;

		if (repositoryTicket == null) {
			valorString = "------------------------" + "\n" + "Valor total de las compras:" + "\n"
					+ "------------------------" + "\n" + "0 €";
		} else {

			double totalVentas = repositoryTicket.getAllTicketsList().stream().mapToDouble(Ticket::getTotalPrice).sum();

			valorString = "------------------------" + "\n" + "Valor total de las compras:" 
					+ "\n" + "------------------------" + "\n" + Double.toString(totalVentas) + " €";
		}
		return valorString;

	}	
	
	
}
