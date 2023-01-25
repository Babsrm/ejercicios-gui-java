package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio01 extends JFrame {
	
//	Ejercicio 1. Escribe una aplicación gráfica con una ventana que tenga una etiqueta y dos 
//	botones de operación. El comportamiento de la aplicación debe reflejar en el texto de la 
//	etiqueta cuál es el último botón en el que el usuario ha hecho clic.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio01 frame = new Ejercicio01();
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
	public Ejercicio01() {
		setTitle("ejecicio1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[grow,fill][center][][center][][center][grow,fill]", "[]"));
		
		JLabel lblNewLabel = new JLabel("Pulsa un botón");
		
		getContentPane().add(lblNewLabel, "cell 1 0");
		
		JButton btnNewButton = new JButton("Botón 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has pulsado botón 1");
			}
		});
		getContentPane().add(btnNewButton, "cell 3 0");
		
		JButton btnNewButton_1 = new JButton("Botón 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has pulsado botón 2");
			}
		});
		
		getContentPane().add(btnNewButton_1, "cell 5 0");
	}
}
