package com.shubham.brewery.model.events;

import com.shubham.brewery.model.BeerOrderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocateOrderResult {

	private BeerOrderDto beerOrderDto;
	private Boolean allocationError = false;
	private Boolean pendingInventory = false;

}
