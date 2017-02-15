package gui;

import gui.dialog.DrzavaStandardForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import database.DBConnection;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame instance;

	public MainFrame(){
		
		setTitle("Poslovna vežbe");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setSize(900, 600);
		setLocationRelativeTo(null);
		
		initMenu();
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da zatvorite aplikaciju?", "Potvrda", JOptionPane.YES_NO_OPTION) 
						== JOptionPane.YES_OPTION){
						DBConnection.close();
						System.exit(0);
				}
				
			}
		});
	
	}
	
	private void initMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu orgSemaMenu = new JMenu("Org. šema");
		JMenuItem drzavaMI = new JMenuItem("Država");
		JMenuItem nasmestoMI = new JMenuItem("Naseljeno mesto");
		JMenuItem preduzeceMi = new JMenuItem("Preduzeće");
		JMenuItem poslovniPartnerMI = new JMenuItem("Poslovni partner");
		JMenuItem sektorMI = new JMenuItem("Sektor");
		JMenuItem sluzbaMI = new JMenuItem("Služba");
		
		orgSemaMenu.add(drzavaMI);
		orgSemaMenu.add(nasmestoMI);
		orgSemaMenu.add(preduzeceMi);
		orgSemaMenu.add(poslovniPartnerMI);
		orgSemaMenu.add(sektorMI);
		orgSemaMenu.add(sluzbaMI);
		menuBar.add(orgSemaMenu);
		
		//postavljamo menu bar
		//ne koristimo add(), nego setJMenuBar()
		setJMenuBar(menuBar);
		
		drzavaMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DrzavaStandardForm drzavaSF = new DrzavaStandardForm();
				drzavaSF.setVisible(true);
				
			}
		});
		
	}
	
	public static MainFrame getInstance(){
		if (instance == null)
			instance = new MainFrame();
		return instance;
	}

}
