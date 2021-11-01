package controller;

public class CampoVacio extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4816819260031085264L;
	
	public static final String CAMPO_VACIO = "Campo/s de texto vacío/s";

	public CampoVacio(String mensaje) {
		super(mensaje);
		
	}

	
}
