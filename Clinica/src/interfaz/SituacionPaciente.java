package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import data.DiagnosticoRepository;
import data.MedicoRepository;
import data.PacienteRepository;
import entidades.Diagnostico;
import entidades.Medico;
import entidades.Paciente;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SituacionPaciente {

	private JFrame frame;
	private JComboBox<Paciente> comboPacientes;
	private JComboBox<Medico> comboMedicos;
	JTextArea textArea;
	private MenuIngresoPacientes menu;
	private PacienteRepository pacienteRepo;
	private MedicoRepository medicoRepo;
	private DiagnosticoRepository diagnosticoRepo;
	private Diagnostico diagnostico;

	/**
	 * Create the application.
	 * 
	 * @param menu
	 */
	public SituacionPaciente(MenuIngresoPacientes menu) {
		this.menu = menu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		pacienteRepo = new PacienteRepository();
		medicoRepo = new MedicoRepository();
		diagnosticoRepo = new DiagnosticoRepository();
		frame.setBounds(100, 100, 640, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblSituacinDelPaciente = new JLabel("Situaci\u00F3n del Paciente");
		lblSituacinDelPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSituacinDelPaciente.setBounds(182, 16, 249, 38);
		frame.getContentPane().add(lblSituacinDelPaciente);

		JLabel lblCodigoPaciente = new JLabel("C\u00F3digo Paciente");
		lblCodigoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigoPaciente.setBounds(69, 94, 214, 30);
		frame.getContentPane().add(lblCodigoPaciente);

		JLabel lblCdigoMdico = new JLabel("C\u00F3digo M\u00E9dico");
		lblCdigoMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCdigoMdico.setBounds(69, 157, 214, 30);
		frame.getContentPane().add(lblCdigoMdico);

		JLabel lblDiagnosticoDelMdico = new JLabel("Diagnostico del M\u00E9dico");
		lblDiagnosticoDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiagnosticoDelMdico.setBounds(69, 218, 214, 30);
		frame.getContentPane().add(lblDiagnosticoDelMdico);

		comboPacientes = new JComboBox<Paciente>();
		comboPacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboPacientes.setBounds(267, 96, 200, 26);
		frame.getContentPane().add(comboPacientes);
		comboPacientes
				.setModel(new DefaultComboBoxModel<Paciente>(pacienteRepo.listadoPacientes().toArray(new Paciente[0])));

		comboMedicos = new JComboBox<Medico>();
		comboMedicos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboMedicos.setBounds(267, 159, 200, 26);
		frame.getContentPane().add(comboMedicos);
		comboMedicos.setModel(new DefaultComboBoxModel<Medico>(medicoRepo.listadoMedicos().toArray(new Medico[0])));

		textArea = new JTextArea();
		textArea.setBounds(69, 258, 434, 109);
		frame.getContentPane().add(textArea);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (esDatosCompletos()) {
					diagnostico = new Diagnostico(obtenerCodigoPaciente(), obtenerCodigoMedico(), textArea.getText());
					diagnosticoRepo.guardarDiagnostico(diagnostico);
					JOptionPane.showMessageDialog(null, "Se ha ingresado el diagnostico correctamente.",
							"Acción Realizada", JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(69, 512, 130, 36);
		frame.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(373, 512, 130, 36);
		frame.getContentPane().add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				frame.setVisible(false);
			}
		});
	}

	private boolean esDatosCompletos() {
		if (textArea.getText().length() != 0) {
			return true;
		}
		return false;
	}

	private void limpiarCampos() {
		textArea.setText("");
	}

	private String obtenerCodigoPaciente() {
		Paciente p = (Paciente) comboPacientes.getSelectedItem();
		return String.valueOf(p.getCodigo());
	}

	private String obtenerCodigoMedico() {
		Medico m = (Medico) comboMedicos.getSelectedItem();
		return String.valueOf(m.getCodigo());
	}
}
