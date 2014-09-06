package grafica;

import logica.Fachada;

public class ControladorPrincipal 
{
	private VentanaPrincipal ventanaPrincipal = null;
	private VentanaMensajes ventanaMensajes = null;
	
	public ControladorPrincipal (VentanaPrincipal ventana)
	{
		this.ventanaPrincipal = ventana;
	}
	
	public void difundirEstoyActivo ()
	{
		/*
		 * 1. Difundo a trav�s de la fachada que estoy activo
		 */
	}
	
	public void recibirEquiposActivos ()
	{
		/*
		 * Establezco un LOOP infinito que realiza las siguientes acciones:
		 * 1. Le pido a la fachada que reciba la direcci�n IP de un equipo activo
		 * 2. Si devolvi� el String "ninguna", no hago nada
		 * 3. En otro caso, actualizo la lista de equipos activos de la VentanaPrincipal
		 *    con la direcci�n IP del equipo activo que fue recibida
		 */
	}
	
	public void enviarMensaje (String mensaje, String ipEquipoSeleccionado)
	{
		/*
		 * 1. Env�o a trav�s de la fachada el mensaje recibido al equipo seleccionado
		 */
	}
	
	public void mostrarVentanaMensajes ()
	{
		if (ventanaMensajes == null)
		{
			ventanaMensajes = new VentanaMensajes();
		}
	}
}
