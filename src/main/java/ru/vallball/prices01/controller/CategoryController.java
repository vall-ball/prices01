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

import ru.vallball.prices01.dto.CategoryDTO;
import ru.vallball.prices01.model.Category;
import ru.vallball.prices01.service.CategoryService;
import ru.vallball.prices01.util.CategoryConverter;

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public List<CategoryDTO> list() {
		List<CategoryDTO> list = new ArrayList<>();
		for (Category c : categoryService.list()) {
			list.add(CategoryConverter.convertToCategoryDto(c));
		}
		return list;
	}

	@PostMapping
	public ResponseEntity<Object> createCategory(@RequestBody CategoryDTO categoryDto) {
		Category category = CategoryConverter.convertToCategory(categoryDto);
		categoryService.save(category);
		return new ResponseEntity<>("Category is created successfully", HttpStatus.CREATED);
	}

	@GetMapping("{nameOfCategory}")
	public ResponseEntity<Object> get(@PathVariable(value = "nameOfCategory") String name) {
		Category category = categoryService.findCategoryByName(name);
		if (category == null) {
			return new ResponseEntity<>("Category not found", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(CategoryConverter.convertToCategoryDto(category));
	}

	@DeleteMapping("{nameOfCategory}")
	public ResponseEntity<Object> delete(@PathVariable(value = "nameOfCategory") String name) {
		try {
			categoryService.deleteCategoryByName(name);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Category not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Category is deleted successfully", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("{nameOfCategory}")
	public ResponseEntity<Object> update(@PathVariable(value = "nameOfCategory") String name, @RequestBody CategoryDTO categoryDto) {
		try {
			categoryService.update(name, CategoryConverter.convertToCategory(categoryDto));
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Category not found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Category is updated successfully", HttpStatus.ACCEPTED);
	}

}
