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

public class InterfazIngresoDeDatos extends JFrame {

	private JPanel contentPane;
	private JButton btnInformes;
	private JButton btnAnterior;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblIngresoDeDatos;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoIngresoDeDatos;
	private JButton btnDatosDelPaciente;
	private JLabel lblFondo;
	private JLabel lblCentroMedico;
	private JButton btnDatosDelMedico;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazIngresoDeDatos frame = new InterfazIngresoDeDatos();
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
	public InterfazIngresoDeDatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
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
		
		lblIngresoDeDatos = new JLabel("\"Ingreso De Datos\"");
		lblIngresoDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresoDeDatos.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblIngresoDeDatos.setBackground(Color.WHITE);
		lblIngresoDeDatos.setBounds(32, 41, 378, 47);
		contentPane.add(lblIngresoDeDatos);
		
		lblFondoIngresoDeDatos = new JLabel("");
		lblFondoIngresoDeDatos.setIcon(new ImageIcon("./src/Source\\borde2.png"));
		lblFondoIngresoDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoIngresoDeDatos.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoIngresoDeDatos.setBackground(Color.WHITE);
		lblFondoIngresoDeDatos.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoIngresoDeDatos);
		
		btnDatosDelPaciente = new JButton("Datos del Paciente");
		btnDatosDelPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//genero la ventana de ingresos de datos del paciente
				InterfazDatosDelPaciente iDatosDelPaciente=new InterfazDatosDelPaciente();
				//pongo la ventana visible
				iDatosDelPaciente.setVisible(true);
				//cierro la ventana del ingreso de datos
				InterfazIngresoDeDatos.this.dispose();
			}
		});
		btnDatosDelPaciente.setForeground(Color.BLACK);
		btnDatosDelPaciente.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnDatosDelPaciente.setBackground(new Color(0, 128, 128));
		btnDatosDelPaciente.setBounds(106, 129, 231, 23);
		contentPane.add(btnDatosDelPaciente);
		
		btnInformes = new JButton("Situacion del Paciente");
		btnInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//genero la ventana de situacion del paciente
				InterfazSituacionDelPaciente iSituacionDelPaciente=new InterfazSituacionDelPaciente();
				//pongo visible la ventana de la situacion del paciente
				iSituacionDelPaciente.setVisible(true);
				//cierro la ventana de ingreso de datos
				InterfazIngresoDeDatos.this.dispose();
			}
		});
		btnInformes.setForeground(Color.BLACK);
		btnInformes.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnInformes.setBackground(new Color(0, 128, 128));
		btnInformes.setBounds(106, 163, 231, 23);
		contentPane.add(btnInformes);
		
		btnDatosDelMedico = new JButton("Datos del Medico");
		btnDatosDelMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//genero la ventana del ingreso de datos del medico
				InterfazDatosDelMedico iDatosDelMedico=new InterfazDatosDelMedico();
				//pongo visible la ventana deingreso de datos del medico
				iDatosDelMedico.setVisible(true);
				//cierro la ventana del ingreso de datos
				InterfazIngresoDeDatos.this.dispose();
			}
		});
		btnDatosDelMedico.setForeground(Color.BLACK);
		btnDatosDelMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnDatosDelMedico.setBackground(new Color(0, 128, 128));
		btnDatosDelMedico.setBounds(106, 198, 231, 23);
		contentPane.add(btnDatosDelMedico);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//genero la ventana principal
				InterfazCentroMedico iCentroMedico=new InterfazCentroMedico();
				//pongo visible la nueva ventana
				iCentroMedico.setVisible(true);
				//cierro la ventan de ingreso de datos
				InterfazIngresoDeDatos.this.dispose();
			}
		});
		btnAnterior.setForeground(Color.BLACK);
		btnAnterior.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnAnterior.setBackground(new Color(0, 128, 128));
		btnAnterior.setBounds(155, 263, 138, 23);
		contentPane.add(btnAnterior);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
		lblFondo.setBounds(0, 0, 434, 297);
		contentPane.add(lblFondo);
	}
}
