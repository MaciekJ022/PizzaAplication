package pl.maciek.pizzaaplication1.remote.rest.dto.request;

import pl.maciek.pizzaaplication1.remote.rest.dto.response.SizeDto;

import java.util.List;

public class PizzaOrderDto {
    public Integer id;
    public List<SizeDto> sizes;
    public Integer count;
}
