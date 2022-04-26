package pl.maciek.pizzaaplication1.domain.mapper;

import org.springframework.stereotype.Component;
import pl.maciek.pizzaaplication1.data.entity.size.SizeEntity;
import pl.maciek.pizzaaplication1.domain.model.SizeType;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.AddSizeDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.SizeDto;

import java.util.List;

@Component
public class SizeMapper {

    public SizeEntity mapToSizeEntity(AddSizeDto addSizeDto,Integer pizzaId ){
        SizeEntity sizeEntity = new sizeEntity;
        sizeEntity.setSizeType(SizeDto.getSize().name());
        sizeEntity.setPriceBase(SizeDto.getPrice());
        sizeEntity.setId(SizeDto.getId());
        sizeEntity.setPizzaId(SavedPizzaEntity.getId());
        return sizeEntity;
    }

    public SizeDto mapToSizeDto(SizeEntity sizeEntity){
        SizeDto sizeDto = new SizeDto();
        sizeDto.setSize(SizeType.valueOf(sizeEntity.getSizeType()));
        sizeDto.setPrice(sizeEntity.getPriceBase());
        return sizeDto;
    }

}
