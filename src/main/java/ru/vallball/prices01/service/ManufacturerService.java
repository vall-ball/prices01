package ru.vallball.prices01.service;

import java.util.List;

import ru.vallball.prices01.model.Manufacturer;

public interface ManufacturerService {
	
	void save(Manufacturer manufacturer);

	List<Manufacturer> list();

	void update(String name, Manufacturer manufacturer);

	Manufacturer findManufacturerByName(String name);

	void deleteManufacturerByName(String name);
}
