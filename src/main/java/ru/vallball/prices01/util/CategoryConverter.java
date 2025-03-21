package ru.vallball.prices01.util;

import ru.vallball.prices01.dto.CategoryDTO;
import ru.vallball.prices01.model.Category;

public class CategoryConverter {
	public static Category convertToCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		return category;
	}

	public static CategoryDTO convertToCategoryDto(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setName(category.getName());
		return dto;
	}
}
