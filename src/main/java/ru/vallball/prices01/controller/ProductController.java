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
import ru.vallball.prices01.dto.ProductDTO;
import ru.vallball.prices01.model.Product;
import ru.vallball.prices01.service.ProductService;
import ru.vallball.prices01.util.ProductConverter;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<ProductDTO> list() {
		List<ProductDTO> list = new ArrayList<>();
		for (Product p : productService.list()) {
			list.add(ProductConverter.convertToProductDto(p));
		}
		return list;
	}

	@PostMapping
	public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductDTO productDto) {
		Product product = ProductConverter.convertToProduct(productDto);
		productService.save(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@GetMapping("{nameOfProduct}")
	public ResponseEntity<Object> get(@PathVariable(value = "nameOfProduct") String name) {
		Product product = productService.findProductByName(name);
		if (product == null) {
			return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(ProductConverter.convertToProductDto(product));
	}

	@DeleteMapping("{nameOfProduct}")
	public ResponseEntity<Object> delete(@PathVariable(value = "nameOfProduct") String name) {
		try {
			productService.deleteProductByName(name);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Product is deleted successfully", HttpStatus.ACCEPTED);
	}

	@PutMapping("{nameOfProduct}")
	public ResponseEntity<Object> update(@PathVariable(value = "nameOfProduct") String name,
			@RequestBody ProductDTO productDto) {
		try {
			productService.update(name, ProductConverter.convertToProduct(productDto));
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/category/{nameOfCategory}")
	public List<ProductDTO> listOfProductsByCategory(@PathVariable(value = "nameOfCategory") String name) {
		List<ProductDTO> list = new ArrayList<>();
		for (Product p : productService.listOfProductsByCategory(name)) {
			list.add(ProductConverter.convertToProductDto(p));
		}
		return list;
	}
	
	@GetMapping("/manufacturer/{nameOfManufacturer}")
	public List<ProductDTO> listOfProductsByManufacturer(@PathVariable(value = "nameOfManufacturer") String name) {
		List<ProductDTO> list = new ArrayList<>();
		for (Product p : productService.listOfProductsByManufacturer(name)) {
			list.add(ProductConverter.convertToProductDto(p));
		}
		return list;
	}

}
