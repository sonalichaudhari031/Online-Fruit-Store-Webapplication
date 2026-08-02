package com.example.online.fruit.store.Repository;

import com.example.online.fruit.store.Entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findByShop_Id(Long shopId);

    List<Fruit> findByAvailableTrue();
}
