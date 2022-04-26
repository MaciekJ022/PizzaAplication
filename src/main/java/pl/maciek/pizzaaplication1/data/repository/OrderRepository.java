package pl.maciek.pizzaaplication1.data.repository;

import pl.maciek.pizzaaplication1.data.entity.order.OrderEntity;

import java.util.List;

public interface OrderRepository {

    OrderEntity findByToken(String token);

    List<OrderEntity> findAllByStatus(String status);
}
