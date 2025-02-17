package ru.vallball.prices01.dto;



public class ProductDTO {
	
	public ProductDTO(String name, ManufacturerDTO manufacturerDto, CategoryDTO categoryDto, int weightInGrams) {
		this.name = name;
		this.manufacturerDto = manufacturerDto;
		this.categoryDto = categoryDto;
		this.weightInGrams = weightInGrams;
	}
	public ProductDTO() {
		
	}
	

	private String name;

	private ManufacturerDTO manufacturerDto;

	private CategoryDTO categoryDto;

	private int weightInGrams;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManufacturerDTO getManufacturerDto() {
		return manufacturerDto;
	}

	public void setManufacturerDto(ManufacturerDTO manufacturerDto) {
		this.manufacturerDto = manufacturerDto;
	}

	public CategoryDTO getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDTO categoryDto) {
		this.categoryDto = categoryDto;
	}

	public int getWeightInGrams() {
		return weightInGrams;
	}

	public void setWeightInGrams(int weightInGrams) {
		this.weightInGrams = weightInGrams;
	}
}
