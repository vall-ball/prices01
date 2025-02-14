package ru.vallball.prices01.dto;

public class CategoryDTO {

	public CategoryDTO() {

	}

	public CategoryDTO(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
