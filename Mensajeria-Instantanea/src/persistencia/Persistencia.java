package persistencia; 

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Persistencia 
{
	public void persistirMensaje (String ipEmisor, String mensaje) throws Exception
	{
		/*
		 * 1. agrego al archivo de texto que contiene el historial de mensajes recibidos
		 *    el mensaje recibido junto con la dirección IP del emisor
		 */
		try { 	
			FileOutputStream archivo = new FileOutputStream("src/persistencia/historial.txt", true);
			ObjectOutputStream objeto = new ObjectOutputStream(archivo);

			objeto.writeObject (ipEmisor);
			objeto.writeObject (mensaje);
			objeto.close();
			archivo.close();
		
		} catch(Exception e){
			throw new Exception();			
		}
	}
}
