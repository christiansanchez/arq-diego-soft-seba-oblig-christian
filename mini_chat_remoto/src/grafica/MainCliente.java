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
			Properties prop = new Properties();
			prop.load(new FileInputStream("properties/server.properties"));
			String puerto = prop.getProperty("Puerto");
			String ruta = "//" + InetAddress.getLocalHost().getHostAddress() + ":" + puerto + "/cliente";
			
			IVentanaChat iVentanaChat = new VentanaChat();
			System.out.println("Cliente iniciado ");
			Naming.rebind(ruta, iVentanaChat);
			System.out.println("y publicado <RMI>");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
