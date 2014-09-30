import grafica.VentanaGestion;

public class Main {

	public static void main(String[] args) throws Exception {
		VentanaGestion window = null;
		try {
			if(window == null){
				window = new VentanaGestion();
			}
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
