package grafica;

import logica.FachadaGestion;

public class ControladorGestion {

	private VentanaGestion ventanaGestion = null;
	private FachadaGestion fachada;
	
	public ControladorGestion (VentanaGestion ventana){
		this.ventanaGestion = ventana;
		fachada = FachadaGestion.getInstancia();
	}
	
	public void crearUsuario(String name, String pwd)
	{
		fachada.crearUsuario(name, pwd);
	}
	
	public void borrarUsuario(String name)
	{
		fachada.borrarUsuario(name);
	}
	
	public String[] listarUsuarios()
	{
		String aux = fachada.listarUsuarios();
		String [] lstUsers = aux.split(";");
							
		return lstUsers;
	}
	
	public void validarUsuario(String name, String pwd)
	{
		fachada.validarUsuario(name, pwd);
	}
	
}
