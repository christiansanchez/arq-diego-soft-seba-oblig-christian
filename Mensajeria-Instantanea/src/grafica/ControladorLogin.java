package grafica;

import logica.Fachada;

public class ControladorLogin {

	private VentanaLogin ventanaLogin = null;
	private Fachada fachada;

	public ControladorLogin (VentanaLogin ventana){
		this.ventanaLogin = ventana;
		fachada = Fachada.getInstancia();
	}

	public boolean validarUsuario(String name, char[] password){
		return fachada.validateUser(name, password.toString());
	}
	
	/*PRECONDICION: El usuario es valido*/
	public void iniciarSesion(String text, char[] password) {
		ventanaLogin.getFrame().setVisible(false);
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
	}

}
