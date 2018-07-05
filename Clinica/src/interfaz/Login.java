package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.UsuarioRepository;
import entidades.Usuario;
import utilities.Log;
import utilities.Utils;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField tpContrasena;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private Login login;
	private Usuario usuario;
	private UsuarioRepository usuarioRepo;
	private JFrame frame;
	private int limiteTexto = 12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					Log.getInstance().error("Error iniciar: " + e.getMessage());
				}
			}
		});
	}

	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Log.getInstance().info("Cerrar sesion");
			}
		});

		this.usuario = new Usuario();
		this.usuarioRepo = new UsuarioRepository();
		setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		setLogin(this);
		setBounds(100, 100, 624, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login : Ingreso al sistema");
		lblLogin.setForeground(new Color(0, 0, 153));
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 30));
		lblLogin.setBounds(93, 37, 452, 47);
		contentPane.add(lblLogin);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 18));

		lblUsuario.setBounds(56, 122, 140, 20);
		contentPane.add(lblUsuario);
		lblContrasena = new JLabel("Contrase\u00F1a: ");
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Verdana", Font.BOLD, 18));
		lblContrasena.setBounds(56, 153, 140, 20);
		contentPane.add(lblContrasena);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Nombre de usuario. Hasta 12 caracteres");
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.setBounds(206, 122, 297, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		tpContrasena = new JPasswordField();
		tpContrasena.setToolTipText("Contrase\u00F1a de usuario. Hasta 12 caracteres");
		tpContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tpContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					try {
						if (camposCompletos()) {
							loguear();
						}
					} catch (Exception e) {
						Log.getInstance().error("Error al validar contrasena " + e.getMessage());
					}
			}
		});
		tpContrasena.setBounds(206, 153, 297, 20);
		contentPane.add(tpContrasena);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setToolTipText("Ingresar al sistema");
		btnIngresar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnIngresar.setBackground(new Color(204, 255, 204));
		btnIngresar.setForeground(new Color(0, 0, 153));
		btnIngresar.setBounds(112, 215, 160, 47);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (camposCompletos()) {
					loguear();
				}
			}
		});

		contentPane.add(btnIngresar);

		txtUsuario.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (txtUsuario.getText().length() == limiteTexto)
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

		tpContrasena.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (tpContrasena.getText().length() == limiteTexto)
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

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(204, 255, 204));
		btnCancelar.setForeground(new Color(0, 0, 153));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelar();
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnCancelar.setBounds(343, 215, 160, 47);
		contentPane.add(btnCancelar);
		
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
		btnAyuda.setBounds(565, 0, 43, 23);
		btnAyuda.setBackground(new Color(204, 255, 204));
		btnAyuda.setForeground(new Color(0, 0, 153));
		contentPane.add(btnAyuda);

		visible(true);

	}

	private boolean camposCompletos() {
		if (txtUsuario.getText().length() != 0 && tpContrasena.getPassword().length != 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Complete todos los campos", "Campo vacio", JOptionPane.WARNING_MESSAGE);
		return false;
	}

	private void loguear() {
		usuario.setNombreUsuario(txtUsuario.getText());
		usuario.setPassword(tpContrasena.getText());
		if (usuarioRepo.loguearUsuario(usuario)) {
			new MenuPrincipal(login);
			this.setVisible(false);
		} else {
			verificarNombreUsuario();
		}
	}

	private void verificarNombreUsuario() {
		if (usuarioRepo.existeUsuario(usuario)) {
			JOptionPane.showMessageDialog(null, "Error al loguearse", "Error nombre de usuario no existe",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Error al loguearse", "Error contraseña no válida",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void cancelar() {
		txtUsuario.setText("");
		tpContrasena.setText("");
		txtUsuario.grabFocus();
	}

	public void visible(boolean value) {
		this.setVisible(value);
	}

	public void closeApp() {
		System.exit(NORMAL);
	}
}
