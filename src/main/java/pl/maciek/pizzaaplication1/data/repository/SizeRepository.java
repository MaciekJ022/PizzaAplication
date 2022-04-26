package pl.maciek.pizzaaplication1.data.repository;


import java.util.Set;

public interface SizeRepository {
    void deleteAllById(Integer pizzaId);

    boolean existsAllById(Set<Integer> ids);
}
