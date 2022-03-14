package pl.maciek.pizzaaplication1.remote.rest.dto.response;

import pl.maciek.pizzaaplication1.domain.model.OrderStatusType;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.PersonOrderDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.PizzaOrderDto;

import java.util.List;

public class OrderDto {
    private Integer id;
    private OrderStatusType status;
    private List<PizzaOrderDto> pizzas;
    private PersonOrderDto person;

    public OrderDto(Integer id,OrderStatusType status ,List<PizzaOrderDto> pizzas, PersonOrderDto person){
        this.id=id;
        this.status = status;
        this.pizzas = pizzas;
        this.person = person;
    }

    public List<PizzaOrderDto> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaOrderDto> pizzas) {
        this.pizzas = pizzas;
    }

    public PersonOrderDto getPerson() {
        return person;
    }

    public void setPerson(PersonOrderDto person) {
        this.person = person;
    }
}
