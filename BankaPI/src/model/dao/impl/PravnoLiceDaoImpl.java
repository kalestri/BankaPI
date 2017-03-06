package model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import model.PravnoLice;
import model.dao.PravnoLiceDao;

//@Repository
public class PravnoLiceDaoImpl implements PravnoLiceDao {
//	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(PravnoLice pravnoLice) {
		session.getCurrentSession().save(pravnoLice);
	}

	@Override
	public void edit(PravnoLice pravnoLice) {
		session.getCurrentSession().update(pravnoLice);

	}

	@Override
	public void delete(int pib) {
		
		session.getCurrentSession().delete(getPravnoLice(pib));

	}

	@Override
	public PravnoLice getPravnoLice(int pib) {
		return (PravnoLice) session.getCurrentSession().get(PravnoLice.class, pib);
	}

	@Override
	public List getPravnaLica() {
		return session.getCurrentSession().createQuery("from PravnoLice").list();
	}

}
