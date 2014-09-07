package grafica;

import java.awt.TextArea;

import logica.Fachada;

public class ControladorMensajes
{
	private VentanaMensajes ventanaMensajes = null;
	private Fachada fachada;
	
	public ControladorMensajes (VentanaMensajes ventana)
	{
		this.ventanaMensajes = ventana;
		fachada = Fachada.getInstancia();
	}
	
	public void recibirMensajes ()
	{
		/*
		 * Establezco un LOOP infinito que realiza las siguientes acciones:
		 * 1. Le pido a la fachada que reciba un mensaje dirigido a mí
		 * 2. Agrego el mensaje recibido al historial de mensajes mostrados en la VentanaMensajes
		 */
		while(true){
			String mensaje = fachada.recibirMensaje();
			TextArea texto = ventanaMensajes.getTextAreaConversacion();
			texto.append(mensaje);
		}
	}
}
