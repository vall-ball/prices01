package ru.vallball.prices01.dto;

public class RetailerDTO {
	public RetailerDTO() {
	}

	public RetailerDTO(String name) {
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
