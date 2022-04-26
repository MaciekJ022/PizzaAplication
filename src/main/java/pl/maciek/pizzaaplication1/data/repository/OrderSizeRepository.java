package pl.maciek.pizzaaplication1.data.repository;

import pl.maciek.pizzaaplication1.data.entity.ordersize.OrderSizeEntity;
import pl.maciek.pizzaaplication1.data.entity.size.SizeEntity;

public interface OrderSizeRepository{

    void deleteAllByOrderID(Integer orderId);
}
