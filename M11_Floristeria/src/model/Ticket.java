package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controller.CampoVacio;

public class Ticket {

	private int id;
	private static int counter = 1;
	private LocalDateTime date;
	private List<Producto> productosTicket = new ArrayList<Producto>();
	double totalCount;

	/* formato de la fecha */
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("'FECHA:' dd/MM/yyyy	'HORA:' HH:mm");

	public Ticket(List<Producto> productosTicket) throws CampoVacio {
		
		if(productosTicket.isEmpty()) {
			throw new CampoVacio("Debe haber comprado al menos un producto para generar un ticket");
		}
		this.id = counter++;
		this.date = LocalDateTime.now();

	}

	public int getId() {
		return id;
	}

	public void addProduct(Producto producto) {
		productosTicket.add(producto);
	}

	public double getTotalPrice() {

		totalCount = 0;

		productosTicket.forEach(p -> totalCount += p.getPrice());

		return totalCount;

	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", date=" + date.format(format) + ", productosTicket=" + productosTicket + ", totalCount="
				+ totalCount + "]";
	}
	
	public void imprimirTicket() {
		productosTicket.forEach(System.out::println);
	}
}
