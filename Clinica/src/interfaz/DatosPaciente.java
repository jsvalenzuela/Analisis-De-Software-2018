package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import data.PacienteRepository;
import entidades.Paciente;
import utilities.Log;
import utilities.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class DatosPaciente {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textDNI;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JComboBox<String> comboTipoSangre;
	private PacienteRepository pacienteRepo;
	private MenuIngresoPacientes menu;
	private Paciente paciente;
	private int limiteTexto = 25;
	private int limiteDNI = 8;

	/**
	 * Create the application.
	 */
	public DatosPaciente(MenuIngresoPacientes menu) {
		this.menu = menu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.pacienteRepo = new PacienteRepository();
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblDatosDePacientes = new JLabel("Datos de Pacientes");
		lblDatosDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosDePacientes.setBounds(180, 16, 215, 36);
		frame.getContentPane().add(lblDatosDePacientes);

		JLabel lblNombrePaciente = new JLabel("Nombre Paciente");
		lblNombrePaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombrePaciente.setBounds(52, 117, 179, 42);
		frame.getContentPane().add(lblNombrePaciente);

		textNombre = new JTextField();
		textNombre.setToolTipText("Nombre del paciente. Hasta 25 caracteres separados por un caracter de espacio cada palabra");

		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(267, 124, 200, 32);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setToolTipText("Guadar los datos del paciente");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paciente = cargarDatosPaciente();
				if (!esDatosCompletos()) {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (datosValidos()) {
						pacienteRepo.guardarPaciente(paciente);
						JOptionPane.showMessageDialog(null, "Se ha ingresado el paciente correctamente.",
								"Acción Realizada", JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
				}
			}
		});
		btnGuardar.setBounds(114, 430, 115, 36);
		frame.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCancelar.setBounds(352, 430, 115, 36);
		frame.getContentPane().add(btnCancelar);

		JLabel lblDniPaciente = new JLabel("DNI Paciente");
		lblDniPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDniPaciente.setBounds(52, 169, 149, 36);
		frame.getContentPane().add(lblDniPaciente);

		textDNI = new JTextField();
		textDNI.setToolTipText("DNI del paciente. Hasta 8 cifras");
		textDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDNI.setColumns(10);
		textDNI.setBounds(267, 172, 200, 32);
		frame.getContentPane().add(textDNI);

		JLabel lblTelefonoPaciente = new JLabel("Telefono Paciente");
		lblTelefonoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefonoPaciente.setBounds(52, 216, 169, 36);
		frame.getContentPane().add(lblTelefonoPaciente);

		textTelefono = new JTextField();
		textTelefono.setToolTipText("Tel\u00E9fono del paciente. Hasta 25 caracteres");
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTelefono.setColumns(10);
		textTelefono.setBounds(267, 220, 200, 32);
		frame.getContentPane().add(textTelefono);

		JLabel lblTipoDeSangre = new JLabel("Tipo de Sangre");
		lblTipoDeSangre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeSangre.setBounds(52, 274, 169, 31);
		frame.getContentPane().add(lblTipoDeSangre);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDireccin.setBounds(52, 321, 115, 32);
		frame.getContentPane().add(lblDireccin);

		JLabel lblN = new JLabel("N\u00B0");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 189));
		lblN.setBounds(114, 454, 115, 32);
		frame.getContentPane().add(lblN);

		textDireccion = new JTextField();
		textDireccion.setToolTipText("Direcci\u00F3n del paciente. Hasta 25 caracteres");
		textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDireccion.setColumns(10);
		textDireccion.setBounds(267, 321, 200, 32);
		frame.getContentPane().add(textDireccion);

		comboTipoSangre = new JComboBox<String>();
		comboTipoSangre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboTipoSangre.setModel(
				new DefaultComboBoxModel<String>(new String[] { "A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+" }));
		comboTipoSangre.setBounds(267, 278, 200, 26);
		frame.getContentPane().add(comboTipoSangre);
		
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
		frame.getContentPane().add(btnAyuda);
		addListeners();
	}

	private void addListeners() {
		textDNI.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textDNI.getText().length() == limiteDNI)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		textDireccion.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textDireccion.getText().length() == limiteTexto)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		textTelefono.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textTelefono.getText().length() == limiteTexto)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		textNombre.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textNombre.getText().length() == limiteTexto)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void limpiarCampos() {
		textNombre.setText("");
		textDNI.setText("");
		textTelefono.setText("");
		textDireccion.setText("");
	}

	private boolean esDatosCompletos() {
		if (textNombre.getText().length() != 0 && textDNI.getText().length() != 0
				&& textTelefono.getText().length() != 0 && textDireccion.getText().length() != 0) {
			return true;
		}
		return false;
	}

	private Paciente cargarDatosPaciente() {
		Paciente paciente = new Paciente(textDNI.getText(), textNombre.getText(), textTelefono.getText(),
				textDireccion.getText(), comboTipoSangre.getSelectedItem().toString());
		return paciente;
	}

	private boolean datosValidos() {
		if (Utils.esTextoValido(textNombre.getText(), "Nombre") && Utils.esNumeroValido(textDNI.getText(), "DNI"))
			return true;
		return false;
	}
}
