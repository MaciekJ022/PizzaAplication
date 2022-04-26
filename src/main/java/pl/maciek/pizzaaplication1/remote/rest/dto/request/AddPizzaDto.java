package pl.maciek.pizzaaplication1.remote.rest.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddPizzaDto {
    private String name;
    @JsonProperty("sizes")
    private List<AddSizeDto> sizes;

    public AddPizzaDto(String name, List<AddSizeDto> sizes){
        this.name = name;
        this.sizes = sizes;
    }

    public String getName(){
        return name;
    }

    public List<AddSizeDto> getSizes(){
        return sizes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSizes(List<AddSizeDto> sizes) {
        this.sizes = sizes;
    }
}
