package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JTextField;

import data.MedicoRepository;
import entidades.Medico;
import utilities.Log;
import utilities.Utils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DatosMedico {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textEspecialidad;
	private JTextField textTelefono;
	private JTextField textMatricula;
	private MedicoRepository medicoRepo;
	private MenuIngresoPacientes menu;
	private Medico medico;
	private int limiteTexto = 25;
	private int limiteMatricula = 6;

	/**
	 * Create the application.
	 */
	public DatosMedico(MenuIngresoPacientes menu) {
		this.menu = menu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.getContentPane().setForeground(Color.ORANGE);
		medicoRepo = new MedicoRepository();
		frame.setBounds(100, 100, 640, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblDatosDeMdico = new JLabel("Datos del M\u00E9dico");
		lblDatosDeMdico.setForeground(new Color(0, 0, 153));
		lblDatosDeMdico.setFont(new Font("Verdana", Font.BOLD, 30));
		lblDatosDeMdico.setBounds(164, 55, 312, 42);
		frame.getContentPane().add(lblDatosDeMdico);

		JLabel lblNombreDelMdico = new JLabel("Nombre del M\u00E9dico");
		lblNombreDelMdico.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNombreDelMdico.setBounds(72, 128, 239, 30);
		frame.getContentPane().add(lblNombreDelMdico);

		JLabel lblEspecializacinDelMdico = new JLabel("Especialidad del M\u00E9dico");
		lblEspecializacinDelMdico.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblEspecializacinDelMdico.setBounds(70, 327, 241, 30);
		frame.getContentPane().add(lblEspecializacinDelMdico);

		textNombre = new JTextField();
		textNombre.setToolTipText("Nombre del m\u00E9dico. Hasta 25 caracteres");

		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(321, 128, 181, 30);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textEspecialidad = new JTextField();
		textEspecialidad.setToolTipText("Especialidad del m\u00E9dico. Hasta 25 caracteres");
		textEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEspecialidad.setBounds(319, 327, 181, 30);
		frame.getContentPane().add(textEspecialidad);
		textEspecialidad.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(0, 0, 153));
		btnGuardar.setBackground(new Color(204, 255, 204));
		btnGuardar.setToolTipText("Guadar los datooos del m\u00E9dico");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medico = cargarDatosMedico();
				if (!esDatosCompletos()) {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {
					if (datosValidos()) {
						medicoRepo.guardarMedico(medico);
						JOptionPane.showMessageDialog(null, "Se ha ingresado al médico correctamente.",
								"Acción Realizada", JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					}
				}
			}
		});
		btnGuardar.setFont(new Font("Verdana", Font.BOLD, 18));
		btnGuardar.setBounds(111, 414, 165, 36);
		frame.getContentPane().add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 153));
		btnCancelar.setBackground(new Color(204, 255, 204));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelar.setBounds(349, 414, 153, 36);
		frame.getContentPane().add(btnCancelar);

		JLabel lblMatrculaDelMdico = new JLabel("Matr\u00EDcula del M\u00E9dico");
		lblMatrculaDelMdico.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblMatrculaDelMdico.setBounds(72, 192, 206, 30);
		frame.getContentPane().add(lblMatrculaDelMdico);

		textMatricula = new JTextField();
		textMatricula.setToolTipText("Matricula del m\u00E9dico. Hasta 6 cifras");
		textMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(321, 191, 181, 30);
		frame.getContentPane().add(textMatricula);

		JLabel lblTelefonoMdico = new JLabel("Tel\u00E9fono M\u00E9dico");
		lblTelefonoMdico.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblTelefonoMdico.setBounds(70, 265, 241, 30);
		frame.getContentPane().add(lblTelefonoMdico);

		textTelefono = new JTextField();
		textTelefono.setToolTipText("Tel\u00E9fono del m\u00E9dico. Hasta 25 caracteres");
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTelefono.setColumns(10);
		textTelefono.setBounds(321, 263, 181, 30);
		frame.getContentPane().add(textTelefono);
		
		
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
		addListeners();
	}

	private void addListeners() {
		textMatricula.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textMatricula.getText().length() == limiteMatricula)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		textEspecialidad.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textEspecialidad.getText().length() == limiteTexto)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		textTelefono.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textTelefono.getText().length() == limiteTexto)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		textNombre.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (textNombre.getText().length() == limiteTexto)
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void limpiarCampos() {
		textNombre.setText("");
		textEspecialidad.setText("");
		textTelefono.setText("");
		textMatricula.setText("");
	}

	private boolean esDatosCompletos() {
		if (textNombre.getText().length() != 0 && textEspecialidad.getText().length() != 0
				&& textTelefono.getText().length() != 0 && textMatricula.getText().length() != 0) {
			return true;
		}
		return false;
	}

	private Medico cargarDatosMedico() {
		Medico medico = new Medico(textEspecialidad.getText(), textNombre.getText(), textTelefono.getText(),
				textMatricula.getText());
		return medico;
	}

	private boolean datosValidos() {
		if (Utils.esTextoValido(textNombre.getText(), "Nombre")
				&& Utils.esNumeroValido(textMatricula.getText(), "Matricula")
				&& Utils.esTextoValido(textEspecialidad.getText(), "Especialidad"))
			return true;
		return false;
	}
}
