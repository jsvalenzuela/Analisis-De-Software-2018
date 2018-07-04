package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.MedicoRepository;
import entidades.Medico;
import utilities.Log;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InformeMedico extends JFrame {

	private JPanel contentPane;
	private JList list = new JList();
	private MenuInformes menuInformes;
	private MedicoRepository medicoRepo;
	private JComboBox<Medico> comboMedicos;
	private JTextField textMedico;

	/**
	 * Create the frame.
	 */
	public InformeMedico(MenuInformes menu) {
		this.menuInformes = menu;
		medicoRepo = new MedicoRepository();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 620);
		setVisible(true);
		setTitle("Sistema de Control de Pacientes - Cl�nica Nuevo Espiritu");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInformeDeMdicos = new JLabel("Informe de M\u00E9dicos");
		lblInformeDeMdicos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInformeDeMdicos.setBounds(180, 16, 242, 31);
		contentPane.add(lblInformeDeMdicos);

		JLabel label = new JLabel("Seleccione el M\u00E9dico:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(43, 141, 175, 31);
		contentPane.add(label);

		comboMedicos = new JComboBox<Medico>();
		comboMedicos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboMedicos.setBounds(260, 143, 290, 26);
		contentPane.add(comboMedicos);
		filtrarMedico("");// Trae todos los médicos
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Realizar la búsqueda");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEspecialidades(obtenerCodigoMedico());
			}
		});
		btnBuscar.setBounds(435, 194, 115, 29);
		contentPane.add(btnBuscar);

		JLabel lblElMdicoTrata = new JLabel("El M\u00E9dico trata las siguientes enfermedades:");
		lblElMdicoTrata.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblElMdicoTrata.setBounds(42, 242, 411, 31);
		contentPane.add(lblElMdicoTrata);

		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuInformes.setVisible(true);
				setVisible(false);
			}
		});
		btnAtras.setBounds(435, 539, 115, 31);
		contentPane.add(btnAtras);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));

		list.setBounds(40, 289, 382, 229);
		contentPane.add(list);

		JLabel lblBusqueUnMdico = new JLabel("Busque un Médico:");
		lblBusqueUnMdico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBusqueUnMdico.setBounds(43, 95, 175, 31);
		contentPane.add(lblBusqueUnMdico);

		textMedico = new JTextField();
		textMedico.setToolTipText("Ingrese el nombre para filtrar listado");
		textMedico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMedico.setColumns(10);
		textMedico.setBounds(260, 97, 290, 26);
		contentPane.add(textMedico);

		textMedico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() == key.VK_ENTER)
					try {
						filtrarMedico(textMedico.getText());
					} catch (Exception e) {
						Log.getInstance().error(e.getMessage());
					}
			}
		});

		JButton btnFiltrar = new JButton("...");
		btnFiltrar.setToolTipText("Filtrar listado");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarMedico(textMedico.getText());
			}
		});
		btnFiltrar.setBounds(560, 95, 30, 30);
		contentPane.add(btnFiltrar);
	}

	private void agregarEspecialidades(String codMedico) {
		try {
			DefaultListModel<String> modelo = new DefaultListModel<>();
			ArrayList<Medico> medicos = (ArrayList<Medico>) medicoRepo.listadoMedicos("");
			for (Medico medico : medicos) {
				if (String.valueOf(medico.getCodigo()).equals(codMedico)) {
					modelo.addElement(medico.getEspecialidad());
				}
			}
			list.setModel(modelo);
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
