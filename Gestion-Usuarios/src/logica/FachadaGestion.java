package logica;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import logica.LoginStub.CreateUser;
import logica.LoginStub.ExistsUser;
import logica.LoginStub.ExistsUserResponse;
import logica.LoginStub.ListUsersResponse;
import logica.LoginStub.RemoveUser;
import logica.LoginStub.ValidateUser;
import logica.LoginStub.ValidateUserResponse;

public class FachadaGestion {

	private static FachadaGestion instancia = null;
	private String url;
	private LoginStub cliente;

	public synchronized static FachadaGestion getInstancia ()
	{
		if (instancia == null)
			instancia = new FachadaGestion();
		return instancia;
	}

	public FachadaGestion() {
		this.url = "http://127.0.0.1:8080/axis2/services/" + "Login.LoginHttpEndpoint/";
		try {
			this.cliente = new LoginStub(url);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}

	public void crearUsuario(String name, String pwd){
		//Controlar que el usuario no exista
		try {
			ExistsUser reqExistsUsr = new ExistsUser();
			ExistsUserResponse respExistsUsr = new ExistsUserResponse();
			
			reqExistsUsr.setName(name);
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
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}
	
	public void borrarUsuario(String name){
		//Controlar que el usuario no exista
		try {
			ExistsUser reqExistsUsr = new ExistsUser();
			ExistsUserResponse respExistsUsr = new ExistsUserResponse();
			
			reqExistsUsr.setName(name);			
			respExistsUsr = cliente.existsUser(reqExistsUsr);
			
			if(respExistsUsr.get_return()){
				RemoveUser remUser = new RemoveUser();
				remUser.setName(name);
				
				cliente.removeUser(remUser);
			}
			else{
				//Mensaje el usuario no exsite
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public String listarUsuarios(){
		ListUsersResponse listUsrResp = null;
		try {	
			listUsrResp = new ListUsersResponse();
			listUsrResp = cliente.listUsers();
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		return listUsrResp.get_return();
	}
	
	public boolean validarUsuario (String name, String pwd)
	{
		ValidateUserResponse valUsrResp = null;
		try {
			ValidateUser reqValidar = new ValidateUser();
			valUsrResp = new ValidateUserResponse();
		
			reqValidar.setName(name);
			reqValidar.setPwd(pwd);	
			valUsrResp = cliente.validateUser(reqValidar);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return valUsrResp.get_return();
	}

}
