package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrder;
import guru.sfg.beer.order.service.domain.BeerOrder.BeerOrderBuilder;
import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.web.model.BeerOrderDto;
import guru.sfg.beer.order.service.web.model.BeerOrderDto.BeerOrderDtoBuilder;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import guru.sfg.beer.order.service.web.model.OrderStatusEnum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-09T22:31:16+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 16.0.1 (Oracle Corporation)"
)
public class BeerOrderMapperImpl implements BeerOrderMapper {

    private final DateMapper dateMapper = new DateMapper();
    private final BeerOrderLineMapper beerOrderLineMapper = Mappers.getMapper( BeerOrderLineMapper.class );

    @Override
    public BeerOrderDto beerOrderToDto(BeerOrder beerOrder) {
        if ( beerOrder == null ) {
            return null;
        }

        BeerOrderDtoBuilder beerOrderDto = BeerOrderDto.builder();

        beerOrderDto.beerOrderLines( beerOrderLineSetToBeerOrderLineDtoList( beerOrder.getBeerOrderLines() ) );
        beerOrderDto.createdDate( dateMapper.asOffsetDateTime( beerOrder.getCreatedDate() ) );
        beerOrderDto.customerRef( beerOrder.getCustomerRef() );
        beerOrderDto.id( beerOrder.getId() );
        beerOrderDto.lastModifiedDate( dateMapper.asOffsetDateTime( beerOrder.getLastModifiedDate() ) );
        beerOrderDto.orderStatus( orderStatusEnumToOrderStatusEnum( beerOrder.getOrderStatus() ) );
        beerOrderDto.orderStatusCallbackUrl( beerOrder.getOrderStatusCallbackUrl() );
        if ( beerOrder.getVersion() != null ) {
            beerOrderDto.version( beerOrder.getVersion().intValue() );
        }

        return beerOrderDto.build();
    }

    @Override
    public BeerOrder dtoToBeerOrder(BeerOrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerOrderBuilder beerOrder = BeerOrder.builder();

        beerOrder.beerOrderLines( beerOrderLineDtoListToBeerOrderLineSet( dto.getBeerOrderLines() ) );
        beerOrder.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beerOrder.customerRef( dto.getCustomerRef() );
        beerOrder.id( dto.getId() );
        beerOrder.lastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beerOrder.orderStatus( orderStatusEnumToOrderStatusEnum1( dto.getOrderStatus() ) );
        beerOrder.orderStatusCallbackUrl( dto.getOrderStatusCallbackUrl() );
        if ( dto.getVersion() != null ) {
            beerOrder.version( dto.getVersion().longValue() );
        }

        return beerOrder.build();
    }

    protected List<BeerOrderLineDto> beerOrderLineSetToBeerOrderLineDtoList(Set<BeerOrderLine> set) {
        if ( set == null ) {
            return null;
        }

        List<BeerOrderLineDto> list = new ArrayList<BeerOrderLineDto>( set.size() );
        for ( BeerOrderLine beerOrderLine : set ) {
            list.add( beerOrderLineMapper.beerOrderLineToDto( beerOrderLine ) );
        }

        return list;
    }

    protected OrderStatusEnum orderStatusEnumToOrderStatusEnum(guru.sfg.beer.order.service.domain.OrderStatusEnum orderStatusEnum) {
        if ( orderStatusEnum == null ) {
            return null;
        }

        OrderStatusEnum orderStatusEnum1;

        switch ( orderStatusEnum ) {
            case NEW: orderStatusEnum1 = OrderStatusEnum.NEW;
            break;
            case READY: orderStatusEnum1 = OrderStatusEnum.READY;
            break;
            case PICKED_UP: orderStatusEnum1 = OrderStatusEnum.PICKED_UP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + orderStatusEnum );
        }

        return orderStatusEnum1;
    }

    protected Set<BeerOrderLine> beerOrderLineDtoListToBeerOrderLineSet(List<BeerOrderLineDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<BeerOrderLine> set = new HashSet<BeerOrderLine>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( BeerOrderLineDto beerOrderLineDto : list ) {
            set.add( beerOrderLineMapper.dtoToBeerOrderLine( beerOrderLineDto ) );
        }

        return set;
    }

    protected guru.sfg.beer.order.service.domain.OrderStatusEnum orderStatusEnumToOrderStatusEnum1(OrderStatusEnum orderStatusEnum) {
        if ( orderStatusEnum == null ) {
            return null;
        }

        guru.sfg.beer.order.service.domain.OrderStatusEnum orderStatusEnum1;

        switch ( orderStatusEnum ) {
            case NEW: orderStatusEnum1 = guru.sfg.beer.order.service.domain.OrderStatusEnum.NEW;
            break;
            case READY: orderStatusEnum1 = guru.sfg.beer.order.service.domain.OrderStatusEnum.READY;
            break;
            case PICKED_UP: orderStatusEnum1 = guru.sfg.beer.order.service.domain.OrderStatusEnum.PICKED_UP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + orderStatusEnum );
        }

        return orderStatusEnum1;
    }
}
