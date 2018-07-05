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

public class MenuIngresoPacientes {

	private JFrame frame;
	private MenuIngresoPacientes menu;
	private MenuPrincipal menuPrincipal;

	/**
	 * Create the application.
	 */
	public MenuIngresoPacientes(MenuPrincipal menuPrincipal) {
		this.menuPrincipal= menuPrincipal;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.menu = this;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 640, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblDatosDePacientes = new JLabel("Ingreso de Pacientes");
		lblDatosDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDePacientes.setForeground(new Color(0, 0, 153));
		lblDatosDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDatosDePacientes.setBounds(112, 23, 346, 45);
		frame.getContentPane().add(lblDatosDePacientes);

		JButton btnNewButton = new JButton("Datos del Paciente");
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DatosPaciente(menu);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(174, 99, 237, 50);
		frame.getContentPane().add(btnNewButton);

		JButton btnDatosDelMdico = new JButton("Datos del M\u00E9dico");
		btnDatosDelMdico.setForeground(new Color(0, 0, 153));
		btnDatosDelMdico.setBackground(new Color(204, 255, 204));
		btnDatosDelMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DatosMedico(menu);
				frame.setVisible(false);
			}
		});
		btnDatosDelMdico.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnDatosDelMdico.setBounds(174, 250, 237, 50);
		frame.getContentPane().add(btnDatosDelMdico);

		JButton btnSituacion = new JButton("Situaci\u00F3n Paciente");
		btnSituacion.setForeground(new Color(0, 0, 153));
		btnSituacion.setBackground(new Color(204, 255, 204));
		btnSituacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SituacionPaciente(menu);
				frame.setVisible(false);
			}
		});
		btnSituacion.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnSituacion.setBounds(174, 176, 237, 50);
		frame.getContentPane().add(btnSituacion);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setForeground(new Color(0, 0, 153));
		btnAtrs.setBackground(new Color(204, 255, 204));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAtrs.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnAtrs.setBounds(174, 316, 237, 50);
		frame.getContentPane().add(btnAtrs);
		
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
