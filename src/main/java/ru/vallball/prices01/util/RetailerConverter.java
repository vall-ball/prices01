package ru.vallball.prices01.util;

import ru.vallball.prices01.dto.RetailerDTO;
import ru.vallball.prices01.model.Retailer;

public class RetailerConverter {
	public static Retailer convertToRetailer(RetailerDTO retailerDTO) {
		Retailer retailer = new Retailer();
		retailer.setName(retailerDTO.getName());
		return retailer;
	}

	public static RetailerDTO convertToRetailerDto(Retailer retailer) {
		RetailerDTO dto = new RetailerDTO();
		dto.setName(retailer.getName());
		return dto;
	}
}
