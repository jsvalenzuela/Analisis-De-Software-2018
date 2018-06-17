package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Clínica Nuevo Espiritu");
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema de la Cl\u00EDnica Nuevo Espiritu");
		lblBienvenidoAlSistema.setBackground(new Color(238, 238, 238));
		lblBienvenidoAlSistema.setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().add(lblBienvenidoAlSistema, BorderLayout.NORTH);
	}

}
