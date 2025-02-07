package ru.vallball.prices01.service;

import java.util.List;

import ru.vallball.prices01.model.Category;

public interface CategoryService {
	void save(Category category);

	List<Category> list();

	void delete(Long id);

	void update(Category category);

	Category findCategoryById(Long id);
	
	Category findCategoryByName(String name);
}
