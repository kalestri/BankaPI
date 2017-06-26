package model.dao;

import java.util.List;

import model.PravnaLica;
import model.RacuniPravnihLica;

public interface RacuniPravnihLicaDao{
	
	public void add(RacuniPravnihLica racun);
	public void edit(RacuniPravnihLica racun);
	public void delete(int brojRacuna);
	public RacuniPravnihLica getRacun(int brojRacuna);
	public List getRacuniPravnihLica();
	

}
