package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;

import utilities.Log;
import utilities.Utils;

import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MenuPrincipal {

	private JFrame frame;
	private Login login;
	private MenuPrincipal menu;

	/**
	 * @wbp.parser.constructor
	 */
	public MenuPrincipal(Login login) {
		this.login = login;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.menu = this;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 640, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setForeground(new Color(0, 0, 153));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Verdana", Font.BOLD, 30));
		lblMenuPrincipal.setBounds(103, 16, 379, 38);
		frame.getContentPane().add(lblMenuPrincipal);

		JButton btnIngresoDeDatos = new JButton("Ingreso de Datos");
		btnIngresoDeDatos.setForeground(new Color(0, 0, 153));
		btnIngresoDeDatos.setBackground(new Color(204, 255, 204));
		btnIngresoDeDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuIngresoPacientes(menu);
				frame.setVisible(false);
			}
		});
		btnIngresoDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngresoDeDatos.setBounds(184, 112, 216, 50);
		frame.getContentPane().add(btnIngresoDeDatos);

		JButton btnInformes = new JButton("Informes");
		btnInformes.setForeground(new Color(0, 0, 153));
		btnInformes.setBackground(new Color(204, 255, 204));
		btnInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuInformes(menu);
				frame.setVisible(false);
			}
		});
		btnInformes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInformes.setBounds(184, 202, 216, 50);
		frame.getContentPane().add(btnInformes);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(0, 0, 153));
		btnSalir.setBackground(new Color(204, 255, 204));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login.closeApp();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(184, 374, 216, 50);
		frame.getContentPane().add(btnSalir);

		JButton btnRegistro = new JButton("Registro de Usuario");
		btnRegistro.setForeground(new Color(0, 0, 153));
		btnRegistro.setBackground(new Color(204, 255, 204));
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Registro(menu);
				frame.setVisible(false);
			}
		});

		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistro.setBounds(184, 294, 216, 50);
		frame.getContentPane().add(btnRegistro);
		
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
		btnAyuda.setBackground(new Color(204, 255, 204));
		btnAyuda.setForeground(new Color(0, 0, 153));
		frame.getContentPane().add(btnAyuda);
	}

	public void setVisible(boolean visible) {
		this.frame.setVisible(visible);
	}
}
