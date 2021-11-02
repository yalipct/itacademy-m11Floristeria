package view;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.stream.Collectors;

import javax.swing.*;
import controller.CampoVacio;
import controller.FloristeriaController;
import controller.MaterialException;
import model.*;
import model.Decoracion.Material;

public class FloristeriaSwing extends JFrame {

	Container container;
	Floristeria floristeria;
	FloristeriaController controller;
	JPanel panel2;
	JButton crear = new JButton("Crear");
	JLabel texto = new JLabel("", SwingConstants.CENTER);
	JTextField text1, text2, text3;
	LaminaBotones laminaBotones;
	//JButton para acceder a nueva app.
	JButton tickets = new JButton("Acceder a App Tickets");

	public FloristeriaSwing(Floristeria floristeria, FloristeriaController controller) {
		this.floristeria = floristeria;
		this.controller = controller;

		Toolkit screenDisplay = Toolkit.getDefaultToolkit();
		Dimension screenSize = screenDisplay.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);

		setIconImage(screenDisplay.getImage("src/view/flor.png"));
		setTitle("Gestión de floristerias");

		LaminaGeneral laminaGeneral = new LaminaGeneral();
		add(laminaGeneral);

		tickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this.dispose();
				actionDone1();
			}
		});

		add(tickets, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionDone1() {
		this.dispose();
		FloristeriaTicketView ticketView = new FloristeriaTicketView(floristeria, controller);
	}

	class LaminaGeneral extends JPanel {

		public LaminaGeneral() {
			BorderLayout borderLayout = new BorderLayout();
			LaminaImagen laminaImagen = new LaminaImagen();
			add(laminaImagen, BorderLayout.CENTER);

			laminaBotones = new LaminaBotones();
			add(laminaBotones, BorderLayout.SOUTH);

			setVisible(true);

		}
	}

	class LaminaImagen extends JPanel {

		JLabel textoFloristeria = new JLabel("", SwingConstants.CENTER);
		ImageIcon icon = new ImageIcon("src/view/tienda.gif");
		JLabel labelIcon = new JLabel(icon);

		public LaminaImagen() {

			Font miFuente = new Font("Arial", Font.BOLD, 15);

			textoFloristeria.setBounds(100, 500, 200, 20);
			textoFloristeria.setFont(miFuente);
			textoFloristeria.setForeground(Color.BLACK);
			textoFloristeria.setBackground(Color.BLUE);
			textoFloristeria.setOpaque(true);
			textoFloristeria.setText(floristeria.getNomFloristeria());

			add(textoFloristeria);

			labelIcon.setBounds(200, 100, 200, 200);
			add(labelIcon);

		}
	}

	class LaminaBotones extends JPanel {

		JLabel texto0 = new JLabel("", SwingConstants.LEFT);
		JLabel texto1 = new JLabel("", SwingConstants.LEFT);
		JLabel texto2 = new JLabel("", SwingConstants.CENTER);
		JLabel texto3 = new JLabel("", SwingConstants.RIGHT);

		JButton añadirArbol = new JButton("Añadir árbol");
		JButton añadirFlor = new JButton("Añadir flor");
		JButton añadirDecoracion = new JButton("Añadir decoración");
		JButton retirarArbol = new JButton("Eliminar árbol");
		JButton retirarFlor = new JButton("Eliminar flor");
		JButton retirarDecoracion = new JButton("Eliminar decoración");
		JButton verValorTotal = new JButton("Ver valor total");
		JButton verStock = new JButton("Ver stock");
		JComboBox<String> material = new JComboBox<String>(); 
		MarcoBasico marco;
		int counter = 0;

		public LaminaBotones() {

			setLayout(new GridLayout(2, 2));

			añadirArbol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marco = new MarcoBasico(e);
					actionDone(e);
					counter++;

				}
			});

			añadirFlor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marco = new MarcoBasico(e);
					actionDone(e);

				}
			});

			añadirDecoracion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marco = new MarcoBasico(e);
					actionDone(e); 

				}
			});

			verStock.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marco = new MarcoBasico(e);
					Container container = marco.getContentPane();
					container.removeAll();
					actionDone(e); 

				}
			});

			retirarArbol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marco = new MarcoBasico(e);
					Container container = marco.getContentPane();
					container.removeAll();
					actionDone(e);

				}
			});

			retirarFlor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marco = new MarcoBasico(e);
					Container container = marco.getContentPane();
					container.removeAll();
					actionDone(e);

				}
			});

			retirarDecoracion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marco = new MarcoBasico(e);
					Container container = marco.getContentPane();
					container.removeAll();
					actionDone(e);

				}
			});

			verValorTotal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, controller.getStockValue(floristeria));
				}
			});

			add(añadirArbol);
			add(añadirFlor);
			add(añadirDecoracion);
			add(verStock);
			add(retirarArbol);
			add(retirarFlor);
			add(retirarDecoracion);
			add(verValorTotal);

		}
				
		private void actionDone(ActionEvent e) {

			Object source = e.getSource();

			if (source == añadirArbol) {
				panel2 = new LaminaArbol();
				marco.add(panel2, BorderLayout.CENTER);
				// setVisible(true);
				validate();

			} else if (source == añadirFlor) {
				panel2 = new LaminaFlor();
				marco.add(panel2, BorderLayout.CENTER);
				setVisible(true);
				validate();
			} else if (source == añadirDecoracion) {
				panel2 = new LaminaDecoracion();
				marco.add(panel2, BorderLayout.CENTER);
				setVisible(true);
				validate();
				// PANEL2
			} else if (source == verStock) {
				marco.add(new LaminaStock());
				marco.pack(); 
				setVisible(true);
				validate();
			} else if (source == retirarArbol || source == retirarFlor || source == retirarDecoracion) {
				marco.add(new LaminaEliminar(e));
				marco.pack();
				setVisible(true);
				validate();
			}

		}

		class LaminaProductos extends JPanel {

			public LaminaProductos(ActionEvent e) {

				setLayout(new GridLayout(2, 4));

				text1 = new JTextField(16);
				text2 = new JTextField(16);
				text3 = new JTextField(16);
				
				//añadido para que permita introducir solo letras en todos los campos nombre del producto
				text1.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char validar = e.getKeyChar();
						
						if(Character.isDigit(validar)) {			
							e.consume();
							JOptionPane.showMessageDialog(null, "Ingresar Solo Letras en el campo nombre");
						}
					}
				});

				add(crear);
				add(text1);
				add(text2);

				if (e.getSource() == añadirDecoracion) {
					remove(text2);
					add(material);
					revalidate();
				}

				add(text3);

				add(texto0);
				add(texto1);
				add(texto2);
				add(texto3);

				setVisible(true);

			}

		}

		class LaminaArbol extends JPanel {

			ActionListener myactionLis = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							actionDone(e);
						} catch (CampoVacio e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
				}
			};

			public LaminaArbol() {

				texto1.setText("Nombre");
				texto2.setText("Altura (m)");
				texto3.setText("Precio(double)");

				crear.addActionListener(myactionLis);

				setVisible(true);
			}

			public void actionDone(ActionEvent e) throws CampoVacio {
				double altura = 0, precio = 0;
				
				try {
					altura = Double.parseDouble(text2.getText());
					precio = Double.parseDouble(text3.getText());
					
					controller.afegirArbre(floristeria, text1.getText(), altura, precio);				
				
				} catch (Exception err) {
					 
					 if (text2.getText().equals("")|| text3.getText().equals("") || text1.getText().equals("")) {
						 JOptionPane.showMessageDialog(null, "Campo/s de texto vacío/s"); 
					 } else {
						 JOptionPane.showMessageDialog(null, "Tipo de dato introducido erróneo");
					 }
					   return;
				 }

				crear.removeActionListener(myactionLis);
				texto.setText("Árbol creado con éxito");
			}

		}

		public class LaminaFlor extends JPanel {

			ActionListener myactionLis2 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actionDone(e);
					} catch (CampoVacio e1) {
						e1.printStackTrace();
					}
				}
			};

			public LaminaFlor() {

				texto1.setText("Nombre");
				texto2.setText("Color");
				texto3.setText("Precio(double)");

				crear.addActionListener(myactionLis2);
				
				//añadido para que permita introducir solo letras en el campo color
				text2.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char validar = e.getKeyChar();
						
						if(Character.isDigit(validar)) {				
							e.consume();
							JOptionPane.showMessageDialog(null, "Ingresar Solo Letras en el campo color");
						}
					}
				});

				setVisible(true);

			}

			public void actionDone(ActionEvent e) throws CampoVacio {
				double precio = 0;				

				try {
					precio = Double.parseDouble(text3.getText());
					controller.afegirFlor(floristeria, text1.getText(), text2.getText(), precio);
				} catch (Exception err) {
					
					if (text2.getText().equals("")|| text3.getText().equals("") || text1.getText().equals("")) {
						 JOptionPane.showMessageDialog(null, "Campo/s de texto vacío/s"); 
					 } else {
						 JOptionPane.showMessageDialog(null, "Tipo de dato introducido erróneo");
					 }
					 return;
				}
				crear.removeActionListener(myactionLis2);
				texto.setText("Flor creada con éxito");
			}

		}

		class LaminaDecoracion extends JPanel {
			ActionListener myactionLis3 = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actionDone(e);
					} catch (CampoVacio | MaterialException e1) {
						e1.printStackTrace();
					}

				}
			};

			public LaminaDecoracion() {

				texto1.setText("Nombre");
				texto2.setText("Material");
				texto3.setText("Precio(double)");

				material.removeAllItems();
				material.addItem("PLASTICO");
				material.addItem("MADERA");

				crear.addActionListener(myactionLis3);

				setVisible(true);

			}

			public void actionDone(ActionEvent e) throws CampoVacio, MaterialException {
				double precio = 0;
				Material material1 = null;

				if (material.getSelectedItem().equals(Material.MADERA)) {					
					
					material1 = Material.MADERA;
					
				} else {
					
					material1 = Material.PLASTICO;
				}

				try {
					precio = Double.parseDouble(text3.getText());
					controller.afegirDecoracio(floristeria, text1.getText(), material1, precio);
				} catch (Exception err) {
					
					if (text3.getText().equals("") || text1.getText().equals("")) {
						 JOptionPane.showMessageDialog(null, "Campo/s de texto vacío/s"); 
					 } else {
						 JOptionPane.showMessageDialog(null, "Tipo de dato introducido erróneo");
					 }
					 return;
				}
				crear.removeActionListener(myactionLis3);
				texto.setText("Decoración creada con éxito");
			}

		}

		public class LaminaEliminar extends JPanel {

			JTextArea texto = new JTextArea("");
			JTextField campoTexto = new JTextField(3);
			JLabel etiqueta = new JLabel();
			JButton enter = new JButton("Enter");
			String producto;
			String listaProducto;

			// Refrescar cuando se elimina un elemento. No aparece mensaje de lista vacia.
			public LaminaEliminar(ActionEvent elim) {

				setLayout(new GridLayout(4, 1));

				if (elim.getSource() == retirarArbol) {
					listaProducto = controller.getProductStock(floristeria, "Arbol");
					producto = "Arbol"; // lo cambie pq me daba conflicto
				} else if (elim.getSource() == retirarFlor) {
					listaProducto = controller.getProductStock(floristeria, "Flor");
					producto = "Flor";
				} else if (elim.getSource() == retirarDecoracion) {
					listaProducto = controller.getProductStock(floristeria, "Decoracion");
					producto = "Decoracion";
				}

				enter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						actionDone(producto); 
					}
				});

				texto.setText(listaProducto);
				texto.setEditable(false);
				etiqueta.setText("Introduce el id del producto a eliminar: ");
				add(texto);
				add(etiqueta);
				add(campoTexto);
				add(enter);
				setVisible(true);
			}
			
			private void actionDone(String producto) {
								
				int opcion;

				try {
					opcion = Integer.parseInt(campoTexto.getText());
										
					List<Producto> listaProductos = floristeria.getAllProducts();
					
					Producto prod = null;
					
					for (int i = 0; i < listaProductos.size(); i++) {
			        	if (listaProductos.get(i).getId() == opcion){
			        		prod = listaProductos.get(i);
			        	}
			        }
					
					String tipoProducto = prod.getClass().getSimpleName();
					
					if (tipoProducto.equalsIgnoreCase(producto)) {
						
						controller.retirarProducto(floristeria, producto, opcion);
						JOptionPane.showMessageDialog(null, producto + " eliminado/a con éxito");
						marco.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado ningún producto: " + producto + " con este id.");
					}
					
				} catch(NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El producto que intenta eliminar no existe");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debes introducir un número");
				} 
				
			}

		}

		public class LaminaStock extends JPanel {

			JTextArea texto = new JTextArea("");

			public LaminaStock() {

				// setTitle("Stock de la floristeria");
				String listaProductos = "STOCK Arboles: \n" + controller.getProductStock(floristeria, "Arbol")
						+ "STOCK Flores: \n" + controller.getProductStock(floristeria, "Flor")
						+ "STOCK Decoraciones: \n" + controller.getProductStock(floristeria, "Decoracion");

				texto.setText(listaProductos);
				texto.setEditable(false);
				add(texto);
				setVisible(true);

			}
		}

		public class MarcoBasico extends JFrame {

			JButton atras = new JButton("Atrás");
			LaminaProductos laminaProductos;

			public MarcoBasico(ActionEvent ev) {
				Toolkit screenDisplay = Toolkit.getDefaultToolkit();
				Dimension screenSize = screenDisplay.getScreenSize();
				int screenHeight = screenSize.height;
				int screenWidth = screenSize.width;
				setSize(screenWidth / 2, screenHeight / 3);
				setLocation(screenWidth / 4 + 10, screenHeight / 4 + 10);

				setIconImage(screenDisplay.getImage("src/view/flor.png"));
				setTitle(ev.getActionCommand());

				laminaProductos = new LaminaProductos(ev);
				add(laminaProductos, BorderLayout.NORTH);
				Font miFuente = new Font("Arial", Font.BOLD, 15);

				texto.setFont(miFuente);
				texto.setForeground(Color.RED);
				texto.setOpaque(true);

				add(texto, BorderLayout.CENTER);

				atras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						texto.setText("");
						actionDone();
					}
				});

				atras.setPreferredSize(new Dimension(50, 50));
				add(atras, BorderLayout.SOUTH);

				// EXIT ON CLOSE? ELEGIR!
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setVisible(true);
			}

			public void actionDone() {
				this.getContentPane().removeAll();
				this.getContentPane().validate();
				this.dispose();

			}

		}

	}

}
