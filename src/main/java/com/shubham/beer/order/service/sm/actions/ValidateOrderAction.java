package com.shubham.beer.order.service.sm.actions;

import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import com.shubham.beer.order.service.config.JmsConfig;
import com.shubham.beer.order.service.domain.BeerOrder;
import com.shubham.beer.order.service.domain.BeerOrderEventEnum;
import com.shubham.beer.order.service.domain.BeerOrderStatusEnum;
import com.shubham.beer.order.service.repositories.BeerOrderRepository;
import com.shubham.beer.order.service.services.impl.BeerOrderManagerImpl;
import com.shubham.beer.order.service.web.mappers.BeerOrderMapper;
import com.shubham.brewery.model.events.ValidateOrderRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValidateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

	private final BeerOrderRepository beerOrderRepository;
	private final BeerOrderMapper beerOrderMapper;
	private final JmsTemplate jmsTemplate;

	@Override
	public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> context) {
		String beerOrderId = (String) context.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
		BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOrderId));

		jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_QUEUE,
				ValidateOrderRequest.builder().beerOrder(beerOrderMapper.beerOrderToDto(beerOrder)).build());

		log.debug("Sent Validation Message to JMS Queue :" + beerOrderId);

	}

}
