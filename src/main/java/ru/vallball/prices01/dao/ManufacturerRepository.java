package ru.vallball.prices01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.prices01.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
	
	public Manufacturer findManufacturerByName(String name);

	public List<Manufacturer> findAllByOrderByNameAsc();

	public long deleteManufacturerByName(String name);

}
