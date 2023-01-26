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
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;

public class Ejercicio03 extends JFrame {
	
//	Ejercicio 3. Crea un nueva ventana para el login de los usuarios. La ventana deberá tener dos 
//	etiquetas (JLabel) y dos cajas de texto (JTextField) y un botón Entrar (JButton).
//	Al pulsar el botón Entrar debe mostrar un mensaje si el intento de login es correcto o no. Una 
//	vez que lo tengas sustituye el campo de texto de la contraseña por un componente 
//	JPasswordField.


	private JPanel contentPane;
	private JTextField textCampoUsuario;
	private JPasswordField textCampoPassword;
	
	private Ejercicio03 ventana;
	private int numIntentos;
	private JButton btnInicioSesion;

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
		this.numIntentos=3;
		
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
		textCampoUsuario.addKeyListener(new KeyAdapter() {
			@Override
		//evento listener que, tras pulsar enter, le pasa el focus al siguiente campo (password)
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					textCampoPassword.requestFocusInWindow();
				}
			}
		});
		contentPane.add(textCampoUsuario, "cell 2 1 2 1,growx");
		textCampoUsuario.setColumns(10);
		
		
		JLabel lblPassword = new JLabel("Contraseña");
		contentPane.add(lblPassword, "cell 0 3");
		
		textCampoPassword = new JPasswordField();
		textCampoPassword.addKeyListener(new KeyAdapter() {
			@Override
			//evento listener que, tras pulsar enter, le pasa el focus al botón de inicio sesión
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnInicioSesion.requestFocusInWindow();
				}
			}
		});
		contentPane.add(textCampoPassword, "cell 2 3 2 1,growx");
		textCampoPassword.setColumns(10);
		
		btnInicioSesion = new JButton("Iniciar Sesión");
		btnInicioSesion.addKeyListener(new KeyAdapter() {
			@Override
			//evento listener que hace clic al pulsar enter
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnInicioSesion.doClick();
				}
			}
		});
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();				
			}

			
		});
		contentPane.add(btnInicioSesion, "cell 0 5 4 1,alignx center");		
		ventana = this;
		//this.setRootPane().setDefaultButton(btnInicioSesion);
	}
	//	Este login es sencillo. No tengo DB de usuarios por lo que si la contraseña y el usuario coinciden, hará el login.
		private void login() {
			
			String pass = new String(textCampoPassword.getPassword());
		//	String user = textCampoUsuario.getText();
			if (textCampoUsuario.getText().equals("") || pass.equals("") || !textCampoUsuario.getText().equals(pass))
			//si el usuario es vacio o la pass es vacia o el usuario y la pass son diferentes entre sí
			// también podría haberlo escrito como user=null o user.isBlank();
			{
				numIntentos--;
				JOptionPane.showMessageDialog(null, "Error: usuario y/o contraseña incorrectos. Te quedan "+numIntentos +" intentos de login.","Fallo inicio sesión",JOptionPane.ERROR_MESSAGE);
				//este diálogo aparece centrado según la pantalla del usuario. gracias al null
				
				if (numIntentos<=0) {
					System.exit(0);
					//se sale del programa tras tres intentos
				}
			};
			if (textCampoUsuario.getText().equals(pass) && !pass.equals("")) {
				JOptionPane.showMessageDialog(this,  "Bienvenido. Haga clic para continuar.", "Inicio de sesión correcto.", JOptionPane.INFORMATION_MESSAGE);
				//este diálogo aparece centrado según la ventana de login, gracias al this
			}
	}

}
