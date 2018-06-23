package clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class InterfazDatosDelPaciente extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6295405315725566565L;
	private JPanel contentPane;
	private JButton btnCancelar;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblDatosDelPaciente;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoDatosDelPaciente;
	private JLabel lblFondo;
	private JButton btnConfirmar;
	private JLabel lblCodPaciente;
	private JLabel lblNombre;
	private JLabel lblFechaDeIngreso;
	private JLabel lblDireccion;
	private JLabel lblTipoDeSangre;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JTextField texCodPaciente;
	private JTextField texNombre;
	private JTextField texDni;
	private JTextField texFechaDeIngreso;
	private JTextField texTipoDeSangre;
	private JTextField texTelefono;
	private JLabel lblCalle;
	private JTextField texCalle;
	private JLabel lblCentroMedico;
	private JTextField texNumero;
	private JLabel lblNumero;
	private static boolean errorDeArchivo;
	
	
	private int ultimoCod= -1;
	private Paciente paciente;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDatosDelPaciente frame = new InterfazDatosDelPaciente();
					
					if(!errorDeArchivo)
					{	
						frame.setVisible(true);
					}
					else
						frame.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazDatosDelPaciente() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Source/Los_Laureles.png")));
		
		//inicio de busqueda del ultimo codigo asignado
		
				try{
					FileReader input = new FileReader("./src/Archivos\\Pacientes.txt");
					BufferedReader bufInput = new BufferedReader(input);
					
					String line;
					
					line = bufInput.readLine();
					
					while(line != null){
						String [] datos;
						
						datos = line.split(" ");
						
						if (datos.length > 1) {
							ultimoCod = Integer.parseInt(datos[0]);
						}		
						
						line = bufInput.readLine();
					}
					
					ultimoCod++; //Lo utilizo incrementado en 1
					
					bufInput.close();
					
				} catch (IOException e){
					e.printStackTrace();
					errorDeArchivo = true;
					JOptionPane.showMessageDialog(rootPane, "Error al intentar abrir el archivo Pacientes", "", JOptionPane.ERROR_MESSAGE, null);
				}
				
				//fin de busqueda del ultimo codigo asignado
		
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
			lblFondoCentroMedico.setIcon(new ImageIcon("./src/Source\\borde.png"));
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
			lblFondoControlDePacientes.setIcon(new ImageIcon("./src/Source\\borde.png"));
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
			lblFondoDatosDelPaciente.setIcon(new ImageIcon("./src/Source\\borde2.png"));
			lblFondoDatosDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
			lblFondoDatosDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			lblFondoDatosDelPaciente.setBackground(Color.WHITE);
			lblFondoDatosDelPaciente.setBounds(32, 41, 378, 47);
			contentPane.add(lblFondoDatosDelPaciente);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (errorDeArchivo == true) {
						//al cancelar el ingreso de datos se regresa a la ventana ingreso de datos
						//genero una ventana de ingreso de datos
						InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
						//pongo visible la ventana de ingreso de datos
						iIngresoDeDatos.setVisible(true);
						//cierro la ventana de ingreso de datos del paciente
						InterfazDatosDelPaciente.this.dispose();
					}
					else
					{
						if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de abortar la carga de Datos del paciente?") == JOptionPane.YES_OPTION) {
							//al cancelar el ingreso de datos se regresa a la ventana ingreso de datos
							//genero una ventana de ingreso de datos
							InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
							//pongo visible la ventana de ingreso de datos
							iIngresoDeDatos.setVisible(true);
							//cierro la ventana de ingreso de datos del paciente
							InterfazDatosDelPaciente.this.dispose();
						}
					}	
					
					
				}
			});
			btnCancelar.setForeground(Color.BLACK);
			btnCancelar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
			btnCancelar.setBackground(new Color(0, 128, 128));
			btnCancelar.setBounds(10, 458, 138, 23);
			contentPane.add(btnCancelar);
			
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(errorDeArchivo == true)
					{	
						JOptionPane.showMessageDialog(rootPane, "La operacion no puede ser completada por error al abrir el Archivo Pacientes.txt", "", JOptionPane.ERROR_MESSAGE, null);
					}
					else
					{
						if (texTipoDeSangre.getText().length()*texDni.getText().length()*texFechaDeIngreso.getText().length()*texNombre.getText().length()*texTelefono.getText().length()*texCalle.getText().length()*texNumero.getText().length() != 0) {
							
							//registro de la informacion en el Archivo Pacientes
							
							paciente = new Paciente(ultimoCod, texTipoDeSangre.getText(), Integer.parseInt(texDni.getText()), texFechaDeIngreso.getText(), texNombre.getText(), Integer.parseInt(texTelefono.getText()) , texCalle.getText() +" "+ texNumero.getText());
							
							FileWriter fichero = null;
					        PrintWriter pw = null;
					        try
					        {
					            fichero = new FileWriter("./src/Archivos\\Pacientes.txt", true); //Con pasarle por parametro el true agrega al final sin borrar el contenido
					            pw = new PrintWriter(fichero);
					            
					            pw.println(paciente.toString());
					            
					            JOptionPane.showMessageDialog(rootPane, "Registro agregado al archivo con exito", "", JOptionPane.INFORMATION_MESSAGE, null);
		
					        } catch (Exception e1) {
					            e1.printStackTrace();
					            JOptionPane.showMessageDialog(rootPane, "Error al intentar abrir el archivo Pacientes", "", JOptionPane.ERROR_MESSAGE, null);
					        } finally {
					           try {
					           // Nuevamente aprovechamos el finally para 
					           // asegurarnos que se cierra el fichero.
					           if (null != fichero)
					              fichero.close();
					           } catch (Exception e2) {
					              e2.printStackTrace();
					              JOptionPane.showMessageDialog(rootPane, "Error al intentar cerrar el archivo Pacientes", "", JOptionPane.ERROR_MESSAGE, null);
					           }
					        }
							
					        //fin registro
					        
							//suponemos que todos los datos son correctos y se regresa a la ventana anterior que es ingreso de datos
							//genero una ventana de ingreso de datos
							InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
							//pongo visible la ventana de ingreso de datos
							iIngresoDeDatos.setVisible(true);
							//cierro la ventana de ingreso de datos del paciente
							InterfazDatosDelPaciente.this.dispose();
						}
						else
							JOptionPane.showMessageDialog(rootPane, "Faltan campos por Completar", "", JOptionPane.ERROR_MESSAGE, null);
					}
					
				}
			});
			
			btnConfirmar.setForeground(Color.BLACK);
			btnConfirmar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
			btnConfirmar.setBackground(new Color(0, 128, 128));
			btnConfirmar.setBounds(286, 458, 138, 23);
			contentPane.add(btnConfirmar);
			
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
			texCodPaciente.setText("" + ultimoCod);
			texCodPaciente.setBounds(168, 138, 242, 20);
			contentPane.add(texCodPaciente);
			texCodPaciente.setColumns(10);
			
			texNombre = new JTextField(10);
			texNombre.setColumns(10);
			texNombre.setBounds(168, 175, 242, 20);
			contentPane.add(texNombre);
			
			//Validacion entrada de texto
			
			texNombre.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					 char caracter = e.getKeyChar();
	
					 // Verificar si la tecla pulsada no es una letra
					 if((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z') && caracter != ' ')
					 {
					     e.consume();  // ignorar el evento de teclado
					 }
				}
			});
			
			
			texDni = new JTextField();
			texDni.setColumns(10);
			texDni.setBounds(168, 212, 242, 20);
			contentPane.add(texDni);
			
			//Validacion entrada de texto
			
			texDni.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
			      char caracter = e.getKeyChar();
			      int maximoCarDni = 8;
	
			      // Verificar si la tecla pulsada no es un digito o supera el maximo
			      if((caracter < '0' || caracter > '9') || texDni.getText().length() >= maximoCarDni)
			      {
			         e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
			
			texFechaDeIngreso = new JTextField();
			texFechaDeIngreso.setColumns(10);
			texFechaDeIngreso.setBounds(168, 249, 242, 20);
			contentPane.add(texFechaDeIngreso);
			
			texFechaDeIngreso.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					 char caracter = e.getKeyChar();
					 int maximoCarFecha = 10;
	
					 // Verificar si la tecla pulsada no es un numero o los 2 cracteres validos
					 if(((caracter < '0' || caracter > '9') && caracter != '-' && caracter != '/') || texFechaDeIngreso.getText().length() >= maximoCarFecha)
					 {
					     e.consume();  // ignorar el evento de teclado
					 }
				}
			});
			
			texTipoDeSangre = new JTextField();
			texTipoDeSangre.setColumns(10);
			texTipoDeSangre.setBounds(168, 286, 242, 20);
			contentPane.add(texTipoDeSangre);
			
			texTipoDeSangre.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					 char caracter = e.getKeyChar();
					 int maximoCarTipo = 3;
					 // Verificar si la tecla pulsada no es una letra o los 2 caracteres validos y no supera el maximo de caracteres
					 if(texTipoDeSangre.getText().length() >= maximoCarTipo || (caracter < 'A' || caracter > 'Z') && caracter != '+' && caracter != '-')
					 {
					     e.consume();  // ignorar el evento de teclado
					 }
				}
			});
			
			texTelefono = new JTextField();
			texTelefono.setColumns(10);
			texTelefono.setBounds(168, 323, 242, 20);
			contentPane.add(texTelefono);
			
			//Validacion entrada de texto
			
			texTelefono.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
			      char caracter = e.getKeyChar();
			      int maximoCarTel = 10;
	
			      // Verificar si la tecla pulsada no es un digito o supera el maximo
			      if((caracter < '0' || caracter > '9') || texTelefono.getText().length() >= maximoCarTel)
			      {
			         e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
			
			
			texCalle = new JTextField();
			texCalle.setColumns(10);
			texCalle.setBounds(168, 388, 242, 20);
			contentPane.add(texCalle);
			
			texCalle.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					 char caracter = e.getKeyChar();
	
					 // Verificar si la tecla pulsada no es una letra o el espacio
					 if((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z') && caracter != ' ')
					 {
					     e.consume();  // ignorar el evento de teclado
					 }
				}
			});
			
			texNumero = new JTextField();
			texNumero.setColumns(10);
			texNumero.setBounds(168, 419, 242, 20);
			contentPane.add(texNumero);
			
			texNumero.addKeyListener(new KeyAdapter()
			{
			   public void keyTyped(KeyEvent e)
			   {
			      char caracter = e.getKeyChar();
			      int maximoCarCalle = 5;
	
			      // Verificar si la tecla pulsada no es un digito o supera el maximo
			      if((caracter < '0' || caracter > '9') || texNumero.getText().length() >= maximoCarCalle)
			      {
			         e.consume();  // ignorar el evento de teclado
			      }
			   }
			});
			
			lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
			lblFondo.setBounds(0, 0, 434, 492);
			contentPane.add(lblFondo);
	}
		
}
