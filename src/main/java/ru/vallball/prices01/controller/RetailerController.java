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

import ru.vallball.prices01.dto.RetailerDTO;
import ru.vallball.prices01.model.Retailer;
import ru.vallball.prices01.service.RetailerService;
import ru.vallball.prices01.util.RetailerConverter;


@RestController
@RequestMapping("retailers")
public class RetailerController {
	
	@Autowired
	RetailerService retailerService;
	
	@GetMapping
	public List<RetailerDTO> list() {
		List<RetailerDTO> list = new ArrayList<>();
		for (Retailer r : retailerService.list()) {
			list.add(RetailerConverter.convertToRetailerDto(r));
		}
		return list;
	}

	@PostMapping
	public ResponseEntity<Object> createCategory(@RequestBody RetailerDTO retailerDto) {
		Retailer retailer = RetailerConverter.convertToRetailer(retailerDto);
		retailerService.save(retailer);
		return new ResponseEntity<>("Retailer is created successfully", HttpStatus.CREATED);
	}

	@GetMapping("{nameOfRetailer}")
	public ResponseEntity<Object> get(@PathVariable(value = "nameOfRetailer") String name) {
		Retailer retailer = retailerService.findRetailerByName(name);
		if (retailer == null) {
			return new ResponseEntity<>("Retailer not found", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(RetailerConverter.convertToRetailerDto(retailer));
	}

	@DeleteMapping("{nameOfRetailer}")
	public ResponseEntity<Object> delete(@PathVariable(value = "nameOfRetailer") String name) {
		try {
			retailerService.deleteRetailerByName(name);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Retailer not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Retailer is deleted successfully", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("{nameOfRetailer}")
	public ResponseEntity<Object> update(@PathVariable(value = "nameOfRetailer") String name, @RequestBody RetailerDTO retailerDto) {
		try {
			retailerService.update(name, RetailerConverter.convertToRetailer(retailerDto));
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Retailer not found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Retailer is updated successfully", HttpStatus.ACCEPTED);
	}


}
