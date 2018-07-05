package launcher;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import algoritmo.Puntaje;

import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaTest {

	private JFrame frame;
	private JPanel panelPrincipal;
	private JPanel panelUno;
	private JPanel panelDos;
	private JPanel panelTres;
	private JProgressBar progressBar;
	private Puntaje puntaje;
	
	private ButtonGroup grupoComplejidad;
	private ButtonGroup grupoComentarios;
	private ButtonGroup grupoUtilizacionRec;
	private ButtonGroup grupoComportamiento;
	private ButtonGroup grupoInstabilidad;
	private ButtonGroup grupoOperado;
	
	private JComboBox<String> cbxRecuperacion;
	private JComboBox<String> cbxToleranciaFallos;
	private JComboBox<String> cbxSeguridad;
	private JComboBox<String> cbxExactitud;

	public VentanaTest() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 1024, 960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Algoritmo de Calidad - Grupo 5");
		
		ImageIcon ImageIcon = new ImageIcon("resource/img/icono.png");
		Image image = ImageIcon.getImage();
		frame.setIconImage(image);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1000, 840);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		
		panelUno = new JPanel();
		panelUno.setBackground(new Color(245, 255, 250));
		panelUno.setLayout(null);
		panelPrincipal.add(panelUno);
		
		panelDos = new JPanel();
		panelDos.setBackground(new Color(245, 255, 250));
		panelDos.setLayout(null);
		panelPrincipal.add(panelDos);
		
		panelTres = new JPanel();
		panelTres.setBackground(new Color(245, 255, 250));
		panelTres.setLayout(null);
		panelPrincipal.add(panelTres);
		
		puntaje = new Puntaje();
		
		JLabel lblUsabilidad = new JLabel("Usabilidad");
		lblUsabilidad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUsabilidad.setBounds(15, 16, 153, 25);
		panelTres.add(lblUsabilidad);
		
		JLabel lblCapacidadDeSer = new JLabel("Capacidad de ser atendido");
		lblCapacidadDeSer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapacidadDeSer.setBounds(15, 55, 341, 30);
		panelTres.add(lblCapacidadDeSer);
		
		JLabel lblSeleccioneCualDe = new JLabel("Seleccione cual de las caracteristicas tiene el sistema:");
		lblSeleccioneCualDe.setBounds(15, 101, 386, 20);
		panelTres.add(lblSeleccioneCualDe);
		
		JRadioButton rdbtnMenuContextual = new JRadioButton("Ayuda contextual sobre men\u00FAs y botones de acci\u00F3n.");
		rdbtnMenuContextual.setBackground(new Color(245, 255, 250));
		rdbtnMenuContextual.setBounds(15, 133, 401, 29);
		panelTres.add(rdbtnMenuContextual);
		
		JRadioButton rdbtnManualDeUsuario = new JRadioButton("Manual de usuario incorporado al sistema como un men\u00FA.");
		rdbtnManualDeUsuario.setBackground(new Color(245, 255, 250));
		rdbtnManualDeUsuario.setBounds(15, 170, 443, 29);
		panelTres.add(rdbtnManualDeUsuario);
		
		JLabel lblCapacidadDeSer_1 = new JLabel("Capacidad de ser atractivo");
		lblCapacidadDeSer_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapacidadDeSer_1.setBounds(508, 55, 341, 30);
		panelTres.add(lblCapacidadDeSer_1);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el n\u00FAmero promedio de pasos para alcanzar una funci\u00F3n");
		lblNewLabel_1.setBounds(508, 101, 477, 20);
		panelTres.add(lblNewLabel_1);
		
		JComboBox cbxCapacidadAtrctivo = new JComboBox();
		cbxCapacidadAtrctivo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxCapacidadAtrctivo.setBackground(new Color(245, 255, 250));
		cbxCapacidadAtrctivo.setModel(new DefaultComboBoxModel(new String[] {"Seis o m\u00E1s pasos promedio", "Entre 3 y 5 pasos promedio ", "1 o 2 pasos promedio "}));
		cbxCapacidadAtrctivo.setBounds(578, 151, 271, 26);
		panelTres.add(cbxCapacidadAtrctivo);
		
		JLabel lblCapacidadDeSer_2 = new JLabel("Capacidad de ser operado");
		lblCapacidadDeSer_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapacidadDeSer_2.setBounds(364, 230, 217, 30);
		panelTres.add(lblCapacidadDeSer_2);
		
		JLabel lblElUsuario = new JLabel("El usuario...");
		lblElUsuario.setBounds(429, 277, 98, 20);
		panelTres.add(lblElUsuario);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("...requiere consultar a personal especializado para operar el producto.");
		rdbtnNewRadioButton_2.setBackground(new Color(245, 255, 250));
		rdbtnNewRadioButton_2.setBounds(247, 312, 565, 29);
		panelTres.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnrequiereAyudaContextual = new JRadioButton("...requiere ayuda contextual y manual de uso para operar el producto.");
		rdbtnrequiereAyudaContextual.setBackground(new Color(245, 255, 250));
		rdbtnrequiereAyudaContextual.setBounds(247, 349, 565, 29);
		panelTres.add(rdbtnrequiereAyudaContextual);
		
		JRadioButton rdbtnoperaElProducto = new JRadioButton("...opera el producto software sin asistencia.");
		rdbtnoperaElProducto.setBackground(new Color(245, 255, 250));
		rdbtnoperaElProducto.setBounds(247, 386, 565, 29);
		panelTres.add(rdbtnoperaElProducto);
		
		grupoOperado = new ButtonGroup();
		grupoOperado.add(rdbtnNewRadioButton_2);
		grupoOperado.add(rdbtnrequiereAyudaContextual);
		grupoOperado.add(rdbtnoperaElProducto);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(15, 438, 970, 20);
		panelTres.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(15, 528, 970, 25);
		panelTres.add(separator_4);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultado.setBounds(25, 545, 143, 25);
		panelTres.add(lblResultado);
		
		JLabel lblResultado_1 = new JLabel("");
		lblResultado_1.setForeground(Color.BLUE);
		lblResultado_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblResultado_1.setBounds(15, 584, 970, 158);
		panelTres.add(lblResultado_1);
		
		JLabel label_2 = new JLabel("Mantenibilidad");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBounds(15, 16, 153, 25);
		panelDos.add(label_2);
		
		JLabel label_3 = new JLabel("Capacidad del c\u00F3digo de ser analizado");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(15, 56, 341, 30);
		panelDos.add(label_3);
		
		JLabel label_4 = new JLabel("Analize y calcule el porcentaje de comentarios que posee");
		label_4.setBounds(15, 104, 427, 25);
		panelDos.add(label_4);
		
		JLabel label_5 = new JLabel("el c\u00F3digo por cada m\u00E9todo y en general. Seleccione.");
		label_5.setBounds(36, 130, 383, 25);
		panelDos.add(label_5);
		
		JRadioButton rbtnComentario_1 = new JRadioButton("14% o menos del c\u00F3digo comentado.");
		rbtnComentario_1.setBackground(new Color(245, 255, 250));
		rbtnComentario_1.setBounds(31, 167, 326, 29);
		panelDos.add(rbtnComentario_1);
		
		JRadioButton rbtnComentario_2 = new JRadioButton("Entre 15 y 29% del c\u00F3digo comentado.");
		rbtnComentario_2.setBackground(new Color(245, 255, 250));
		rbtnComentario_2.setBounds(31, 204, 326, 29);
		panelDos.add(rbtnComentario_2);
		
		JRadioButton rbtnComentario_3 = new JRadioButton("30% o m\u00E1s del c\u00F3digo comentado.");
		rbtnComentario_3.setBackground(new Color(245, 255, 250));
		rbtnComentario_3.setBounds(31, 241, 306, 29);
		panelDos.add(rbtnComentario_3);
		
		grupoComentarios = new ButtonGroup();
		grupoComentarios.add(rbtnComentario_1);
		grupoComentarios.add(rbtnComentario_2);
		grupoComentarios.add(rbtnComentario_3);
		
		JLabel label_6 = new JLabel("Capacidad del c\u00F3digo de ser cambiado");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_6.setBounds(560, 56, 341, 30);
		panelDos.add(label_6);
		
		JLabel label_7 = new JLabel("Calcule la complejidad ciclom\u00E1tica del m\u00E9todo");
		label_7.setBounds(570, 104, 351, 25);
		panelDos.add(label_7);
		
		JLabel label_8 = new JLabel("y seleccione la opci\u00F3n seg\u00FAn el resultado");
		label_8.setBounds(595, 130, 326, 25);
		panelDos.add(label_8);
		
		JRadioButton rbtnComplejidad_1 = new JRadioButton("La complejidad ciclom\u00E1tica es mayor o igual a 21.");
		rbtnComplejidad_1.setBackground(new Color(245, 255, 250));
		rbtnComplejidad_1.setBounds(560, 167, 400, 29);
		panelDos.add(rbtnComplejidad_1);
		
		JRadioButton rbtnComplejidad_2 = new JRadioButton("La complejidad ciclom\u00E1tica est\u00E1 entre 10 y 21.");
		rbtnComplejidad_2.setBackground(new Color(245, 255, 250));
		rbtnComplejidad_2.setBounds(560, 204, 383, 29);
		panelDos.add(rbtnComplejidad_2);
		
		JRadioButton rbtnComplejidad_3 = new JRadioButton("La complejidad ciclomatica es menor a 10");
		rbtnComplejidad_3.setBackground(new Color(245, 255, 250));
		rbtnComplejidad_3.setBounds(560, 241, 383, 29);
		panelDos.add(rbtnComplejidad_3);
		
		grupoComplejidad = new ButtonGroup();
		grupoComplejidad.add(rbtnComplejidad_1);
		grupoComplejidad.add(rbtnComplejidad_2);
		grupoComplejidad.add(rbtnComplejidad_3);
		
		JLabel lblEstabilidad = new JLabel("Estabilidad");
		lblEstabilidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstabilidad.setBounds(383, 296, 106, 30);
		panelDos.add(lblEstabilidad);
		
		JLabel lblRealizeUnaPrueba = new JLabel("Realize una prueba y evalue el promedio de fallas. Seleccione:");
		lblRealizeUnaPrueba.setBounds(216, 330, 455, 25);
		panelDos.add(lblRealizeUnaPrueba);
		
		JComboBox cbxEstabilidad = new JComboBox();
		cbxEstabilidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxEstabilidad.setBackground(new Color(245, 255, 250));
		cbxEstabilidad.setModel(new DefaultComboBoxModel(new String[] {"El software presenta 10 o m\u00E1s errores por prueba.", "El software presenta entre 5 y 9 errores por prueba.", "El software presenta menos de 5 por prueba."}));
		cbxEstabilidad.setBounds(248, 371, 383, 26);
		panelDos.add(cbxEstabilidad);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 413, 970, 15);
		panelDos.add(separator_2);
		
		JLabel lblPortabilidad = new JLabel("Portabilidad");
		lblPortabilidad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPortabilidad.setBounds(15, 444, 153, 25);
		panelDos.add(lblPortabilidad);
		
		JLabel lblAdaptabilidad = new JLabel("Adaptabilidad");
		lblAdaptabilidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdaptabilidad.setBounds(15, 484, 341, 30);
		panelDos.add(lblAdaptabilidad);
		
		JLabel lblconCuantosSistemas = new JLabel("\u00BFCon cuantos Sistemas Operativos es compatible el sistema?");
		lblconCuantosSistemas.setBounds(15, 532, 435, 25);
		panelDos.add(lblconCuantosSistemas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(new Color(245, 255, 250));
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(102, 573, 39, 35);
		panelDos.add(spinner);
		
		JLabel lblSistemas = new JLabel("Sistemas");
		lblSistemas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSistemas.setBounds(166, 576, 88, 32);
		panelDos.add(lblSistemas);
		
		JLabel lblInstabilidad = new JLabel("Instalabilidad");
		lblInstabilidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInstabilidad.setBounds(560, 484, 341, 30);
		panelDos.add(lblInstabilidad);
		
		JLabel lblenCuantosPasos = new JLabel("\u00BFEn cuantos pasos pudo instalar el sistema?");
		lblenCuantosPasos.setBounds(560, 534, 435, 25);
		panelDos.add(lblenCuantosPasos);
		
		JRadioButton rdbtnEntreDiezY = new JRadioButton("Entre diez y siete pasos");
		rdbtnEntreDiezY.setBackground(new Color(245, 255, 250));
		rdbtnEntreDiezY.setBounds(570, 576, 197, 29);
		panelDos.add(rdbtnEntreDiezY);
		
		JRadioButton rdbtnSeisYTres = new JRadioButton("Entre seis y tres pasos");
		rdbtnSeisYTres.setBackground(new Color(245, 255, 250));
		rdbtnSeisYTres.setBounds(570, 612, 197, 29);
		panelDos.add(rdbtnSeisYTres);
		
		JRadioButton rdbtnUnoODos = new JRadioButton("Uno o dos pasos");
		rdbtnUnoODos.setBackground(new Color(245, 255, 250));
		rdbtnUnoODos.setBounds(570, 649, 155, 29);
		panelDos.add(rdbtnUnoODos);
		
		grupoInstabilidad = new ButtonGroup();
		grupoInstabilidad.add(rdbtnEntreDiezY);
		grupoInstabilidad.add(rdbtnSeisYTres);
		grupoInstabilidad.add(rdbtnUnoODos);
		
		JButton btnSiguiente_1 = new JButton("Siguiente");
		btnSiguiente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (panelPrincipal.getLayout());
				Integer valorCapacidadCodigo = -1;
				Integer valorComplejidad = -1;
				Integer valorEstabilidad = -1;
				Integer valorInstabilidad = -1;
				
				if(rbtnComentario_1.isSelected()) {
					valorCapacidadCodigo = new Integer(0);
				} else {
					if(rbtnComentario_2.isSelected()) {
						valorCapacidadCodigo = new Integer(1);
					} else {
						if(rbtnComentario_3.isSelected()) {
							valorCapacidadCodigo = new Integer(2);
						} else {
							JOptionPane.showMessageDialog(null, "Elija una opción en Mantenibilidad", "Error", JOptionPane.ERROR_MESSAGE);
						}	
					}
				}
				
				if(rbtnComplejidad_1.isSelected()) {
					valorComplejidad = new Integer(0);
				} else {
					if(rbtnComplejidad_2.isSelected()) {
						valorComplejidad = new Integer(1);
					} else {
						if(rbtnComplejidad_3.isSelected()) {
							valorComplejidad = new Integer(2);
						} else {
							JOptionPane.showMessageDialog(null, "Elija una opción en Mantenibilidad", "Error", JOptionPane.ERROR_MESSAGE);
						}	
					}
				}
				
				valorEstabilidad = cbxEstabilidad.getSelectedIndex();
				Integer valorAdaptabilidad = Integer.valueOf(spinner.getValue().toString());
				
				if(rdbtnEntreDiezY.isSelected()) {
					valorInstabilidad = new Integer(0);
				} else {
					if(rdbtnSeisYTres.isSelected()) {
						valorInstabilidad = new Integer(1);
					} else {
						if(rdbtnUnoODos.isSelected()) {
							valorInstabilidad = new Integer(2);
						} else {
							JOptionPane.showMessageDialog(null, "Elija una opción en Instabilidad", "Error", JOptionPane.ERROR_MESSAGE);
						}	
					}
				}
				
				
				if(!valorCapacidadCodigo.equals(new Integer(-1)) && !valorComplejidad.equals(new Integer(-1)) && !valorInstabilidad.equals(new Integer(-1))) {
					puntaje.calcularPuntajeMantenibilidad(valorCapacidadCodigo, valorComplejidad, valorEstabilidad);
					puntaje.calcularPuntajePortabilidad(valorAdaptabilidad, valorInstabilidad);
					
					cl.next(panelPrincipal);
					progressBar.setValue(66);
				}
			}
		});
		btnSiguiente_1.setBounds(437, 783, 115, 41);
		panelDos.add(btnSiguiente_1);
		
		JLabel lblSeguridad = new JLabel("Funcionalidad");
		lblSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSeguridad.setBounds(15, 16, 153, 25);
		panelUno.add(lblSeguridad);
		
		JLabel lblSeguridadDeAcceso = new JLabel("Seguridad de acceso");
		lblSeguridadDeAcceso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeguridadDeAcceso.setBounds(15, 57, 184, 30);
		panelUno.add(lblSeguridadDeAcceso);
		
		JLabel lblElSoftwareCumple = new JLabel("\u00BFEl sistema cumple con las siguientes caracteristicas?");
		lblElSoftwareCumple.setBounds(15, 103, 383, 20);
		panelUno.add(lblElSoftwareCumple);
		
		JLabel lblNewLabel = new JLabel(".Encriptaci\u00F3n de datos\r\n");
		lblNewLabel.setBounds(15, 139, 168, 20);
		panelUno.add(lblNewLabel);
		
		JLabel lblInicioDeSesin = new JLabel(".Inicio de sesi\u00F3n de usuarios\r\n");
		lblInicioDeSesin.setBounds(207, 139, 207, 20);
		panelUno.add(lblInicioDeSesin);
		
		cbxSeguridad = new JComboBox();
		cbxSeguridad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxSeguridad.setBackground(new Color(245, 255, 250));
		cbxSeguridad.setModel(new DefaultComboBoxModel(new String[] {"No cumple con alguna caracter\u00EDstica.", "Cumple con 1 caracter\u00EDstica.", "Cumple con 2 caracter\u00EDsticas."}));
		cbxSeguridad.setBounds(67, 175, 289, 26);
		panelUno.add(cbxSeguridad);
		
		JLabel lblExactitudDeLos = new JLabel("Exactitud de los resultados");
		lblExactitudDeLos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExactitudDeLos.setBounds(560, 57, 227, 30);
		panelUno.add(lblExactitudDeLos);
		
		JLabel lblqueGradoDe = new JLabel("Indique el orden de presici\u00F3n del sistema en sus resultados");
		lblqueGradoDe.setBounds(560, 103, 427, 20);
		panelUno.add(lblqueGradoDe);
		
		cbxExactitud = new JComboBox();
		cbxExactitud.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxExactitud.setBackground(new Color(245, 255, 250));
		cbxExactitud.setModel(new DefaultComboBoxModel(new String[] {"10-3 o Superior", "Entre 10-4 y 10-6", "10-7 o Inferior"}));
		cbxExactitud.setBounds(674, 175, 212, 26);
		panelUno.add(cbxExactitud);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 217, 972, 9);
		panelUno.add(separator);
		
		JLabel lblFiabilidad = new JLabel("Fiabilidad");
		lblFiabilidad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFiabilidad.setBounds(15, 242, 153, 25);
		panelUno.add(lblFiabilidad);
		
		JLabel lblToleranciaAFallos = new JLabel("Tolerancia a fallos");
		lblToleranciaAFallos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblToleranciaAFallos.setBounds(15, 280, 184, 30);
		panelUno.add(lblToleranciaAFallos);
		
		JLabel label = new JLabel("\u00BFEl sistema cumple con las siguientes caracteristicas?");
		label.setBounds(15, 326, 383, 20);
		panelUno.add(label);
		
		JLabel lblOCuandoSucede = new JLabel(".Cuando sucede un error se protegen los datos procesados.");
		lblOCuandoSucede.setBounds(15, 362, 427, 20);
		panelUno.add(lblOCuandoSucede);
		
		JLabel lblOSeRealiza = new JLabel(".Se realiza un log de actividades que el sistema estaba haciendo.");
		lblOSeRealiza.setBounds(15, 387, 457, 20);
		panelUno.add(lblOSeRealiza);
		
		JLabel lblOMuestraPor = new JLabel(".Muestra por pantalla el mensaje de error");
		lblOMuestraPor.setBounds(15, 414, 457, 20);
		panelUno.add(lblOMuestraPor);
		
		cbxToleranciaFallos = new JComboBox();
		cbxToleranciaFallos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxToleranciaFallos.setBackground(new Color(245, 255, 250));
		cbxToleranciaFallos.setModel(new DefaultComboBoxModel(new String[] {"No cumple con ninguna caracter\u00EDstica ", "Cumple con una caracter\u00EDstica", "Cumple con dos caracter\u00EDsticas", "Cumple con las tres caracter\u00EDsticas"}));
		cbxToleranciaFallos.setBounds(57, 450, 299, 26);
		panelUno.add(cbxToleranciaFallos);
		
		JLabel lblCapacidadDeRecuperacin = new JLabel("Capacidad de recuperaci\u00F3n de errores");
		lblCapacidadDeRecuperacin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapacidadDeRecuperacin.setBounds(560, 286, 326, 20);
		panelUno.add(lblCapacidadDeRecuperacin);
		
		JLabel label_1 = new JLabel("\u00BFEl sistema cumple con las siguientes caracteristicas?");
		label_1.setBounds(560, 326, 383, 20);
		panelUno.add(label_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 492, 972, 9);
		panelUno.add(separator_1);
		
		JRadioButton rdbtnMsDe = new JRadioButton("M\u00E1s de 5");
		rdbtnMsDe.setBackground(new Color(245, 255, 250));
		rdbtnMsDe.setBounds(632, 661, 155, 29);
		panelUno.add(rdbtnMsDe);
		
		JRadioButton rdbtnEntreY = new JRadioButton("Entre 2 y 4");
		rdbtnEntreY.setBackground(new Color(245, 255, 250));
		rdbtnEntreY.setBounds(632, 698, 155, 29);
		panelUno.add(rdbtnEntreY);
		
		JRadioButton rdbtnMenosDe = new JRadioButton("Menos de 1");
		rdbtnMenosDe.setBackground(new Color(245, 255, 250));
		rdbtnMenosDe.setBounds(632, 735, 155, 29);
		panelUno.add(rdbtnMenosDe);
		
		grupoComportamiento = new ButtonGroup();
		grupoComportamiento.add(rdbtnMsDe);
		grupoComportamiento.add(rdbtnEntreY);
		grupoComportamiento.add(rdbtnMenosDe);
		
		JRadioButton rdbtnRecursosUno = new JRadioButton("41% o m\u00E1s de uso de procesador");
		rdbtnRecursosUno.setBackground(new Color(245, 255, 250));
		rdbtnRecursosUno.setBounds(67, 636, 289, 29);
		panelUno.add(rdbtnRecursosUno);
		
		JRadioButton rdbtnRecursosDos = new JRadioButton("11% a 40% de uso de procesador");
		rdbtnRecursosDos.setBackground(new Color(245, 255, 250));
		rdbtnRecursosDos.setBounds(67, 673, 289, 29);
		panelUno.add(rdbtnRecursosDos);
		
		JRadioButton rdbtnRecursosTres = new JRadioButton("10% o menos de uso de procesador");
		rdbtnRecursosTres.setBackground(new Color(245, 255, 250));
		rdbtnRecursosTres.setBounds(67, 711, 289, 29);
		panelUno.add(rdbtnRecursosTres);
		
		grupoUtilizacionRec = new ButtonGroup();
		grupoUtilizacionRec.add(rdbtnRecursosUno);
		grupoUtilizacionRec.add(rdbtnRecursosDos);
		grupoUtilizacionRec.add(rdbtnRecursosTres);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (panelPrincipal.getLayout());
				Integer valorSeguridad = cbxSeguridad.getSelectedIndex();
				Integer valorExactitud = cbxExactitud.getSelectedIndex();
				Integer valorTolerancia = cbxToleranciaFallos.getSelectedIndex();
				Integer valorRecuperacion = cbxRecuperacion.getSelectedIndex();
				Integer valorRecursos = -1;
				Integer valorComportamiento = -1;
				
				if(rdbtnRecursosUno.isSelected()) {
					valorRecursos = new Integer(0);
				} else {
					if(rdbtnRecursosDos.isSelected()) {
						valorRecursos = new Integer(1);
					} else {
						if(rdbtnRecursosTres.isSelected()) {
							valorRecursos = new Integer(2);
						} else {
							JOptionPane.showMessageDialog(null, "Elija una opción en Utilización de Recursos", "Error", JOptionPane.ERROR_MESSAGE);
						}
							
					}
				}
				
				if(rdbtnMsDe.isSelected()) {
					valorComportamiento = new Integer(0);
				} else {
					if(rdbtnEntreY.isSelected()) {
						valorComportamiento = new Integer(1);
					} else {
						if(rdbtnMenosDe.isSelected()) {
							valorComportamiento = new Integer(2);
						} else {
							JOptionPane.showMessageDialog(null, "Elija una opción en Comportamiento", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				puntaje.calcularPuntajeFuncionabilidad(valorSeguridad, valorExactitud);
				puntaje.calcularPuntajeFiabilidad(valorTolerancia, valorRecuperacion);
				
				if(!valorRecursos.equals(new Integer(-1)) && !valorComportamiento.equals(new Integer(-1))) {
					puntaje.calcularPuntajeEficiencia(valorRecursos, valorComportamiento);
					cl.next(panelPrincipal);
					progressBar.setValue(33);
				}
			}
		});
		btnSiguiente.setBounds(428, 791, 115, 40);
		panelUno.add(btnSiguiente);
		
		JLabel lblelSistemaReanuda = new JLabel(".El sistema reanuda las actividades si se produce una falla");
		lblelSistemaReanuda.setBounds(560, 362, 427, 20);
		panelUno.add(lblelSistemaReanuda);
		
		JLabel lblreanudaSusActividades = new JLabel(".Reanuda sus actividades y vuelve al estado en que estaba");
		lblreanudaSusActividades.setBounds(560, 387, 427, 20);
		panelUno.add(lblreanudaSusActividades);
		
		cbxRecuperacion = new JComboBox();
		cbxRecuperacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxRecuperacion.setBackground(new Color(245, 255, 250));
		cbxRecuperacion.setModel(new DefaultComboBoxModel(new String[] {"No cumple con ninguna caracter\u00EDstica", "Cumple con una o dos caracter\u00EDsticas", "Cumple con las tres caracter\u00EDsticas"}));
		cbxRecuperacion.setBounds(608, 450, 299, 26);
		panelUno.add(cbxRecuperacion);
		
		JLabel lblEficiencia = new JLabel("Eficiencia");
		lblEficiencia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEficiencia.setBounds(15, 517, 153, 25);
		panelUno.add(lblEficiencia);
		
		JLabel lblUtilizacinDeRecursos = new JLabel("Utilizaci\u00F3n de recursos");
		lblUtilizacinDeRecursos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilizacinDeRecursos.setBounds(15, 558, 184, 30);
		panelUno.add(lblUtilizacinDeRecursos);
		
		JLabel lblPorcentajeDeUso = new JLabel("\u00BFCual es el porcentaje de uso de procesador del sistema?");
		lblPorcentajeDeUso.setBounds(15, 604, 457, 20);
		panelUno.add(lblPorcentajeDeUso);
		
		JLabel lblComportamientoFrenteAl = new JLabel("Comportamiento frente al tiempo");
		lblComportamientoFrenteAl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComportamientoFrenteAl.setBounds(560, 564, 326, 30);
		panelUno.add(lblComportamientoFrenteAl);
		
		JLabel lblcuantosSegundoEl = new JLabel("\u00BFCuantos segundos esta el sistema no informar ");
		lblcuantosSegundoEl.setBounds(560, 604, 425, 20);
		panelUno.add(lblcuantosSegundoEl);
		
		JLabel lblElEstadoDe = new JLabel("el estado de la solicitud hecha por el usuario?");
		lblElEstadoDe.setBounds(566, 629, 341, 20);
		panelUno.add(lblElEstadoDe);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer valorCapacidadAtendido = 0;
				Integer valorOperado = -1;
				
				if(rdbtnMenuContextual.isSelected()) {
					valorCapacidadAtendido = Integer.sum(valorCapacidadAtendido.intValue(), 1);
				}
				
				if(rdbtnManualDeUsuario.isSelected()) {
					valorCapacidadAtendido = Integer.sum(valorCapacidadAtendido.intValue(), 1);
				}
				
				Integer valorAtractivo = cbxCapacidadAtrctivo.getSelectedIndex();
				
				if(rdbtnNewRadioButton_2.isSelected()) {
					valorOperado = new Integer(0);
				} else {
					if(rdbtnrequiereAyudaContextual.isSelected()) {
						valorOperado = new Integer(1);
					} else {
						if(rdbtnoperaElProducto.isSelected()) {
							valorOperado = new Integer(2);
						} else {
							JOptionPane.showMessageDialog(null, "Elija una opción en Comportamiento", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				if(!valorOperado.equals(new Integer(-1))) {
					puntaje.calcularPuntajeUsabilidad(valorCapacidadAtendido, valorOperado, valorAtractivo);
					progressBar.setValue(100);
					
					if(puntaje.getAlgoritmo().calcularResultadoFinal().equals(new Integer(1))) {
						lblResultado_1.setText("Satisfactorio");
						lblResultado_1.setForeground(Color.GREEN);
					}	
					
					if(puntaje.getAlgoritmo().calcularResultadoFinal().equals(new Integer(2))) {
						lblResultado_1.setText("Aceptable");
						lblResultado_1.setForeground(Color.BLUE);
					}
					
					if(puntaje.getAlgoritmo().calcularResultadoFinal().equals(new Integer(3))) {
						lblResultado_1.setText("No Satisfactorio");
						lblResultado_1.setForeground(Color.RED);
					}
				}
			}
		});
		btnCalcular.setBounds(439, 458, 115, 42);
		panelTres.add(btnCalcular);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(15, 856, 972, 32);
		frame.getContentPane().add(progressBar);
		progressBar.setStringPainted(true);
		
		
	}
}
