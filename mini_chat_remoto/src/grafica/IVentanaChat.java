package grafica;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVentanaChat extends Remote 
{
	public void updateMensaje (String msg) throws RemoteException;
}
