package ru.vallball.prices01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.prices01.dao.CategoryRepository;
import ru.vallball.prices01.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void save(Category category) {
		categoryRepository.save(category);

	}

	@Override
	public List<Category> list() {
		return categoryRepository.findAll();
	}

	@Override
	public void update(String name, Category category) {
		Category categoryForUpdate = categoryRepository.findCategoryByName(name);
		categoryForUpdate.setName(category.getName());
		categoryRepository.save(categoryForUpdate);
	}

	@Override
	public Category findCategoryByName(String name) {
		return categoryRepository.findCategoryByName(name);
	}

	@Override
	public void deleteCategoryByName(String name) {
		long l = categoryRepository.deleteCategoryByName(name);
		if (l == 0) {
			throw new EmptyResultDataAccessException((int) l);
		}
	}

}
