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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class DatosMedico {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textMatricula;
	private JTextField textTelefono;
	private JTextField textEspecialidad;
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
		lblEspecializacinDelMdico.setBounds(50, 271, 241, 30);
		frame.getContentPane().add(lblEspecializacinDelMdico);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(321, 128, 181, 30);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMatricula.setBounds(321, 273, 181, 30);
		frame.getContentPane().add(textMatricula);
		textMatricula.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico medico = new Medico(textMatricula.getText(), textNombre.getText(), textTelefono.getText(),
						textEspecialidad.getText());
				if (medico.esDatosCompletos()) {
					medicoRepo.insertarMedico(medico);
					JOptionPane.showMessageDialog(null, "Se ha ingresado al médico correctamente.", "Acción Realizada",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGuardar.setBounds(67, 371, 115, 36);
		frame.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancelar.setBounds(360, 371, 115, 36);
		frame.getContentPane().add(btnCancelar);

		JLabel lblMatrculaDelMdico = new JLabel("Matr\u00EDcula del M\u00E9dico");
		lblMatrculaDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatrculaDelMdico.setBounds(50, 202, 198, 30);
		frame.getContentPane().add(lblMatrculaDelMdico);

		textEspecialidad = new JTextField();
		textEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEspecialidad.setColumns(10);
		textEspecialidad.setBounds(321, 204, 181, 30);
		frame.getContentPane().add(textEspecialidad);
	}
}
