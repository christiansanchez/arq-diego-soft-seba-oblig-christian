package logica;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServidorChat extends Remote
{
	public void registrarCliente (String urlCliente) throws RemoteException;
	public void publicarMensaje (String mensaje) throws RemoteException;
	public void repartirUltimoMensaje () throws RemoteException;
}
