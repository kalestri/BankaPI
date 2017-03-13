package model.service.impl;

import java.util.List;



import model.PravnaLica;
import model.dao.PravnoLiceDao;
import model.service.PravnoLiceService;
//@Service
public class PravnoLiceServiceImpl implements PravnoLiceService {
//@Autowired
	private PravnoLiceDao pravnoLiceDao;
	

	public void add(PravnaLica pravnoLice) {
		pravnoLiceDao.add(pravnoLice);

	}

	public void edit(PravnaLica pravnoLice) {
		pravnoLiceDao.edit(pravnoLice);

	}


	public void delete(int pib) {
		pravnoLiceDao.delete(pib);

	}

	public PravnaLica getPravnoLice(int pib) {
		return pravnoLiceDao.getPravnoLice(pib);
	}

	public List getPravnaLica() {
		return pravnoLiceDao.getPravnaLica();
	}

}
