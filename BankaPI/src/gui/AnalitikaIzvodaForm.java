package gui;
import gui.MainMenu;
import model.NaseljenoMesto;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class AnalitikaIzvodaForm extends JDialog{
	private static final long serialVersionUID = 1L;


	public static final int MODE_EDIT   = 1;
	public static final int MODE_ADD    = 2;
	public static final int MODE_SEARCH = 3;
	private int mode;

	private JToolBar toolBar;
	private JButton btnAdd, btnCommit, btnDelete, btnFirst, btnLast, btnHelp, btnNext, btnNextForm,
	btnPickup, btnRefresh, btnRollback, btnSearch, btnPrevious;
	private JTable tblGrid = new JTable();
	private JTextField tfSifra = new JTextField(5);
	private JTextField tfNaziv = new JTextField(20);


	public AnalitikaIzvodaForm(){

		//TODO 
		//za next mehanizam formirati ColumnList u listeneru vezanom za nextForm dugme forme Drzava
		//proslediti ga ovom konstruktoru
		//iskoristiti ga da se izvrsi filtriranje - u table modelu pri inicijalnom otvaranju ove forme
		//koristiti getWhereClause metodu ColumnList objekta
		//obratiti paznju da se tako postave nazivi Column objekata da dobijena where klauzula bude validna
		//tj. da se moze direktno poslati bazi
		
		getContentPane().setLayout(new MigLayout("fill"));

		setSize(new Dimension(980, 402));
		setTitle("Analitika izvoda");
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);
		
		mode = MODE_EDIT;

		initToolbar();
		initTable();
		initGui();

	}
	
	
	private void initGui(){
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new MigLayout("fillx"));
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new MigLayout());

		JPanel buttonsPanel = new JPanel();
		btnCommit = new JButton(new ImageIcon(getClass().getResource("/img/commit.gif")));
		btnCommit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnRollback = new JButton(new ImageIcon(getClass().getResource("/img/remove.gif")));
		btnRollback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});


		JLabel lblSifra = new JLabel ("Šifra mesta");
		JLabel lblNaziv = new JLabel("Naziv mesta:");

		dataPanel.add(lblSifra);
		dataPanel.add(tfSifra,"wrap, gapx 15px");
		dataPanel.add(lblNaziv);
		dataPanel.add(tfNaziv,"wrap,gapx 15px, span 3");
		bottomPanel.add(dataPanel);

		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		buttonsPanel.add(btnRollback);
		bottomPanel.add(buttonsPanel,"dock east");

		getContentPane().add(bottomPanel, "grow, wrap");

	
	}
	
	private void initToolbar(){
		toolBar = new JToolBar();

		btnSearch = new JButton(new ImageIcon(getClass().getResource("/img/search.gif")));

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		toolBar.add(btnSearch);


		btnRefresh = new JButton(new ImageIcon(getClass().getResource("/img/refresh.gif")));

		btnRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		toolBar.add(btnRefresh);

		btnPickup = new JButton(new ImageIcon(getClass().getResource("/img/zoom-pickup.gif")));
		btnPickup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		toolBar.add(btnPickup);


		btnHelp = new JButton(new ImageIcon(getClass().getResource("/img/help.gif")));
		btnHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		toolBar.add(btnHelp);

		toolBar.addSeparator();

		btnFirst = new JButton(new ImageIcon(getClass().getResource("/img/first.gif")));
		btnFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		toolBar.add(btnFirst);

		btnPrevious = new JButton(new ImageIcon(getClass().getResource("/img/prev.gif")));
		btnPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		toolBar.add(btnPrevious);

		btnNext = new JButton(new ImageIcon(getClass().getResource("/img/next.gif")));
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		toolBar.add(btnNext);

		btnLast = new JButton(new ImageIcon(getClass().getResource("/img/last.gif"))); 
		btnLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		toolBar.add(btnLast);

		toolBar.addSeparator();


		btnAdd = new JButton(new ImageIcon(getClass().getResource("/img/add.gif")));
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		toolBar.add(btnAdd);

		btnDelete = new JButton(new ImageIcon(getClass().getResource("/img/remove.gif")));
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		toolBar.add(btnDelete);

		toolBar.addSeparator();

		btnNextForm = new JButton(new ImageIcon(getClass().getResource("/img/nextform.gif")));
		btnNextForm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		toolBar.add(btnNextForm);

		btnPickup.setEnabled(false);
		getContentPane().add(toolBar, "dock north");

	}


	private void initTable(){

		JScrollPane scrollPane = new JScrollPane(tblGrid);      
		getContentPane().add(scrollPane, "grow, wrap");

		DefaultTableModel tableModel = new DefaultTableModel(new String[] {"Br. stavke",   "Duznik", "Poverilac", "Svrha placanja",
				"Datum prijema", "Datum valute", "Racun duznika", "Model zaduzenja", "PNB zaduzenja", "Racun poverioca", "Model odobrenja", "PNB odobrenja", 
				"Hitno?", "Iznos", "Smer", "Tip greske", "Status", "Analitika izvoda banke", "Naseljeno mesto", "Vrsta placanja", "Valuta placanja", }, 0);
		tblGrid.setModel(tableModel);

//		try {
//			tableModel.open();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 

		//Dozvoljeno selektovanje redova
		tblGrid.setRowSelectionAllowed(true);
		//Ali ne i selektovanje kolona 
		tblGrid.setColumnSelectionAllowed(false);

		//Dozvoljeno selektovanje samo jednog reda u jedinici vremena 
		tblGrid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblGrid.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					return;
				sync();
			}
		});

	}

	private void sync() {
		int index = tblGrid.getSelectedRow();
		if (index < 0) {
			tfSifra.setText("");
			tfNaziv.setText("");
			return;
		}
		String sifra = (String)tblGrid.getModel().getValueAt(index, 0);
		String naziv = (String)tblGrid.getModel().getValueAt(index, 1);
		String sifraDrzave = (String)tblGrid.getModel().getValueAt(index, 2);
		String nazivDrzave = (String)tblGrid.getModel().getValueAt(index, 3);
		tfSifra.setText(sifra);
		tfNaziv.setText(naziv);

	}
}

