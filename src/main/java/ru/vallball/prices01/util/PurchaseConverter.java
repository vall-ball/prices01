package ru.vallball.prices01.util;

import ru.vallball.prices01.dto.PurchaseDTO;
import ru.vallball.prices01.model.Purchase;

public class PurchaseConverter {
	public static Purchase convertToPurchase(PurchaseDTO purchaseDto) {
		Purchase purchase = new Purchase();
		purchase.setDate(purchaseDto.getDate());
		purchase.setPrice(purchaseDto.getPrice());
		purchase.setProduct(ProductConverter.convertToProduct(purchaseDto.getProductDto()));
		purchase.setRetailer(RetailerConverter.convertToRetailer(purchaseDto.getRetailerDto()));
		return purchase;
	}

	public static PurchaseDTO convertToPurchaseDto(Purchase purchase) {
		PurchaseDTO dto = new PurchaseDTO();
		dto.setId(purchase.getId());
		dto.setDate(purchase.getDate());
		dto.setPrice(purchase.getPrice());
		dto.setProductDto(ProductConverter.convertToProductDto(purchase.getProduct()));
		dto.setRetailerDto(RetailerConverter.convertToRetailerDto(purchase.getRetailer()));
		return dto;
	}

}
