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
import utilities.Log;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
	private JTextField textMedico;
	private JTextField textPaciente;

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

		JLabel lblCodigoPaciente = new JLabel("Paciente");
		lblCodigoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigoPaciente.setBounds(69, 158, 183, 30);
		frame.getContentPane().add(lblCodigoPaciente);

		JLabel lblCdigoMdico = new JLabel("M\u00E9dico");
		lblCdigoMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCdigoMdico.setBounds(69, 255, 150, 30);
		frame.getContentPane().add(lblCdigoMdico);

		JLabel lblDiagnosticoDelMdico = new JLabel("Diagnostico del M\u00E9dico");
		lblDiagnosticoDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiagnosticoDelMdico.setBounds(69, 289, 214, 30);
		frame.getContentPane().add(lblDiagnosticoDelMdico);

		comboPacientes = new JComboBox<Paciente>();
		comboPacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboPacientes.setBounds(286, 153, 217, 26);
		frame.getContentPane().add(comboPacientes);
		filtrarPaciente("");

		comboMedicos = new JComboBox<Medico>();
		comboMedicos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboMedicos.setBounds(286, 257, 217, 26);
		frame.getContentPane().add(comboMedicos);
		filtrarMedico("");// Trae todos los medicos

		textArea = new JTextArea();
		textArea.setBounds(69, 358, 434, 109);
		frame.getContentPane().add(textArea);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guardar situacion del paciente");
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

		JButton btnFiltroMedico = new JButton("...");
		btnFiltroMedico.setToolTipText("Filtrar listado");
		btnFiltroMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarMedico(textMedico.getText());
			}
		});
		btnFiltroMedico.setBounds(527, 202, 30, 30);
		frame.getContentPane().add(btnFiltroMedico);

		textMedico = new JTextField();
		textMedico.setToolTipText("Ingrese el nombre para filtrar listado");
		textMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMedico.setColumns(10);
		textMedico.setBounds(286, 201, 219, 26);
		frame.getContentPane().add(textMedico);

		textMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					try {
						filtrarMedico(textMedico.getText());
					} catch (Exception e) {
						Log.getInstance().error(e.getMessage());
					}
			}
		});

		
		JLabel label = new JLabel("Busque un M\u00E9dico:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(69, 199, 175, 31);
		frame.getContentPane().add(label);

		JLabel lblBusqueUnPaciente = new JLabel("Busque un Paciente");
		lblBusqueUnPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBusqueUnPaciente.setBounds(69, 114, 175, 31);
		frame.getContentPane().add(lblBusqueUnPaciente);

		textPaciente = new JTextField();
		textPaciente.setToolTipText("Ingrese el nombre para filtrar listado");
		textPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPaciente.setColumns(10);
		textPaciente.setBounds(286, 116, 219, 26);
		frame.getContentPane().add(textPaciente);
		
		textPaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					try {
						filtrarPaciente(textPaciente.getText());
					} catch (Exception e) {
						Log.getInstance().error(e.getMessage());
					}
			}
		});

		JButton btnFiltroPaciente = new JButton("...");
		btnFiltroPaciente.setToolTipText("Filtrar listado");
		btnFiltroPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarPaciente(textPaciente.getText());
			}
		});
		btnFiltroPaciente.setBounds(527, 117, 30, 30);
		frame.getContentPane().add(btnFiltroPaciente);

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

	private void filtrarMedico(String filtro) {
		comboMedicos
				.setModel(new DefaultComboBoxModel<Medico>(medicoRepo.listadoMedicos(filtro).toArray(new Medico[0])));
	}

	private void filtrarPaciente(String filtro) {
		comboPacientes.setModel(
				new DefaultComboBoxModel<Paciente>(pacienteRepo.listadoPacientes(filtro).toArray(new Paciente[0])));

	}
}
