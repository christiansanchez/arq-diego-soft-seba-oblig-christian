package logica;

public class FachadaGestion {

	//Contara con los metodos para ejecutar los requerimientos de gestion de usuarios
	//(Crear usuario, borrar usuario y listar usuarios).
	//Esta clase se conecta remotamente con el web service y hara uso de sus servicios.
	private static FachadaGestion instancia = null;
		
	public synchronized static FachadaGestion getInstancia ()
	{
		if (instancia == null)
			instancia = new FachadaGestion();
		return instancia;
	}
	
}
