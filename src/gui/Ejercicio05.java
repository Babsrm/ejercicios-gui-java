package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio05 extends JFrame {
	
//	Ejercicio 4. Crea una aplicación que tenga tres botones como los siguientes:
//	Cuando arranque la aplicación el botón Habilita debe estar deshabilitado. Cuando se 
//	pulse el botón “Deshabilita Central”, el botón Central y “Deshabilita Central” deberán 
//	deshabilitarse para que no se pueden pinchar y habilitar el botón “Habilita Central”. El 
//	botón “Habilita central” hará lo contrario volverá a habilitar los otros dos botones y se 
//	deshabilitará el mismo.

	private JPanel contentPane;
private JButton btnDesCentral;
private JButton btnCentral;
private JButton btnHabCentral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio05 frame = new Ejercicio05();
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
	public Ejercicio05() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][:15:30][][:15:30px][][grow]", "[]"));
		
		btnDesCentral = new JButton("Deshabilita Central");
		btnDesCentral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHabCentral.setEnabled(true);		
				btnDesCentral.setEnabled(false);
				btnCentral.setEnabled(false);
			}
		});
		contentPane.add(btnDesCentral, "cell 1 0");
		
		btnCentral = new JButton("Central");
		contentPane.add(btnCentral, "cell 3 0");
		
		btnHabCentral = new JButton("Habilita Central");
		btnHabCentral.setEnabled(false);
		btnHabCentral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHabCentral.setEnabled(false);		
				btnDesCentral.setEnabled(true);
				btnCentral.setEnabled(true);
			}
		});
		contentPane.add(btnHabCentral, "cell 5 0");
	}

}
