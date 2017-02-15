package gui.dialog;


import gui.MainFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import table.model.DrzaveTableModel;

public class DrzavaStandardForm extends JDialog{
	private static final long serialVersionUID = 1L;

	private JToolBar toolBar;
	private JButton btnAdd, btnCommit, btnDelete, btnFirst, btnLast, btnHelp, btnNext, btnNextForm,
	btnPickup, btnRefresh, btnRollback, btnSearch, btnPrevious;
	private JTextField tfSifra = new JTextField(5);
	private JTextField tfNaziv = new JTextField(20);
	private JTable tblGrid;
	private DrzaveTableModel tableModel;

	private static final int MODE_EDIT   = 1;
	private static final int MODE_ADD    = 2;
	private static final int MODE_SEARCH = 3;
	private int mode;


	public DrzavaStandardForm(){

		setLayout(new MigLayout("fill"));
		setSize(new Dimension(800, 600));
		setTitle("Države");
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);

		initToolbar();
		initTable();
		initGui();

		mode = MODE_EDIT;
	}

	private void initGui(){
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new MigLayout("fillx"));
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new MigLayout("gapx 15px"));

		JPanel buttonsPanel = new JPanel();
		btnCommit = new JButton(new ImageIcon(getClass().getResource("/img/commit.gif")));
		btnCommit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (mode == MODE_ADD)
					addRow();
				else if (mode == MODE_EDIT)
					updateRow();
				else if (mode == MODE_SEARCH)
					search();

			}
		});
		btnRollback = new JButton(new ImageIcon(getClass().getResource("/img/remove.gif")));
		btnRollback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(MODE_EDIT);
			}
		});


		JLabel lblSifra = new JLabel ("Šifra države:");
		JLabel lblNaziv = new JLabel("Naziv države:");

		dataPanel.add(lblSifra);
		dataPanel.add(tfSifra,"wrap");
		dataPanel.add(lblNaziv);
		dataPanel.add(tfNaziv);
		bottomPanel.add(dataPanel);


		buttonsPanel.setLayout(new MigLayout("wrap"));
		buttonsPanel.add(btnCommit);
		buttonsPanel.add(btnRollback);
		bottomPanel.add(buttonsPanel,"dock east");

		add(bottomPanel, "grow, wrap");
	}


	private void initTable(){
		tblGrid = new JTable();
		JScrollPane scrollPane = new JScrollPane(tblGrid);
		add(scrollPane, "grow, wrap");


		// Kreiranje TableModel-a, parametri: header-i kolona i broj redova 
		tableModel = new DrzaveTableModel(new String[] {"Šifra",   "Naziv"}, 0);
		tblGrid.setModel(tableModel);

		try {
			tableModel.open();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

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

	private void initToolbar(){
		toolBar = new JToolBar();

		btnSearch = new JButton(new ImageIcon(getClass().getResource("/img/search.gif")));

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(MODE_SEARCH);

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
				goFirst();

			}
		});

		toolBar.add(btnFirst);

		btnPrevious = new JButton(new ImageIcon(getClass().getResource("/img/prev.gif")));
		btnPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();

			}
		});
		toolBar.add(btnPrevious);

		btnNext = new JButton(new ImageIcon(getClass().getResource("/img/next.gif")));
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();

			}
		});
		toolBar.add(btnNext);

		btnLast = new JButton(new ImageIcon(getClass().getResource("/img/last.gif"))); 
		btnLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goLast();
			}
		});
		toolBar.add(btnLast);

		toolBar.addSeparator();


		btnAdd = new JButton(new ImageIcon(getClass().getResource("/img/add.gif")));
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setMode(MODE_ADD);

			}
		});
		toolBar.add(btnAdd);

		btnDelete = new JButton(new ImageIcon(getClass().getResource("/img/remove.gif")));
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(MainFrame.getInstance(),"Da li ste sigurni da želite da obrišete red?", "Potvrda",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					removeRow();

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

		add(toolBar, "dock north");

	}

	private void setMode(int mode){

		this.mode = mode;
		
		//TODO odraditi propratne akcije (isprazniti polja, postaviti fokus na prvu komponentu) 
		
	}

	private void removeRow(){
		int selectedRow = tblGrid.getSelectedRow();
		if (selectedRow == -1)
			return;

		int next = selectedRow;

		if (selectedRow == tableModel.getRowCount() - 1)
			next = selectedRow - 1;

		try {
			tableModel.deleteRow(selectedRow);
			tblGrid.setRowSelectionInterval(next, next);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", 
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void addRow() {       
		String sifra = tfSifra.getText().trim();
		String naziv = tfNaziv.getText().trim();
		try {
			DrzaveTableModel dtm = (DrzaveTableModel)tblGrid.getModel(); 
			int index = dtm.insertRow(sifra, naziv);
			tblGrid.setRowSelectionInterval(index, index);
			setMode(MODE_ADD);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(),"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void updateRow(){
		//TODO pozvati metodu za update table modela
	}
	
	private void search(){
		//TODO pozvati metodu za pretragu tablemodela
	}

	private void goLast() {
		int rowCount = tblGrid.getModel().getRowCount(); 
		if (rowCount > 0)
			tblGrid.setRowSelectionInterval(rowCount - 1, rowCount - 1);
	}

	private void goFirst(){
		int rowCount = tblGrid.getModel().getRowCount();
		if (rowCount > 0)
			tblGrid.setRowSelectionInterval(0, 0);
	}

	private void goNext(){
		int rowCount = tblGrid.getModel().getRowCount();
		int selected = tblGrid.getSelectedRow();

		if (selected == -1)
			return;

		int next =  selected < rowCount - 1 ? selected + 1 : 0;
		tblGrid.setRowSelectionInterval(next, next);

	}

	private void goPrevious(){
		int rowCount = tblGrid.getModel().getRowCount();
		int selected = tblGrid.getSelectedRow();

		if (selected == -1)
			return;

		int previous = selected > 0 ? selected - 1 : rowCount - 1;
		tblGrid.setRowSelectionInterval(previous, previous);
	}

	private void sync() {
		int index = tblGrid.getSelectedRow();
		if (index < 0) {
			tfSifra.setText("");
			tfNaziv.setText("");
			return;
		}
		String sifra = (String)tableModel.getValueAt(index, 0);
		String naziv = (String)tableModel.getValueAt(index, 1);
		tfSifra.setText(sifra);
		tfNaziv.setText(naziv);
	}




}
