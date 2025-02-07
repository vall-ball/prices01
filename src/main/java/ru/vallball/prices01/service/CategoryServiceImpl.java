package ru.vallball.prices01.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.prices01.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
