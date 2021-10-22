package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

	List<Producto> productosTicket = new ArrayList<Producto>();
	int id; //
	static int counter = 1;
	LocalDate date;
	double totalCount;
	
	   public Ticket() {
		
	   this.id = counter++;
	   this.date = LocalDate.now();   
	  
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

}
