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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
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
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Log.getInstance().info("Cerrar sesion");
			}
		});

		this.usuario = new Usuario();
		setTitle("Clinica - Login");
		setLogin(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 275);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 11));

		lblUsuario.setBounds(7, 122, 96, 20);
		contentPane.add(lblUsuario);
		lblContrasena = new JLabel("Contrase\u00F1a: ");
		lblContrasena.setForeground(new Color(255, 255, 255));
		lblContrasena.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		lblContrasena.setBounds(7, 153, 96, 20);
		contentPane.add(lblContrasena);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsuario.setBounds(107, 122, 353, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		tpContrasena = new JPasswordField();
		tpContrasena.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tpContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					try {
						if (camposCompletos()) {
							usuario.setNombreUsuario(txtUsuario.getText());
							usuario.setPassword(tpContrasena.getText());
							dispose();
						}
					} catch (Exception e) {
						Log.getInstance().error("Error al validar contrasena " + e.getMessage());
					}
			}
		});
		tpContrasena.setBounds(107, 153, 353, 20);
		contentPane.add(tpContrasena);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		btnIngresar.setBounds(107, 204, 120, 21);
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
		btnCancelar.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		btnCancelar.setBounds(281, 204, 120, 21);
		contentPane.add(btnCancelar);

		// JLabel lbllogo= new JLabel("");
		// lbllogo.setHorizontalAlignment(SwingConstants.CENTER);
		// lblNewLabel_1.setIcon(new
		// ImageIcon(Login.class.getResource("/imagenes/logo.jpg")));
		// lbllogo.setBounds(0, -23, 500, 534);
		// contentPane.add(lbllogo);
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
			dispose();
		} else {
			verificarNombreUsuario();
		}
	}

	private void verificarNombreUsuario() {
		if(usuarioRepo.existeUsuario(usuario)) {
			JOptionPane.showMessageDialog(null, "Error al loguearse", "Error nombre de usuario no existe", JOptionPane.ERROR_MESSAGE);	
		}else {
			JOptionPane.showMessageDialog(null, "Error al loguearse", "Error contraseña no válida", JOptionPane.ERROR_MESSAGE);
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
}
