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
		{ 	
			FileOutputStream archivo = new FileOutputStream("src/persistencia/mensajes.txt");
			ObjectOutputStream objeto = new ObjectOutputStream(archivo);
			objeto.writeObject (mensaje + "\n");
			objeto.close();
			archivo.close();
			
		} catch (IOException e) { 
			throw new IOException(e.getMessage());
		}
		
	}

}
