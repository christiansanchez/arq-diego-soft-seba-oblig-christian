package grafica;

import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.JOptionPane;

public class VentanaMensajes
{
	private ControladorMensajes controlador = null;
	private Frame frame = null;
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
		try{
			this.getFrame().setVisible(true);
			controlador = new ControladorMensajes(this);
			/*
			 * 1. pongo al controlador a recibirMensajes
			 */
			Thread hilo = new Thread(){
				public void run()
				{
					try {
						controlador.recibirMensajes();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Ups! Ocurrio un error interno, intente nuevamente..", "Error!", JOptionPane.ERROR_MESSAGE);
					}	
				}
			};
			hilo.start();
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ups! Ocurrio un error interno, intente nuevamente..", "Error!", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
