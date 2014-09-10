package persistencia; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.management.openmbean.InvalidOpenTypeException;

public class Persistencia 
{
	public void persistirMensaje (String ipEmisor, String mensaje)
	{
		/*
		 * 1. agrego al archivo de texto que contiene el historial de mensajes recibidos
		 *    el mensaje recibido junto con la dirección IP del emisor
		 */
		try
		{ 	
			FileOutputStream archivo = new FileOutputStream("src/persistencia/historial.txt");
			ObjectOutputStream objeto = new ObjectOutputStream(archivo);
			String dataPersistir = ipEmisor + ": " + mensaje; 
			objeto.writeObject (dataPersistir);
			objeto.close();
			archivo.close();
		}
		catch(InvalidOpenTypeException e)
		{
			e.printStackTrace();			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
