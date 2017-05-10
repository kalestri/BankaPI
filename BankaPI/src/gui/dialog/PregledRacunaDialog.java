package gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class PregledRacunaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable prTable;
	private JButton dodajPRbutton;
	private JButton izmeniPRbutton;
	private JButton obrisiPRbutton;
	private JButton sacuvajPRbutton;
	private JButton nazadPRbutton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PregledRacunaDialog dialog = new PregledRacunaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PregledRacunaDialog() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			prTable = new JTable();
			
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addComponent(prTable, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(prTable, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				dodajPRbutton = new JButton("Dodaj");
			}
			{
				izmeniPRbutton = new JButton("Izmeni");
				izmeniPRbutton.setEnabled(false);
			}
			{
				obrisiPRbutton = new JButton("Ukloni");
			}
			{
				sacuvajPRbutton = new JButton("Sacuvaj");
				sacuvajPRbutton.setActionCommand("OK");
				getRootPane().setDefaultButton(sacuvajPRbutton);
			}
			{
				nazadPRbutton = new JButton("Nazad");
				nazadPRbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				nazadPRbutton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(dodajPRbutton)
						.addGap(18)
						.addComponent(izmeniPRbutton)
						.addGap(18)
						.addComponent(obrisiPRbutton)
						.addPreferredGap(ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
						.addComponent(sacuvajPRbutton)
						.addGap(5)
						.addComponent(nazadPRbutton)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addComponent(sacuvajPRbutton)
							.addComponent(nazadPRbutton)
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(dodajPRbutton)
								.addComponent(izmeniPRbutton)
								.addComponent(obrisiPRbutton)))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
}
