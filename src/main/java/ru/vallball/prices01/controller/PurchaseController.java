package ru.vallball.prices01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.vallball.prices01.dto.PurchaseDTO;
import ru.vallball.prices01.model.Purchase;
import ru.vallball.prices01.service.PurchaseService;
import ru.vallball.prices01.util.PurchaseConverter;

@RestController
@RequestMapping("purchases")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;

	@GetMapping
	public List<PurchaseDTO> list() {
		List<PurchaseDTO> list = new ArrayList<>();
		for (Purchase p : purchaseService.list()) {
			list.add(PurchaseConverter.convertToPurchaseDto(p));
		}
		return list;
	}
	
	@PostMapping
	public ResponseEntity<Object> createPurchase(@Valid @RequestBody PurchaseDTO purchaseDto) {
		Purchase purchase = PurchaseConverter.convertToPurchase(purchaseDto);
		purchaseService.save(purchase);
		return new ResponseEntity<>("Purchase is created successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("{idOfPurchase}")
	public ResponseEntity<Object> update(@PathVariable(value = "idOfPurchase") long id, @RequestBody PurchaseDTO purchaseDto) {
		try {
			purchaseService.update(id, PurchaseConverter.convertToPurchase(purchaseDto));
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Purchase not found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Purchase is updated successfully", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{idOfPurchase}")
	public ResponseEntity<Object> delete(@PathVariable(value = "idOfPurchase") long id) {
		try {
			purchaseService.deletePurchase(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Purchase not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Purchase is deleted successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/retailer/{nameOfRetailer}")
	public List<PurchaseDTO> listOfPurchaseByRetailer(@PathVariable(value = "nameOfRetailer") String name) {
		List<PurchaseDTO> list = new ArrayList<>();
		for (Purchase p : purchaseService.listOfPurchasesByRetailer(name)) {
			list.add(PurchaseConverter.convertToPurchaseDto(p));
		}
		return list;
	}
	
	@GetMapping("/product/{nameOfProduct}")
	public List<PurchaseDTO> listOfPurchaseByProduct(@PathVariable(value = "nameOfProduct") String name) {
		List<PurchaseDTO> list = new ArrayList<>();
		for (Purchase p : purchaseService.findPurchasesByProduct(name)) {
			list.add(PurchaseConverter.convertToPurchaseDto(p));
		}
		return list;
	}
}
