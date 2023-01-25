package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ejercicio04 extends JFrame {
	
//	Ejercicio 3. Crea una aplicación intentando imitar en la medida de lo posible el formato de la 
//	siguiente ventana:
//	Esta compuesta por cuatro JTextField, uno para el nombre y otros 3 para las tres notas 
//	diferentes. Luego tendrá un botón Calcula que calcular la media de los tres elementos. Cuando 
//	lo calcule el resultado se mostrará el resultado en la etiqueta JLabel a la izquierda de Promedio 
//	y en resultado pondrá el siguiente mensaje:
//	• Si el promedio es mayor que un 5 se escribe “Ha aprobado la asignatura”
//	• Si no escribe “Toca recuperar”.

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNota1;
	private JTextField textNota2;
	private JTextField textNota3;
	private JLabel lblPromedio;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio04 frame = new Ejercicio04();
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
	public Ejercicio04() {
		setTitle("Ejercicio 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[10][grow][50.00][grow][50][grow,leading][50][10]", "[::30,grow,fill][10][25][10][25][][][30,grow][30,grow]"));
		
		JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(new Color(0, 0, 0));
		contentPane.add(lblTitulo, "cell 1 0 6 1,growx");
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre, "cell 1 2");
		
		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 2 2 5 1,growx");
		textNombre.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota1:");
		contentPane.add(lblNota1, "cell 1 4,alignx left");
		
		textNota1 = new JTextField();
	
		textNota1.setColumns(10);
		contentPane.add(textNota1, "cell 2 4");
		
		JLabel lblNota2 = new JLabel("Nota2:");
		contentPane.add(lblNota2, "cell 3 4,alignx left");
		
		textNota2 = new JTextField();
		textNota2.setColumns(10);
		contentPane.add(textNota2, "cell 4 4,growx");
		
		JLabel lblNota3 = new JLabel("Nota3:");
		contentPane.add(lblNota3, "cell 5 4,alignx left");
		
		textNota3 = new JTextField();
		textNota3.setColumns(10);
		contentPane.add(textNota3, "cell 6 4,growx");
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				double nota1 = Double.parseDouble(textNota1.getText());
				double nota2 = Double.parseDouble(textNota2.getText());
				double nota3 = Double.parseDouble(textNota3.getText());
				if (nota1<0 || nota1>10 
						||
					nota2<0 || nota2>10
						||
					nota3<0 || nota3>10) {
					JOptionPane.showMessageDialog(null,"Alguna de las notas introducidas no es correcta. Por favor, introduzca un valor entre 0 y 10." ,"Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				double promedio = (nota1 + nota2 + nota3)/3;
				lblPromedio.setText("Promedio: " +promedio);
				
				if (promedio >5) {
					lblResultado.setText("Resultado: Ha aprobado la asignatura."); 
				} else {
					lblResultado.setText("Resultado: Toca recuperar.");
				}
				}	
			 catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Debe de introducir valores válidos. Evite usar caracteres. Por favor, introduzca un valor entre 0 y 10.", "Error", JOptionPane.ERROR_MESSAGE);
			}}}
		);
		contentPane.add(btnCalcular, "cell 5 6 2 1,growx");
		
		lblPromedio = new JLabel("Promedio: ");
		contentPane.add(lblPromedio, "cell 1 7 6 1,alignx left");
		
		lblResultado = new JLabel("Resultado:");
		contentPane.add(lblResultado, "cell 1 8 6 1,alignx left");
	}

}
