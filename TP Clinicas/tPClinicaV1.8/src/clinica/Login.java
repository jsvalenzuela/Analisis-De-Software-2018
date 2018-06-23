package clinica;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

public class Login extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5478864625143454143L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private String usuario;
	private String contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("Los_Laureles.png")));
		
		try{
			FileReader input = new FileReader("./bin\\Login.txt");
			BufferedReader bufInput = new BufferedReader(input);
			
			String line;
			
			line = bufInput.readLine();
			
			String lineaDesencriptada = desencriptar(line);
			
			String [] datos; 
			
			datos = lineaDesencriptada.split(" ");
			
			usuario = datos[0];
			contraseña = datos[1];
		
			bufInput.close();
			
		} catch (IOException e){
			JOptionPane.showMessageDialog(null, "Archivo Login.txt no encontrado");
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblBienbenidoAlSistema = new JLabel("Bienvenido");
		lblBienbenidoAlSistema.setFont(new Font("Baskerville Old Face", Font.PLAIN, 35));
		lblBienbenidoAlSistema.setBounds(133, 21, 173, 47);
		contentPane.add(lblBienbenidoAlSistema);
		
		JLabel lblSistemaDeControl = new JLabel("Sistema de Control de Pacientes");
		lblSistemaDeControl.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblSistemaDeControl.setBounds(10, 63, 403, 47);
		contentPane.add(lblSistemaDeControl);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(26, 134, 86, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(26, 170, 115, 47);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(106, 140, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(137, 187, 155, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnAceptar.setBackground(new Color(0, 128, 128));
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				boolean correcUsuario, correcContraseña;
				
				correcUsuario = usuario.equals(textField.getText()); 
				correcContraseña = contraseña.equals(textField_1.getText());
				
				if (correcUsuario) {
					if (correcContraseña) {
						
						JOptionPane.showMessageDialog(null, "Login Correcto");
						
						InterfazCentroMedico interfazCM = new InterfazCentroMedico();
						
						interfazCM.setVisible(true);
						Login.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario incorrecto");
				
			}
		});
		btnAceptar.setBounds(74, 227, 115, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
			}
		});
		btnCancelar.setBounds(244, 227, 124, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("IntCentroMedico.png")));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
	}

	public String encriptar(String linea){
		
	    char array[]=linea.toCharArray(); 
	     
	    for(int i=0;i<array.length;i++){ 
	        array[i]=(char)(array[i]+(char)5); 
	    } 
	    String encriptado =String.valueOf(array);
	    
		return encriptado;
	}
	
	public String desencriptar(String lineaEncriptada) {
		
		char arrayD[]=lineaEncriptada.toCharArray(); 
        for(int i=0;i<arrayD.length;i++){ 
            arrayD[i]=(char)(arrayD[i]-(char)5); 
        } 
        
        String desencriptado =String.valueOf(arrayD); 
        
        return desencriptado;
		
	}
	 
}