package persistencia;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PersistenciaGestion {

	//Almacena los usuarios en un archivo de texto local.
	
	public void persistirUsuario (String name, String pwd) throws Exception
	{		
		try
		{ 	
			FileOutputStream archivo = new FileOutputStream("src/persistencia/usuarios.txt", true);
			ObjectOutputStream objeto = new ObjectOutputStream(archivo);

			objeto.writeObject (name + ";" + pwd);
			objeto.close();
			archivo.close();
		}
		catch(Exception e)
		{
			throw new Exception();
		}
	}

}
