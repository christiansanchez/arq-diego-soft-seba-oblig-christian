package logica;

import logica.LoginStub.CreateUser;
import logica.LoginStub.ExistsUser;
import logica.LoginStub.ExistsUserResponse;
import logica.LoginStub.ListUsersResponse;
import logica.LoginStub.RemoveUser;

public class FachadaGestion {

	//Contara con los metodos para ejecutar los requerimientos de gestion de usuarios
	//(Crear usuario, borrar usuario y listar usuarios).
	//Esta clase se conecta remotamente con el web service y hara uso de sus servicios.
	private static FachadaGestion instancia = null;

	public synchronized static FachadaGestion getInstancia ()
	{
		if (instancia == null)
			instancia = new FachadaGestion();
		return instancia;
	}

	public void crearUsuario(String name, String pwd){
		//Controlar que el usuario no exista
		String url = "http://127.0.0.1:8080/axis2/services/" + "Login.LoginHttpEndpoint/";
		LoginStub cliente;
		
		ExistsUser reqExistsUsr = new ExistsUser();
		ExistsUserResponse respExistsUsr = new ExistsUserResponse();
		
		reqExistsUsr.setName(name);
		
		cliente = new LoginStub(url);
		respExistsUsr = cliente.existsUser(reqExistsUsr);
		
		if(!respExistsUsr.get_return()){
			CreateUser cu = new CreateUser();
			cu.setName(name);
			cu.setPwd(pwd);
			
			cliente.createUser(cu);
		}
		else{
			//Mensaje el usuario ya exsite
		}
		
		
		
	}
	
	public void borrarUsuario(String name){
		//Controlar que el usuario no exista
		String url = "http://127.0.0.1:8080/axis2/services/" + "Login.LoginHttpEndpoint/";
		LoginStub cliente;
		
		ExistsUser reqExistsUsr = new ExistsUser();
		ExistsUserResponse respExistsUsr = new ExistsUserResponse();
		
		reqExistsUsr.setName(name);
		
		cliente = new LoginStub(url);
		respExistsUsr = cliente.existsUser(reqExistsUsr);
		
		if(respExistsUsr.get_return()){
			RemoveUser remUser = new RemoveUser();
			remUser.setName(name);
			
			cliente.removeUser(remUser);
		}
		else{
			//Mensaje el usuario no exsite
		}
		
	}
	
	public String listarUsuario(){
		String url = "http://127.0.0.1:8080/axis2/services/" + "Login.LoginHttpEndpoint/";
		LoginStub cliente;
		
		ListUsersResponse listUsrResp = new ListUsersResponse();
		
		cliente = new LoginStub(url);
		listUsrResp = cliente.listUsers();
		
		return listUsrResp.get_return();
	}

}
