package clinica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class InterfazPacientesPorMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7926670809925213564L;
	private JPanel contentPane;
	private JButton btnVolver;
	private JLabel lblFondoCentroMedico;
	private JLabel lblControlDePacientes;
	private JLabel lblListadoDePacientes;
	private JLabel lblFondoControlDePacientes;
	private JLabel lblListadoPacientes;
	private JLabel lblFondo;
	private JLabel lblCentroMedico;
	private JLabel lblCodigoDelMedico;
	private JLabel lblListaDePacientes;
	private JButton btnSubmitir;
	private JComboBox<String> comboBox;
	private JButton btnVerPaciente;
	
	private String codMedicoIngr;
	private ArrayList<Integer> codPacientes;
	protected static boolean errorArchivoDiagnosticos;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPacientesPorMedico frame = new InterfazPacientesPorMedico();
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
	public InterfazPacientesPorMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Source/Los_Laureles.png")));
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 487);
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
		
		lblListadoDePacientes = new JLabel("\"Listado De Pacientes\"");
		lblListadoDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDePacientes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblListadoDePacientes.setBackground(Color.WHITE);
		lblListadoDePacientes.setBounds(32, 41, 378, 47);
		contentPane.add(lblListadoDePacientes);
		
		lblListadoPacientes = new JLabel("");
		lblListadoPacientes.setIcon(new ImageIcon("./src/Source\\borde2.png"));
		lblListadoPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoPacientes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblListadoPacientes.setBackground(Color.WHITE);
		lblListadoPacientes.setBounds(32, 41, 378, 47);
		contentPane.add(lblListadoPacientes);
		
		lblCodigoDelMedico = new JLabel("Seleccione el medico que desea consultar:");
		lblCodigoDelMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoDelMedico.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblCodigoDelMedico.setBackground(Color.WHITE);
		lblCodigoDelMedico.setBounds(0, 146, 410, 26);
		contentPane.add(lblCodigoDelMedico);
		
		JComboBox<String> comboBox_codMedicos = new JComboBox<String>();
		comboBox_codMedicos.setBounds(10, 183, 210, 20);
		contentPane.add(comboBox_codMedicos);
		//abro el archivos de Diagnostico para buscar el codigo del medico
		try {
			FileReader input = new FileReader("./src/Archivos\\Medicos.txt");
			BufferedReader bufInput = new BufferedReader(input);
						
			String line;// para leer cada linea del archivo
			String lineaCombo;// es la linea que se agregara al comboBox de medicos
			line = bufInput.readLine();
			
			//recorro todas las lineas del archivo
			while(line != null){
				String [] datos;
				
				datos = line.split(" ");
				
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
					comboBox_codMedicos.addItem(lineaCombo);
				}
				
				line = bufInput.readLine();
				
			}

			bufInput.close();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, "No se pudieron cargar los medicos debido a un error al abrir el Archivo Medicos.txt", "", JOptionPane.ERROR_MESSAGE, null);
		}
		
		btnSubmitir = new JButton("Buscar");
		btnSubmitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//"limpo" el combo box de pacientes por medico para una nueva busqueda
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Vacio"}));
				//obtengo el codigo que se ingreso en la interfaz
				//codMedicoIngr=texCodigoDelMedico.getText();
					String auxLineaCombo=(String)comboBox_codMedicos.getSelectedItem();
					
					if(auxLineaCombo != null)
					{	
						String []auxLinea=auxLineaCombo.split(" ");
						codMedicoIngr= auxLinea[0];
						
						
						//abro el archivos de Diagnostico para buscar el codigo del medico
						try {
							FileReader input = new FileReader("./src/Archivos\\Diagnosticos.txt");
							BufferedReader bufInput = new BufferedReader(input);
							//genero un array list para guardar los codigos de los pacientes que atendio ese medico
							codPacientes=new ArrayList<>();
							
							String line;
							
							line = bufInput.readLine();
							//recorro todas las lineas del archivo
							while(line != null){
								String [] datos;
								
								datos = line.split(" ");
								//pregunto si el codigo del medico coincide con el ingresado, entonces agrego a la array list el codigo del
								//paciente que aparece en esa linea
								if(codMedicoIngr.equals(datos[2])){
									codPacientes.add(Integer.parseInt(datos[1]));
								}
								
								line = bufInput.readLine();
							}

							bufInput.close();
							
							//ordenar ArrayList de codigos de los pacientes
							Collections.sort(codPacientes);
							
						} catch (Exception e2) {
							errorArchivoDiagnosticos = true;
							JOptionPane.showMessageDialog(rootPane, "Error al abrir el Archivo Diagnosticos.txt", "", JOptionPane.ERROR_MESSAGE, null);
						}
						
						
						if (!errorArchivoDiagnosticos) {
							
							try {
								//abro el archivo de pacientes para listar todos aquellos que coincidan con los codigos en el array list
								FileReader input = new FileReader("./src/Archivos\\Pacientes.txt");
								BufferedReader bufInput = new BufferedReader(input);
								
								String line;
								
								int i=0;
								
								line = bufInput.readLine();
								
								String lineaCombo=""; 
								//obtengo el primer codigo del paciente que se encuentra en el array list
								int codigoPacienteArrayList=codPacientes.get(i);
								
								while(line != null){
									String [] datos;
									
									datos = line.split(" ");
									//pregunto si el codigo es igual al codigo de la linea que se esta analizando
									if(codigoPacienteArrayList== Integer.parseInt(datos[0])){
										//si es igual procedo a armar el nombre del paciente que se encuentra guardado como: nombre-apellido
										//declaro un vec aux para guardas todos los nombres y apellidos que tiene el paciente
										String [] aux=datos[4].split("-");
										String nomb="";
										int j=0;
										//mediante el while concateno todos los nombres y apellidos en una sola variable: nomb
										while(j<aux.length){
											nomb+=aux[j]+" ";
											j++;
										}
										//genero la linea que contendra el combo box que esta compuesta por el codigo de paciente y el nombre y apellido
										lineaCombo=datos[0]+ " "+nomb;
										//agrego esa linea al combo box
										comboBox.addItem(lineaCombo);
										//incremento en uno el contador con el que me muevo en el array list
										// y lo voy a seguir incrementando hasta que sea distinto al codigo que ya inserte en el combo box
										while(i < codPacientes.size() - 1 && codigoPacienteArrayList==codPacientes.get(i)){
											i++;
										}
										//una vez que se cambio de codigo, se lo asigno de nuevo al codpaciente para compararlo con la siguiente linea
										codigoPacienteArrayList=codPacientes.get(i);
									}
									line = bufInput.readLine();
								}

								bufInput.close();
								
								JOptionPane.showMessageDialog(rootPane, "Pacientes cargados", "", JOptionPane.INFORMATION_MESSAGE, null);
								
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(rootPane, "Error al abrir el Archivo Pacientes.txt", "", JOptionPane.ERROR_MESSAGE, null);
								e2.printStackTrace();
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ningun Medico", "", JOptionPane.INFORMATION_MESSAGE, null);
					}
					
			}
		});
		btnSubmitir.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnSubmitir.setBackground(new Color(0, 128, 128));
		btnSubmitir.setBounds(230, 183, 115, 23);
		contentPane.add(btnSubmitir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 245, 414, 2);
		contentPane.add(separator);
		
		lblListaDePacientes = new JLabel("Lista De Pacientes");
		lblListaDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePacientes.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		lblListaDePacientes.setBackground(Color.WHITE);
		lblListaDePacientes.setBounds(63, 245, 319, 26);
		contentPane.add(lblListaDePacientes);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Vacio"}));
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(10, 282, 281, 20);
		contentPane.add(comboBox);
		
		btnVerPaciente = new JButton("Ver Datos");
		btnVerPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InterfazVerPaciente interfazVerPaciente = new InterfazVerPaciente();
				String codPaciente = (String)comboBox.getSelectedItem();
				if (!codPaciente.equals("Vacio")) {
					interfazVerPaciente.setearCodigoPaciente(codPaciente);
					if (interfazVerPaciente.llenarCampos()) {
						interfazVerPaciente.setVisible(true);
						InterfazPacientesPorMedico.this.dispose();
					}
				}
				else
					JOptionPane.showMessageDialog(rootPane, "No se ha seleccionado ningun Paciente", "", JOptionPane.INFORMATION_MESSAGE, null);
					
			}
		});
		btnVerPaciente.setBackground(new Color(0, 128, 128));
		btnVerPaciente.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		btnVerPaciente.setBounds(301, 280, 123, 23);
		contentPane.add(btnVerPaciente);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//vuelve a la ventana anterior que es informes
				//se genera una ventana de informes
				InterfazInformes iInformes=new InterfazInformes();
				//pongo visible la ventana
				iInformes.setVisible(true);
				//cierro la ventana del listado de  pacientes por medico
				InterfazPacientesPorMedico.this.dispose();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		btnVolver.setBackground(new Color(0, 128, 128));
		btnVolver.setBounds(171, 414, 138, 23);
		contentPane.add(btnVolver);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("./src/Source\\IntCentroMedico.png"));
		lblFondo.setBounds(0, 0, 434, 449);
		contentPane.add(lblFondo);
		
	}
}
