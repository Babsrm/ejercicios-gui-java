package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio08 extends JFrame {
	
//	Ejercicio 8. Haz un programa que contenga un JCombobox con algunas de las ciudades de 
//	Granada. También tendrá un botón Aceptar y dos etiquetas, una con el texto “Has 
//	seleccionado” y otra a su derecha donde se mostrará el mensajede la ciudad que se ha 
//	seleccionado en la lista desplegable (JCombobox).

	private JPanel contentPane;
private JLabel lblCiudadSelec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio08 frame = new Ejercicio08();
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
	public Ejercicio08() {
		setTitle("Ejercicio08");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][]"));
		
		JLabel lblCiudad = new JLabel("Ciudad");
		contentPane.add(lblCiudad, "cell 0 0");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionado = (String) comboBox.getSelectedItem();
				//se coge con el getter la ciudad seleccionada. como es un objeto, tenemos que transformarla a String
				lblCiudadSelec.setText(seleccionado);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Granada", "Armilla", "Huetor Vega", "Alfacar", "Loja", "Atarfe", "Guadix", "Baza", "Monachil", "Las Gabias", "Cenes de la Vega", "Churriana de la Vega", "Huescar", "Jun", "Pinos Genil", "Güejar Sierra", "Dúdar", "Gójar", "Dúrcal", "Nigüelas", "Almuñecar", "Salobreña", "Lanjarón"}));
		contentPane.add(comboBox, "cell 2 0,growx");
		
		JLabel lblSeleccion = new JLabel("Has seleccionado: ");
		contentPane.add(lblSeleccion, "cell 0 2,aligny baseline");
		
		lblCiudadSelec = new JLabel("");
		contentPane.add(lblCiudadSelec, "cell 2 2");
	}

}
