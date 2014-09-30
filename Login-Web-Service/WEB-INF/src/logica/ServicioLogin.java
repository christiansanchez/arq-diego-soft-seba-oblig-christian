package logica;

import java.util.Enumeration;
import java.util.Hashtable;

public class ServicioLogin {
	
	private static Hashtable<String, Usuario> usuarios;

	public ServicioLogin ( ){
		/* método constructor, crea el hashtable vacío */
		if(usuarios == null){
			usuarios = new Hashtable<String, Usuario>();	
		}	 
	}
	
	public boolean existsUser (String name){
		/* verifica si existe el usuario en el hashtable */		
		return usuarios.containsKey(name);
	}
	
	public void createUser (String name, String pwd){
		/* agrega el nuevo usuario y password al hashtable */
		/* Precondición: el usuario no existe en el hashtable */
		Usuario user = new Usuario(name, pwd);
		usuarios.put(name, user);
	}
	
	public void removeUser (String name){
		/* borra el usuario del hashtable */
		/* Precondición: el usuario existe en el hashtable */
		usuarios.remove(name);
	}
		
	public boolean validateUser (String name, String pwd){
		/* verifica si el usuario existe en el hashtable. En caso de */
		/* ser así, valida su password. Devuelve true sólo si se */
		/* trata de un usuario y una password válidos */
		boolean isValid = false;
		if(existsUser(name)){
			Usuario user = usuarios.get(name);
			if(user.getPassword().equals(pwd)){
				isValid = true;
			}
		}
		return isValid;
	}
	
	public String listUsers ( ){
		/* devuelve un String conteniendo todos los nombres de */
		/* usuarios del hashtable, separados mediante comas */
		StringBuilder users = new StringBuilder();
		Enumeration<String> keys = usuarios.keys();
		while(keys.hasMoreElements()){
			users.append(keys.nextElement());
			if(keys.hasMoreElements())
				users.append(", ");
		}
		return users.toString();
	}
	
}
