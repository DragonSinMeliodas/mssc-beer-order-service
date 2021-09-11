package com.shubham.beer.order.service.services;

import java.util.UUID;

import com.shubham.beer.order.service.domain.BeerOrder;
import com.shubham.brewery.model.BeerOrderDto;

public interface BeerOrderManager {
	BeerOrder newBeerOrder(BeerOrder beerOrder);

	void processValidationResult(UUID beerOrderId, Boolean isValid);

	void beerOrderAllocationPassed(BeerOrderDto beerOrder);

	void beerOrderAllocationPendingInventory(BeerOrderDto beerOrder);

	void beerOrderAllocationFailed(BeerOrderDto beerOrder);
}
