package grafica;

import logica.Fachada;

public class ControladorPrincipal 
{
	private VentanaPrincipal ventanaPrincipal = null;
	private VentanaMensajes ventanaMensajes = null;
	private Fachada fachada;
	
	public ControladorPrincipal (VentanaPrincipal ventana) throws Exception
	{
		try{
			this.ventanaPrincipal = ventana;
			fachada = Fachada.getInstancia();
		
		} catch(Exception e){
			throw new Exception();
		}
	}
	
	public void difundirEstoyActivo () throws Exception
	{
		/*
		 * 1. Difundo a través de la fachada que estoy activo
		 */
		try {
			fachada.difundirEstoyActivo();
		
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	public void recibirEquiposActivos () throws Exception
	{
		/*
		 * Establezco un LOOP infinito que realiza las siguientes acciones:
		 * 1. Le pido a la fachada que reciba la dirección IP de un equipo activo
		 * 2. Si devolvió el String "ninguna", no hago nada
		 * 3. En otro caso, actualizo la lista de equipos activos de la VentanaPrincipal
		 *    con la dirección IP del equipo activo que fue recibida
		 */
		try{
			 while(true){
				 String ip = fachada.recibirEquipoActivo();
				 if(!ip.equals("ninguna")){
					 ventanaPrincipal.getListEquiposActivos().add(ip);
				 }
			}
			 
		} catch(Exception e1){
			throw new Exception();
		}
	}
	
	public void enviarMensaje (String mensaje, String ipEquipoSeleccionado) throws Exception
	{
		/*
		 * 1. Envío a través de la fachada el mensaje recibido al equipo seleccionado
		 */
		try {
			fachada.enviarMensaje(mensaje, ipEquipoSeleccionado);
		
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public void mostrarVentanaMensajes ()
	{
		if (ventanaMensajes == null)
		{
			ventanaMensajes = new VentanaMensajes();
		}
	}
}
