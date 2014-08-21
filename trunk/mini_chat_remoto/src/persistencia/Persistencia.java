package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class Persistencia
{
	public void persistirMensaje (String mensaje) throws IOException
	{
		/*
		 * 1. agrego el mensaje recibido al archivo de texto donde se guardan todos los mensajes
		 */
		try
		{ 	FileOutputStream f = new FileOutputStream("src/persistencia/archivo.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject (mensaje);
			o.close();
			f.close();
		}
		catch (IOException e)
		{ 
			throw new IOException(e.getMessage());
		}
		
	}
	
	public String ipServidor(){
		String ip = new String();
		String port = new String();
		
		Properties p = new Properties();
		String nomProp = "src/properties/server.properties";
		try {
			p.load (new FileInputStream (nomProp));
			ip = p.getProperty("SERVER_IP") + ":" + p.getProperty("SERVER_PORT");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ip;
	}
}
