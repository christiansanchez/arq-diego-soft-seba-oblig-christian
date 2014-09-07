package grafica;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.TextField;

public class VentanaPrincipal
{
	private ControladorPrincipal controlador = null;
	
	private Frame frame = null;  //  @jve:decl-index=0:visual-constraint="122,19"
	private Label labelSeleccioneEquipo = null;
	private Button buttonEnviarMensaje = null;  //  @jve:decl-index=0:visual-constraint="485,128"
	private List listEquiposActivos = null;

	private Panel panel = null;

	private Button buttonDifundirEstoyActivo = null;

	private TextField textFieldMensaje = null;

	public Frame getFrame()
	{
		if (frame == null)
		{
			frame = new Frame();
			frame.setSize(new java.awt.Dimension(337,197));
			frame.setTitle("Equipos Activos");
			frame.setResizable(false);
			frame.add(getButtonDifundirEstoyActivo(), java.awt.BorderLayout.NORTH);
			frame.add(getListEquiposActivos(), java.awt.BorderLayout.CENTER);
			frame.add(getPanel(), java.awt.BorderLayout.SOUTH);
			frame.addWindowListener(new java.awt.event.WindowAdapter() 
			{
				public void windowClosing(java.awt.event.WindowEvent e) 
				{
					frame.dispose();
					System.exit(0);
				}
			});
		}
		return frame;
	}

	public List getListEquiposActivos()
	{
		if (listEquiposActivos == null)
		{
			listEquiposActivos = new List();
			listEquiposActivos.setBackground(new java.awt.Color(249,250,185));
		}
		return listEquiposActivos;
	}

	private Panel getPanel()
	{
		if (panel == null)
		{
			labelSeleccioneEquipo = new Label();
			labelSeleccioneEquipo.setText("Seleccione un equipo y escríbale un mensaje:");
			labelSeleccioneEquipo.setBackground(new java.awt.Color(198,240,199));
			labelSeleccioneEquipo.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));

			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(3);
			gridLayout.setColumns(1);
			panel = new Panel();
			panel.setLayout(gridLayout);
			panel.add(labelSeleccioneEquipo, null);
			panel.add(getTextFieldMensaje(), null);
			panel.add(getButtonEnviarMensaje(), null);
		}
		return panel;
	}
	
	private Button getButtonDifundirEstoyActivo()
	{
		if (buttonDifundirEstoyActivo == null)
		{
			buttonDifundirEstoyActivo = new Button();
			buttonDifundirEstoyActivo.setLabel("Difundir que estoy activo");
			buttonDifundirEstoyActivo.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			buttonDifundirEstoyActivo.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) 
						{
							/*
							 * 1. Le pido al controlador que difunda que estoy activo
							 */
							controlador.difundirEstoyActivo();
						}
					});
		}
		return buttonDifundirEstoyActivo;
	}

	public Button getButtonEnviarMensaje()
	{
		if (buttonEnviarMensaje == null)
		{
			buttonEnviarMensaje = new Button();
			buttonEnviarMensaje.setLabel("Enviar Mensaje");
			buttonEnviarMensaje.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
			buttonEnviarMensaje.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e)
				{
					/*
					 * 1. Obtengo la IP del equipo seleccionado de la lista de equipos activos
					 * 2. Si no hay ninguna seleccionada, no hago nada
					 * 3. En otro caso, obtengo el texto del mensaje escrito por el usuario
					 *    y le pido a mi controlador que se lo envíe al equipo seleccionado
					 * 4. le pido al controlador que muestre la ventana de mensajes
					 */
					String ip = getListEquiposActivos().getSelectedItem();
					if(ip != null){
						controlador.enviarMensaje(textFieldMensaje.getText(), ip);
					}
					controlador.mostrarVentanaMensajes();
				}
			});
		}
		return buttonEnviarMensaje;
	}

	private TextField getTextFieldMensaje()
	{
		if (textFieldMensaje == null)
		{
			textFieldMensaje = new TextField();
		}
		return textFieldMensaje;
	}

	public VentanaPrincipal ()
	{
		this.getFrame().setVisible(true);
		controlador = new ControladorPrincipal(this);
		/*
		 * 1. pongo al controlador a recibirEquiposActivos
		 */
		controlador.recibirEquiposActivos();
	}
}
