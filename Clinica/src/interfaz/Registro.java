package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import data.UsuarioRepository;
import entidades.Usuario;
import java.awt.Font;

public class Registro extends JFrame {

	private JFrame frmRegistro;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JButton btnRegistrar;
	private UsuarioRepository usuarioRepo;
	private JButton btnCancelar;
	private Usuario usuario;
	private MenuPrincipal menu;
	protected int limiteTexto = 12;

	public Registro(MenuPrincipal menu) {
		this.menu = menu;
		usuario = new Usuario();
		usuarioRepo = new UsuarioRepository();

		frmRegistro = new JFrame();
		frmRegistro.setResizable(false);
		frmRegistro.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frmRegistro.setBounds(100, 100, 521, 266);
		frmRegistro.getContentPane().setLayout(null);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRegistro.setBounds(150, 22, 137, 31);
		frmRegistro.getContentPane().add(lblRegistro);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(10, 64, 77, 14);
		frmRegistro.getContentPane().add(lblUsuario);

		lblPassword = new JLabel("Contrasena:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(10, 96, 102, 14);
		frmRegistro.getContentPane().add(lblPassword);

		frmRegistro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				menu.setVisible(true);
				frmRegistro.dispose();
			}
		});

		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Contraseña de usuario. Hasta 12 caracteres");
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPassword.setBounds(122, 92, 350, 20);
		frmRegistro.getContentPane().add(txtPassword);

		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Nombre de usuario. Hasta 12 caracteres");
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(122, 64, 350, 20);
		frmRegistro.getContentPane().add(txtUsuario);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setToolTipText("Registrar al usuario en el sistema");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (camposCompletos()) {
					usuario.setNombreUsuario(txtUsuario.getText().toUpperCase());
					usuario.setPassword(txtPassword.getText());
					registrar(usuario);
				}
			}
		});
		btnRegistrar.setBounds(122, 143, 128, 31);
		frmRegistro.getContentPane().add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		
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

		txtPassword.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (txtPassword.getText().length() == limiteTexto )
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
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(283, 143, 128, 31);
		frmRegistro.getContentPane().add(btnCancelar);
		frmRegistro.setVisible(true);
	}

	private void registrar(Usuario user) {
		if (usuarioRepo.existeUsuario(user)) {
			JOptionPane.showMessageDialog(null, "Nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (usuarioRepo.registrarUsuario(user)) {
				JOptionPane.showMessageDialog(null, "Usuario creado correctamente", "Usuario",
						JOptionPane.INFORMATION_MESSAGE);
				cancelar();
			}
		}
	}

	private boolean camposCompletos() {
		if (txtUsuario.getText().length() != 0 && txtPassword.getPassword().length != 0) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Complete todos los campos", "Campo vacio", JOptionPane.WARNING_MESSAGE);
		return false;
	}

	private void cancelar() {
		txtUsuario.setText("");
		txtPassword.setText("");
	}
}
