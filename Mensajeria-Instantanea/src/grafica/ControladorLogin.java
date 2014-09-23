package grafica;

import logica.Fachada;

public class ControladorLogin {

	private VentanaLogin ventanaLogin = null;
	private Fachada fachada;
	
	public ControladorLogin (VentanaLogin ventana){
		this.ventanaLogin = ventana;
		fachada = Fachada.getInstancia();
	}
	
	public void iniciarSesion(String text, char[] password) {
		// TODO DARIN: verificar si existe usuario y luego validar credenciales contra web service.
	}

}
