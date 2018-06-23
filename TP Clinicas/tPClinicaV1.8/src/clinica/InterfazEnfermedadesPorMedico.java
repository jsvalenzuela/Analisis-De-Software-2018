package clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class InterfazEnfermedadesPorMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5631735335592166901L;
	private JPanel contentPane;
	private JButton btnSubmitir;
	private JButton btnAnterior;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblListadoDeEnfermedades;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblFondoListadoDeEnfermedades;
	private JLabel lblFondo;
	private JLabel lblCentroMedico;
	private JLabel lblCodMedico;
	private JLabel lblLasEnfermedades;
	private JComboBox<String> comboBox;
	
	private String codMedicoIngresado;
	private JComboBox<String> comboBoxListaMedicos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEnfermedadesPorMedico frame = new InterfazEnfermedadesPorMedico();
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
	public InterfazEnfermedadesPorMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("Los_Laureles.png")));
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 430);
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
		
		lblListadoDeEnfermedades = new JLabel("\"Listado de Enfermedades\"");
		lblListadoDeEnfermedades.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeEnfermedades.setFont(new Font("Times New Roman", Font.PLAIN, 33));
		lblListadoDeEnfermedades.setBackground(Color.WHITE);
		lblListadoDeEnfermedades.setBounds(32, 41, 378, 47);
		contentPane.add(lblListadoDeEnfermedades);
		
		lblFondoListadoDeEnfermedades = new JLabel("");
		lblFondoListadoDeEnfermedades.setIcon(new ImageIcon(Login.class.getResource("borde2.png")));
		lblFondoListadoDeEnfermedades.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondoListadoDeEnfermedades.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblFondoListadoDeEnfermedades.setBackground(Color.WHITE);
		lblFondoListadoDeEnfermedades.setBounds(32, 41, 378, 47);
		contentPane.add(lblFondoListadoDeEnfermedades);
		
		lblCodMedico = new JLabel("Seleccione el medico que desea consultar:");
		lblCodMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodMedico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodMedico.setBackground(Color.WHITE);
		lblCodMedico.setBounds(0, 128, 404, 26);
		contentPane.add(lblCodMedico);
		
		btnSubmitir = new JButton("Buscar");
		btnSubmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cada vez que realice una busqueda el combo box debe vaciarse para que solo contenga los datos de la nueva busqueda
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Vacio"}));
				//guardo en un vector auxiliar la seleccion que se realizo guardando el codigo y el nombre del medico
				String auxiliarSeleccion = (String)comboBoxListaMedicos.getSelectedItem();
				
				if (auxiliarSeleccion != null) {
					
					String[] seleccion= auxiliarSeleccion.split(" ");
					//tomo el valor que se ingreso para la busqueda del medico
					codMedicoIngresado=seleccion[0];
					//declaro una variable del tipo boolean para que recorra todo el archivo una vez que ya encontro el codigo del medico
					Boolean encontrado=false;
					
					try {
						//abro el archivo que contiene la informacion de los medicos
						FileReader input = new FileReader("./bin\\Medicos.txt");
						BufferedReader bufInput = new BufferedReader(input);
						
						String line;
						
						line = bufInput.readLine();
						//recorro cada linea hasta que finalice el archivo o hasta que se encuentre el codigo buscado
						while(line != null && encontrado==false){
							String [] datos;
							
							String lineaDesencriptada = desencriptar(line);
							
							datos = lineaDesencriptada.split(" ");
							//pregunto si el codigo actual de la linea es igual al ingresado en la interfaz
							if(codMedicoIngresado.equals(datos[0])){
								//cambio el valor de la variable boolean por true, para salir de l while
								encontrado=true;
								//declaro un vector auxiliar para armar el nombre del paciente ya que se guardo en formato nombre-apellido
								String [] aux=datos[2].split("-");
								int j=0;
								//recorro el vector aux hasta que se terminen los nombres y apellidos guardados
								//y los concateno cada uno para armar el nombre completo 
								while(j<aux.length){
									j++;
								}
								
								
								//utilizo el vec aux para ir agregando al combo box los nombres de las especialidades que tiene el medico
								//estas estan guardadas en el archivo como: especialidad1-especialidad2-especialidad3...
								aux=datos[3].split("-");
								int k=0;
								while(k<aux.length){
									comboBox.addItem(aux[k]);
									k++;
								}
								
							}
							
							line = bufInput.readLine();
							
						}

						bufInput.close();
						JOptionPane.showMessageDialog(rootPane, "Enfermedades Cargadas", "", JOptionPane.INFORMATION_MESSAGE, null);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(rootPane, "No se pudieron cargar las Enfermedades debido a un error al abrir el Archivo Diagnosticos.txt", "", JOptionPane.ERROR_MESSAGE, null);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ningun Medico", "", JOptionPane.INFORMATION_MESSAGE, null);
				}
				
				
			}
		});
		btnSubmitir.setForeground(Color.BLACK);
		btnSubmitir.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnSubmitir.setBackground(new Color(0, 128, 128));
		btnSubmitir.setBounds(238, 163, 115, 23);
		contentPane.add(btnSubmitir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 208, 414, 2);
		contentPane.add(separator);
		
		lblLasEnfermedades = new JLabel("Trata las siguientes enfermedades:");
		lblLasEnfermedades.setHorizontalAlignment(SwingConstants.CENTER);
		lblLasEnfermedades.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblLasEnfermedades.setBackground(Color.WHITE);
		lblLasEnfermedades.setBounds(10, 231, 280, 26);
		contentPane.add(lblLasEnfermedades);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Vacio"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(10, 294, 414, 20);
		contentPane.add(comboBox);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//se vuelve a la pantalla de informes
				//se genera una ventana de informes
				InterfazInformes iInforme=new InterfazInformes();
				//se pone visible la ventana de informes
				iInforme.setVisible(true);
				//se cierra la ventana de listado de las enfermedades que atiende cada medico
				InterfazEnfermedadesPorMedico.this.dispose();
			}
		});
		
		comboBoxListaMedicos = new JComboBox<String>();
		comboBoxListaMedicos.setBounds(10, 165, 195, 20);
		contentPane.add(comboBoxListaMedicos);
		btnAnterior.setForeground(Color.BLACK);
		btnAnterior.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnAnterior.setBackground(new Color(0, 128, 128));
		btnAnterior.setBounds(152, 358, 138, 23);
		contentPane.add(btnAnterior);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("IntCentroMedico.png")));
		lblFondo.setBounds(0, 0, 434, 392);
		contentPane.add(lblFondo);
		//abro el archivos de Diagnostico para buscar el codigo del medico
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
							comboBoxListaMedicos.addItem(lineaCombo);
						}
						
						
						line = bufInput.readLine();
					}

					bufInput.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane, "Error al abrir el Archivo Medicos.txt", "", JOptionPane.ERROR_MESSAGE, null);
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
