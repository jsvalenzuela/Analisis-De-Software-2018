package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.UsuarioRepository;
import entidades.Usuario;
import utilities.Log;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

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
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLogin.setBounds(150, 22, 87, 31);
		contentPane.add(lblLogin);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblUsuario.setBounds(22, 122, 96, 20);
		contentPane.add(lblUsuario);
		lblContrasena = new JLabel("Contrase\u00F1a: ");
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasena.setBounds(22, 153, 119, 20);
		contentPane.add(lblContrasena);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.setBounds(150, 122, 353, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		tpContrasena = new JPasswordField();
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
		tpContrasena.setBounds(150, 153, 353, 20);
		contentPane.add(tpContrasena);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIngresar.setBounds(177, 202, 140, 33);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (camposCompletos()) {
					loguear();
				}
			}
		});

		contentPane.add(btnIngresar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelar();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(363, 202, 140, 33);
		contentPane.add(btnCancelar);

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
