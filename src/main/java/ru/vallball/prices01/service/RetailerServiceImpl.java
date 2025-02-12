package ru.vallball.prices01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.prices01.dao.RetailerRepository;
import ru.vallball.prices01.model.Retailer;


@Service
@Transactional
public class RetailerServiceImpl implements RetailerService {
	
	@Autowired
	RetailerRepository retailerRepository;

	@Override
	public void save(Retailer retailer) {
		retailerRepository.save(retailer);
		
	}

	@Override
	public List<Retailer> list() {
		return retailerRepository.findAllByOrderByNameAsc();
	}

	@Override
	public void update(String name, Retailer retailer) {
		Retailer retailerForUpdate = retailerRepository.findRetailerByName(name);
		retailerForUpdate.setName(retailer.getName());
		retailerRepository.save(retailerForUpdate);
		
	}

	@Override
	public Retailer findRetailerByName(String name) {
		return retailerRepository.findRetailerByName(name);
	}

	@Override
	public void deleteRetailerByName(String name) {
		long l = retailerRepository.deleteRetailerByName(name);
		if (l == 0) {
			throw new EmptyResultDataAccessException((int) l);
		}
		
	}

}
