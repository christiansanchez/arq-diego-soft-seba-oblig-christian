package grafica;

import logica.FachadaGestion;

public class ControladorGestion {

	private VentanaGestion ventanaGestion = null;
	private FachadaGestion fachada;
	
	public ControladorGestion (VentanaGestion ventana){
		this.ventanaGestion = ventana;
		fachada = FachadaGestion.getInstancia();
	}
	
}
