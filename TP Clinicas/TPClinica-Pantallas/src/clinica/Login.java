package clinica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienbenidoAlSistema = new JLabel("Bienvenido");
		lblBienbenidoAlSistema.setFont(new Font("Baskerville Old Face", Font.PLAIN, 35));
		lblBienbenidoAlSistema.setBounds(133, 21, 173, 47);
		contentPane.add(lblBienbenidoAlSistema);
		
		JLabel lblSistemaDeControl = new JLabel("Sistema de Control de Pacientes");
		lblSistemaDeControl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblSistemaDeControl.setBounds(10, 64, 403, 47);
		contentPane.add(lblSistemaDeControl);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(26, 134, 86, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(26, 170, 115, 47);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(106, 140, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 187, 155, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazCentroMedico interfazCM = new InterfazCentroMedico();
				interfazCM.setVisible(true);
				Login.this.dispose();
			}
		});
		btnAceptar.setBounds(100, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
			}
		});
		btnCancelar.setBounds(244, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
