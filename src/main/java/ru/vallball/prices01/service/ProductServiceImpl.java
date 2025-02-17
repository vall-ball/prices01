package ru.vallball.prices01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.prices01.dao.CategoryRepository;
import ru.vallball.prices01.dao.ManufacturerRepository;
import ru.vallball.prices01.dao.ProductRepository;
import ru.vallball.prices01.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	public void save(Product product) {
		if (product.getCategory() != null) {
			product.setCategory(categoryRepository.findCategoryByName(product.getCategory().getName()));
		}
		if (product.getManufacturer() != null) {
			product.setManufacturer(manufacturerRepository.findManufacturerByName(product.getManufacturer().getName()));
		}
		productRepository.save(product);
	}

	@Override
	public List<Product> list() {
		return productRepository.findAllByOrderByNameAsc();
	}

	@Override
	public void update(String name, Product product) {
		Product productForUpdate = productRepository.findProductByName(name);
		productForUpdate.setName(product.getName());
		productForUpdate.setCategory(categoryRepository.findCategoryByName(product.getCategory().getName()));
		productForUpdate
				.setManufacturer(manufacturerRepository.findManufacturerByName(product.getManufacturer().getName()));
		productForUpdate.setWeightInGrams(product.getWeightInGrams());
		productRepository.save(productForUpdate);
	}

	@Override
	public Product findProductByName(String name) {
		return productRepository.findProductByName(name);
	}

	@Override
	public void deleteProductByName(String name) {
		long l = productRepository.deleteProductByName(name);
		if (l == 0) {
			throw new EmptyResultDataAccessException((int) l);
		}
	}

	@Override
	public List<Product> listOfProductsByCategory(String name) {	
		return productRepository.findByCategory(categoryRepository.findCategoryByName(name));
	}

	@Override
	public List<Product> listOfProductsByManufacturer(String name) {
		return productRepository.findByManufacturer(manufacturerRepository.findManufacturerByName(name));
	}

}
