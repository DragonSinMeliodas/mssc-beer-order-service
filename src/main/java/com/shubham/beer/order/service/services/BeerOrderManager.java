package com.shubham.beer.order.service.services;

import java.util.UUID;

import com.shubham.beer.order.service.domain.BeerOrder;

public interface BeerOrderManager {
	BeerOrder newBeerOrder(BeerOrder beerOrder);

	void processValidationResult(UUID beerOrderId, Boolean isValid);
}
