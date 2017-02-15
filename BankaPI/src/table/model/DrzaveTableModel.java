package table.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import util.SortUtils;
import database.DBConnection;

public class DrzaveTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	private String basicQuery = "SELECT dr_sifra, dr_naziv FROM drzava";
	private String orderBy = " ORDER BY dr_sifra";
	private String whereStmt = "";

	public DrzaveTableModel(Object[] colNames, int rowCount) {
		super(colNames, rowCount);
	}

	//Otvaranje upita
	public void open() throws SQLException {
		fillData(basicQuery + whereStmt + orderBy);
	}
	
	
	private void fillData(String sql) throws SQLException {
		setRowCount(0);
		Statement stmt = DBConnection.getConnection().createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		while (rset.next()) {
			String sifra = rset.getString("DR_SIFRA");
			String naziv = rset.getString("DR_NAZIV");
			addRow(new String[]{sifra, naziv});
		}
		rset.close();
		stmt.close();
		fireTableDataChanged();
	}  
	
	
	public void deleteRow(int index) throws SQLException{
		
		String sifra = (String) getValueAt(index, 0);
		PreparedStatement stmt = DBConnection.getConnection().prepareStatement("DELETE FROM DRZAVA WHERE DR_SIFRA = ?");
		stmt.setString(1, sifra);
		int rowsAffected = stmt.executeUpdate();
		DBConnection.getConnection().commit();
		if (rowsAffected > 0){
			removeRow(index);
			fireTableDataChanged();
		}
		
		
	}
	
	private int sortedInsert(String sifra, String naziv) { 
	    int left = 0;
	    int right = getRowCount() - 1;   
	    int mid = (left + right) / 2;
	    while (left <= right ) {      
	      mid = (left + right) / 2;
	      String aSifra = (String)getValueAt(mid, 0);      
	      if (SortUtils.getLatCyrCollator().compare(sifra, aSifra) > 0) 
	        left = mid + 1;
	      else if (SortUtils.getLatCyrCollator().compare(sifra, aSifra) < 0)
	        right = mid - 1;
	      else 
	        // ako su jednaki: to ne moze da se desi ako tabela ima primarni kljuc
	        break;      
	    }
	    insertRow(left, new String[] {sifra, naziv});
	    return left;
	  }
	
	public int insertRow(String sifra, String naziv) throws SQLException {
	    int retVal = 0;
	    PreparedStatement stmt = DBConnection.getConnection().prepareStatement(
	      "INSERT INTO drzava (dr_sifra, dr_naziv) VALUES (? ,?)");
	    stmt.setString(1, sifra);
	    stmt.setString(2, naziv);
	    int rowsAffected = stmt.executeUpdate();
	    stmt.close();
	    //Unos sloga u bazu
	    DBConnection.getConnection().commit();
	    if (rowsAffected > 0) {
	      // i unos u TableModel  
	      retVal = sortedInsert(sifra, naziv);
	      fireTableDataChanged();
	    }
	    return retVal;
	  }
	 
	
	public void editRow(int index, String sifra, String naziv) throws SQLException{
		//TODO
	}
	
	public void search(String sifra, String naziv) throws SQLException{
		//TODO
	}
	
}

