package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Ejercicio07 extends JFrame {
//	
//	Ejercicio 6. Crea la siguientes aplicación que muestra cuatro botones de tipo radio 
//	(JRadioButton) con el nombre de un color y un JPanel a la derecha de tal manera que cuando 
//	se pulse uno de los botones se modifique el color del panel de la derecha. Dos botones no se 
//	podrán seleccionar al mismo tiempo

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio07 frame = new Ejercicio07();
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
	public Ejercicio07() {
		setTitle("Ejercicio07");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[39.00,fill][19.00][][][grow][41,fill]", "[fill][23.00][][][][][grow]"));
		
		JLabel lblSelecciona = new JLabel("Selecciona un color:");
		contentPane.add(lblSelecciona, "cell 1 1 2 1");
		
		JRadioButton rdbtnAzul = new JRadioButton("Azul");
		buttonGroup.add(rdbtnAzul);
		rdbtnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAzul.isSelected()) {
					textField.setBackground(Color.BLUE);
				} else {
					textField.setBackground(Color.WHITE);
				}
			}
		});
		
		contentPane.add(rdbtnAzul, "cell 2 2");
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		textField.setBackground(new Color(255, 255, 255));
		contentPane.add(textField, "cell 4 2 1 4,grow");
		textField.setColumns(10);
		
		JRadioButton rdbtnRojo = new JRadioButton("Rojo");
		buttonGroup.add(rdbtnRojo);
		rdbtnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnRojo.isSelected()) {
					textField.setBackground(Color.RED);
				} else {
					textField.setBackground(Color.WHITE);
				}
			}
		});
		contentPane.add(rdbtnRojo, "cell 2 3");
		
		JRadioButton rdbtnVerde = new JRadioButton("Verde");
		buttonGroup.add(rdbtnVerde);
		rdbtnVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnVerde.isSelected()) {
					textField.setBackground(Color.GREEN);
				} else {
					textField.setBackground(Color.WHITE);
				}
			}
		});
		contentPane.add(rdbtnVerde, "cell 2 4");
		
		JRadioButton rdbtnMagenta = new JRadioButton("Magenta");
		rdbtnMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMagenta.isSelected()) {
					textField.setBackground(Color.MAGENTA);
				} else {
					textField.setBackground(Color.WHITE);
				}
			}
		});
		buttonGroup.add(rdbtnMagenta);
		contentPane.add(rdbtnMagenta, "cell 2 5");
	}

}
