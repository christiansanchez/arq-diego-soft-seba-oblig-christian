import grafica.VentanaLogin;

public class Main
{
	public static void main(String[] args)
	{
		try {
			VentanaLogin window = new VentanaLogin();
			window.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//new VentanaPrincipal();
	}
}
