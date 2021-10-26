package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import controller.FloristeriaController;
import model.Floristeria;
import view.FloristeriaSwing.LaminaGeneral;

public class FloristeriaTicketView extends JFrame {
	
	Floristeria floristeria;
	FloristeriaController controller;
	
	public FloristeriaTicketView (Floristeria floristeria, FloristeriaController controller) {
		this.floristeria = floristeria;
		this.controller = controller;
		
		Toolkit screenDisplay =  Toolkit.getDefaultToolkit();
		Dimension screenSize = screenDisplay.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/2, screenHeight/2);
		setLocation(screenWidth/4, screenHeight/4);
		
		setIconImage(screenDisplay.getImage("src/view/ticket.png"));				
		setTitle("Gestión de tickets");    
               
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
