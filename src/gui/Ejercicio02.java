package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio02 extends JFrame {
	
//	Ejercicio 2. Intenta escribir una aplicación gráfica con una ventana que tenga dos etiquetas y 
//	dos botones de operación. El comportamiento de la aplicación debe reflejar en el texto de las 
//	etiquetas el número de veces que el usuario ha hecho clic en cada uno de los botones.

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio02 frame = new Ejercicio02();
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
	public Ejercicio02() {
		setTitle("Ejercicio 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,fill][][:20px:100px,grow 20,fill][][grow,fill]", "[][][]"));
		
		JLabel lblContador1 = new JLabel("Contador botón 1");
		contentPane.add(lblContador1, "cell 1 0");
		
		JButton btnBoton1 = new JButton("Boton1");
		btnBoton1.addActionListener(new ActionListener() {
		int contador1 = 0;	
		public void actionPerformed(ActionEvent e) {
			contador1++;
			lblContador1.setText("Has pulsado el botón1 " +contador1 +" veces.");
			}
		});
		contentPane.add(btnBoton1, "cell 3 0");
		
		JLabel lblContador2 = new JLabel("Contador botón 2");
		contentPane.add(lblContador2, "cell 1 2");
		
		JButton btnBoton2 = new JButton("Botón 2");
		
		btnBoton2.addActionListener(new ActionListener() {
		int contador2 = 0;	
		public void actionPerformed(ActionEvent e) {
			contador2++;
			lblContador2.setText("Has pulsado el botón2 " +contador2 +" veces.");
			}
		});
		contentPane.add(btnBoton2, "cell 3 2");
	}

}
