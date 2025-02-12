package ru.vallball.prices01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.prices01.dao.ManufacturerRepository;
import ru.vallball.prices01.model.Manufacturer;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService{
	
	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	public void save(Manufacturer manufacturer) {
		manufacturerRepository.save(manufacturer);	
	}

	@Override
	public List<Manufacturer> list() {
		return manufacturerRepository.findAllByOrderByNameAsc();
	}

	@Override
	public void update(String name, Manufacturer manufacturer) {
		Manufacturer manufacturerForUpdate = manufacturerRepository.findManufacturerByName(name);
		manufacturerForUpdate.setName(manufacturer.getName());
		manufacturerRepository.save(manufacturerForUpdate);
		
	}

	@Override
	public Manufacturer findManufacturerByName(String name) {
		return manufacturerRepository.findManufacturerByName(name);
	}

	@Override
	public void deleteManufacturerByName(String name) {
		long l = manufacturerRepository.deleteManufacturerByName(name);
		if (l == 0) {
			throw new EmptyResultDataAccessException((int) l);
		}	
	}

}
