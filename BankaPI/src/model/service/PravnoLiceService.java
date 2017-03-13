package model.service;

import java.util.List;

import model.PravnaLica;

public interface PravnoLiceService {

	public void add(PravnaLica pravnoLice);
	public void edit(PravnaLica pravnoLice);
	public void delete(int pib);
	public PravnaLica getPravnoLice(int pib);
	public List getPravnaLica();
	
}
