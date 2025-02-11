package ru.vallball.prices01.service;

import java.util.List;

import ru.vallball.prices01.model.Category;

public interface CategoryService {
	void save(Category category);

	List<Category> list();

	void update(String name, Category category);
	
	Category findCategoryByName(String name);
	
	void deleteCategoryByName(String name);
}
