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
	
	   if(productosTicket.isEmpty()) {
	       throw new CampoVacio("Debe haber comprado al menos un producto para generar un ticket");
	   }
	   this.productosTicket = productosTicket;  
	   this.id = counter++;
	   
	   date = date.now();
	   this.finalDate = date.format(formatoFecha);
	   
	   }
		
	public int getId () {
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

	
	//Corregir estética. Quitar array?
	@Override
	public String toString() {
		return "Id = " + id + "Fecha = " + finalDate + "[Productos = " + productosTicket + " ]" + 
				", totalCount=" + totalCount;
	}

}
