package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuInformes {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MenuInformes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Informes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(241, 16, 111, 43);
		frame.getContentPane().add(lblNewLabel);

		JButton btnListadoDePacientes = new JButton("Listado de pacientes por m\u00E9dico");
		btnListadoDePacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePaciente informePaciente = new InformePaciente();
				frame.setVisible(false);
			}
		});
		btnListadoDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnListadoDePacientes.setBounds(146, 116, 307, 50);
		frame.getContentPane().add(btnListadoDePacientes);

		JButton btnEnfermedadesQueAtiende = new JButton("Enfermedades por m\u00E9dico");
		btnEnfermedadesQueAtiende.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEnfermedadesQueAtiende.setBounds(146, 222, 307, 50);
		frame.getContentPane().add(btnEnfermedadesQueAtiende);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				frame.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtras.setBounds(146, 329, 307, 50);
		frame.getContentPane().add(btnAtras);

	}
}
