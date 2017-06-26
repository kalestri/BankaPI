package model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import model.PravnaLica;
import model.RacuniPravnihLica;
import model.dao.RacuniPravnihLicaDao;

public class RacuniPravnihLicaDaoImpl implements RacuniPravnihLicaDao{
	
private SessionFactory session;
	

	@Override
	public void add(RacuniPravnihLica racun) {
		session.getCurrentSession().save(racun);
		
	}

	@Override
	public void edit(RacuniPravnihLica racun) {
		session.getCurrentSession().update(racun);
		
	}

	@Override
	public RacuniPravnihLica getRacun(int brojRacuna) {
		return (RacuniPravnihLica) session.getCurrentSession().get(RacuniPravnihLica.class, brojRacuna);
	}

	@Override
	public List getRacuniPravnihLica() {
		return session.getCurrentSession().createQuery("from RacuniPravnihLica").list();
	}

	@Override
	public void delete(int brojRacuna) {
		session.getCurrentSession().delete(getRacun(brojRacuna));
		
	}
	
}
