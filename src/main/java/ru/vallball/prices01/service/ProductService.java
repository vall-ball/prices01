package ru.vallball.prices01.service;

import java.util.List;

import ru.vallball.prices01.model.Product;

public interface ProductService {
	
	void save(Product product);

	List<Product> list();

	void update(String name, Product product);

	Product findProductByName(String name);

	void deleteProductByName(String name);

}
