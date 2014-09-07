package grafica;

import java.awt.Frame;
import java.awt.TextArea;

public class VentanaMensajes
{
	private ControladorMensajes controlador = null;
	
	private Frame frame = null;  //  @jve:decl-index=0:visual-constraint="145,18"
	private TextArea textAreaMensaje = null;
	public Frame getFrame()
	{
		if (frame == null)
		{
			frame = new Frame();
			frame.setSize(new java.awt.Dimension(376,210));
			frame.setTitle("Mensajes");
			frame.setResizable(false);
			frame.add(getTextAreaConversacion(), java.awt.BorderLayout.CENTER);
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					frame.dispose();
					System.exit(0);
				}
			});
		}
		return frame;
	}

	public TextArea getTextAreaConversacion()
	{
		if (textAreaMensaje == null)
		{
			textAreaMensaje = new TextArea();
			textAreaMensaje.setEditable(false);
		}
		return textAreaMensaje;
	}

	public VentanaMensajes ()
	{
		this.getFrame().setVisible(true);
		controlador = new ControladorMensajes(this);
		/*
		 * 1. pongo al controlador a recibirMensajes
		 */
		controlador.recibirMensajes();
	}
}
