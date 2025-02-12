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

import ru.vallball.prices01.dto.ManufacturerDTO;
import ru.vallball.prices01.model.Manufacturer;
import ru.vallball.prices01.service.ManufacturerService;
import ru.vallball.prices01.util.ManufacturerConverter;

@RestController
@RequestMapping("manufacturers")
public class ManufacturerController {
	
	@Autowired
	ManufacturerService manufacturerService;
	
	@GetMapping
	public List<ManufacturerDTO> list() {
		List<ManufacturerDTO> list = new ArrayList<>();
		for (Manufacturer m : manufacturerService.list()) {
			list.add(ManufacturerConverter.convertToManufacturerDto(m));
		}
		return list;
	}

	@PostMapping
	public ResponseEntity<Object> createCategory(@RequestBody ManufacturerDTO manufacturerDto) {
		Manufacturer manufacturer = ManufacturerConverter.convertToManufacturer(manufacturerDto);
		manufacturerService.save(manufacturer);
		return new ResponseEntity<>("Manufacturer is created successfully", HttpStatus.CREATED);
	}

	@GetMapping("{nameOfManufacturer}")
	public ResponseEntity<Object> get(@PathVariable(value = "nameOfManufacturer") String name) {
		Manufacturer manufacturer = manufacturerService.findManufacturerByName(name);
		if (manufacturer == null) {
			return new ResponseEntity<>("Manufacturer not found", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(ManufacturerConverter.convertToManufacturerDto(manufacturer));
	}

	@DeleteMapping("{nameOfManufacturer}")
	public ResponseEntity<Object> delete(@PathVariable(value = "nameOfManufacturer") String name) {
		try {
			manufacturerService.deleteManufacturerByName(name);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Manufacturer not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Manufacturer is deleted successfully", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("{nameOfManufacturer}")
	public ResponseEntity<Object> update(@PathVariable(value = "nameOfManufacturer") String name, @RequestBody ManufacturerDTO manufacturerDto) {
		try {
			manufacturerService.update(name, ManufacturerConverter.convertToManufacturer(manufacturerDto));
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Manufacturer not found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Manufacturer is updated successfully", HttpStatus.ACCEPTED);
	}

}
