package model.service.impl;

import java.util.List;



import model.PravnoLice;
import model.dao.PravnoLiceDao;
import model.service.PravnoLiceService;
//@Service
public class PravnoLiceServiceImpl implements PravnoLiceService {
//@Autowired
	private PravnoLiceDao pravnoLiceDao;
	

	public void add(PravnoLice pravnoLice) {
		pravnoLiceDao.add(pravnoLice);

	}

	public void edit(PravnoLice pravnoLice) {
		pravnoLiceDao.edit(pravnoLice);

	}


	public void delete(int pib) {
		pravnoLiceDao.delete(pib);

	}

	public PravnoLice getPravnoLice(int pib) {
		return pravnoLiceDao.getPravnoLice(pib);
	}

	public List getPravnaLica() {
		return pravnoLiceDao.getPravnaLica();
	}

}
