package gui;


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

public class KodoviBankeForm extends JDialog{
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
	private JTextField tfSifraDrzave = new JTextField(5);

	private JButton btnZoom = new JButton("...");


	public KodoviBankeForm(){

		//TODO 
		//za next mehanizam formirati ColumnList u listeneru vezanom za nextForm dugme forme Drzava
		//proslediti ga ovom konstruktoru
		//iskoristiti ga da se izvrsi filtriranje - u table modelu pri inicijalnom otvaranju ove forme
		//koristiti getWhereClause metodu ColumnList objekta
		//obratiti paznju da se tako postave nazivi Column objekata da dobijena where klauzula bude validna
		//tj. da se moze direktno poslati bazi
		
		getContentPane().setLayout(new MigLayout("fill"));

		setSize(new Dimension(640, 400));
		setTitle("Kodovi banke");
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


		JLabel lblSifra = new JLabel ("Sifra banke");
		JLabel lblNaziv = new JLabel("Pravno lice");
		

		dataPanel.add(lblSifra);
		dataPanel.add(tfSifra,"wrap, gapx 15px");
		dataPanel.add(lblNaziv);
		dataPanel.add(tfNaziv,"wrap,gapx 15px, span 3");
		
		
		btnZoom.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//TODO implementirati zoom mehanizam - povezati sa formom Drzava
			//Uputstvo:
			//Instancirati DrzavaStandardForm i prikazati je
			//ako je taj dijalog modalan, izvrsavanje ove metode se nece nastaviti dok se forma Drzava ne zatvori
			//U Drzavi implementirati listener kojim se reaguje na pritisak pickup dugmeta
			//U okviru njega napraviti po Column objekat za svaku kolonu koju zelimo preneti
			//Preciznije, za selektovani red izdvojiti vrednosti trazenih kolona i napraviti Column objekte
			//naziv Column objekta je naziv kolone  bazi (nije bitno za zoom, ali je bitno za next da se poklapaju, 
			//pa je najbolje staviti i ovde).
			//vrednost je vrednost pomenute celije tabele
			//Napraviti Column list objekat koji sadrzi sve ove Column objekte. Izdvijiti ga kao atribut klase, napraviti getter
			//Zatvrotiti formu Drzava na kraju implementacije pickup listener-a
			//Time se vracamo na ovu metodu
			//Preuzeti prenete vrednosti za naziv i sifru drzave i time popuniti odgovarajuca tekstualna polja
			//Paziti da se ne desi exception kada se forma zatvori bez klila na pickup dugme (nego na x)	
			}
		});
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

		DefaultTableModel tableModel = new DefaultTableModel(new String[] {"Sifra banke",   "SWIFT", "Pravno lice"}, 0);
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
		String sifraBanke = (String)tblGrid.getModel().getValueAt(index, 0);
		String swift = (String)tblGrid.getModel().getValueAt(index, 1);
		String pravnoLice = (String)tblGrid.getModel().getValueAt(index, 2);
		
		tfSifra.setText(sifraBanke);
		tfNaziv.setText(swift);
		tfSifraDrzave.setText(pravnoLice);
		
	}


}

