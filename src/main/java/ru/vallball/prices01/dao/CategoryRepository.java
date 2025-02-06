package ru.vallball.prices01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.prices01.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
