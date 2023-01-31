package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Contacto;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EjercicioListas extends JFrame {
	
//	Deberás crear una clase llamada Contacto que contenga dos campos, el nombre y el 
//	teléfono, sus métodos getters y setters, el método toString y los hashCode y equals.
//	El componente de la izquierda es un JTable donde mostraremos la lista de los teléfonos 
//	que vamos incluyendo en la interfaz de usuario. 
//	A la derecha tenemos dos JTextField, uno para el nombre y otro para el teléfono. Cuando 
//	se pulse el botón Añadir se creará un objeto de tipo Contacto y se añadirá a una lista (un 
//	ArrayList<Contacto> y se actualizará la información del JTable.
//	Si se marca un contacto del JTable y se pulsa en Eliminar se eliminará el contacto de la 
//	JTable y se actualizará la lista para mostrar que se ha borrado.
//	El botón Salir saldrá de la aplicación

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTelefono;
	private ArrayList<Contacto> listaContactos;
	private JTable tableTlf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioListas frame = new EjercicioListas();
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
	public EjercicioListas() {
		listaContactos= new ArrayList<Contacto>(); //constructor de array lista para inicializar nuestra lista definida arriba
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[170.00,grow][][grow]", "[22.00][51.00][46.00][58.00][160.00][27.00]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0 1 5,grow");
		
		tableTlf = new JTable();
		scrollPane.setViewportView(tableTlf);
		tableTlf.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Tel\u00E9fono"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre: ");
		contentPane.add(lblNombre, "cell 1 0");
		
		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 2 0,growx");
		textNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		contentPane.add(lblTelefono, "cell 1 1");
		
		textTelefono = new JTextField();
		contentPane.add(textTelefono, "cell 2 1,growx");
		textTelefono.setColumns(10);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		btnAdd.setMinimumSize(new Dimension(69, 23));
		btnAdd.setMaximumSize(new Dimension(69, 23));
		contentPane.add(btnAdd, "cell 1 2 2 1,alignx center");
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		contentPane.add(btnEliminar, "cell 1 3 2 1,alignx center");
		
		JButton btnExit = new JButton("Salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salirPrograma();
			}
		});
		btnExit.setMaximumSize(new Dimension(69, 23));
		btnExit.setMinimumSize(new Dimension(69, 23));
		contentPane.add(btnExit, "cell 1 4 2 1,alignx center,aligny top");
	}

		protected void insertar() {
		String nombre = textNombre.getText();
		String tlf = textTelefono.getText();
		
		Contacto c = new Contacto(nombre, tlf);
		
		if (nombre == null || nombre.isBlank() || tlf==null || tlf.isBlank()) {
			JOptionPane.showMessageDialog(this, "introduzca el nombre y el tlf", "faltan datos", JOptionPane.ERROR_MESSAGE);
		}
		
		if (!listaContactos.contains(c)) { //si la lista no contiene al contacto, lo añade. sino, no hace nada
			listaContactos.add(c);
		}
		mostrarDatos();
	}
		
		protected void eliminar() {
			//recojo el model de la tabla para eliminar los elementos
			DefaultTableModel modelo = (DefaultTableModel) tableTlf.getModel();
			
			//primero guardo en una variable el índice que he seleccionado para borrar
			int indice=tableTlf.getSelectedRow();
			
			if (indice==-1) { //esto es un controlador para que el índice sea el correcto y no salgan errores
				JOptionPane.showMessageDialog(this, "Debe seleccionar un contacto para eliminar", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//una vez seleccionada la fila, la borro de la lista de contactos y de la tabla.
			listaContactos.remove(indice);
			//al borrarla de la tabla, se actualiza directamente y se ve que se ha borrado, habiéndose borrado de la lista previamente tb
			modelo.removeRow(indice);

	}
		
		protected void mostrarDatos() {
			//recojo el model de la tabla para añadir los elementos
			DefaultTableModel modelo = (DefaultTableModel) tableTlf.getModel();
			//limpio la tabla de datos
			modelo.setRowCount(0); //la pongo en la fila cero, por lo que se desechan las que hay
			//recorro la lista y la voy añadiendo como vector en la tabla
			for (Contacto c : listaContactos) { //de la listaContactos, va iterando objeto a objeto y lo mete en la fila
				Object fila [] = {
						c.getNombre(), c.getTelefono()
				};
				modelo.addRow(fila);
			}
		}
protected void salirPrograma() {
		System.exit(0);
		}
}