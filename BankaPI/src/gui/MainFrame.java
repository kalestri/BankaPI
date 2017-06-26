package gui;

import gui.dialog.PregledRacunaDialog;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import database.DBConnection;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame instance;
	
	private static SessionFactory factory;
	public static void main(String[] args) {
		try{
			System.out.print("Dodatoo");
			factory = new AnnotationConfiguration().
					configure().addPackage("model").
				buildSessionFactory();
		}catch(Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame(){
		
		setTitle("BANKA");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		setExtendedState(MAXIMIZED_BOTH);
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
		JMenu file = new JMenu("File");
		JMenuItem racuniPravnihLica = new JMenuItem("Racuni pravnih lica");
		JMenuItem pregledRacuna = new JMenuItem("Pregled racuna");
		JMenuItem preduzeceMi = new JMenuItem("Preduzeće");
		JMenuItem poslovniPartnerMI = new JMenuItem("Poslovni partner");
		JMenuItem sektorMI = new JMenuItem("Sektor");
		JMenuItem sluzbaMI = new JMenuItem("Služba");
		
		file.add(racuniPravnihLica);
		file.add(pregledRacuna);
		file.add(preduzeceMi);
		file.add(poslovniPartnerMI);
		file.add(sektorMI);
		file.add(sluzbaMI);
		menuBar.add(file);
		
		//postavljamo menu bar
		//ne koristimo add(), nego setJMenuBar()
		setJMenuBar(menuBar);
		
		racuniPravnihLica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RacuniPravnihLicaDialog racuniPravnihLicaForm = new RacuniPravnihLicaDialog();
				racuniPravnihLicaForm.setVisible(true);
				
			}
		});
		
		pregledRacuna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PregledRacunaDialog pregledRacuna = new PregledRacunaDialog();
				pregledRacuna.setVisible(true);
				
			}
		});
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static MainFrame getInstance(){
		if (instance == null)
			instance = new MainFrame();
		return instance;
	}

}
