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
		try {
			
			Properties prop = new Properties();
			prop.load(new FileInputStream("properties/server.properties"));
			String puerto = prop.getProperty("Puerto");
			String ipServidor = prop.getProperty("Servidor");
			String ruta = "//"+ ipServidor + ":" + puerto + "/servidor";
			
			IServidorChat servidorChat = new ServidorChat();
			System.out.println("Servidor iniciado ");
			Naming.rebind(ruta, servidorChat);
			System.out.println("y publicado <RMI>");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
