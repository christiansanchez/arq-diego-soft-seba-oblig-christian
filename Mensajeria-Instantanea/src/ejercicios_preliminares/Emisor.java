package ejercicios_preliminares;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Emisor {
	public static void main(String[] args) throws Exception{
		try{
			System.out.println("inicia clase emisor");
			DatagramSocket ds = new DatagramSocket(5000);
			byte[] buf = new byte[64];

			String msjAEnviar = new String();
			msjAEnviar = "Sebastián Sequeira";
			buf = msjAEnviar.getBytes();
			
			DatagramPacket dp;
			//Envíe paquete a la dirección IP del equipo de algún compañero que tenga corriendo el programa Receptor
			
			//dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("Think-seba"),5001);
			
			//broadcast
			dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("255.255.255.255"), 5001);
			
			ds.send(dp);
			ds.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
