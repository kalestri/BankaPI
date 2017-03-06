package model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import model.PravnoLice;
import model.dao.PravnoLiceDao;
import model.service.PravnoLiceService;
//@Service
public class PravnoLiceServiceImpl implements PravnoLiceService {
//@Autowired
	private PravnoLiceDao pravnoLiceDao;
	
	
	@Transactional
	public void add(PravnoLice pravnoLice) {
		pravnoLiceDao.add(pravnoLice);

	}

	@Transactional
	public void edit(PravnoLice pravnoLice) {
		pravnoLiceDao.edit(pravnoLice);

	}

	@Transactional
	public void delete(int pib) {
		pravnoLiceDao.delete(pib);

	}

	@Transactional
	public PravnoLice getPravnoLice(int pib) {
		return pravnoLiceDao.getPravnoLice(pib);
	}

	@Transactional
	public List getPravnaLica() {
		return pravnoLiceDao.getPravnaLica();
	}

}
