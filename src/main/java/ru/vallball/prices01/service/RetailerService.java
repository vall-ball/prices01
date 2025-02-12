package ru.vallball.prices01.service;

import java.util.List;

import ru.vallball.prices01.model.Retailer;

public interface RetailerService {
	void save(Retailer retailer);

	List<Retailer> list();

	void update(String name, Retailer retailer);

	Retailer findRetailerByName(String name);

	void deleteRetailerByName(String name);

}
