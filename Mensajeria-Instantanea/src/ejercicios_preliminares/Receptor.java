package ejercicios_preliminares;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;


public class Receptor {
	public static void main(String[] args) throws Exception{
		try{
			System.out.println("inicia clase receptor");
			DatagramSocket ds = new DatagramSocket(5001);
			byte[] buf = new byte[64];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			while(true){
				ds.receive(dp);
				String msjRecibido = new String(buf);
				SocketAddress socketAddress = ds.getRemoteSocketAddress();
				System.out.println("Mensaje recibido: " + msjRecibido);
//				System.out.println("IP sender: " + socketAddress.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
