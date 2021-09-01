package com.shubham.beer.order.service.services.beer;

import java.util.Optional;
import java.util.UUID;

import com.shubham.brewery.model.BeerDto;

public interface BeerService {

	Optional<BeerDto> getBeerById(UUID uuid);

	Optional<BeerDto> getBeerByUpc(String upc);

}
