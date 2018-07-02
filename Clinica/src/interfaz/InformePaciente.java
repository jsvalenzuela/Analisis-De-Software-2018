package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.MedicoRepository;
import utilities.Log;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InformePaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table = new JTable();
	private MedicoRepository medicoRepo;

	/**
	 * Create the frame.
	 */
	public InformePaciente() {
		medicoRepo = new MedicoRepository();
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

		JLabel lblIngreseMatriculaDel = new JLabel("Ingrese Matricula del M\u00E9dico:");
		lblIngreseMatriculaDel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngreseMatriculaDel.setBounds(15, 82, 308, 31);
		contentPane.add(lblIngreseMatriculaDel);

		textField = new JTextField();
		textField.setBounds(15, 128, 318, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField.getText().isEmpty()) {
					if (medicoRepo.existeMedico(textField.getText())) {
						agregaDatosATabla(textField.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Matricula de Médico Incorrecto", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Matricula de Médico Vacio. Ingrese Matricula", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(408, 127, 115, 29);
		contentPane.add(btnBuscar);

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPacientes.setBounds(15, 196, 115, 31);
		contentPane.add(lblPacientes);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInformes menuInformes = new MenuInformes();
				setVisible(false);
			}
		});
		btnAtrs.setBounds(233, 512, 115, 36);
		contentPane.add(btnAtrs);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		table.setBounds(25, 246, 498, 228);
		contentPane.add(table);
	}

	private void agregaDatosATabla(String matricula) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String linea;

		try {
			fileReader = new FileReader(new File("file/situacionPacientes.txt"));
			bufferedReader = new BufferedReader(fileReader);
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Codigo Paciente");
			modelo.addColumn("Diagnostico");

			while ((linea = bufferedReader.readLine()) != null) {
				String[] datos = linea.split(" ");

				if (matricula.equals(datos[1])) {
					Object[] fila = new Object[2];
					fila[0] = datos[0];
					fila[1] = datos[2];

					modelo.addRow(fila);
				}
			}
			table.setModel(modelo);
		} catch (Exception e) {
			Log.getInstance().error(e.getMessage());
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				Log.getInstance().error(e.getMessage());
			}
		}
	}
}
