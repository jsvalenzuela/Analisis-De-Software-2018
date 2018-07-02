package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.Font;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JFrame frmRegistro;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JButton btnRegistrar;
	private UsuarioRepository usuarioRepo;
	private JButton btnCancelar;

	public Registro(final Usuario usuario) {

		usuarioRepo = new UsuarioRepository();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		frmRegistro = new JFrame();
		frmRegistro.setResizable(false);
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 474, 249);
		frmRegistro.getContentPane().setLayout(null);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		lblUsuario.setBounds(10, 64, 77, 14);
		frmRegistro.getContentPane().add(lblUsuario);

		lblPassword = new JLabel("Contrasena:");
		lblPassword.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		lblPassword.setBounds(10, 89, 77, 14);
		frmRegistro.getContentPane().add(lblPassword);

		frmRegistro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPassword.setBounds(97, 89, 350, 20);
		frmRegistro.getContentPane().add(txtPassword);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(97, 61, 350, 20);
		frmRegistro.getContentPane().add(txtUsuario);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (camposCompletos()) {
					usuario.setNombreUsuario(txtUsuario.getText().toUpperCase());
					usuario.setPassword(txtPassword.getText());
					registrar(usuario);
					frmRegistro.dispose();
				}
			}
		});
		btnRegistrar.setBounds(96, 144, 115, 20);
		frmRegistro.getContentPane().add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		btnCancelar.setBounds(258, 144, 115, 20);
		frmRegistro.getContentPane().add(btnCancelar);
		frmRegistro.setVisible(true);
	}

	private void registrar(Usuario user) {
		if (!usuarioRepo.existeUsuario(user)) {
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
