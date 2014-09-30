package logica;

import persistencia.PersistenciaGestion;
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
	private PersistenciaGestion persistencia;

	public synchronized static FachadaGestion getInstancia () throws Exception
	{
		if (instancia == null)
			instancia = new FachadaGestion();
		return instancia;
	}

	public FachadaGestion() throws Exception {
		this.url = "http://127.0.0.1:8080/axis2/services/" + "Login.LoginHttpEndpoint/";
		try {
			this.cliente = new LoginStub(url);
			this.persistencia = new PersistenciaGestion();
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public boolean existeUsuario(String name) throws Exception
	{
		ExistsUser reqExistsUsr = new ExistsUser();
		ExistsUserResponse respExistsUsr = new ExistsUserResponse();
		try {
			reqExistsUsr.setName(name);
			respExistsUsr = cliente.existsUser(reqExistsUsr);
		
		} catch (Exception e) {
			throw new Exception();
		}
		return respExistsUsr.get_return();
	}

	/*PRECONDICION: El usuario no existe*/
	public void crearUsuario(String name, String pwd) throws Exception
	{	
		CreateUser cu = new CreateUser();
		try {
			cu.setName(name);
			cu.setPwd(pwd);		
			cliente.createUser(cu);
			persistencia.persistirUsuario(name, pwd);
		
		} catch (Exception e) {
			throw new Exception();
		}	
	}
	
	/*PRECONDICION: El usuario existe*/
	public void borrarUsuario(String name) throws Exception
	{
		try {
			RemoveUser remUser = new RemoveUser();
			remUser.setName(name);	
			cliente.removeUser(remUser);

		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public String listarUsuarios() throws Exception
	{
		ListUsersResponse listUsrResp = new ListUsersResponse();
		try {	
			listUsrResp = cliente.listUsers();
		
		} catch (Exception e) {
			throw new Exception();
		}
		return listUsrResp.get_return();
	}
	
	public boolean validarUsuario (String name, String pwd) throws Exception
	{
		ValidateUser reqValidar = new ValidateUser();
		ValidateUserResponse valUsrResp = new ValidateUserResponse();
		try {	
			reqValidar.setName(name);
			reqValidar.setPwd(pwd);	
			valUsrResp = cliente.validateUser(reqValidar);
		
		} catch (Exception e) {
			throw new Exception();
		}
		return valUsrResp.get_return();
	}

}
