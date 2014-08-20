package logica;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorChat extends UnicastRemoteObject implements IServidorChat {

	private static final long serialVersionUID = 1L;
	
	/*
	 * atributos:
	 * una lista conteniendo las url's de todos los clientes que están contectados
	 * otra lista conteniendo todos los mensajes enviados hasta el momento
	 */

	public ServidorChat() throws RemoteException 
	{
		/*
		 * 1. creo la lista de url's de los clientes 
		 * 2. creo la lista de mensajes
		 */
	}

	public void registrarCliente(String urlCliente) throws RemoteException
	{
		/*
		 * 1. agrego la url del nuevo cliente a mi lista de clientes
		 */
	}

	public void publicarMensaje(String mensaje) throws RemoteException
	{
		/*
		 * 1. agrego el mensaje recibido a la lista de mensajes
		 * 2. lo almaceno en la persistencia
		 * 3. procedo a repartir el último mensaje recibido a todos mis clientes
		 */
	}

	public void repartirUltimoMensaje() throws RemoteException
	{
		/*
		 * recorro mi lista de url's de clientes, por cada uno de ellos...
		 * 1. me conecto con él mediante RMI
		 * 2. le paso el último mensaje recibido para que lo muestre en su ventana 
		 */
	}
}
