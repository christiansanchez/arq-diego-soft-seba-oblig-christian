package logica;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Fachada 
{
	private static Fachada instancia = null;
	private DatagramSocket socketDifusion = null;
	private DatagramSocket socketEquiposActivos = null;
	private DatagramSocket socketEnvioMensajes = null;
	private DatagramSocket socketRecepcionMensajes = null;
	
	private Fachada ()
	{
		/*
		 * 1. creo socketDifusion en el puerto 5001 para difundir que estoy activo
		 * 2. creo socketEquiposActivos en el puerto 5002 para recibir avisos de equipos activos
		 * 3. creo socketEnvioMensajes en el puerto 5003 para enviar mensaje personal a un equipo seleccionado
		 * 4. creo socketRecepcionMensajes en el puerto 5004 para recibir mensajes personales
	 	 */
	}
	
	public synchronized static Fachada getInstancia ()
	{
		if (instancia == null)
			instancia = new Fachada();
		return instancia;
	}
	
	public void difundirEstoyActivo ()
	{
		/* 
		 * Procedo a enviar un mensaje en broadcast difundiendo que estoy activo
		 * 1. Creo un paquete UDP conteniendo el mensaje "ArqSoft" de 64 bytes
		 * 2. Lo difundo a toda la red por el socketDifusion a trav�s de la IP de broadcast 255.255.255.255
		 */
	}
	
	public String recibirEquipoActivo ()
	{
		String ipEmisor = null;
		/*
		 * Procedo a recibir un mensaje de alg�n otro equipo que difundi� que est� activo
		 * 1. Recibo un paquete UDP de 64 bytes a trav�s del socketEquiposActivos
		 * 2. Si trae el mensaje "ArqSoft", retorno un String con la direcci�n IP del emisor
		 * 3. Si no trae el mensaje "ArqSoft", retorno el String "ninguna"
		 */	
		return ipEmisor;
	}

	public void enviarMensaje (String mensaje, String ipEquipoSeleccionado)
	{
		/* 
		 * Procedo a enviar el mensaje a la direccion IP del equipo seleccionado
		 * 1. Creo un paquete UDP de 64 bytes conteniendo el mensaje pasado por par�metro
		 * 2. Lo env�o a la IP del equipo seleccionado a trav�s del socketEnvioMensajes
		 */
	}

	public String recibirMensaje ()
	{
		String mensaje = null;
		/*
		 * Procedo a recibir un mensaje de alg�n otro equipo dirigido expresamente a m�
		 * 1. Recibo un paquete UDP de 64 bytes a trav�s del socketRecepcionMensajes
		 * 2. Extraigo la IP del emisor + el contenido del mensaje y los retorno en un String
		 * 3. Agrego la IP del emisor + el contenido del mensaje al historial de mensajes en la Persistencia
		 */	
		return mensaje;
	}
}