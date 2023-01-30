package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio09 extends JFrame {
	
//	Ejercicio 8. Crea una simple lista de películas. tendremos un JComboBox, donde 
//	almacenaremos las películas, que vayamos almacenando en un campo de texto. Al pulsar el 
//	botón Añadir la película que hayamos metido, se introducirá en el JComboBox.

	private JPanel contentPane;
	private JTextField textPelicula;
	private JComboBox<String> comboBoxPeliculas;
	private JLabel lblAviso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio09 frame = new Ejercicio09();
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
	public Ejercicio09() {
		setTitle("Ejercicio09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[][][][40][]"));
		
		JLabel lblEnunciado = new JLabel("Escribe el título de una película:");
		contentPane.add(lblEnunciado, "flowx,cell 0 0");
		
		JLabel lblPeliculas = new JLabel("Películas:");
		contentPane.add(lblPeliculas, "cell 1 0");
		
		textPelicula = new JTextField();
		contentPane.add(textPelicula, "cell 0 2,growx");
		textPelicula.setColumns(10);
		
		comboBoxPeliculas = new JComboBox<String>();
		comboBoxPeliculas.setModel(new DefaultComboBoxModel<String>(new String[] {"Beetlechus", "Orgullo y Prejuicio"}));
		contentPane.add(comboBoxPeliculas, "cell 1 2,growx");
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
							
		//voy a recorrer mi comboBox para comprobar si la película ya está dentro y avisar al usuario con un mensaje
		//meto en una variable la lista que ya tengo de películas
				ComboBoxModel<String> modelo = comboBoxPeliculas.getModel();
		//recorro la lista
			for (int i = 0; i < modelo.getSize(); i++) {
		//si la película ya está incluida en alguna posición del modelo, con el boolean lo cambiamos a true y mostramos mensaje
				if (modelo.getElementAt(i).equals(textPelicula.getText())) {
					encontrado = true;
					lblAviso.setForeground(Color.RED);
					lblAviso.setText("La película ya está incluída en la lista.");
				}
			}
		//si la película no se encuentra en el modelo, la añade
			if (!encontrado) {
				lblAviso.setText("");
				comboBoxPeliculas.addItem(textPelicula.getText());
			}
			}
		});
		
		lblAviso = new JLabel("");
		contentPane.add(lblAviso, "cell 0 3 2 1");
		contentPane.add(btnAnadir, "cell 0 4 2 1,alignx center");
	}

}
