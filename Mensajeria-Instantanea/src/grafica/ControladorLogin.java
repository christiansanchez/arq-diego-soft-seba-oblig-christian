package grafica;

import logica.Fachada;

public class ControladorLogin {

	private VentanaLogin ventanaLogin = null;
	private VentanaPrincipal ventanaPrincipal = null;
	private Fachada fachada;

	public ControladorLogin (VentanaLogin ventana) throws Exception{
		try{
			this.ventanaLogin = ventana;
			fachada = Fachada.getInstancia();
		
		} catch(Exception e){
			throw new Exception();
		}
	}

	public boolean validarUsuario(String name, char[] password) throws Exception{
		try {
			return fachada.validateUser(name, String.valueOf(password));
		
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	/*PRECONDICION: El usuario es valido*/
	public void iniciarSesion(String text, char[] password) throws Exception 
	{
		try{
			if(ventanaPrincipal == null){
				ventanaLogin.getFrame().setVisible(false);
				ventanaPrincipal = new VentanaPrincipal();
			}
			
		} catch(Exception e1){
			throw new Exception();
		}
	}

}
