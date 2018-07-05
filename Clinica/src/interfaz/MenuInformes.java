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

public class MenuInformes {

	private JFrame frame;
	private MenuInformes menu;
	private MenuPrincipal menuPrincipal;
	
	/**
	 * Create the application.
	 * @param menu2 
	 */
	public MenuInformes(MenuPrincipal menuPrincipal) {
		this.menuPrincipal=menuPrincipal;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		this.menu = this;
		frame.setBounds(100, 100, 640, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Informes");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setBounds(157, 32, 296, 58);
		frame.getContentPane().add(lblNewLabel);

		JButton btnListadoDePacientes = new JButton("Listado de pacientes por m\u00E9dico");
		btnListadoDePacientes.setBackground(new Color(204, 255, 204));
		btnListadoDePacientes.setForeground(new Color(0, 0, 153));
		btnListadoDePacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InformePaciente(menu);
				frame.setVisible(false);
			}
		});
		btnListadoDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnListadoDePacientes.setBounds(146, 116, 307, 50);
		btnListadoDePacientes.setForeground(new Color(0, 0, 153));
		frame.getContentPane().add(btnListadoDePacientes);

		JButton btnEnfermedadesQueAtiende = new JButton("Enfermedades por m\u00E9dico");
		btnEnfermedadesQueAtiende.setBackground(new Color(204, 255, 204));
		btnEnfermedadesQueAtiende.setForeground(new Color(0, 0, 153));
		btnEnfermedadesQueAtiende.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InformeMedico(menu);
				frame.setVisible(false);
			}
		});
		btnEnfermedadesQueAtiende.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEnfermedadesQueAtiende.setBounds(146, 222, 307, 50);
		frame.getContentPane().add(btnEnfermedadesQueAtiende);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBackground(new Color(204, 255, 204));
		btnAtras.setForeground(new Color(0, 0, 153));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtras.setBounds(146, 329, 307, 50);
		frame.getContentPane().add(btnAtras);
		
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
