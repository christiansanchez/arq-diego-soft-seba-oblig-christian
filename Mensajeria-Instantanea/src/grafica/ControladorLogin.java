package grafica;

import logica.Fachada;

public class ControladorLogin {

	private VentanaLogin ventanaLogin = null;
	private VentanaPrincipal ventanaPrincipal = null;
	private Fachada fachada;

	public ControladorLogin (VentanaLogin ventana){
		this.ventanaLogin = ventana;
		fachada = Fachada.getInstancia();
	}

	public void iniciarSesion(String text, char[] password) {
		ventanaLogin.setErrorMsg("");
		boolean valido = false;
		valido = fachada.validateUser(text, password.toString());
		if(valido){
			ventanaLogin.getFrame().setVisible(false);
			ventanaPrincipal = new VentanaPrincipal();
		}
		else{
			ventanaLogin.setErrorMsg("Error al iniciar sesión, intente nuevamente");
		}
	}

}
