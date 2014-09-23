package logica;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import persistencia.Persistencia;

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
		try {
			socketDifusion = new DatagramSocket(5001);
			socketEquiposActivos = new DatagramSocket(5002);
			socketEnvioMensajes = new DatagramSocket(5003);
			socketRecepcionMensajes = new DatagramSocket(5004);
		} catch (SocketException e) {
			e.printStackTrace();
		}
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
		 * 2. Lo difundo a toda la red por el socketDifusion a través de la IP de broadcast 255.255.255.255
		 */
		try {
			byte[] buf = new byte[64];
			String mensaje = "ArqSoft";
			buf = mensaje.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("255.255.255.255"), 5002);
			socketDifusion.send(dp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String recibirEquipoActivo ()
	{
		String ipEmisor = null;
		/*
		 * Procedo a recibir un mensaje de algún otro equipo que difundió que está activo
		 * 1. Recibo un paquete UDP de 64 bytes a través del socketEquiposActivos
		 * 2. Si trae el mensaje "ArqSoft", retorno un String con la dirección IP del emisor
		 * 3. Si no trae el mensaje "ArqSoft", retorno el String "ninguna"
		 */
		try {
			byte[] buf = new byte[64];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			socketEquiposActivos.receive(dp);
			String mensaje = new String(buf);
			mensaje = mensaje.trim();
			if(mensaje.equals("ArqSoft")){
				ipEmisor = dp.getAddress().getHostAddress();
			}else{
				ipEmisor = "ninguna";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ipEmisor;
	}

	public void enviarMensaje (String mensaje, String ipEquipoSeleccionado)
	{
		/* 
		 * Procedo a enviar el mensaje a la direccion IP del equipo seleccionado
		 * 1. Creo un paquete UDP de 64 bytes conteniendo el mensaje pasado por parámetro
		 * 2. Lo envío a la IP del equipo seleccionado a través del socketEnvioMensajes
		 */
		try {
			byte[] buf = new byte[64];
			buf = mensaje.getBytes();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(ipEquipoSeleccionado), 5004);
			socketEnvioMensajes.send(dp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String recibirMensaje ()
	{
		String mensaje = null;
		/*
		 * Procedo a recibir un mensaje de algún otro equipo dirigido expresamente a mí
		 * 1. Recibo un paquete UDP de 64 bytes a través del socketRecepcionMensajes
		 * 2. Extraigo la IP del emisor + el contenido del mensaje y los retorno en un String
		 * 3. Agrego la IP del emisor + el contenido del mensaje al historial de mensajes en la Persistencia
		 */	
		try {
			byte[] buf = new byte[64];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			socketRecepcionMensajes.receive(dp);
			mensaje = new String(buf);
			mensaje = mensaje.trim();
			
			Persistencia p = new Persistencia();
			p.persistirMensaje(dp.getAddress().getHostAddress(), mensaje);

			mensaje = dp.getAddress().getHostAddress() + ":" + mensaje;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mensaje;
	}
	
	public boolean validateUser (String name, String pwd){
		//TODO: DARIN: consumir desde web service
		return false;
	}
}
