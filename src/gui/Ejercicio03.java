package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Ejercicio03 extends JFrame {
	
//	Ejercicio 3. Crea un nueva ventana para el login de los usuarios. La ventana deberá tener dos 
//	etiquetas (JLabel) y dos cajas de texto (JTextField) y un botón Entrar (JButton).
//	Al pulsar el botón Entrar debe mostrar un mensaje si el intento de login es correcto o no. Una 
//	vez que lo tengas sustituye el campo de texto de la contraseña por un componente 
//	JPasswordField.


	private JPanel contentPane;
	private JTextField textCampoUsuario;
	private JPasswordField textCampoPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio03 frame = new Ejercicio03();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio03() {
		setTitle("Inicio de sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][]", "[fill][][][][grow,fill][]"));
		
		JLabel lblUsuario = new JLabel("Usuario");
		contentPane.add(lblUsuario, "cell 0 1");
		
		textCampoUsuario = new JTextField();
		contentPane.add(textCampoUsuario, "cell 2 1 2 1,growx");
		textCampoUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña");
		contentPane.add(lblPassword, "cell 0 3");
		
		textCampoPassword = new JPasswordField();
		contentPane.add(textCampoPassword, "cell 2 3 2 1,growx");
		textCampoPassword.setColumns(10);
		
		JButton btnInicioSesion = new JButton("Iniciar Sesión");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(textCampoPassword.getPassword());
				if (textCampoUsuario.getText().equals("") || pass.equals("") || !textCampoUsuario.getText().equals(pass))
				//si el usuario es vacio o la pass es vacia o el usuario y la pass son diferentes entre sí
				{
					JOptionPane.showMessageDialog(null, "Error: usuario y/o contraseña incorrectos","Fallo inicio sesión",JOptionPane.ERROR_MESSAGE);
				};
				if (textCampoUsuario.getText().equals(pass)) {
					JOptionPane.showMessageDialog(null,  "Bienvenido. Haga clic para continuar.", "Inicio de sesión correcto.", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		contentPane.add(btnInicioSesion, "cell 0 5 4 1,alignx center");
	}

}
