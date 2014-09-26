package grafica;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class VentanaGestion {
	
	private ControladorGestion controlador = null;
	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel create;
	private JPanel delete;
	private JPanel list;
	//CREAR USUARIO
	private JLabel lblAgregarUsuario;
	private JLabel lblAgregarPassword;
	private JTextField textAgregarUsuario;
	private JTextField textAgregarPassword;
	private JLabel lblAgregarTitulo;
	private JLabel lblAgregarError;
	private JLabel lblAgregarSuccess;
	private JButton btnAgregarUsuario;
	//BORRAR USUARIO
	private JLabel lblBorrarUsuario;
	private JLabel lblBorrarPassword;
	private JTextField textBorrarUsuario;
	private JTextField textBorrarPassword;
	private JLabel lblBorrarTitulo;
	private JLabel lblBorrarError;
	private JLabel lblBorrarSuccess;
	private JButton btnBorrarUsuario;
	//LISTAR USUARIOS
	private JScrollPane scrollPane;
	private JList<String> listUsuarios;
	private DefaultListModel<String> resultList;
	private JButton btnListarUsuarios;

	public VentanaGestion() {
		controlador = new ControladorGestion(this);
		initialize();
		this.getFrame().setVisible(true);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gesti\u00F3n de usuarios");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(tabbedPane);
		
		//COMIENZO PANEL CREAR USUARIO
		create = new JPanel();
		tabbedPane.addTab("Crear un nuevo usuario", null, create, null);
		create.setLayout(null);
	
		lblAgregarUsuario = new JLabel("Usuario:");
		lblAgregarUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblAgregarUsuario.setBounds(10, 59, 105, 31);
		create.add(lblAgregarUsuario);
		
		lblAgregarPassword = new JLabel("Password:");
		lblAgregarPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblAgregarPassword.setBounds(10, 101, 109, 31);
		create.add(lblAgregarPassword);
		
		textAgregarUsuario = new JTextField();
		textAgregarUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		textAgregarUsuario.setBounds(129, 59, 290, 31);
		create.add(textAgregarUsuario);
		textAgregarUsuario.setColumns(10);
		
		textAgregarPassword = new JTextField();
		textAgregarPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		textAgregarPassword.setBounds(129, 104, 290, 31);
		create.add(textAgregarPassword);
		textAgregarPassword.setColumns(10);
		
		btnAgregarUsuario = new JButton("Agregar usuario");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controlar existe
				controlador.crearUsuario(textAgregarUsuario.getText(), textAgregarPassword.getText());
			}
		});
		btnAgregarUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnAgregarUsuario.setBounds(10, 149, 409, 39);
		create.add(btnAgregarUsuario);
		
		lblAgregarTitulo = new JLabel("Ingrese un usuario y un password");
		lblAgregarTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblAgregarTitulo.setBounds(10, 11, 409, 31);
		create.add(lblAgregarTitulo);
		
		lblAgregarError = new JLabel("");
		lblAgregarError.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarError.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblAgregarError.setForeground(Color.RED);
		lblAgregarError.setBounds(10, 184, 409, 39);
		create.add(lblAgregarError);
		
		lblAgregarSuccess = new JLabel("");
		lblAgregarSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarSuccess.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblAgregarSuccess.setForeground(Color.GREEN);
		lblAgregarSuccess.setBounds(10, 184, 409, 39);
		create.add(lblAgregarSuccess);
		//FIN PANEL CREAR USUARIO
		
		//COMIENZO PANEL BORRAR USUARIO
		delete = new JPanel();
		tabbedPane.addTab("Borrar un usuario", null, delete, null);
		delete.setLayout(null);
		
		lblBorrarUsuario = new JLabel("Usuario:");
		lblBorrarUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblBorrarUsuario.setBounds(10, 59, 105, 31);
		delete.add(lblBorrarUsuario);
		
		lblBorrarPassword = new JLabel("Password:");
		lblBorrarPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblBorrarPassword.setBounds(10, 101, 109, 31);
		delete.add(lblBorrarPassword);
		
		textBorrarUsuario = new JTextField();
		textBorrarUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		textBorrarUsuario.setBounds(129, 59, 290, 31);
		delete.add(textBorrarUsuario);
		textBorrarUsuario.setColumns(10);
		
		textBorrarPassword = new JTextField();
		textBorrarPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		textBorrarPassword.setBounds(129, 104, 290, 31);
		delete.add(textBorrarPassword);
		textBorrarPassword.setColumns(10);
		
		btnBorrarUsuario = new JButton("Borrar usuario");
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controlar existe y si es valido
				controlador.borrarUsuario(textBorrarUsuario.getText());
			}
		});
		btnBorrarUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnBorrarUsuario.setBounds(10, 149, 409, 39);
		delete.add(btnBorrarUsuario);
		
		lblBorrarTitulo = new JLabel("Ingrese su usuario y password");
		lblBorrarTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblBorrarTitulo.setBounds(10, 11, 409, 31);
		delete.add(lblBorrarTitulo);
		
		lblBorrarError = new JLabel("");
		lblBorrarError.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarError.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblBorrarError.setForeground(Color.RED);
		lblBorrarError.setBounds(10, 184, 409, 39);
		delete.add(lblBorrarError);
		
		lblBorrarSuccess = new JLabel("");
		lblBorrarSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarSuccess.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblBorrarSuccess.setForeground(Color.GREEN);
		lblBorrarSuccess.setBounds(10, 184, 409, 39);
		delete.add(lblBorrarSuccess);
		//FIN PANEL BORRAR USUARIO
		
		//COMIENZO PANEL LISTAR USUARIOS
		list = new JPanel();
		tabbedPane.addTab("Listar usuarios", null, list, null);
		list.setLayout(null);
		
		btnListarUsuarios = new JButton("Listar todos los usuarios registrados");
		btnListarUsuarios.setBounds(10, 11, 409, 39);
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String[] listaUsuarios = controlador.listarUsuarios();
				
				for(int i = 0; i< listaUsuarios.length; i++)
				{
					resultList.clear();
					resultList.addElement(listaUsuarios[i]);
				}
			}
		});
		btnListarUsuarios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		list.add(btnListarUsuarios);
		
		resultList = new DefaultListModel<String>();
		listUsuarios = new JList<String>();
		listUsuarios.setModel(resultList);
		listUsuarios.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		listUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUsuarios.setBounds(10, 61, 409, 162);
		scrollPane = new JScrollPane(listUsuarios);
		scrollPane.setBounds(10, 61, 409, 162);
		list.add(scrollPane);
		//FIN PANEL LISTAR USUARIOS
	}
}
