package com.shubham.beer.order.service.services;

import com.shubham.beer.order.service.domain.BeerOrder;

public interface BeerOrderManager {
	BeerOrder newBeerOrder(BeerOrder beerOrder);
}
