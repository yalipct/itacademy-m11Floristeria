package persistence;

import java.util.*;
import java.util.stream.Collectors;

import controller.CampoVacio;
import model.Producto;
import model.Ticket;

public class TicketRepository {
	
	private static List<Ticket> listaTickets = new ArrayList<Ticket>();
	double totalCount;

	public TicketRepository() {
		
	}
	
	public List<Ticket> getTicketsList(){
		
        return listaTickets;		

	}
	
	public String getAllTickets() {
		
		String listTickets;
		
		listTickets = listaTickets.stream()
				                    .map(t -> t.toString() + "\n")   
				                    .collect(Collectors.joining());
		
	     return listTickets;	
	
	}
	
	public void addTicket(Ticket ticket) throws CampoVacio{
		
		if(ticket == null) throw new CampoVacio("No se ha añadido ningún ticket");
		listaTickets.add(ticket);
	}

	/*
	public double getTotalCount() {
		totalCount = 0;
	
		listaTickets.forEach(t -> totalCount += t.getTotalPrice());
		
		return totalCount;
	}*/
	
	
	
	
}
