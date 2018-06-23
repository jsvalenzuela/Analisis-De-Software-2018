package clinica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazCentroMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2842894370471790599L;
	private JPanel contentPane;
	private JButton btnInformes;
	private JButton btnSalir;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblLosLaureles;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblCentroMedico;
	private JLabel lblFondoLosLaureles;
	private JButton btnIngresoDeDatos;
	private JLabel lblFondo;
	private JButton btnCambiarClave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCentroMedico frame = new InterfazCentroMedico();
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
	public InterfazCentroMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("Los_Laureles.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblCentroMedico = new JLabel("Centro Medico");
		lblCentroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentroMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblCentroMedico.setBackground(Color.WHITE);
		lblCentroMedico.setBounds(32, 12, 378, 26);
		contentPane.add(lblCentroMedico);
		
		lblFondoCentroMedico = new JLabel("");
		lblFondoCentroMedico.setIcon(new ImageIcon(Login.class.getResource("borde.png")));
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
		lblFondoControlDePacientes.setIcon(new ImageIcon(Login.class.getResource("borde.png")));
		lblFondoControlDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoControlDePacientes.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblFondoControlDePacientes.setBackground(Color.WHITE);
		lblFondoControlDePacientes.setBounds(32, 92, 378, 26);
		contentPane.add(lblFondoControlDePacientes);
		
		lblLosLaureles = new JLabel("\"Los Laureles\"");
		lblLosLaureles.setHorizontalAlignment(SwingConstants.CENTER);
		lblLosLaureles.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblLosLaureles.setBackground(Color.WHITE);
		lblLosLaureles.setBounds(32, 41, 378, 47);
		contentPane.add(lblLosLaureles);
		
		lblFondoLosLaureles = new JLabel("");
		lblFondoLosLaureles.setIcon(new ImageIcon(Login.class.getResource("borde2.png")));
		lblFondoLosLaureles.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoLosLaureles.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoLosLaureles.setBackground(Color.WHITE);
		lblFondoLosLaureles.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoLosLaureles);
		
		btnIngresoDeDatos = new JButton("Ingreso de datos");
		btnIngresoDeDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazIngresoDeDatos iIngresoDatos=new InterfazIngresoDeDatos();
				iIngresoDatos.setVisible(true);
				InterfazCentroMedico.this.dispose();
			}
		});
		
		btnCambiarClave = new JButton("Cambiar Clave");
		btnCambiarClave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InterfazCambiarClave iCambiarClave=new InterfazCambiarClave();
				iCambiarClave.setVisible(true);
				InterfazCentroMedico.this.dispose();
			}
		});
		btnCambiarClave.setForeground(Color.BLACK);
		btnCambiarClave.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnCambiarClave.setBackground(new Color(0, 128, 128));
		btnCambiarClave.setBounds(136, 138, 172, 23);
		contentPane.add(btnCambiarClave);
		btnIngresoDeDatos.setForeground(Color.BLACK);
		btnIngresoDeDatos.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnIngresoDeDatos.setBackground(new Color(0, 128, 128));
		btnIngresoDeDatos.setBounds(136, 172, 172, 23);
		contentPane.add(btnIngresoDeDatos);
		
		btnInformes = new JButton("Informes");
		btnInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazInformes iInformes =new InterfazInformes();
				iInformes.setVisible(true);
				InterfazCentroMedico.this.dispose();
			}
		});
		btnInformes.setForeground(Color.BLACK);
		btnInformes.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnInformes.setBackground(new Color(0, 128, 128));
		btnInformes.setBounds(136, 206, 172, 23);
		contentPane.add(btnInformes);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro deseas salir del sistema?") == JOptionPane.YES_OPTION) {
				
					InterfazCentroMedico.this.dispose();
				}
			}
		});
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnSalir.setBackground(new Color(0, 128, 128));
		btnSalir.setBounds(136, 263, 172, 23);
		contentPane.add(btnSalir);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("IntCentroMedico.png")));
		lblFondo.setBounds(0, 0, 434, 297);
		contentPane.add(lblFondo);
	}
}
