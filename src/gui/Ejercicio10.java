package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField textValor;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnDolares_1;
	private JRadioButton rdbtnEuros_1;
	private JRadioButton rdbtnYenes_1;
	private JRadioButton rdbtnEuros;
	private JRadioButton rdbtnYenes;
	private JLabel lblResultadoRes;
	private JRadioButton rdbtnDolares;
	private JLabel lblResultado;

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
		contentPane.setLayout(new MigLayout("", "[grow][59.00][][][][][][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblTitulo = new JLabel("Conversión de monedas");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblTitulo, "cell 1 0 6 1,alignx center");
		
		JLabel lblLabel1 = new JLabel("De:");
		contentPane.add(lblLabel1, "cell 1 2");
		
		rdbtnDolares = new JRadioButton("Dólares");
		rdbtnDolares.setActionCommand("Dólares");
		buttonGroup.add(rdbtnDolares);
		contentPane.add(rdbtnDolares, "cell 2 2");
		
		rdbtnEuros = new JRadioButton("Euros");
		rdbtnEuros.setActionCommand("Euros"); //esta linea es necesaria para que me coja el valor (set action comand) del radio button. le puedo poner el valor que quiera pero abajo tengo que llamarlo igual en el swtich case
		buttonGroup.add(rdbtnEuros);
		contentPane.add(rdbtnEuros, "cell 4 2");
		
		rdbtnYenes = new JRadioButton("Yenes");
		rdbtnYenes.setActionCommand("Yenes");
		buttonGroup.add(rdbtnYenes);
		contentPane.add(rdbtnYenes, "cell 6 2");
		
		JLabel lblLabel2 = new JLabel("Cantidad: ");
		contentPane.add(lblLabel2, "cell 1 4,alignx trailing");
		
		textValor = new JTextField();
		contentPane.add(textValor, "cell 2 4 5 1,growx");
		textValor.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculo();
			}
		});
		contentPane.add(btnCalcular, "cell 1 6 6 1,alignx center");
		
		JLabel lblLabel3 = new JLabel("A: ");
		contentPane.add(lblLabel3, "cell 1 8");
		
		rdbtnDolares_1 = new JRadioButton("Dólares");
		rdbtnDolares_1.setActionCommand("Dólares");
		buttonGroup_1.add(rdbtnDolares_1);
		contentPane.add(rdbtnDolares_1, "cell 2 8");
		
		rdbtnEuros_1 = new JRadioButton("Euros");
		rdbtnEuros_1.setActionCommand("Euros");
		buttonGroup_1.add(rdbtnEuros_1);
		contentPane.add(rdbtnEuros_1, "cell 4 8");
		
		rdbtnYenes_1 = new JRadioButton("Yenes");
		rdbtnYenes_1.setActionCommand("Yenes");
		buttonGroup_1.add(rdbtnYenes_1);
		contentPane.add(rdbtnYenes_1, "cell 6 8");
		
		lblResultado = new JLabel("Resultado: ");
		contentPane.add(lblResultado, "cell 1 10 2 1");
		
		lblResultadoRes = new JLabel("");
		contentPane.add(lblResultadoRes, "cell 3 10 4 1");
	}

	protected void calculo() {
		String monedaOrigen = buttonGroup.getSelection().getActionCommand();
		String monedaDestino = buttonGroup_1.getSelection().getActionCommand();
		double resultado = 0;
		
		if (monedaOrigen.equals(monedaDestino)) {
			lblResultado.setText("");
			lblResultadoRes.setText("Las monedas son iguales.");
			return;
		} else {
			lblResultado.setText("Resultado:");
		}
	
		switch(monedaOrigen) {
		case "Dólares": {
			switch(monedaDestino) {
			case "Euros": resultado = Double.parseDouble(textValor.getText())*0.92; break;
			case "Yenes": resultado = Double.parseDouble(textValor.getText())*129.98; break;
			}}
		break;
		case "Euros": {
			switch (monedaDestino) {
			case "Dólares":resultado = Double.parseDouble(textValor.getText())*1.09; break;
			case "Yenes": resultado = Double.parseDouble(textValor.getText())*141.41; break;
			}
		}
		break;
		case "Yenes": {
			switch(monedaDestino) {
			case "Dólares": resultado = Double.parseDouble(textValor.getText())*0.0077; break;
			case "Euros": resultado = Double.parseDouble(textValor.getText())*0.0071; break;
			}
		}break;
		}lblResultadoRes.setText(""+resultado + " "+monedaDestino);
		
}}
