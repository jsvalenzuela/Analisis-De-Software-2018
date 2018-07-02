package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import data.PacienteRepository;
import entidades.Paciente;
import utilities.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DatosPaciente {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textDNI;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JDateChooser dateIngreso;
	private JComboBox<String> comboTipoSangre;
	private PacienteRepository pacienteRepo;
	private MenuIngresoPacientes menu;

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
		lblNombrePaciente.setBounds(52, 76, 179, 42);
		frame.getContentPane().add(lblNombrePaciente);

		textNombre = new JTextField();
		textNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				Utils.esTextoValido(textNombre.getText());
			}
		});
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(267, 83, 200, 32);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente paciente = new Paciente(textDNI.getText(), dateIngreso.getCalendar(), textNombre.getText(),
						textTelefono.getText(), textDireccion.getText(), comboTipoSangre.getSelectedItem().toString());
				if (esDatosCompletos()) {
					pacienteRepo.guardarPaciente(paciente);
					JOptionPane.showMessageDialog(null, "Se ha ingresado el paciente correctamente.",
							"Acción Realizada", JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
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
		lblDniPaciente.setBounds(52, 128, 149, 36);
		frame.getContentPane().add(lblDniPaciente);

		textDNI = new JTextField();
		textDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDNI.setColumns(10);
		textDNI.setBounds(267, 131, 200, 32);
		frame.getContentPane().add(textDNI);
		
		textDNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				Utils.esNumeroValido(textDNI.getText());
			}
		});

		JLabel lblTelefonoPaciente = new JLabel("Telefono Paciente");
		lblTelefonoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefonoPaciente.setBounds(52, 175, 169, 36);
		frame.getContentPane().add(lblTelefonoPaciente);

		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTelefono.setColumns(10);
		textTelefono.setBounds(267, 179, 200, 32);
		frame.getContentPane().add(textTelefono);

		JLabel lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
		lblFechaDeIngreso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFechaDeIngreso.setBounds(52, 227, 169, 31);
		frame.getContentPane().add(lblFechaDeIngreso);

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
		textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDireccion.setColumns(10);
		textDireccion.setBounds(267, 321, 200, 32);
		frame.getContentPane().add(textDireccion);
		
		textDireccion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				Utils.esTextoValido(textDNI.getText());
			}
		});

		dateIngreso = new JDateChooser();
		dateIngreso.setBounds(267, 227, 200, 31);
		dateIngreso.setDateFormatString("dd-MM-yyyy");
		dateIngreso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(dateIngreso);

		comboTipoSangre = new JComboBox<String>();
		comboTipoSangre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboTipoSangre.setModel(
				new DefaultComboBoxModel<String>(new String[] { "A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+" }));
		comboTipoSangre.setBounds(267, 278, 200, 26);
		frame.getContentPane().add(comboTipoSangre);
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
}
