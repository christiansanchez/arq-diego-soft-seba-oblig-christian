package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.management.openmbean.InvalidOpenTypeException;

public class PersistenciaGestion {

	//Almacena los usuarios en un archivo de texto local.
	
	public void persistirUsuarios (String name, String pwd)
	{
		
		try
		{ 	
			FileOutputStream archivo = new FileOutputStream("src/persistencia/usuarios.txt", true);
			ObjectOutputStream objeto = new ObjectOutputStream(archivo);

			objeto.writeObject (name + ";" + pwd);
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
	
	public boolean validarUsuario (String name, String pwd){
		try {
			FileInputStream archivo = new FileInputStream("src/persistencia/usuarios.txt");
			ObjectInputStream objeto = new ObjectInputStream(archivo);
			String strObj = new String();
			String nameObj = new String();
			String pwdObj = new String();
			String [] arrStrObj = null;
			
			List listaObj = (List)objeto.readObject();
			
			for(int i=0 ; i<listaObj.size() ; i++){
				Object obj = listaObj.get(i);
				strObj = (String)obj;
				arrStrObj = strObj.split(";");
				nameObj = arrStrObj[0];
				pwdObj = arrStrObj[1];
				
				if(nameObj.equalsIgnoreCase(name) && pwdObj.equals(pwd))
					return true;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean existeUsuario(String name){
		try {
			FileInputStream archivo = new FileInputStream("src/persistencia/usuarios.txt");
			ObjectInputStream objeto = new ObjectInputStream(archivo);
			String strObj = new String();
			String nameObj = new String();
			String pwdObj = new String();
			String [] arrStrObj = null;
			
			List listaObj = (List)objeto.readObject();
			
			for(int i=0 ; i<listaObj.size() ; i++){
				Object obj = listaObj.get(i);
				strObj = (String)obj;
				arrStrObj = strObj.split(";");
				nameObj = arrStrObj[0];
				pwdObj = arrStrObj[1];
				
				if(nameObj.equalsIgnoreCase(name))
					return true;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void borrarUsuario (String name){
		try {
			FileInputStream archivo = new FileInputStream("src/persistencia/usuarios.txt");
			ObjectInputStream objeto = new ObjectInputStream(archivo);
			String strObj = new String();
			String nameObj = new String();
			String pwdObj = new String();
			String [] arrStrObj = null;
			
			List listaObj = (List)objeto.readObject();
			
			for(int i=0 ; i<listaObj.size() ; i++){
				Object obj = listaObj.get(i);
				strObj = (String)obj;
				arrStrObj = strObj.split(";");
				nameObj = arrStrObj[0];
				pwdObj = arrStrObj[1];
				
				if(nameObj.equalsIgnoreCase(name)){
					listaObj.remove(i);
					break;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
