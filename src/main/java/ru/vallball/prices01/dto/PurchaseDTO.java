package ru.vallball.prices01.dto;

import java.time.LocalDate;

public class PurchaseDTO {
	
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private ProductDTO productDto;

	private LocalDate date;

	private RetailerDTO retailerDto;

	private int price;

	public ProductDTO getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDTO productDto) {
		this.productDto = productDto;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public RetailerDTO getRetailerDto() {
		return retailerDto;
	}

	public void setRetailerDto(RetailerDTO retailerDto) {
		this.retailerDto = retailerDto;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
