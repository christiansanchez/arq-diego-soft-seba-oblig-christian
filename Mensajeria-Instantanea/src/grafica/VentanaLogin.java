package grafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin {
	
	private ControladorLogin controlador = null;
	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField pwdPassword;
	private JLabel labelUsuario;
	private JLabel labelPassword;
	private JLabel labelDatos;
	private JButton buttonIniciarSesion;
	private JLabel labelError;

	public VentanaLogin() {
		controlador = new ControladorLogin(this);
		initialize();
		this.getFrame().setVisible(true);
	}

	public JFrame getFrame(){
		return this.frame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Servicio de autenticaci\u00F3n de usuarios");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		textUsuario.setBounds(129, 103, 295, 31);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		labelUsuario = new JLabel("Usuario:");
		labelUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelUsuario.setBounds(10, 103, 105, 31);
		frame.getContentPane().add(labelUsuario);
		
		labelPassword = new JLabel("Password:");
		labelPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelPassword.setBounds(10, 145, 109, 31);
		frame.getContentPane().add(labelPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		pwdPassword.setBounds(129, 148, 295, 31);
		frame.getContentPane().add(pwdPassword);
		
		labelDatos = new JLabel("Ingrese sus datos para iniciar sesi\u00F3n");
		labelDatos.setHorizontalAlignment(SwingConstants.CENTER);
		labelDatos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelDatos.setBounds(10, 11, 414, 31);
		frame.getContentPane().add(labelDatos);
		
		buttonIniciarSesion = new JButton("Iniciar sesi\u00F3n");
		buttonIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				controlador.iniciarSesion(textUsuario.getText(), pwdPassword.getPassword());
			}
		});
		buttonIniciarSesion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		buttonIniciarSesion.setBounds(10, 212, 414, 39);
		frame.getContentPane().add(buttonIniciarSesion);

		labelError = new JLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelError.setForeground(Color.RED);
		labelError.setBounds(10, 53, 414, 39);
		frame.getContentPane().add(labelError);
	}

	public void setErrorMsg(String error) {
		labelError.setText(error);
		
	}
}
