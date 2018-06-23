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
import javax.swing.JComboBox;
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
	private JComboBox<String> comboPacientes;
	private JComboBox<String> comboMedicos;
	
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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("Los_Laureles.png")));
		
		//inicio de busqueda del ultimo codigo asignado
		
		try{
			FileReader input = new FileReader("./bin\\Diagnosticos.txt");
			BufferedReader bufInput = new BufferedReader(input);
			
			String line;
			
			line = bufInput.readLine();
			
			while(line != null){
				String [] datos;
				
				String lineaDesencriptada = desencriptar(line);
				
				datos = lineaDesencriptada.split(" ");
				
				if (datos.length > 1) {
					setUltimoCod(Integer.parseInt(datos[0]));
				}			
				
				line = bufInput.readLine();
			}
			
			setUltimoCod(getUltimoCod() + 1); //Lo utilizo incrementado en 1
			
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
		
		lblSituacionDelPaciente = new JLabel("\"Situacion Del Paciente\"");
		lblSituacionDelPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacionDelPaciente.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblSituacionDelPaciente.setBackground(Color.WHITE);
		lblSituacionDelPaciente.setBounds(32, 41, 378, 47);
		contentPane.add(lblSituacionDelPaciente);
		
		lblFondoSituacionDelPaciente = new JLabel("");
		lblFondoSituacionDelPaciente.setIcon(new ImageIcon(Login.class.getResource("borde2.png")));
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
		
		comboPacientes = new JComboBox<String>();
		comboPacientes.setBackground(new Color(0, 128, 128));
		comboPacientes.setBounds(215, 138, 195, 20);
		contentPane.add(comboPacientes);
		
		//abrir archivo pacientes para cargar los pacientes
		
				try {
					FileReader input = new FileReader("./bin\\Pacientes.txt");
					BufferedReader bufInput = new BufferedReader(input);
								
					String line;// para leer cada linea del archivo
					String lineaCombo;// es la linea que se agregara al comboBox de medicos
					line = bufInput.readLine();
					
					//recorro todas las lineas del archivo
					while(line != null){
						String [] datos;
						
						String lineaDesencriptada = desencriptar(line);
						
						datos = lineaDesencriptada.split(" ");
						
						lineaCombo=datos[0]+" ";
						String[] aux;//va a contener a todos los nombres y apellidos del medico
						if (datos.length > 1) {
							aux=datos[4].split("-");
							//mediante un while los concateno junto con el codigo
							int i=0;
							while(i<aux.length){
								lineaCombo+=aux[i]+" ";
								i++;
							}
							//la linea del combo ya tiene el codigo y el nombre del medico al que corresponde ese codigo
							//lo agrego al comboBox
							comboPacientes.addItem(lineaCombo);
						}
						
						line = bufInput.readLine();
						
					}
					
					bufInput.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "No se pudieron cargar los pacientes debido a un error al abrir el Archivo Pacientes.txt", "", JOptionPane.ERROR_MESSAGE, null);
				}
		
		
		comboMedicos = new JComboBox<String>();
		comboMedicos.setBackground(new Color(0, 128, 128));
		comboMedicos.setBounds(215, 171, 195, 20);
		contentPane.add(comboMedicos);
		
		try {
			FileReader input = new FileReader("./bin\\Medicos.txt");
			BufferedReader bufInput = new BufferedReader(input);
						
			String line;// para leer cada linea del archivo
			String lineaCombo;// es la linea que se agregara al comboBox de medicos
			line = bufInput.readLine();
			
			//recorro todas las lineas del archivo
			while(line != null){
				String [] datos;
				
				String lineaDesencriptada = desencriptar(line);
				
				datos = lineaDesencriptada.split(" ");
				
				lineaCombo=datos[0]+" ";
				String[] aux;//va a contener a todos los nombres y apellidos del medico
				if (datos.length > 1) {
					aux=datos[2].split("-");
					//mediante un while los concateno junto con el codigo
					int i=0;
					while(i<aux.length){
						lineaCombo+=aux[i]+" ";
						i++;
					}
					//la linea del combo ya tiene el codigo y el nombre del medico al que corresponde ese codigo
					//lo agrego al comboBox
					comboMedicos.addItem(lineaCombo);
				}
				
				line = bufInput.readLine();
				
			}

			bufInput.close();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, "No se pudieron cargar los medicos debido a un error al abrir el Archivo Medicos.txt", "", JOptionPane.ERROR_MESSAGE, null);
		}
		
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
					String seleccionMed = (String)comboMedicos.getSelectedItem();
					String seleccionPac = (String)comboPacientes.getSelectedItem();
					
					if (seleccionPac != null && seleccionMed != null) {
						
						String [] datos = seleccionMed.split(" ");
						String codMedico = datos[0];
						datos = seleccionPac.split(" ");
						String codPaciente = datos[0];
						
						if (texDiagnostico.getText().length()*texFecha.getText().length()*texHora.getText().length()*texMinutos.getText().length() != 0) {
							
							//registro de la informacion en el Archivo Pacientes
							
							
							
							
							diagnostico = new Diagnostico(ultimoCod, Integer.parseInt(codPaciente), Integer.parseInt((codMedico)), texDiagnostico.getText(), texFecha.getText(), texHora.getText() + ":" + texMinutos.getText());
							
							FileWriter fichero = null;
					        PrintWriter pw = null;
					        try
					        {
					            fichero = new FileWriter("./bin\\Diagnosticos.txt", true); //Con pasarle por parametro el true agrega al final sin borrar el contenido
					            pw = new PrintWriter(fichero);
					            
					            pw.println(encriptar(diagnostico.toString()));
					            
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
		
		lblCodMedico = new JLabel("Cod. Medico");
		lblCodMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodMedico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodMedico.setBackground(Color.WHITE);
		lblCodMedico.setBounds(10, 171, 131, 26);
		contentPane.add(lblCodMedico);
		
		lblFecha = new JLabel("Fecha(dd-mm-aaaa)");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(10, 208, 169, 26);
		contentPane.add(lblFecha);
		
		texFecha = new JTextField();
		texFecha.setColumns(10);
		texFecha.setBounds(215, 212, 195, 20);
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
		
		lblHora = new JLabel("Hora(hh:mm)");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblHora.setBackground(Color.WHITE);
		lblHora.setBounds(10, 245, 138, 26);
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
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("IntCentroMedico.png")));
		lblFondo.setBounds(0, 0, 434, 517);
		contentPane.add(lblFondo);
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

	public int getUltimoCod() {
		return ultimoCod;
	}

	public void setUltimoCod(int ultimoCod) {
		this.ultimoCod = ultimoCod;
	}
}
