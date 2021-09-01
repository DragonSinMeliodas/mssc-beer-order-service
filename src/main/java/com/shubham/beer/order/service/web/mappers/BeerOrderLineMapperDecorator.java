package com.shubham.beer.order.service.web.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.shubham.beer.order.service.domain.BeerOrderLine;
import com.shubham.beer.order.service.services.beer.BeerService;
import com.shubham.beer.order.service.web.model.BeerDto;
import com.shubham.beer.order.service.web.model.BeerOrderLineDto;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

	private BeerService beerService;
	private BeerOrderLineMapper beerOrderLineMapper;

	// Setter Injection
	@Autowired
	public void setBeerService(BeerService beerService) {
		this.beerService = beerService;
	}

	@Autowired
	@Qualifier("delegate")
	public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
		this.beerOrderLineMapper = beerOrderLineMapper;
	}

	@Override
	public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
		BeerOrderLineDto orderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
		Optional<BeerDto> beerDtoOptional = beerService.getBeerByUpc(line.getUpc());

		beerDtoOptional.ifPresent(beerDto -> {
			orderLineDto.setBeerName(beerDto.getBeerName());
			orderLineDto.setBeerStyle(beerDto.getBeerStyle());
			orderLineDto.setPrice(beerDto.getPrice());
			orderLineDto.setBeerId(beerDto.getId());
		});

		return orderLineDto;
	}

}
