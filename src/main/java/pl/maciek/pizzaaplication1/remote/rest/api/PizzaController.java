package pl.maciek.pizzaaplication1.remote.rest.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciek.pizzaaplication1.domain.service.PizzaService;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.AddPizzaDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.PizzaDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/pizzas", produces = APPLICATION_JSON_VALUE)
@RestController
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService){this.pizzaService = pizzaService;}

    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestBody AddPizzaDto addPizzaDto,
                                             @RequestHeader("Access-Token") String token){
        PizzaDto pizzaDto = pizzaService.addPizza(addPizzaDto,token);
        return ResponseEntity.ok(pizzaDto);
    }
}
