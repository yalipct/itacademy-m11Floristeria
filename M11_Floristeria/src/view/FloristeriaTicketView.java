package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import controller.CampoVacio;
import controller.FloristeriaController;
import model.Floristeria;
import model.Producto;
import model.Ticket;
import persistence.TicketRepository;

public class FloristeriaTicketView extends JFrame {
	
	TicketRepository repositoryTick;
	marcoEmergente marcoEm;
	Floristeria floristeria;
	FloristeriaController controller;
	ImageIcon icon = new ImageIcon("src/view/receipt1.gif");
	JLabel labelIcon = new JLabel(icon); 
	
		
	public FloristeriaTicketView (Floristeria floristeria, FloristeriaController controller) {
			
		this.floristeria = floristeria;
		this.controller = controller;
		
		Toolkit screenDisplay =  Toolkit.getDefaultToolkit();
		Dimension screenSize = screenDisplay.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/2, screenHeight/2);
		setLocation(screenWidth/4, screenHeight/4);
		
		setIconImage(screenDisplay.getImage("src/view/dolar.png"));				
		setTitle("Gestión de tickets");    
		
		LaminaBotones laminaBotones = new LaminaBotones();
		add(laminaBotones, BorderLayout.SOUTH);
		
		//labelIcon.setBounds(200, 100,200, 200);
		add(labelIcon, BorderLayout.CENTER);
               
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	class LaminaBotones extends JPanel {
		
		JButton crearTicket = new JButton("Crear ticket");
		JButton mostrarCompras = new JButton("Mostrar cuentas");
		//otro nombre.
		JButton ganancias = new JButton("Ver ganancias");
		laminaCrear laminaCrear;
		laminaTickets laminaTickets;
				
		public LaminaBotones() {
			
			crearTicket.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					   laminaCrear = new laminaCrear();
					   marcoEm = new marcoEmergente();
					   marcoEm.add(laminaCrear);
					   		   
				   } });
			mostrarCompras.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					   laminaTickets = new laminaTickets();
					   marcoEm = new marcoEmergente();
					   marcoEm.add(laminaTickets);
				   } });
			ganancias.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) {
					   JOptionPane.showMessageDialog(null, controller.getAllTicketsValue());
				   } });
			
			add(crearTicket);
			add(mostrarCompras);
			add(ganancias);
			
		}
	}
	
	class laminaCrear extends JPanel {
			
		List<Producto> array = floristeria.getAllProducts();
		ListModel<Producto> model; 
	    
		final DefaultListModel<Producto> model2 = new DefaultListModel<Producto>();
	    final DefaultListModel<Producto> model1 = new DefaultListModel<Producto>();
	    
	    JList<Producto> productsList = new JList<Producto>();
	    JList<Producto> selectedItems = new JList<Producto>();

	    JTextArea stock = new JTextArea();
	
	    JButton añadir = new JButton("Añadir>>>");
	    JButton eliminar = new JButton("<<Eliminar");
	    JButton crear = new JButton("Crear Ticket");

		
	  
		public laminaCrear() {
			
			setLayout(null);
			
			productsList.setBounds(20, 11, 250, 290);
					
			selectedItems.setBounds(393, 11, 250, 290);
			
			
			añadir.setBounds(280, 120, 100,30);
			crear.setBounds(275, 220, 110, 30);
			eliminar.setBounds(280, 150, 100, 30);
			
						
	        for (int i = 0; i < array.size(); i++) {
	 	          model1.addElement(array.get(i));
	         } 
	        
	        productsList.setModel(model1);
	        selectedItems.setModel(model2);
	        
		
		    productsList.setFixedCellHeight(15);
		    productsList.setFixedCellWidth(500);
		    productsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		    productsList.setVisibleRowCount(4);
	        add(new JScrollPane(productsList));
	        
	        
	        selectedItems.setFixedCellHeight(15);
	        selectedItems.setFixedCellWidth(100);
	        selectedItems.setVisibleRowCount(4);
	        //selectedItems.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	        add(new JScrollPane(selectedItems));

	        añadir.addActionListener(new ActionListener() {	            
	             public void actionPerformed(ActionEvent e) {
	            	int[] indices = productsList.getSelectedIndices();
	            
	            	for(int i = indices.length - 1; i >= 0; i--) {
	                    model2.addElement(model1.get(indices[i]));
	            	}
	            	
	            	for(int i = indices.length - 1; i >= 0; i--) {
	                   	model1.removeElementAt(indices[i]);
	            	}

	             } });
	        
	        eliminar.addActionListener(new ActionListener() {	            
	             public void actionPerformed(ActionEvent e) {
	            	int[] indices = selectedItems.getSelectedIndices();
	            	
	            	for(int i = indices.length - 1; i >= 0; i--) {
	                    model1.addElement(model2.get(indices[i]));
	                       
	            	}
	            	
	            	
	            	for(int i = indices.length - 1; i >= 0; i--) {
	                   	model2.removeElementAt(indices[i]);
	                   	
	            	}

	             } });
	        
	        
	        crear.addActionListener(new ActionListener() {	            
	             public void actionPerformed(ActionEvent e) {
	               model = selectedItems.getModel();
	               actionDone(model);
	             } });
			
	        
	        add(productsList);
			add(crear);
			add(añadir);
			add(eliminar);
			add(selectedItems);
			
			setVisible(true);
			
		}
		
		
		public void actionDone(ListModel<Producto> model) {
			
			repositoryTick = controller.getTicketRepository();
			Ticket ticket;
			List<Producto> productosTicket = new ArrayList<Producto>();
					
			
			for(int i = 0; i < model.getSize(); i++) {
				productosTicket.add((Producto) model.getElementAt(i));
	     	}
			
		    try {
		    	ticket = new Ticket(productosTicket);
		        repositoryTick.addTicket(ticket);
		        JOptionPane.showMessageDialog(null, "Ticket creado con éxito");
		        marcoEm.dispose();
		    } catch (CampoVacio e) { 
		    	JOptionPane.showMessageDialog(null, e.getMessage());
		    }
		
	}

}
	
//Me puedo ahorrar esta clase.	
class laminaTickets extends JPanel {
	
	JTextArea texto = new JTextArea ("");
	JScrollPane scroll;
	
	public laminaTickets() {
		
		setLayout(new BorderLayout());
	    	
		texto.setText(controller.getAllTickets());
    	texto.setEditable(false);
    	scroll = new JScrollPane(texto);
    	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	add(scroll, BorderLayout.CENTER);
    	//add(texto);
       	setVisible(true);
		
	}
}	


class marcoEmergente extends JFrame {
	
	public marcoEmergente() {
		
		Toolkit screenDisplay =  Toolkit.getDefaultToolkit();
		Dimension screenSize = screenDisplay.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize((int) (screenWidth/2), screenHeight/2);
		setLocation(screenWidth/4 + 10, screenHeight/4 + 10);
		
		setIconImage(screenDisplay.getImage("src/view/flor.png"));
		
		
        //EXIT ON CLOSE? ELEGIR!
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		
	}
}

}
