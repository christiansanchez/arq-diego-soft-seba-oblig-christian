package logica;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import persistencia.Persistencia;

public class MainServidor
{
	public static void main(String[] args)
	{
		/*
		 * 1. creo una instancia del servidor de chat
		 * 2. la publico en el rmiregistry para que los clientes se puedan conectar con ella
		 */
		try {//Prueba Diego
			ServidorChat sc = new ServidorChat();
			Persistencia persistencia = new Persistencia();
			Naming.rebind(persistencia.ipServidor(), sc);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
