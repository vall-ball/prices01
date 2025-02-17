package ru.vallball.prices01.service;

import java.util.List;

import ru.vallball.prices01.model.Purchase;

public interface PurchaseService {
	
	void save(Purchase purchase);

	List<Purchase> list();
	
	void update(long id, Purchase purchase);

	List<Purchase> findPurchasesByProduct(String name);

	void deletePurchase(long id);
	
	List<Purchase> listOfPurchasesByRetailer(String name);
}
