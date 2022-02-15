package pl.maciek.pizzaaplication1.remote.rest.dto.response;

import pl.maciek.pizzaaplication1.domain.model.SizeType;

import java.math.BigDecimal;

public class SizeDto {

    private Integer id;
    private SizeType size;
    private BigDecimal price;

    public SizeDto() {
    }

    public SizeDto(Integer id, SizeType size, BigDecimal price) {
        this.id = id;
        this.size = size;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void SetId(Integer id) {
        this.id = id;
    }


}
