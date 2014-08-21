package grafica;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MainCliente
{
	public static void main(String[] args)
	{
		/*
		 * 1. creo una instancia de la ventana de chat
		 * 2. la publico en el rmiregistry para que el servidor se pueda conectar con ella
		 */
		try {
			VentanaChat vc = new VentanaChat();
			
			Naming.rebind("localhost:8181/Ventana", vc);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
