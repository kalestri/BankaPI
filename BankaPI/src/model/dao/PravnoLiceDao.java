package model.dao;

import java.util.List;

import model.PravnoLice;

public interface PravnoLiceDao {
	public void add(PravnoLice pravnoLice);
	public void edit(PravnoLice pravnoLice);
	public void delete(int pib);
	public PravnoLice getPravnoLice(int pib);
	public List getPravnaLica();
}
