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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class InterfazSituacionDelPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8695794247140068850L;
	private JPanel contentPane;
	private JButton btnCancelar;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblSituacionDelPaciente;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoSituacionDelPaciente;
	private JLabel lblFondo;
	private JButton btnConfirmar;
	private JLabel lblCodPaciente;
	private JLabel lblDiagnostico;
	private JTextField texCodPaciente;
	private JTextField texCodMedico;
	private JTextArea texDiagnostico;
	private JLabel lblCentroMedico;
	private JLabel lblCodMedico;
	private JLabel lblFecha;
	private JTextField texFecha;
	private JLabel lblHora;
	private JTextField texHora;
	private JTextField texMinutos;
	private JLabel label;
	private static boolean errorDeArchivo;
	
	private int ultimoCod = -1;
	private Diagnostico diagnostico;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazSituacionDelPaciente frame = new InterfazSituacionDelPaciente();
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
	public InterfazSituacionDelPaciente() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Source/Los_Laureles.png")));
		
		//inicio de busqueda del ultimo codigo asignado
		
		try{
			FileReader input = new FileReader("./src/Archivos\\Diagnosticos.txt");
			BufferedReader bufInput = new BufferedReader(input);
			
			String line;
			
			line = bufInput.readLine();
			
			while(line != null){
				String [] datos;
				
				datos = line.split(" ");
				if (datos.length > 1) {
					ultimoCod  = Integer.parseInt(datos[0]);
				}			
				
				line = bufInput.readLine();
			}
			
			ultimoCod++; //Lo utilizo incrementado en 1
			
			bufInput.close();
			
		} catch (IOException e){
			e.printStackTrace();
			errorDeArchivo = true;
			JOptionPane.showMessageDialog(rootPane, "Error al intentar abrir el archivo Diagnosticos", "", JOptionPane.ERROR_MESSAGE, null);
		}
		
		//fin de busqueda del ultimo codigo asignado
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 555);
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
		
		lblSituacionDelPaciente = new JLabel("\"Situacion Del Paciente\"");
		lblSituacionDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacionDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblSituacionDelPaciente.setBackground(Color.WHITE);
		lblSituacionDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblSituacionDelPaciente);
		
		lblFondoSituacionDelPaciente = new JLabel("");
		lblFondoSituacionDelPaciente.setIcon(new ImageIcon("./src/Source\\borde2.png"));
		lblFondoSituacionDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoSituacionDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoSituacionDelPaciente.setBackground(Color.WHITE);
		lblFondoSituacionDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoSituacionDelPaciente);
		
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
					InterfazSituacionDelPaciente.this.dispose();
				}
				else
				{
					if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de abortar la carga de Datos del Diagnostico?") == JOptionPane.YES_OPTION) {
						
						//al cancelar el ingreso de la situacion del paciente, se regresa a la ventana anterior que es ingreso de datos.
						//genero una ventana de ingreso de datos
						InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
						//pongo visible la ventana de ingreso de datos
						iIngresoDeDatos.setVisible(true);
						//cierro la ventana de ingreso de la situacion del paciente
						InterfazSituacionDelPaciente.this.dispose();
					
					}
				}
				
				
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnCancelar.setBackground(new Color(0, 128, 128));
		btnCancelar.setBounds(10, 483, 138, 23);
		contentPane.add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(errorDeArchivo == true)
				{	
					JOptionPane.showMessageDialog(rootPane, "La operacion no puede ser completada por error al abrir el Archivo Diagnosticos.txt", "", JOptionPane.ERROR_MESSAGE, null);
				}
				else
				{
					if (texCodPaciente.getText().length()*texCodMedico.getText().length()*texDiagnostico.getText().length()*texFecha.getText().length()*texHora.getText().length()*texMinutos.getText().length() != 0) {
						
						//registro de la informacion en el Archivo Pacientes
						
						diagnostico = new Diagnostico(ultimoCod, Integer.parseInt(texCodPaciente.getText()), Integer.parseInt(texCodMedico.getText()), texDiagnostico.getText(), texFecha.getText(), texHora.getText() + ":" + texMinutos.getText());
						
						FileWriter fichero = null;
				        PrintWriter pw = null;
				        try
				        {
				            fichero = new FileWriter("./src/Archivos\\Diagnosticos.txt", true); //Con pasarle por parametro el true agrega al final sin borrar el contenido
				            pw = new PrintWriter(fichero);
				            
				            pw.println(diagnostico.toString());
				            
				            JOptionPane.showMessageDialog(rootPane, "Registro agregado al archivo con exito", "", JOptionPane.INFORMATION_MESSAGE, null);

				        } catch (Exception e1) {
				            e1.printStackTrace();
				            JOptionPane.showMessageDialog(rootPane, "Error al intentar abrir el archivo Diagnosticos", "", JOptionPane.ERROR_MESSAGE, null);
				        } finally {
				           try {
				           // Nuevamente aprovechamos el finally para 
				           // asegurarnos que se cierra el fichero.
				           if (null != fichero)
				              fichero.close();
				           } catch (Exception e2) {
				              e2.printStackTrace();
				              JOptionPane.showMessageDialog(rootPane, "Error al intentar cerrar el archivo Diagnosticos", "", JOptionPane.ERROR_MESSAGE, null);
				           }
				        }
						
				        //fin registro
					
					//suponemos que todos los datos son correctos y se regresa a la ventana anterior que es ingreso de datos
					//genero una ventana de ingreso de datos
					InterfazIngresoDeDatos iIngresoDeDatos=new InterfazIngresoDeDatos();
					//pongo visible la ventana de ingreso de datos
					iIngresoDeDatos.setVisible(true);
					//cierro la ventana de ingreso de la situacion del paciente
					InterfazSituacionDelPaciente.this.dispose();
					
					}
					else
						JOptionPane.showMessageDialog(rootPane, "Faltan campos por Completar", "", JOptionPane.ERROR_MESSAGE, null);
				}	
			}
		});
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnConfirmar.setBackground(new Color(0, 128, 128));
		btnConfirmar.setBounds(286, 483, 138, 23);
		contentPane.add(btnConfirmar);
		
		lblCodPaciente = new JLabel("Cod. Paciente");
		lblCodPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodPaciente.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodPaciente.setBackground(Color.WHITE);
		lblCodPaciente.setBounds(10, 134, 131, 26);
		contentPane.add(lblCodPaciente);
		
		texCodPaciente = new JTextField();
		texCodPaciente.setBounds(168, 138, 242, 20);
		contentPane.add(texCodPaciente);
		texCodPaciente.setColumns(10);
		
		texCodPaciente.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();

		      // Verificar si la tecla pulsada no es un digito o supera el maximo
		      if((caracter < '0' || caracter > '9'))
		      {
		         e.consume();  // ignorar el evento de teclado
		      }
		   }
		});
		
		texCodMedico = new JTextField();
		texCodMedico.setColumns(10);
		texCodMedico.setBounds(168, 175, 242, 20);
		contentPane.add(texCodMedico);
		
		texCodMedico.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();

		      // Verificar si la tecla pulsada no es un digito o supera el maximo
		      if((caracter < '0' || caracter > '9'))
		      {
		         e.consume();  // ignorar el evento de teclado
		      }
		   }
		});
		
		
		lblCodMedico = new JLabel("Cod. Medico");
		lblCodMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodMedico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodMedico.setBackground(Color.WHITE);
		lblCodMedico.setBounds(10, 171, 131, 26);
		contentPane.add(lblCodMedico);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(10, 208, 131, 26);
		contentPane.add(lblFecha);
		
		texFecha = new JTextField();
		texFecha.setColumns(10);
		texFecha.setBounds(168, 212, 242, 20);
		contentPane.add(texFecha);
		
		texFecha.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				 char caracter = e.getKeyChar();
				 int maximoCarFecha = 10;

				 // Verificar si la tecla pulsada no es un numero o los 2 cracteres validos
				 if(((caracter < '0' || caracter > '9') && caracter != '-' && caracter != '/') || texFecha.getText().length() >= maximoCarFecha)
				 {
				     e.consume();  // ignorar el evento de teclado
				 }
			}
		});
		
		lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblHora.setBackground(Color.WHITE);
		lblHora.setBounds(10, 245, 131, 26);
		contentPane.add(lblHora);
		
		texHora = new JTextField();
		texHora.setColumns(10);
		texHora.setBounds(168, 249, 30, 20);
		contentPane.add(texHora);
		
		texHora.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      int maximoCarHora = 2;
		      // Verificar si la tecla pulsada no es un digito o supera el maximo
		      if((caracter < '0' || caracter > '9') || texHora.getText().length() >= maximoCarHora)
		      {
		         e.consume();  // ignorar el evento de teclado
		      }
		   }
		});
		
		
		label = new JLabel(":");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		label.setBackground(Color.WHITE);
		label.setBounds(201, 245, 23, 26);
		contentPane.add(label);
		
		texMinutos = new JTextField();
		texMinutos.setColumns(10);
		texMinutos.setBounds(227, 249, 30, 20);
		contentPane.add(texMinutos);
		
		texMinutos.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      int maximoCarMinutos = 2;
		      // Verificar si la tecla pulsada no es un digito o supera el maximo
		      if((caracter < '0' || caracter > '9') || texMinutos.getText().length() >= maximoCarMinutos)
		      {
		         e.consume();  // ignorar el evento de teclado
		      }
		   }
		});
		
		
		lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnostico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblDiagnostico.setBackground(Color.WHITE);
		lblDiagnostico.setBounds(10, 273, 113, 26);
		contentPane.add(lblDiagnostico);
		
		texDiagnostico = new JTextArea();
		texDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		texDiagnostico.setLineWrap(true);
		texDiagnostico.setBounds(10, 310, 400, 162);
		contentPane.add(texDiagnostico);
		
		texDiagnostico.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				 char caracter = e.getKeyChar();

				 // Verificar si la tecla pulsada no es una letra
				 if((caracter < '0' || caracter > '9') && (caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z') && caracter != ' ')
				 {
				     e.consume();  // ignorar el evento de teclado
				 }
			}
		});
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
		lblFondo.setBounds(0, 0, 434, 517);
		contentPane.add(lblFondo);
	}
}
