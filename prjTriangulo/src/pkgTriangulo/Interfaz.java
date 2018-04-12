package pkgTriangulo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLado1;
	private JTextField textLado2;
	private JTextField textLado3;
	private JLabel labelResultado;
	private boolean lado1ok = false, lado2ok = false, lado3ok = false;

	public static void main(String[] args) {
		Interfaz frame = new Interfaz();
		frame.setTitle("Triangulo");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textLado1 = new JTextField();
		textLado1.setBackground(new Color(255, 255, 255));
		textLado1.setBounds(236, 50, 127, 22);
		contentPane.add(textLado1);

		textLado2 = new JTextField();
		textLado2.setBounds(236, 125, 127, 22);
		contentPane.add(textLado2);

		textLado3 = new JTextField();
		textLado3.setBounds(236, 200, 127, 22);
		contentPane.add(textLado3);

		JLabel lblNewLabel = new JLabel("Valor del lado 1:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 50, 173, 20);
		contentPane.add(lblNewLabel);

		JLabel lblValorDelLado = new JLabel("Valor del lado 2:");
		lblValorDelLado.setForeground(Color.WHITE);
		lblValorDelLado.setFont(new Font("Arial", Font.PLAIN, 20));
		lblValorDelLado.setBounds(26, 125, 173, 20);
		contentPane.add(lblValorDelLado);

		JLabel lblValorDelLado_1 = new JLabel("Valor del lado 3:");
		lblValorDelLado_1.setForeground(Color.WHITE);
		lblValorDelLado_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblValorDelLado_1.setBounds(26, 200, 173, 20);
		contentPane.add(lblValorDelLado_1);

		labelResultado = new JLabel("");
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setForeground(Color.WHITE);
		labelResultado.setFont(new Font("Arial", Font.PLAIN, 26));
		labelResultado.setBounds(12, 235, 645, 76);
		contentPane.add(labelResultado);

		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton.setBounds(439, 111, 203, 45);
		contentPane.add(btnNewButton);

		// Listeners

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				lado1ok = validarEntrada(textLado1.getText());
				lado2ok = validarEntrada(textLado2.getText());
				lado3ok = validarEntrada(textLado3.getText());
				mostrarResultado();
			}
		});
	}

	public boolean validarEntrada(String cadena) {
		
		
		cadena = cadena.replace(',', '.');

		if (cadena.matches("\\d+(\\.\\d+)?") && Double.valueOf(cadena) != 0)
			return true;

		return false;
	}

	public void mostrarResultado() {
		double lado1, lado2, lado3;

		if (lado1ok && lado2ok && lado3ok) {
			lado1 = Double.valueOf(textLado1.getText().replace(',', '.'));
			lado2 = Double.valueOf(textLado2.getText().replace(',', '.'));
			lado3 = Double.valueOf(textLado3.getText().replace(',', '.'));

			// Es triangulo
			if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {

				labelResultado.setForeground(Color.GREEN);

				if (lado1 == lado2) {
					if (lado1 == lado3) {
						labelResultado.setText("Es un triangulo equilatero");						
					} else {
						labelResultado.setText("Es un triangulo isosceles");
					}
				} else if (lado1 == lado3 || lado2 == lado3) {
					labelResultado.setText("Es un triangulo isosceles");					
				} else {
					labelResultado.setText("Es un triangulo escaleno");
				}
			} 
			
			else {
				labelResultado.setForeground(Color.RED);
				labelResultado.setText("La suma de dos lados debe ser mayor al tercero");
			}
		} else {
			labelResultado.setForeground(Color.RED);
			labelResultado.setText("Error, alguno de los lados es nulo o menor que cero");			
		}
	}
}
