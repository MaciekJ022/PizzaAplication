package pl.maciek.pizzaaplication1.domain.mapper;


import org.springframework.stereotype.Component;
import pl.maciek.pizzaaplication1.data.entity.order.OrderEntity;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.TokenDto;

@Component
public class TokenMapper {

    public TokenDto mapTOTokenDto(OrderEntity orderEntity){
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(orderEntity.getToken());
        return tokenDto;
    }
}
