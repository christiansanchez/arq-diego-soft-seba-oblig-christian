package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.Persistencia;
import logica.IServidorChat;

public class VentanaChat extends UnicastRemoteObject implements ActionListener, IVentanaChat
{
	private static final long serialVersionUID = 1L;

	// Componentes gráficos de la ventana
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JTextField textField;
    private JLabel label;
    private JButton button;
    IServidorChat iServidorChat;

    public VentanaChat () throws RemoteException
    {
        // instancio los componentes graficos de la ventana
        frame = new JFrame ("Mini Chat Remoto");
        textField = new JTextField();
        label = new JLabel ();
        Color col = new Color(170,200,245);
        label.setBackground(col);
        button = new JButton ("Enviar mensaje");

        // agrupo apropiadamente los componentes
        panel1 = new JPanel (new BorderLayout());
        panel2 = new JPanel (new BorderLayout());
        panel1.add(label,BorderLayout.CENTER);
        panel2.add(textField,BorderLayout.CENTER);
        panel2.add(button,BorderLayout.EAST);

        // se los agrego al marco de la ventana
        frame.setLayout(new GridLayout(2,1));
        frame.add(panel1);
        frame.add(panel2);
        frame.setSize(500,90);
        frame.setResizable(false);
       
        // registro a esta ventana como escucha de todos los eventos
        // relevantes que el usuario puede realizar sobre ella
        button.addActionListener(this);

        // finalmente, hago visible la ventana
        frame.setVisible(true);
    }

    public void actionPerformed (ActionEvent e)
    {
    	/*
    	 * 1. me conecto con el servidor vía RMI
    	 * 2. si es la primera vez que me conecto, le paso mi url para que la registre
    	 * 3. le paso el mensaje que el usuario acaba de escribir en el campo de texto
    	 */
    	try {
    		String mensaje = textField.getText();
    		Properties prop = new Properties();
    		prop.load(new FileInputStream("properties/server.properties"));
			String ipServidor = prop.getProperty("Servidor");
			String puerto = prop.getProperty("Puerto");
			iServidorChat = (IServidorChat) Naming.lookup("//" + ipServidor + ":" + puerto + "/servidor");
			iServidorChat.registrarCliente("//" + InetAddress.getLocalHost().getHostAddress() + ":" + puerto + "/cliente");
			iServidorChat.publicarMensaje(mensaje);

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
    }

    public void updateMensaje (String msg) throws RemoteException
    {
    	/*
    	 * a este método me lo invoca el servidor cuando le llega un nuevo mensaje
    	 * 1. actualizo mi etiqueta con el mensaje que acabo de recibir
    	 */
    	label.setText(msg);
    }    

}