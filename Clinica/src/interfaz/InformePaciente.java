package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Desktop;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.DiagnosticoRepository;
import data.MedicoRepository;
import data.PacienteRepository;
import entidades.Diagnostico;
import entidades.Medico;
import utilities.Log;
import utilities.Utils;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InformePaciente extends JFrame {

	private JPanel contentPane;
	private JTable table = new JTable();
	private MedicoRepository medicoRepo;
	private JComboBox<Medico> comboMedicos;
	private MenuInformes menuInformes;
	private DiagnosticoRepository diagnosticoRepo;
	private PacienteRepository pacienteRepo;
	private JTextField textMedico;

	/**
	 * Create the frame.
	 * 
	 * @param menu
	 */
	public InformePaciente(MenuInformes menu) {
		this.menuInformes = menu;
		pacienteRepo = new PacienteRepository();
		medicoRepo = new MedicoRepository();
		diagnosticoRepo = new DiagnosticoRepository();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 620);
		setVisible(true);
		setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInformeDePacientes = new JLabel("Informe de Pacientes");
		lblInformeDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInformeDePacientes.setBounds(181, 16, 242, 31);
		contentPane.add(lblInformeDePacientes);

		JLabel lblIngreseMatriculaDel = new JLabel("Seleccione el M\u00E9dico:");
		lblIngreseMatriculaDel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngreseMatriculaDel.setBounds(10, 124, 207, 31);
		contentPane.add(lblIngreseMatriculaDel);

		comboMedicos = new JComboBox<Medico>();
		comboMedicos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboMedicos.setBounds(233, 126, 290, 26);
		contentPane.add(comboMedicos);
		filtrarMedico("");// Trae todos los medicos

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Realizar b\u00FAsqueda");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codMedico = obtenerCodigoMedico();
				agregaDatosATabla(codMedico);
			}
		});
		btnBuscar.setBounds(408, 181, 115, 29);
		contentPane.add(btnBuscar);

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPacientes.setBounds(25, 229, 115, 31);
		contentPane.add(lblPacientes);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInformes.setVisible(true);
				setVisible(false);
			}
		});
		btnAtrs.setBounds(234, 534, 115, 36);
		contentPane.add(btnAtrs);

		JButton button = new JButton("...");
		button.setToolTipText("Filtrar listado");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarMedico(textMedico.getText());
			}
		});
		button.setBounds(527, 71, 30, 30);
		contentPane.add(button);

		textMedico = new JTextField();
		textMedico.setToolTipText("Ingrese el nombre para filtrar listado");
		textMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMedico.setColumns(10);
		textMedico.setBounds(233, 73, 284, 26);
		contentPane.add(textMedico);

		textMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					try {
						filtrarMedico(textMedico.getText());
					} catch (Exception e) {
						Log.getInstance().error("Error al validar contrasena " + e.getMessage());
					}
			}
		});

		JLabel label = new JLabel("Busque un Médico:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(10, 71, 175, 31);
		contentPane.add(label);

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(26, 294, 491, 197);
	    contentPane.add(scrollPane);
	    scrollPane.setViewportView(table);
	    
		JButton btnAyuda = new JButton("?");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(Utils.obtenerUrlAyuda());
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e) {
					Log.getInstance().error(e.getMessage());
				}
			}
		});
		btnAyuda.setBounds(581, 0, 43, 23);
		this.getContentPane().add(btnAyuda);
	
	}

	private void agregaDatosATabla(String codMedico) {

		try {
			DefaultTableModel modelo = new DefaultTableModel();

			modelo.addColumn("Paciente");
			modelo.addColumn("Diagnostico");
			ArrayList<Diagnostico> diagnosticos = (ArrayList<Diagnostico>) diagnosticoRepo
					.listadoDiagnosticoMedico(codMedico);
			for (Diagnostico diagnostico : diagnosticos) {
				Object[] fila = new Object[2];
				fila[0] = pacienteRepo.obtenerNombrePaciente(diagnostico.getIdPaciente());
				fila[1] = diagnostico.getDiagnostico();
				modelo.addRow(fila);
			}
			table.setModel(modelo);
		} catch (Exception e) {
			Log.getInstance().error(e.getMessage());
		}
	}

	private String obtenerCodigoMedico() {
		Medico m = (Medico) comboMedicos.getSelectedItem();
		return String.valueOf(m.getCodigo());
	}

	private void filtrarMedico(String filtro) {
		comboMedicos
				.setModel(new DefaultComboBoxModel<Medico>(medicoRepo.listadoMedicos(filtro).toArray(new Medico[0])));
	}
}
