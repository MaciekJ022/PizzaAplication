package pl.maciek.pizzaaplication1.remote.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.OrderCollectionDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.OrderStatusDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/manu", produces = APPLICATION_JSON_VALUE)

public class OrderController {
    @PostMapping
    public ResponseEntity<OrderStatusDto> getStatus(@PathVariable("token")String token) {

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
