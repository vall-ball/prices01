package ru.vallball.prices01.util;

import ru.vallball.prices01.dto.ManufacturerDTO;
import ru.vallball.prices01.model.Manufacturer;

public class ManufacturerConverter {
	public static Manufacturer convertToManufacturer(ManufacturerDTO manufacturerDTO) {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setName(manufacturerDTO.getName());
		return manufacturer;
	}

	public static ManufacturerDTO convertToManufacturerDto(Manufacturer manufacturer) {
		ManufacturerDTO dto = new ManufacturerDTO();
		dto.setName(manufacturer.getName());
		return dto;
	}
}
