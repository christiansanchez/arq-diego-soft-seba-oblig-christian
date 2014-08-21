package logica;

import grafica.IVentanaChat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import persistencia.Persistencia;

public class ServidorChat extends UnicastRemoteObject implements IServidorChat {

	private static final long serialVersionUID = 1L;
	
	/*
	 * atributos:
	 * una lista conteniendo las url's de todos los clientes que están contectados
	 * otra lista conteniendo todos los mensajes enviados hasta el momento
	 */
	ArrayList<String> arr_clientes;
	ArrayList<String> arr_mensajes;
	
	

	public ServidorChat() throws RemoteException 
	{
		/*
		 * 1. creo la lista de url's de los clientes 
		 * 2. creo la lista de mensajes
		 */
		arr_clientes = new ArrayList<String>();
		arr_mensajes = new ArrayList<String>();
	}

	public void registrarCliente(String urlCliente) throws RemoteException
	{
		/*
		 * 1. agrego la url del nuevo cliente a mi lista de clientes
		 */
		
		if(!arr_clientes.contains(urlCliente))
			arr_clientes.add(urlCliente);
	}

	public void publicarMensaje(String mensaje) throws RemoteException
	{
		/*
		 * 1. agrego el mensaje recibido a la lista de mensajes
		 * 2. lo almaceno en la persistencia
		 * 3. procedo a repartir el último mensaje recibido a todos mis clientes
		 */
		arr_mensajes.add(mensaje);
		Persistencia persistencia = new Persistencia();
		try {
			persistencia.persistirMensaje(mensaje);
			repartirUltimoMensaje();
		} catch (IOException e) {
			throw new RemoteException(e.getMessage());
		}
		
		
	}

	public void repartirUltimoMensaje() throws RemoteException
	{
		/*
		 * recorro mi lista de url's de clientes, por cada uno de ellos...
		 * 1. me conecto con él mediante RMI
		 * 2. le paso el último mensaje recibido para que lo muestre en su ventana 
		 */
		String msg = arr_mensajes.get(arr_mensajes.size()-1);
		IVentanaChat ivc = null;
		
		for(String cliente : arr_clientes){
			try {
				ivc = (IVentanaChat)Naming.lookup(cliente);
				ivc.updateMensaje(msg);
				
			} catch (MalformedURLException e) {
				throw new RemoteException(e.getMessage());
			} catch (NotBoundException e) {
				throw new RemoteException(e.getMessage());
			}
			
		}
	}
	
	
}
