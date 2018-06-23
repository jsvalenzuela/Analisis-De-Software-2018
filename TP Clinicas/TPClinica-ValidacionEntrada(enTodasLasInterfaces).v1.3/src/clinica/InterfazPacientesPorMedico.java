package clinica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazPacientesPorMedico extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblListadoDePacientes;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblListadoPacientes;
	private JLabel lblFondo;
	private JLabel lblCentroMedico;
	private JLabel lblCodigoDelMedico;
	private JTextField texCodigoDelMedico;
	private JLabel lblListaDePacientes;
	private JTextField texCodPaciente;
	private JTextField texDni;
	private JLabel lblDni;
	private JButton btnSubmitir;
	private JComboBox comboBox;
	private JLabel lblCodPaciente;
	private JButton btnSeleccionar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPacientesPorMedico frame = new InterfazPacientesPorMedico();
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
	public InterfazPacientesPorMedico() {
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
		
		lblListadoDePacientes = new JLabel("\"Listado De Pacientes\"");
		lblListadoDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDePacientes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblListadoDePacientes.setBackground(Color.WHITE);
		lblListadoDePacientes.setBounds(32, 41, 378, 47);
		contentPane.add(lblListadoDePacientes);
		
		lblListadoPacientes = new JLabel("");
		lblListadoPacientes.setIcon(new ImageIcon("./src/Source\\borde2.png"));
		lblListadoPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoPacientes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblListadoPacientes.setBackground(Color.WHITE);
		lblListadoPacientes.setBounds(32, 41, 378, 47);
		contentPane.add(lblListadoPacientes);
		
		lblCodigoDelMedico = new JLabel("Ingrese el Codigo del medico que desea consultar:");
		lblCodigoDelMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoDelMedico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodigoDelMedico.setBackground(Color.WHITE);
		lblCodigoDelMedico.setBounds(0, 146, 410, 26);
		contentPane.add(lblCodigoDelMedico);
		
		texCodigoDelMedico = new JTextField();
		texCodigoDelMedico.setBounds(10, 183, 190, 23);
		contentPane.add(texCodigoDelMedico);
		texCodigoDelMedico.setColumns(10);
		
		btnSubmitir = new JButton("Buscar");
		btnSubmitir.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnSubmitir.setBackground(new Color(0, 128, 128));
		btnSubmitir.setBounds(230, 183, 115, 23);
		contentPane.add(btnSubmitir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 245, 414, 2);
		contentPane.add(separator);
		
		lblListaDePacientes = new JLabel("Lista De Pacientes");
		lblListaDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePacientes.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblListaDePacientes.setBackground(Color.WHITE);
		lblListaDePacientes.setBounds(63, 245, 319, 26);
		contentPane.add(lblListaDePacientes);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vacio", "Benitez Sergio Javier", "Leon Fuentes Ana"}));
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(10, 282, 281, 20);
		contentPane.add(comboBox);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBackground(new Color(0, 128, 128));
		btnSeleccionar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		btnSeleccionar.setBounds(301, 280, 123, 23);
		contentPane.add(btnSeleccionar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//vuelve a la ventana anterior que es informes
				//se genera una ventana de informes
				InterfazInformes iInformes=new InterfazInformes();
				//pongo visible la ventana
				iInformes.setVisible(true);
				//cierro la ventana del listado de  pacientes por medico
				InterfazPacientesPorMedico.this.dispose();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnVolver.setBackground(new Color(0, 128, 128));
		btnVolver.setBounds(10, 415, 138, 23);
		contentPane.add(btnVolver);
		
		lblCodPaciente = new JLabel("Cod. Paciente");
		lblCodPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodPaciente.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodPaciente.setBackground(Color.WHITE);
		lblCodPaciente.setBounds(10, 313, 131, 26);
		contentPane.add(lblCodPaciente);
		
		texCodPaciente = new JTextField();
		texCodPaciente.setEditable(false);
		texCodPaciente.setColumns(10);
		texCodPaciente.setBounds(168, 317, 242, 20);
		contentPane.add(texCodPaciente);
		
		lblDni = new JLabel("Dni");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblDni.setBackground(Color.WHITE);
		lblDni.setBounds(83, 350, 58, 26);
		contentPane.add(lblDni);
		
		texDni = new JTextField();
		texDni.setEditable(false);
		texDni.setColumns(10);
		texDni.setBounds(168, 354, 242, 20);
		contentPane.add(texDni);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
		lblFondo.setBounds(0, 0, 434, 449);
		contentPane.add(lblFondo);
	}
}
