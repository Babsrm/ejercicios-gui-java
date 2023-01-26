package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio10 extends JFrame {
	
//	Ejercicio 9. Haz una interfaz de usuario como la siguiente:
//	La aplicación deberá tener un JTextField dónde el usuario introducirá una cantidad y en 
//	que unidad monetaria se encuentra, que se seleccionará entre tres posibilidades 
//	mediante un JRadioButtons. También seleccionará la unidad a la que la quiere 
//	convertir. Cuando se pulse el botón Calcular deberá calcular el cambio monetario. 
//	Deberás controlar que el cambio no se haga entre dos monedas iguales, en ese caso 
//	indica al usuario que debe elegir una moneda diferentes (hazlo mediante un 
//	JOptionPane.showMessageDialog)

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio10 frame = new Ejercicio10();
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
	public Ejercicio10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
