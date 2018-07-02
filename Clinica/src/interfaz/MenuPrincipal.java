package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	private JFrame frame;
	private Login login;
	private MenuPrincipal menu;
	

	/**
	 * Create the application.
	 */
	public MenuPrincipal(Login login) {
		this.login = login;
		initialize();
	}

	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.menu= this;
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMenuPrincipal.setBounds(210, 16, 176, 38);
		frame.getContentPane().add(lblMenuPrincipal);

		JButton btnIngresoDeDatos = new JButton("Ingreso de Datos");
		btnIngresoDeDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuIngresoPacientes datosPacientes = new MenuIngresoPacientes();
				frame.setVisible(false);
			}
		});
		btnIngresoDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngresoDeDatos.setBounds(184, 112, 216, 50);
		frame.getContentPane().add(btnIngresoDeDatos);

		JButton btnInformes = new JButton("Informes");
		btnInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuInformes menuInformes = new MenuInformes();
				frame.setVisible(false);
			}
		});
		btnInformes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInformes.setBounds(184, 202, 216, 50);
		frame.getContentPane().add(btnInformes);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(184, 374, 216, 50);
		frame.getContentPane().add(btnSalir);

		JButton btnRegistro = new JButton("Registro de Usuario");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro registro = new Registro(menu);
				frame.setVisible(false);
			}
		});

		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistro.setBounds(184, 294, 216, 50);
		frame.getContentPane().add(btnRegistro);
	}
}
