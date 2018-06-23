package clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfazVerPaciente extends JFrame {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -523772614675985260L;
	private JPanel contentPane;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblDatosDelPaciente;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoDatosDelPaciente;
	private JLabel lblFondo;
	private JLabel lblCodPaciente;
	private JLabel lblNombre;
	private JLabel lblFechaDeIngreso;
	private JLabel lblDireccion;
	private JLabel lblTipoDeSangre;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JTextField texCodPaciente;
	private JTextField texNombre;
	private JTextField texTipoDeSangre;
	private JTextField texTelefono;
	private JLabel lblCalle;
	private JTextField texCalle;
	private JLabel lblCentroMedico;
	private JTextField texNumero;
	private JLabel lblNumero;
	private JButton btnVolver;
	private JTextField textFieldDNI;
	private JTextField textFieldFechaIngreso;
	private String codPacienteAver;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazVerPaciente frame = new InterfazVerPaciente();
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
	public InterfazVerPaciente() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("Los_Laureles.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblCentroMedico = new JLabel("Centro Medico");
		lblCentroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentroMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblCentroMedico.setBackground(Color.WHITE);
		lblCentroMedico.setBounds(32, 12, 378, 26);
		contentPane.add(lblCentroMedico);
		
		lblFondoCentroMedico = new JLabel("");
		lblFondoCentroMedico.setIcon(new ImageIcon(Login.class.getResource("borde.png")));
		lblFondoCentroMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoCentroMedico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblFondoCentroMedico.setBackground(Color.WHITE);
		lblFondoCentroMedico.setBounds(32, 12, 378, 26);
		contentPane.add(lblFondoCentroMedico);
		
		lblControlDePacientes = new JLabel("Control de Pacientes");
		lblControlDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblControlDePacientes.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblControlDePacientes.setBackground(Color.WHITE);
		lblControlDePacientes.setBounds(32, 92, 378, 26);
		contentPane.add(lblControlDePacientes);
		
		lblFondoControlDePacientes = new JLabel("");
		lblFondoControlDePacientes.setIcon(new ImageIcon(Login.class.getResource("borde.png")));
		lblFondoControlDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoControlDePacientes.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblFondoControlDePacientes.setBackground(Color.WHITE);
		lblFondoControlDePacientes.setBounds(32, 92, 378, 26);
		contentPane.add(lblFondoControlDePacientes);
		
		lblDatosDelPaciente = new JLabel("\"Datos Del Paciente\"");
		lblDatosDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblDatosDelPaciente.setBackground(Color.WHITE);
		lblDatosDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblDatosDelPaciente);
		
		lblFondoDatosDelPaciente = new JLabel("");
		lblFondoDatosDelPaciente.setIcon(new ImageIcon(Login.class.getResource("borde2.png")));
		lblFondoDatosDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoDatosDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoDatosDelPaciente.setBackground(Color.WHITE);
		lblFondoDatosDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoDatosDelPaciente);
		
		lblCodPaciente = new JLabel("Cod. Paciente");
		lblCodPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodPaciente.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodPaciente.setBackground(Color.WHITE);
		lblCodPaciente.setBounds(10, 134, 131, 26);
		contentPane.add(lblCodPaciente);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(10, 171, 83, 26);
		contentPane.add(lblNombre);
		
		lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
		lblFechaDeIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeIngreso.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblFechaDeIngreso.setBackground(Color.WHITE);
		lblFechaDeIngreso.setBounds(10, 245, 148, 26);
		contentPane.add(lblFechaDeIngreso);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblDireccion.setBackground(Color.WHITE);
		lblDireccion.setBounds(10, 367, 95, 26);
		contentPane.add(lblDireccion);
		
		lblTipoDeSangre = new JLabel("Tipo de Sangre");
		lblTipoDeSangre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeSangre.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblTipoDeSangre.setBackground(Color.WHITE);
		lblTipoDeSangre.setBounds(17, 282, 131, 26);
		contentPane.add(lblTipoDeSangre);
		
		lblDni = new JLabel("Dni");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblDni.setBackground(Color.WHITE);
		lblDni.setBounds(10, 208, 58, 26);
		contentPane.add(lblDni);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblTelefono.setBackground(Color.WHITE);
		lblTelefono.setBounds(27, 319, 83, 26);
		contentPane.add(lblTelefono);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalle.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCalle.setBackground(Color.WHITE);
		lblCalle.setBounds(90, 384, 58, 26);
		contentPane.add(lblCalle);
		
		lblNumero = new JLabel("N\u00BA");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblNumero.setBackground(Color.WHITE);
		lblNumero.setBounds(90, 415, 58, 26);
		contentPane.add(lblNumero);
		
		texCodPaciente = new JTextField();
		texCodPaciente.setEditable(false);
		texCodPaciente.setBounds(168, 138, 242, 20);
		contentPane.add(texCodPaciente);
		texCodPaciente.setColumns(10);
		
		texNombre = new JTextField(10);
		texNombre.setEditable(false);
		texNombre.setColumns(10);
		texNombre.setBounds(168, 175, 242, 20);
		contentPane.add(texNombre);
		
		
		texTipoDeSangre = new JTextField();
		texTipoDeSangre.setEditable(false);
		texTipoDeSangre.setColumns(10);
		texTipoDeSangre.setBounds(168, 286, 242, 20);
		contentPane.add(texTipoDeSangre);
			
		texTelefono = new JTextField();
		texTelefono.setEditable(false);
		texTelefono.setColumns(10);
		texTelefono.setBounds(168, 323, 242, 20);
		contentPane.add(texTelefono);
				
		texCalle = new JTextField();
		texCalle.setEditable(false);
		texCalle.setColumns(10);
		texCalle.setBounds(168, 388, 242, 20);
		contentPane.add(texCalle);
				
		texNumero = new JTextField();
		texNumero.setEditable(false);
		texNumero.setColumns(10);
		texNumero.setBounds(168, 419, 242, 20);
		contentPane.add(texNumero);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setEditable(false);
		textFieldDNI.setBounds(168, 212, 242, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldFechaIngreso = new JTextField();
		textFieldFechaIngreso.setEnabled(true);
		textFieldFechaIngreso.setEditable(false);
		textFieldFechaIngreso.setText("");
		textFieldFechaIngreso.setBounds(168, 249, 242, 20);
		contentPane.add(textFieldFechaIngreso);
		textFieldFechaIngreso.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnVolver.setBackground(new Color(0, 128, 128));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//si se pulsa el boton de volver, se regresa a la pantalla que informa que pacientes atiende cada medico
				//para esto creamos una interfaz pacientes por medico
				InterfazPacientesPorMedico interfazPacientePorMedico = new InterfazPacientesPorMedico();
				//ponemos visible la ventana de pacientes que atiende cada medico
				interfazPacientePorMedico.setVisible(true);
				//por ultimo cerramos la ventana que muestra los datos del paciente
				InterfazVerPaciente.this.dispose();
			}
		});
		btnVolver.setBounds(160, 466, 108, 26);
		contentPane.add(btnVolver);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("IntCentroMedico.png")));
		lblFondo.setBounds(0, 0, 434, 492);
		contentPane.add(lblFondo);
		
		
	}
	//funcion para que se pueda "pasar" el codigo obtenido en la pantalla de pacientes por medico y buscarlo en el archivo y mostrar sus datos
	public void setearCodigoPaciente(String cod){
		//como lo que se obtuvo del combo box es el codigo mas el nombre, necesito parsearlo para obtener solo el codigo
		String []datos=cod.split(" ");
		this.codPacienteAver=datos[0];
	}
	//esta funcion se llama luego de haber creado la interfaz, porque si no tira error al querer buscar un codigo null
	public boolean llenarCampos(){
		
				try{
					//abro el archivo para buscar el codigo del paciente
					FileReader input = new FileReader("./bin\\Pacientes.txt");
					BufferedReader bufInput = new BufferedReader(input);
					
					String line;//string con el que voy a recorrer todo el archivo
					Boolean encontrado=false;//para salir del archivo una vez que encontre el paciente
					line = bufInput.readLine();//leo una linea del archivo
					//recorro todo el archivo hasta que encuentre el paciente que coincide con el codigo
					while(line != null && encontrado==false){
						String [] datos;
						
						String lineaDesencriptada = desencriptar(line);
						
						datos = lineaDesencriptada.split(" ");
									
						if(codPacienteAver.equals(datos[0])){
							encontrado=true;
							//lleno todos los campos con los datos del paciente
							texCodPaciente.setText(datos[0]);
							texTipoDeSangre.setText(datos[1]);
							textFieldDNI.setText(datos[2]);
							textFieldFechaIngreso.setText(datos[3]);
							//como el nombre del paciente esta guardado en el formato nombre-apellido
							//hago un split para obtener todas las partes y luego concatenarlas cambiando el - por un espacio
							
							String []auxNombre=datos[4].split("-");
							String lineaNombre=auxNombre[0];
							int j=1;
							while(j<auxNombre.length){
								lineaNombre+=" "+auxNombre[j];
								j++;
								
							}
							texNombre.setText(lineaNombre);
							texTelefono.setText(datos[5]);
							//lo mismo sucede con la direccion, que puede ser mas de una palabra, por lo tanto se guarda palabra1-palabra2...
							auxNombre=datos[6].split("-");
							lineaNombre=auxNombre[0];
							j=1;
							while(j<auxNombre.length){
								lineaNombre+=" "+auxNombre[j];
								j++;
								
							}
							texCalle.setText(lineaNombre);
							texNumero.setText(datos[7]);
							
							
						}
						
						line = bufInput.readLine();
					}
					
					
					
					bufInput.close();
					
					return true;
					
				} catch (IOException e){
					e.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "Error al intentar abrir el archivo Pacientes", "", JOptionPane.ERROR_MESSAGE, null);
					return false;
				}
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
