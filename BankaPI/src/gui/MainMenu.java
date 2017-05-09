package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.dialog.PregledRacuna;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JButton btnPregledRacuna = new JButton("Pregled racuna");
		btnPregledRacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PregledRacuna pregledRacunaDialog = new PregledRacuna();
				pregledRacunaDialog.setVisible(true);
				}
		});
		
		JButton btnNewButton = new JButton("Dugme dva");
		
		JButton btnRacuniPravnihLica = new JButton("Racuni pravnih lica");
		btnRacuniPravnihLica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RacuniPravnihLicaForm racuniPravnihLicaForm = new RacuniPravnihLicaForm();
				racuniPravnihLicaForm.setVisible(true);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRacuniPravnihLica, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnPregledRacuna, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(69)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(74))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPregledRacuna, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(78)
					.addComponent(btnRacuniPravnihLica, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
