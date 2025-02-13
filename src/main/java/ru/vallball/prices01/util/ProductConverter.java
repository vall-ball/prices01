package ru.vallball.prices01.util;

import ru.vallball.prices01.dto.ProductDTO;
import ru.vallball.prices01.model.Product;

public class ProductConverter {
	public static Product convertToProduct (ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setCategory(CategoryConverter.convertToCategory(productDTO.getCategoryDto()));
		product.setManufacturer(ManufacturerConverter.convertToManufacturer(productDTO.getManufacturerDto()));
		product.setWeightInGrams(productDTO.getWeightInGrams());
		return product;
	}

	public static ProductDTO convertToProductDto(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setName(product.getName());
		dto.setCategoryDto(CategoryConverter.convertToCategoryDto(product.getCategory()));
		dto.setManufacturerDto(ManufacturerConverter.convertToManufacturerDto(product.getManufacturer()));
		dto.setWeightInGrams(product.getWeightInGrams());
		return dto;
	}
}
