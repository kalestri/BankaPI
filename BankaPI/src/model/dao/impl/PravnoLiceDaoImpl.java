package model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import model.PravnaLica;
import model.dao.PravnoLiceDao;

//@Repository
public class PravnoLiceDaoImpl implements PravnoLiceDao {
//	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(PravnaLica pravnoLice) {
		session.getCurrentSession().save(pravnoLice);
	}

	@Override
	public void edit(PravnaLica pravnoLice) {
		session.getCurrentSession().update(pravnoLice);

	}

	@Override
	public void delete(int pib) {
		
		session.getCurrentSession().delete(getPravnoLice(pib));

	}

	@Override
	public PravnaLica getPravnoLice(int pib) {
		return (PravnaLica) session.getCurrentSession().get(PravnaLica.class, pib);
	}

	@Override
	public List getPravnaLica() {
		return session.getCurrentSession().createQuery("from PravnoLice").list();
	}

}
