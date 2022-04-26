package pl.maciek.pizzaaplication1.domain.service;

import org.springframework.stereotype.Service;
import pl.maciek.pizzaaplication1.data.entity.order.OrderEntity;
import pl.maciek.pizzaaplication1.data.repository.OrderRepository;
import pl.maciek.pizzaaplication1.data.repository.OrderSizeRepository;
import pl.maciek.pizzaaplication1.domain.exeption.UnauthorizedExeption;
import pl.maciek.pizzaaplication1.domain.mapper.OrderMapper;
import pl.maciek.pizzaaplication1.domain.model.OrderStatusType;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.OrderStatusDto;

@Service
public class GetOrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public GetOrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderStatusDto getOrderStatus(String token){

        OrderEntity orderEntity = orderRepository.findByToken(token);
        if(orderEntity == null){
            throw new UnauthorizedExeption("Brak dostepu");
        }

        return orderMapper.mapToOrderStatusDto;
    }
}
