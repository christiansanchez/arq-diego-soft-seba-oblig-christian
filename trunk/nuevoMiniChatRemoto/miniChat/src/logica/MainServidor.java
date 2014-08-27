package logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

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
			prop.load(new FileInputStream("config.properties"));
			String puerto = prop.getProperty("Puerto");
			String ipServidor = prop.getProperty("Servidor");
			String ruta = "//"+ ipServidor + ":" + puerto + "/servidor";
			
			IServidorChat servidorChat = new ServidorChat();
			System.out.print("Servidor iniciado ");
			Naming.rebind(ruta, servidorChat);
			System.out.print("y publicado <RMI>");
			
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
