package grafica;

import logica.FachadaGestion;

public class ControladorGestion {

	private FachadaGestion fachada;
	
	public ControladorGestion (VentanaGestion ventana){
		fachada = FachadaGestion.getInstancia();
	}
	
	public boolean existeUsuario(String name){
		return fachada.existeUsuario(name);
	}
	
	/*PRECONDICION: El usuario no existe*/
	public void crearUsuario(String name, String pwd)
	{
		fachada.crearUsuario(name, pwd);
	}
	
	/*PRECONDICION: El usuario existe*/
	public void borrarUsuario(String name)
	{
		fachada.borrarUsuario(name);
	}
	
	public String[] listarUsuarios()
	{
		String aux = fachada.listarUsuarios();
		String [] lstUsers = aux.split(", ");
							
		return lstUsers;
	}
	
	public boolean validarUsuario(String name, String pwd)
	{
		return fachada.validarUsuario(name, pwd);
	}
	
}
