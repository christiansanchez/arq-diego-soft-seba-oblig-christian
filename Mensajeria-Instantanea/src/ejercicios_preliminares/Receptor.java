package ejercicios_preliminares;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


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
				System.out.print("IP: " + dp.getAddress().getHostAddress());
				System.out.print(" - Mensaje recibido: " + msjRecibido + "\n");
				//ds.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
