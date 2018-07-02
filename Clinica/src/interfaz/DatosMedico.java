package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import data.MedicoRepository;
import entidades.Medico;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosMedico {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textEspecialidad;
	private JTextField textTelefono;
	private JTextField textMatricula;
	private MedicoRepository medicoRepo;

	/**
	 * Create the application.
	 */
	public DatosMedico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		medicoRepo = new MedicoRepository();
		frame.setBounds(100, 100, 640, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblDatosDeMdico = new JLabel("Datos del M\u00E9dico");
		lblDatosDeMdico.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDatosDeMdico.setBounds(190, 16, 198, 42);
		frame.getContentPane().add(lblDatosDeMdico);

		JLabel lblNombreDelMdico = new JLabel("Nombre del M\u00E9dico");
		lblNombreDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreDelMdico.setBounds(50, 126, 176, 30);
		frame.getContentPane().add(lblNombreDelMdico);

		JLabel lblEspecializacinDelMdico = new JLabel("Especialidad del M\u00E9dico");
		lblEspecializacinDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspecializacinDelMdico.setBounds(48, 325, 241, 30);
		frame.getContentPane().add(lblEspecializacinDelMdico);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(321, 128, 181, 30);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textEspecialidad = new JTextField();
		textEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEspecialidad.setBounds(319, 327, 181, 30);
		frame.getContentPane().add(textEspecialidad);
		textEspecialidad.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Medico medico = new Medico(textEspecialidad.getText(), textNombre.getText(), textTelefono.getText(),
						textMatricula.getText());
				if (medico.esDatosCompletos()) {
					medicoRepo.guardarMedico(medico);
					JOptionPane.showMessageDialog(null, "Se ha ingresado al médico correctamente.", "Acción Realizada",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGuardar.setBounds(68, 412, 115, 36);
		frame.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancelar.setBounds(361, 412, 115, 36);
		frame.getContentPane().add(btnCancelar);

		JLabel lblMatrculaDelMdico = new JLabel("Matr\u00EDcula del M\u00E9dico");
		lblMatrculaDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatrculaDelMdico.setBounds(50, 202, 198, 30);
		frame.getContentPane().add(lblMatrculaDelMdico);

		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(321, 204, 181, 30);
		frame.getContentPane().add(textMatricula);
		
		JLabel lblTelefonoMdico = new JLabel("Tel\u00E9fono M\u00E9dico");
		lblTelefonoMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefonoMdico.setBounds(48, 263, 241, 30);
		frame.getContentPane().add(lblTelefonoMdico);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTelefono.setColumns(10);
		textTelefono.setBounds(321, 263, 181, 30);
		frame.getContentPane().add(textTelefono);
	}
}
