package ru.vallball.prices01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.prices01.dao.ProductRepository;
import ru.vallball.prices01.dao.PurchaseRepository;
import ru.vallball.prices01.dao.RetailerRepository;
import ru.vallball.prices01.model.Purchase;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	RetailerRepository retailerRepository;

	@Override
	public void save(Purchase purchase) {
		if (purchase.getProduct() != null) {
			purchase.setProduct(productRepository.findProductByName(purchase.getProduct().getName()));
		}
		if (purchase.getRetailer() != null) {
			purchase.setRetailer(retailerRepository.findRetailerByName(purchase.getRetailer().getName()));
		}
		purchaseRepository.save(purchase);
	}

	@Override
	public List<Purchase> list() {
		return purchaseRepository.findAll();
	}

	@Override
	public void update(long id, Purchase purchase) {
		Purchase purchaseForUpdate = purchaseRepository.findById(id).get();
		purchaseForUpdate.setDate(purchase.getDate());
		purchaseForUpdate.setPrice(purchase.getPrice());
		purchaseForUpdate.setProduct(productRepository.findProductByName(purchase.getProduct().getName()));
		purchaseForUpdate.setRetailer(retailerRepository.findRetailerByName(purchase.getRetailer().getName()));
		purchaseRepository.save(purchaseForUpdate);
	}

	@Override
	public void deletePurchase(long id) {
		long l = purchaseRepository.deletePurchaseById(id);
		if (l == 0) {
			throw new EmptyResultDataAccessException((int) l);
		}
		
	}

	@Override
	public List<Purchase> listOfPurchasesByRetailer(String name) {
		return purchaseRepository.findByRetailer(retailerRepository.findRetailerByName(name));
	}
	
	@Override
	public List<Purchase> findPurchasesByProduct(String name) {
		return purchaseRepository.findByProduct(productRepository.findProductByName(name));
	}

}
