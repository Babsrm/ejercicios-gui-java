package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio06 extends JFrame {
	
//	Ejercicio 6. Crea una aplicación que tenga la siguiente interfaz:
//	Esta basada en 4 JCheckButton un JTextPane para mostrar el resultado , dos etiquetas 
//	y JButton para mostrar el resultado. Cuando se pulse el botón comprobar se 
//	comprobará que JCheckbox están seleccionados mediante su método isSelected. Si el 
//	checkbox está seleccionado escribirá el texto de su etiqueta tal y como se ve en la 
//	figura


	private JPanel contentPane;
private JTextPane textPanel;
private JCheckBox chckbxDeportes;
private JCheckBox chckbxTecnologia;
private JCheckBox chckbxJuegos;
private JCheckBox chckbxCocina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio06 frame = new Ejercicio06();
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
	public Ejercicio06() {
		setTitle("Ejercicio06");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow]", "[][30,baseline][30][30][30][][]"));
		
		JLabel lblHobbies = new JLabel("Hobbies: ");
		contentPane.add(lblHobbies, "cell 1 0 2 1");
		
		JLabel lblSeleccion = new JLabel("Has seleccionado: ");
		contentPane.add(lblSeleccion, "cell 5 0");
		
		chckbxDeportes = new JCheckBox("Deportes");
		contentPane.add(chckbxDeportes, "cell 2 1");
		
		textPanel = new JTextPane();
		contentPane.add(textPanel, "cell 4 1 2 4,grow");
		
		chckbxTecnologia = new JCheckBox("Tecnología");
		contentPane.add(chckbxTecnologia, "cell 2 2");
		
		chckbxJuegos = new JCheckBox("Juegos");
		contentPane.add(chckbxJuegos, "cell 2 3");
		
		chckbxCocina = new JCheckBox("Cocina");
		contentPane.add(chckbxCocina, "cell 2 4");
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
		contentPane.add(btnComprobar, "cell 4 6 2 1,alignx center");	
	}
	protected void comprobar() {
		String texto = "";
			if (chckbxDeportes.isSelected()) {
				texto="Deportes\n";
			} 
			if (chckbxTecnologia.isSelected()) {
				texto=texto+"Tecnologia\n";
			} 
			if (chckbxJuegos.isSelected()) {
				texto= texto+"Juegos\n";
			}
			if (chckbxCocina.isSelected() ) {
				texto=texto+"Cocina";
			}
			
			textPanel.setText(texto);
		}

}
