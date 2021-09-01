package com.shubham.beer.order.service.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import com.shubham.beer.order.service.domain.BeerOrderLine;
import com.shubham.beer.order.service.web.model.BeerOrderLineDto;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerOrderLineMapperDecorator.class)
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
