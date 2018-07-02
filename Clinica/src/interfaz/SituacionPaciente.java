package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class SituacionPaciente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public SituacionPaciente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblSituacinDelPaciente = new JLabel("Situaci\u00F3n del Paciente");
		lblSituacinDelPaciente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSituacinDelPaciente.setBounds(182, 16, 249, 38);
		frame.getContentPane().add(lblSituacinDelPaciente);

		JLabel lblCodigoPaciente = new JLabel("C\u00F3digo Paciente");
		lblCodigoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodigoPaciente.setBounds(69, 94, 214, 30);
		frame.getContentPane().add(lblCodigoPaciente);

		JLabel lblCdigoMdico = new JLabel("C\u00F3digo M\u00E9dico");
		lblCdigoMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCdigoMdico.setBounds(69, 157, 214, 30);
		frame.getContentPane().add(lblCdigoMdico);

		JLabel lblDiagnosticoDelMdico = new JLabel("Diagnostico del M\u00E9dico");
		lblDiagnosticoDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiagnosticoDelMdico.setBounds(69, 218, 214, 30);
		frame.getContentPane().add(lblDiagnosticoDelMdico);

		textField = new JTextField();
		textField.setBounds(312, 94, 191, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(312, 157, 191, 34);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(312, 225, 191, 109);
		frame.getContentPane().add(textArea);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(69, 512, 130, 36);
		frame.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(373, 512, 130, 36);
		frame.getContentPane().add(btnCancelar);
	}
}
