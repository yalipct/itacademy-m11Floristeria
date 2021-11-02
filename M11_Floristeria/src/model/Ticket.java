package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import controller.CampoVacio;

public class Ticket {

	private List<Producto> productosTicket = new ArrayList<Producto>();
	private int id; //
	private static int counter = 1;
	private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("'FECHA:' dd/MM/yyyy 'HORA:' HH:mm");
	private String finalDate;
	private LocalDateTime date;
	private double totalCount;

	public Ticket(List<Producto> productosTicket) throws CampoVacio {

		if (productosTicket.isEmpty()) {
			throw new CampoVacio("Debe haber comprado al menos un producto para generar un ticket");
		}
		this.productosTicket = productosTicket;
		this.id = counter++;

		this.date = LocalDateTime.now();
		this.finalDate = date.format(formatoFecha);
		this.totalCount = getTotalPrice();
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


	//Método para ordenar los productos del array y que aparezcan más legibles en el ticket.	
	
	public String ordenarTicket() {
		
		String productosTicket1 = "";
		
		for(int i = 0; i < productosTicket.size(); i++) {
			
			if (i == productosTicket.size() - 1) {
				productosTicket1 += productosTicket.get(i).toString();
			} else {
				productosTicket1 += productosTicket.get(i).toString() + "\n";
			}
		}
		return productosTicket1;
	}
	
	
	@Override
	public String toString() {
		return "Id = " + id + " " + finalDate + "\n" +  "[Productos = ]" + "\n" + ordenarTicket() + "\n" +
				"totalCount=" + totalCount + "\n-------------------------------------------------------" + "\n";
	}
}
