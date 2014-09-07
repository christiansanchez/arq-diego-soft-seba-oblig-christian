package grafica;

import logica.Fachada;

public class ControladorPrincipal 
{
	private VentanaPrincipal ventanaPrincipal = null;
	private VentanaMensajes ventanaMensajes = null;
	private Fachada fachada;
	
	public ControladorPrincipal (VentanaPrincipal ventana)
	{
		this.ventanaPrincipal = ventana;
		fachada = Fachada.getInstancia();
	}
	
	public void difundirEstoyActivo ()
	{
		/*
		 * 1. Difundo a trav�s de la fachada que estoy activo
		 */
		fachada.difundirEstoyActivo();
		
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
		 while(true){
			 String ip = fachada.recibirEquipoActivo();
			 if(!ip.equals("ninguna")){
				 ventanaPrincipal.getListEquiposActivos().add(ip);
			 }
		 }
	}
	
	public void enviarMensaje (String mensaje, String ipEquipoSeleccionado)
	{
		/*
		 * 1. Env�o a trav�s de la fachada el mensaje recibido al equipo seleccionado
		 */
		fachada.enviarMensaje(mensaje, ipEquipoSeleccionado);
	}
	
	public void mostrarVentanaMensajes ()
	{
		if (ventanaMensajes == null)
		{
			ventanaMensajes = new VentanaMensajes();
		}
	}
}
