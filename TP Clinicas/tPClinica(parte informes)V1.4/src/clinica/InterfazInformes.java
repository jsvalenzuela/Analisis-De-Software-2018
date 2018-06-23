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

public class InterfazInformes extends JFrame {

	private JPanel contentPane;
	private JButton btnPacientesPorMedico;
	private JButton btnAnterior;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblInformes;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoInformes;
	private JLabel lblFondo;
	private JLabel lblCentroMedico;
	private JButton btnEnfermedadesPorMedico;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInformes frame = new InterfazInformes();
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
	public InterfazInformes() {
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
		
		lblInformes = new JLabel("\"Informes\"");
		lblInformes.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblInformes.setBackground(Color.WHITE);
		lblInformes.setBounds(32, 41, 378, 47);
		contentPane.add(lblInformes);
		
		lblFondoInformes = new JLabel("");
		lblFondoInformes.setIcon(new ImageIcon("./src/Source\\borde2.png"));
		lblFondoInformes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoInformes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoInformes.setBackground(Color.WHITE);
		lblFondoInformes.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoInformes);
		
		btnPacientesPorMedico = new JButton("Listado de pacientes por medico");
		btnPacientesPorMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//genero una ventana de listado de pacientes por medico
				InterfazPacientesPorMedico iPacientesPorMedico=new InterfazPacientesPorMedico();
				//pongo visible la ventana que mostrara la lista de pacientes segun un medico
				iPacientesPorMedico.setVisible(true);
				//cierro la ventana de informes
				InterfazInformes.this.dispose();
			}
		});
		btnPacientesPorMedico.setForeground(Color.BLACK);
		btnPacientesPorMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnPacientesPorMedico.setBackground(new Color(0, 128, 128));
		btnPacientesPorMedico.setBounds(32, 164, 367, 23);
		contentPane.add(btnPacientesPorMedico);
		
		btnEnfermedadesPorMedico = new JButton("Enfermedades que atiende cada medico");
		btnEnfermedadesPorMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//genero una ventana de enfermedades que atiende cada medico
				InterfazEnfermedadesPorMedico iEnfermedadesPorMedico=new InterfazEnfermedadesPorMedico();
				//pongo visible la ventana que muestra los pacientes que atiende cada medico
				iEnfermedadesPorMedico.setVisible(true);
				//cierro la ventana de informes
				InterfazInformes.this.dispose();
			}
		});
		btnEnfermedadesPorMedico.setForeground(Color.BLACK);
		btnEnfermedadesPorMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnEnfermedadesPorMedico.setBackground(new Color(0, 128, 128));
		btnEnfermedadesPorMedico.setBounds(32, 198, 367, 23);
		contentPane.add(btnEnfermedadesPorMedico);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//se regresa a la ventana principal
				//genero una ventana de interfaz dentro medico
				InterfazCentroMedico iCentroMedico =new InterfazCentroMedico();
				//pongo la ventana visible
				iCentroMedico.setVisible(true);
				//cierro la ventana actual de informes
				InterfazInformes.this.dispose();
			}
		});
		btnAnterior.setForeground(Color.BLACK);
		btnAnterior.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnAnterior.setBackground(new Color(0, 128, 128));
		btnAnterior.setBounds(154, 263, 138, 23);
		contentPane.add(btnAnterior);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
		lblFondo.setBounds(0, 0, 434, 297);
		contentPane.add(lblFondo);
	}

}
