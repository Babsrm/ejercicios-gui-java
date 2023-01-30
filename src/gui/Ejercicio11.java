package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import clases.Profesor;
import net.miginfocom.swing.MigLayout;

public class Ejercicio11 extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtSalario;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnBuscar;
	private JButton btnSalir;
	private JButton btnAnadir;
	private JButton btnLimpiar;
	private List<Profesor> listaProfesores;
	private JRadioButton rdbFijo;
	private JRadioButton rdbTemporal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio11 frame = new Ejercicio11();
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
	public Ejercicio11() {
		this.listaProfesores = new ArrayList<Profesor>();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][174.00,grow][grow]", "[][][][][][grow]"));
		
		JLabel lblDni = new JLabel("DNI:");
		contentPane.add(lblDni, "cell 0 1 2 1,alignx trailing");
		
		txtDni = new JTextField();
		contentPane.add(txtDni, "flowx,cell 2 1,growx");
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		contentPane.add(lblNombre, "cell 0 2 2 1,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		contentPane.add(txtNombre, "cell 2 2,growx");
		
		JLabel lblSalario = new JLabel("Salario:");
		contentPane.add(lblSalario, "cell 0 3 2 1,alignx trailing");
		
		btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarProfesor();
			}
		});
		contentPane.add(btnAnadir, "cell 3 1,growx");
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}
		});
		contentPane.add(btnLimpiar, "cell 3 2,growx");
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		contentPane.add(txtSalario, "cell 2 3,growx");
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProfesor();
			}
		});
		contentPane.add(btnBuscar, "cell 3 3,growx");
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir, "cell 3 4,growx");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipos de contrato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, "cell 0 5 2 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[][]"));
		
		rdbFijo = new JRadioButton("Fijo");
		buttonGroup.add(rdbFijo);
		panel.add(rdbFijo, "cell 0 0");
		
		rdbTemporal = new JRadioButton("Temporal");
		buttonGroup.add(rdbTemporal);
		panel.add(rdbTemporal, "cell 0 1");
	}

	protected void buscarProfesor() {
		String dni = txtDni.getText();
		Profesor p = new Profesor();
		p.setDni(dni);
		
		int indice = listaProfesores.indexOf(p); //devuelve el índice de donde se encuentra el profesor con el dni indicado
		if (indice != -1) { // !-1 es que el profesor lo ha encontrado
			p = listaProfesores.get(indice);
			txtNombre.setText(p.getNombre());
			txtSalario.setText(""+p.getSalario());
			if (p.isFijo()) {
				rdbFijo.setSelected(true);
				rdbTemporal.setSelected(false);
			} else {
				rdbFijo.setSelected(false);
				rdbTemporal.setSelected(true);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se ha encontrado el profesor con el dni "+dni+".", "Profesor no encontrado", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}

	protected void limpiarDatos() {
		txtDni.setText("");
		txtNombre.setText("");
		txtSalario.setText("");
		rdbTemporal.setSelected(false);
		rdbFijo.setSelected(true);
		
	}

	protected void insertarProfesor() {
		String dni=txtDni.getText();
		String nombre = txtNombre.getText();
		double salario = Double.parseDouble(txtSalario.getText());
		boolean fijo = rdbFijo.isSelected();
		
		if (nombre == null || nombre.isBlank() || dni==null || dni.isBlank()) {
			JOptionPane.showMessageDialog(this, "introduzca el nombre y el dni", "faltan datos", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Profesor p = new Profesor(dni, nombre, salario, fijo);
			if (!listaProfesores.contains(p)) {
				listaProfesores.add(p);
			} ;
		}
	}


