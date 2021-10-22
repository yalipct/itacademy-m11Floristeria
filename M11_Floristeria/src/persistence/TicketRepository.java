package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import controller.CampoVacio;
import model.Producto;
import model.Ticket;

public class TicketRepository {
	
	private static List<Ticket> listaTickets = new ArrayList<Ticket>();
	double totalCount;

	public TicketRepository() {
		
	}
	
	public List<Ticket> getAllTickets(){
		
        return listaTickets;		

	}
	
	public void addTicket(Ticket ticket) throws CampoVacio{
		
		if(ticket == null) throw new CampoVacio("No se ha añadido ningún ticket");
		listaTickets.add(ticket);
	}

	public void removeProduct(int id) throws CampoVacio{		

		Predicate<Ticket> ticket = t -> t.getId() == id;
		
		if(listaTickets.stream().anyMatch(ticket)) {
			
			listaTickets.removeIf(ticket);
			System.out.println("Ticket id:" + id + " eliminado correctamente");
			
		} else {
			throw new CampoVacio("No se ha encontrado el ticket con id: " + id);
		}
		
	}
	
	public double getTotalCount() {
		totalCount = 0;
	
		listaTickets.forEach(t -> totalCount += t.getTotalPrice());
		
		return totalCount;
	}
	
	
	
	
}
