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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollBar;

public class InterfazSituacionDelPaciente extends JFrame {

	private JPanel contentPane;
	private JButton btnCancelar;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblSituacionDelPaciente;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoSituacionDelPaciente;
	private JLabel lblFondo;
	private JButton btnConfirmar;
	private JLabel lblCodPaciente;
	private JLabel lblDiagnostico;
	private JTextField texCodPaciente;
	private JTextField texCodMedico;
	private JLabel lblCentroMedico;
	private JLabel lblCodMedico;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazSituacionDelPaciente frame = new InterfazSituacionDelPaciente();
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
	public InterfazSituacionDelPaciente() {
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
		
		lblSituacionDelPaciente = new JLabel("\"Situacion Del Paciente\"");
		lblSituacionDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacionDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblSituacionDelPaciente.setBackground(Color.WHITE);
		lblSituacionDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblSituacionDelPaciente);
		
		lblFondoSituacionDelPaciente = new JLabel("");
		lblFondoSituacionDelPaciente.setIcon(new ImageIcon("./src/Source\\borde2.png"));
		lblFondoSituacionDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoSituacionDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoSituacionDelPaciente.setBackground(Color.WHITE);
		lblFondoSituacionDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoSituacionDelPaciente);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//al cancelar el ingreso de la situacion del paciente, se regresa a la ventana anterior que es ingreso de datos.
				//genero una ventana de ingreso de datos
				InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
				//pongo visible la ventana de ingreso de datos
				iIngresoDeDatos.setVisible(true);
				//cierro la ventana de ingreso de la situacion del paciente
				InterfazSituacionDelPaciente.this.dispose();
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
				//cierro la ventana de ingreso de la situacion del paciente
				InterfazSituacionDelPaciente.this.dispose();
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
		
		lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnostico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblDiagnostico.setBackground(Color.WHITE);
		lblDiagnostico.setBounds(20, 208, 113, 26);
		contentPane.add(lblDiagnostico);
		
		texCodPaciente = new JTextField();
		texCodPaciente.setBounds(168, 138, 242, 20);
		contentPane.add(texCodPaciente);
		texCodPaciente.setColumns(10);
		
		texCodMedico = new JTextField();
		texCodMedico.setColumns(10);
		texCodMedico.setBounds(168, 175, 242, 20);
		contentPane.add(texCodMedico);
		
		lblCodMedico = new JLabel("Cod. Medico");
		lblCodMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodMedico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodMedico.setBackground(Color.WHITE);
		lblCodMedico.setBounds(10, 171, 131, 26);
		contentPane.add(lblCodMedico);
		
		JTextArea texDiagnostico = new JTextArea();
		texDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		texDiagnostico.setLineWrap(true);
		texDiagnostico.setBounds(10, 242, 400, 162);
		contentPane.add(texDiagnostico);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
		lblFondo.setBounds(0, 0, 434, 449);
		contentPane.add(lblFondo);
	}
}
