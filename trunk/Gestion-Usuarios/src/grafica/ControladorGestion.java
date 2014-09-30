package grafica;

import logica.FachadaGestion;

public class ControladorGestion {

	private FachadaGestion fachada;
	
	public ControladorGestion (VentanaGestion ventana) throws Exception{
		fachada = FachadaGestion.getInstancia();
	}
	
	public boolean existeUsuario(String name) throws Exception{
		return fachada.existeUsuario(name);
	}
	
	/*PRECONDICION: El usuario no existe*/
	public void crearUsuario(String name, String pwd) throws Exception
	{
		fachada.crearUsuario(name, pwd);
	}
	
	/*PRECONDICION: El usuario existe*/
	public void borrarUsuario(String name) throws Exception
	{
		fachada.borrarUsuario(name);
	}
	
	public String[] listarUsuarios() throws Exception
	{
		String aux = fachada.listarUsuarios();
		String [] lstUsers = aux.split(", ");
							
		return lstUsers;
	}
	
	public boolean validarUsuario(String name, String pwd) throws Exception
	{
		return fachada.validarUsuario(name, pwd);
	}
	
}
