package launcher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.event.ActionEvent;

public class Lanzador {

	private JFrame frame;
	private VentanaTest test;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					Lanzador window = new Lanzador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lanzador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Algoritmo de Calidad - Grupo 5");
		frame.getContentPane().setLayout(null);
		
		ImageIcon ImageIcon = new ImageIcon("resource/img/icono.png");
		Image image = ImageIcon.getImage();
		frame.setIconImage(image);
		
		JLabel lblBienvenidoAlTest = new JLabel("Bienvenido al Test de Calidad");
		lblBienvenidoAlTest.setForeground(new Color(0, 128, 128));
		lblBienvenidoAlTest.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblBienvenidoAlTest.setBounds(41, 41, 534, 113);
		frame.getContentPane().add(lblBienvenidoAlTest);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setForeground(new Color(0, 0, 0));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test = new VentanaTest();
				frame.setVisible(false);
			}
		});
		btnIniciar.setBackground(new Color(0, 128, 128));
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIniciar.setBounds(204, 218, 170, 61);
		frame.getContentPane().add(btnIniciar);
	}
}
