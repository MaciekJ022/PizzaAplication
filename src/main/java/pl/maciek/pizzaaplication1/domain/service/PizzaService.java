package pl.maciek.pizzaaplication1.domain.service;

import org.springframework.stereotype.Service;
import pl.maciek.pizzaaplication1.data.entity.pizza.PizzaEntity;
import pl.maciek.pizzaaplication1.data.entity.size.SizeEntity;
import pl.maciek.pizzaaplication1.data.repository.PizzaRepository;
import pl.maciek.pizzaaplication1.data.repository.SizeRepository;
import pl.maciek.pizzaaplication1.domain.exeption.ResourseNotFoundExeption;
import pl.maciek.pizzaaplication1.domain.mapper.PizzaMapper;
import pl.maciek.pizzaaplication1.domain.mapper.SizeMapper;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.AddPizzaDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.AddSizeDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.request.UpdatePizzaDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.MenuDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.PizzaDto;
import pl.maciek.pizzaaplication1.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

import static pl.maciek.pizzaaplication1.domain.service.AuthorizationService.checkToken;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRespository;
    private final PizzaMapper pizzaMapper;
    private final SizeMapper sizeMapper;

    public PizzaService(PizzaRepository pizzaRepository, SizeRespository sizeRespository,
                        PizzaMapper pizzaMapper, SizeMapper sizeMapper){
        this.pizzaRepository = pizzaRepository;
        this.sizeRespository = sizeRespository;
        this.pizzaMapper = pizzaMapper;
        this.sizeMapper = sizeMapper;
    }

    public PizzaDto (AddPizzaDto addPizzaDto, String token){

        checkToken(token);

        PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaEntity);

        /*PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(addPizzaDto.getName());
        PizzaEntity savedPizzaEntity = PizzaRepository.save(pizzaEntity);
         */

        List<AddSizeDto> addSizeDtoList = addPizzaDto.getAddSizeDtoList();
        List<SizeEntity> sizeEntities = addSizeDtoList
          .stream()
          .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId()))
          .collect(Collectors.toList());
        sizeRepository.saveAll(sizeEntities);

        List<SizeDto> SizeDtoList = savedSizeEntities
                .stream()
                .map(SizeEntity -> {
                    SizeDto sizeDto = new SizeDto();
                    sizeDto.set
                });
        /*
         SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setSizeType(SizeDto.getSize().name());
        sizeEntity.setPriceBase(SizeDto.getPrice());
        sizeEntity.setId(SizeDto.getId());
        sizeEntity.setPizzaId(SavedPizzaEntity.getId());
        return sizeEntity;
        }).collect(Collectors.toList());
        PizzaEntity SavedPizzaEntity = sizeRepository.saveAll(sizeEntity);
        */
        return pizzaMapper.mapToPizzaDto(pizzaEntity, SizeDtoList);
        }

        public MenuDto getMenu(){

            List<PizzaEntity> pizzaEntities = pizzaRepository.findAll();
            List<PizzaDto> pizzaDtoList = pizzaEntities
                    .stream()
                    .map(pizzaEntity -> pizzaMapper.mapToPizzaDto(pizzaEntity))
                    .collect(Collectors.toList());

            return new MenuDto(pizzaDtoList);
        }

        public void deletePizza(Integer pizzaId, String token){
            checkToken(token);
            boolean pizzaExist = pizzaRepository.existsById(pizzaId);
            if (!pizzaExist){
                throw new ResourseNotFoundExeption("Pizza o podanym Id nie istnieje");
            }
            pizzaRepository.deleteById(pizzaId);
        }

        public PizzaDto updeatePizza(UpdatePizzaDto updatePizzaDto, String token, Integer pizzaId){
            checkToken(token);
            boolean pizzaExist = pizzaRepository.existsById(pizzaId);
            if (!pizzaExist){
                throw new ResourseNotFoundExeption("Pizza o podanym Id nie istnieje");
            }
            PizzaEntity pizzaEntity = pizzaRepository.existsById(pizzaId);
            pizzaEntity.SetName(updatePizzaDto.getName());
            pizzaRepository.save(pizzaEntity);

            sizeRespository.deleteAllById(pizzaId);

            List<AddSizeDto> addSizeDtoList = updatePizzaDto.getSizes();
            List<SizeEntity> sizeEntities = addSizeDtoList
                    .stream()
                    .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaId))
                    .collect(Collectors.toList());
            sizeRespository.saveAll(sizeEntities);


            List<SizeDto> sizeDtoList = sizeEntities.stream()
                    .map(sizeMapper::mapToSizeDto)
                    .collect(Collectors.toList());

            return pizzaMapper.mapToPizzaDto(pizzaEntity, sizeDtoList);
        }
}

