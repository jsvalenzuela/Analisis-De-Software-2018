package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuIngresoPacientes {

	private JFrame frame;
	private MenuIngresoPacientes menu;

	/**
	 * Create the application.
	 */
	public MenuIngresoPacientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.menu = this;
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblDatosDePacientes = new JLabel("Ingreso de Pacientes");
		lblDatosDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDatosDePacientes.setBounds(174, 16, 237, 45);
		frame.getContentPane().add(lblDatosDePacientes);

		JButton btnNewButton = new JButton("Datos del Paciente");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosPaciente datosPaciente = new DatosPaciente(menu);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(189, 99, 216, 50);
		frame.getContentPane().add(btnNewButton);

		JButton btnDatosDelMdico = new JButton("Datos del M\u00E9dico");
		btnDatosDelMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosMedico datosMedico = new DatosMedico(menu);
				frame.setVisible(false);
			}
		});
		btnDatosDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatosDelMdico.setBounds(189, 250, 216, 50);
		frame.getContentPane().add(btnDatosDelMdico);

		JButton btnNewButton_1 = new JButton("Situaci\u00F3n Paciente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SituacionPaciente sitPaciente = new SituacionPaciente(menu);
				frame.setVisible(false);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(189, 176, 216, 50);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				frame.setVisible(false);
			}
		});
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtrs.setBounds(189, 316, 216, 50);
		frame.getContentPane().add(btnAtrs);
	}

	public void setVisible(boolean visible) {
		this.frame.setVisible(visible);
	}

}
