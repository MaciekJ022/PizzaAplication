package pl.maciek.pizzaaplication1.domain.service;

import pl.maciek.pizzaaplication1.data.entity.order.OrderEntity;
import pl.maciek.pizzaaplication1.data.entity.ordersize.OrderSizeEntity;
import pl.maciek.pizzaaplication1.data.repository.OrderRepository;
import pl.maciek.pizzaaplication1.data.repository.OrderSizeRepository;
import pl.maciek.pizzaaplication1.data.repository.SizeRepository;
import pl.maciek.pizzaaplication1.domain.exeption.ResourseNotFoundExeption;
import pl.maciek.pizzaaplication1.domain.mapper.TokenMapper;
import pl.maciek.pizzaaplication1.domain.model.OrderStatusType;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.AddOrderDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.PersonOrderDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.PizzaOrderDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.OrderStatusDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.TokenDto;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class AddOrderService {

    private final OrderSizeRepository orderSizeEntity;
    private final SizeRepository sizeRespository;
    private final OrderRepository orderRepository;
    private final TokenMapper tokenMapper;


    public AddOrderService(OrderSizeRepository orderSizeEntity,SizeRepository sizeRespository, OrderRepository orderRepository, TokenMapper tokenMapper) {
        this.orderSizeEntity = orderSizeEntity;
        this.sizeRespository = sizeRespository;
        this.orderRepository = orderRepository;
        this.tokenMapper = tokenMapper;
    }

    public TokenDto addOrder(AddOrderDto addOrderDto){

        Set<Integer> sizeIds = addOrderDto.getPizzas()
                .stream()
                .map(pizzaOrderDto -> pizzaOrderDto.getSizeId())
                .collect(Collectors.toSet());
        boolean existSizes = sizeRespository.existsAllById(sizeIds);
        if (!existSizes){
            throw new ResourseNotFoundExeption("Pizze o podanym rozmiarze nie istnieja w bazie danych");
        }

        String token = UUID.randomUUID().toString();

        Date now = new Date();
        PersonOrderDto person = addOrderDto.getPersonOrderDto();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setClientName(person.getName());
        orderEntity.setClientAddress(person.getAddress());
        orderEntity.setClientPhone(person.getPhone());
        orderEntity.setClientFloor(person.getFloor());
        orderEntity.setStatus(OrderStatusType.NEW.name());
        orderEntity.setCreatedAt(now);
        orderEntity.setUpdatedAt(now);
        orderRepository.save(orderEntity);

        Integer orderId = orderEntity.getId();

        List<PizzaOrderDto> pizzaOrderDtoList = addOrderDto.getPizzas();
        List<OrderSizeEntity> orderSizeEntities = pizzaOrderDtoList
                .stream()
                .map(pizzaOrderDto -> {
                    OrderSizeEntity orderSizeEntity = new OrderSizeEntity();
                    orderSizeEntity.setSizeId(pizzaOrderDto.getSizeId());
                    orderEntity.setOrderId(orderId);
                    orderSizeEntity.setSizeCount(pizzaOrderDto.getCount());
                    return orderSizeEntity;
                }).collect(Collectors.toList());
        orderSizeRespository.saveAll(orderSizeEntity);


        TokenDto tokenDto = new TokenDto();
        TokenDto.setToken(token);

        return tokenMapper.mapToTokenDto(orderEntity);



    }
}
