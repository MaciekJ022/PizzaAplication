package pl.maciek.pizzaaplication1.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciek.pizzaaplication1.domain.service.AddOrderService;
import pl.maciek.pizzaaplication1.domain.service.GetOrderService;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.AddOrderDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.OrderCollectionDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.OrderStatusDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.TokenDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/manu", produces = APPLICATION_JSON_VALUE)

public class OrderController {

    private final AddOrderService addOrderService;
    private final GetOrderService getOrderService;

    public OrderController(AddOrderService addOrderService, GetOrderService getOrderService) {
        this.addOrderService = addOrderService;
        this.getOrderService = getOrderService;
    }


    @PostMapping
    public ResponseEntity<TokenDto> addOrder(@RequestBody AddOrderDto addOrderDto){
        TokenDto tokenDto = addOrderService.addOrder(addOrderDto);
        return ResponseEntity.ok(tokenDto);
    }

    @GetMapping("/status/{token}")
    public ResponseEntity<OrderStatusDto> getStatus(@PathVariable("token")String token) {
        OrderStatusDto orderStatusDto = getOrderService.getOrderStatus(token);

        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<OrderCollectionDto> getOrders(@RequestParam("status") OrderStatusDto orderStatus,
                                                        @RequestHeader("Access-Token")String token){

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity<Void> deleteOrders(@PathVariable("order-id")Integer orderId,
                                             @RequestHeader("Acces-Token")String token){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<OrderStatusDto> updateOrders(@RequestHeader("Acces-Token")String token,
                                                       @PathVariable("order-id")Integer orderId,
                                                       @RequestBody OrderStatusDto){
        return ResponseEntity.ok(null);
    }
}
