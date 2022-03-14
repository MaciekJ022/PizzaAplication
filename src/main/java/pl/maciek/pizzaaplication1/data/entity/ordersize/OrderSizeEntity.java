package pl.maciek.pizzaaplication1.data.entity.ordersize;

import pl.maciek.pizzaaplication1.data.entity.order.OrderEntity;

import javax.persistence.*;

@Entity
@Table(name = "orders_sizes")
public class OrderSizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "size_id")
    private Integer size_id;

    @Column(name = "size_count")
    private Integer size_count;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "size_id", insertable = false, updatable = false)
    private OrderEntity size;


}
