package clinica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class InterfazDatosDelPaciente extends JFrame {

	private JPanel contentPane;
	private JButton btnCancelar;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblDatosDelPaciente;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoDatosDelPaciente;
	private JLabel lblFondo;
	private JButton btnConfirmar;
	private JLabel lblCodPaciente;
	private JLabel lblNombre;
	private JLabel lblFechaDeIngreso;
	private JLabel lblDireccion;
	private JLabel lblTipoDeSangre;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JTextField texCodPaciente;
	private JTextField texNombre;
	private JTextField texDni;
	private JTextField texFechaDeIngreso;
	private JTextField texTipoDeSangre;
	private JTextField texTelefono;
	private JTextField texDireccion;
	private JLabel lblCentroMedico;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDatosDelPaciente frame = new InterfazDatosDelPaciente();
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
	public InterfazDatosDelPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCentroMedico = new JLabel("Centro Medico");
		lblCentroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentroMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblCentroMedico.setBackground(Color.WHITE);
		lblCentroMedico.setBounds(32, 12, 378, 26);
		contentPane.add(lblCentroMedico);
		
		lblFondoCentroMedico = new JLabel("");
		lblFondoCentroMedico.setIcon(new ImageIcon("./src/Source\\borde.png"));
		lblFondoCentroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoCentroMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblFondoCentroMedico.setBackground(Color.WHITE);
		lblFondoCentroMedico.setBounds(32, 12, 378, 26);
		contentPane.add(lblFondoCentroMedico);
		
		lblControlDePacientes = new JLabel("Control de Pacientes");
		lblControlDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblControlDePacientes.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblControlDePacientes.setBackground(Color.WHITE);
		lblControlDePacientes.setBounds(32, 92, 378, 26);
		contentPane.add(lblControlDePacientes);
		
		lblFondoControlDePacientes = new JLabel("");
		lblFondoControlDePacientes.setIcon(new ImageIcon("./src/Source\\borde.png"));
		lblFondoControlDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoControlDePacientes.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblFondoControlDePacientes.setBackground(Color.WHITE);
		lblFondoControlDePacientes.setBounds(32, 92, 378, 26);
		contentPane.add(lblFondoControlDePacientes);
		
		lblDatosDelPaciente = new JLabel("\"Datos Del Paciente\"");
		lblDatosDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblDatosDelPaciente.setBackground(Color.WHITE);
		lblDatosDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblDatosDelPaciente);
		
		lblFondoDatosDelPaciente = new JLabel("");
		lblFondoDatosDelPaciente.setIcon(new ImageIcon("./src/Source\\borde2.png"));
		lblFondoDatosDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoDatosDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoDatosDelPaciente.setBackground(Color.WHITE);
		lblFondoDatosDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoDatosDelPaciente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//al cancelar el ingreso de datos se regresa a la ventana ingreso de datos
				//genero una ventana de ingreso de datos
				InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
				//pongo visible la ventana de ingreso de datos
				iIngresoDeDatos.setVisible(true);
				//cierro la ventana de ingreso de datos del paciente
				InterfazDatosDelPaciente.this.dispose();
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(10, 415, 138, 23);
		contentPane.add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//suponemos que todos los datos son correctos y se regresa a la ventana anterior que es ingreso de datos
				//genero una ventana de ingreso de datos
				InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
				//pongo visible la ventana de ingreso de datos
				iIngresoDeDatos.setVisible(true);
				//cierro la ventana de ingreso de datos del paciente
				InterfazDatosDelPaciente.this.dispose();
			}
		});
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnConfirmar.setBackground(new Color(0, 128, 128));
		btnConfirmar.setBounds(286, 415, 138, 23);
		contentPane.add(btnConfirmar);
		
		lblCodPaciente = new JLabel("Cod. Paciente");
		lblCodPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodPaciente.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodPaciente.setBackground(Color.WHITE);
		lblCodPaciente.setBounds(10, 134, 131, 26);
		contentPane.add(lblCodPaciente);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(10, 171, 83, 26);
		contentPane.add(lblNombre);
		
		lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
		lblFechaDeIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeIngreso.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblFechaDeIngreso.setBackground(Color.WHITE);
		lblFechaDeIngreso.setBounds(10, 245, 148, 26);
		contentPane.add(lblFechaDeIngreso);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblDireccion.setBackground(Color.WHITE);
		lblDireccion.setBounds(20, 356, 95, 26);
		contentPane.add(lblDireccion);
		
		lblTipoDeSangre = new JLabel("Tipo de Sangre");
		lblTipoDeSangre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeSangre.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblTipoDeSangre.setBackground(Color.WHITE);
		lblTipoDeSangre.setBounds(17, 282, 131, 26);
		contentPane.add(lblTipoDeSangre);
		
		lblDni = new JLabel("Dni");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblDni.setBackground(Color.WHITE);
		lblDni.setBounds(10, 208, 58, 26);
		contentPane.add(lblDni);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblTelefono.setBackground(Color.WHITE);
		lblTelefono.setBounds(27, 319, 83, 26);
		contentPane.add(lblTelefono);
		
		texCodPaciente = new JTextField();
		texCodPaciente.setBounds(168, 138, 242, 20);
		contentPane.add(texCodPaciente);
		texCodPaciente.setColumns(10);
		
		texNombre = new JTextField();
		texNombre.setColumns(10);
		texNombre.setBounds(168, 175, 242, 20);
		contentPane.add(texNombre);
		
		texDni = new JTextField();
		texDni.setColumns(10);
		texDni.setBounds(168, 212, 242, 20);
		contentPane.add(texDni);
		
		texFechaDeIngreso = new JTextField();
		texFechaDeIngreso.setColumns(10);
		texFechaDeIngreso.setBounds(168, 249, 242, 20);
		contentPane.add(texFechaDeIngreso);
		
		texTipoDeSangre = new JTextField();
		texTipoDeSangre.setColumns(10);
		texTipoDeSangre.setBounds(168, 286, 242, 20);
		contentPane.add(texTipoDeSangre);
		
		texTelefono = new JTextField();
		texTelefono.setColumns(10);
		texTelefono.setBounds(168, 323, 242, 20);
		contentPane.add(texTelefono);
		
		texDireccion = new JTextField();
		texDireccion.setColumns(10);
		texDireccion.setBounds(168, 360, 242, 20);
		contentPane.add(texDireccion);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
		lblFondo.setBounds(0, 0, 434, 449);
		contentPane.add(lblFondo);
	}
}
