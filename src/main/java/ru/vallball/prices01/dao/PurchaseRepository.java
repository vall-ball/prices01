package ru.vallball.prices01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.prices01.model.Product;
import ru.vallball.prices01.model.Purchase;
import ru.vallball.prices01.model.Retailer;


public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	
	public long deletePurchaseById(long id);
	
	public List<Purchase> findByProduct(Product product);
	
	public List<Purchase> findByRetailer(Retailer retailer);
	
}
