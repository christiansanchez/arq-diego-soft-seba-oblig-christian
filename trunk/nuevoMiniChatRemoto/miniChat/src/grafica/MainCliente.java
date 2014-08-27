package grafica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

public class MainCliente
{
	public static void main(String[] args)
	{
		/*
		 * 1. creo una instancia de la ventana de chat
		 * 2. la publico en el rmiregistry para que el servidor se pueda conectar con ella
		 */
		try {			
			Properties prop = new Properties();
			prop.load(new FileInputStream("config.properties"));
			String puerto = prop.getProperty("Puerto");
			String ruta = "//" + InetAddress.getLocalHost().getHostAddress() + ":" + puerto + "/cliente";
			
			IVentanaChat iVentanaChat = new VentanaChat();
			System.out.print("Cliente iniciado ");
			Naming.rebind(ruta, iVentanaChat);
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
