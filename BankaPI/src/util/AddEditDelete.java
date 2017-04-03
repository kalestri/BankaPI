package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface AddEditDelete {

	Configuration con = new Configuration();
	@SuppressWarnings("deprecation")
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	
	
	public void addEntity();
	
	public void deleteEntity();
	
	public void editEntity();
	
	
}
