package ru.vallball.prices01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.prices01.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findCategoryByName(String name);

	public List<Category> findAllByOrderByNameAsc();

	public long deleteCategoryByName(String name);

}
