package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.awt.Font;

import data.DiagnosticoRepository;
import data.MedicoRepository;
import data.PacienteRepository;
import entidades.Diagnostico;
import entidades.Medico;
import entidades.Paciente;
import utilities.Log;
import utilities.Utils;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

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
		frame.getContentPane().setBackground(new Color(224, 255, 255));
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
		lblSituacinDelPaciente.setForeground(new Color(0, 0, 153));
		lblSituacinDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacinDelPaciente.setFont(new Font("Verdana", Font.BOLD, 30));
		lblSituacinDelPaciente.setBounds(69, 16, 499, 38);
		frame.getContentPane().add(lblSituacinDelPaciente);

		JLabel lblCodigoPaciente = new JLabel("Paciente");
		lblCodigoPaciente.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCodigoPaciente.setBounds(31, 158, 252, 30);
		frame.getContentPane().add(lblCodigoPaciente);

		JLabel lblCdigoMdico = new JLabel("M\u00E9dico");
		lblCdigoMdico.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoMdico.setBounds(31, 255, 252, 30);
		frame.getContentPane().add(lblCdigoMdico);

		JLabel lblDiagnosticoDelMdico = new JLabel("Diagnostico del M\u00E9dico");
		lblDiagnosticoDelMdico.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDiagnosticoDelMdico.setBounds(31, 289, 252, 30);
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
		textArea.setBounds(31, 358, 526, 109);
		frame.getContentPane().add(textArea);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guardar situacion del paciente");
		btnGuardar.setBackground(new Color(204, 255, 204));
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
		btnGuardar.setBounds(69, 498, 161, 50);
		frame.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(204, 255, 204));
		btnCancelar.setBounds(353, 498, 150, 50);
		frame.getContentPane().add(btnCancelar);

		JButton btnFiltroMedico = new JButton("...");
		btnFiltroMedico.setToolTipText("Filtrar listado");
		btnFiltroMedico.setBackground(new Color(204, 255, 204));
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
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(31, 199, 252, 31);
		frame.getContentPane().add(label);

		JLabel lblBusqueUnPaciente = new JLabel("Busque un Paciente");
		lblBusqueUnPaciente.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBusqueUnPaciente.setBounds(31, 114, 252, 31);
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
		btnFiltroPaciente.setBackground(new Color(204, 255, 204));
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
		
		JButton btnAyuda = new JButton("?");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(Utils.obtenerUrlAyuda());
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					Log.getInstance().error(e.getMessage());
				}
			}
		});
		btnAyuda.setBounds(581, 0, 43, 23);
		btnAyuda.setBackground(new Color(204, 255, 204));
		btnAyuda.setForeground(new Color(0, 0, 153));
		frame.getContentPane().add(btnAyuda);
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
