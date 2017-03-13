package model.dao;

import java.util.List;

import model.PravnaLica;

public interface PravnoLiceDao {
	public void add(PravnaLica pravnoLice);
	public void edit(PravnaLica pravnoLice);
	public void delete(int pib);
	public PravnaLica getPravnoLice(int pib);
	public List getPravnaLica();
}
