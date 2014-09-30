import grafica.VentanaLogin;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		VentanaLogin window = null;
		try {
			if(window == null){
				window = new VentanaLogin();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
