package ru.vallball.prices01.dto;

public class ManufacturerDTO {
	public ManufacturerDTO() {
		
	}

	public ManufacturerDTO(String name) {
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
