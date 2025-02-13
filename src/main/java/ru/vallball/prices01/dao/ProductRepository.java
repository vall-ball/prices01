package ru.vallball.prices01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.prices01.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findAllByOrderByNameAsc();

	public Product findProductByName(String name);

	public long deleteProductByName(String name);

}
