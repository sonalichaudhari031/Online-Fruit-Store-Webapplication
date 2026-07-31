package com.example.online.fruit.store.service;

import org.springframework.stereotype.Service;
import com.example.online.fruit.store.Repository.FruitRepository;
import com.example.online.fruit.store.Entity.Fruit;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    // 1. Naya fruit save karne ke liye
    public Fruit saveFruit(Fruit fruit) {
        fruit.setAvailable(fruit.getQuantity() > 0);
        return fruitRepository.save(fruit);
    }

    // 2. Shop ID ke hisaab se fruits lane ke liye
    public List<Fruit> getFruitsByShopId(Long shopId) {
        return fruitRepository.findByShop_Id(shopId); 
    }

    // 3. Saare fruits lane ke liye (Dashboard ke liye)
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    // 4. Single Fruit Details nikalne ke liye (Isi method ki wajah se 500 error aa raha tha)
    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found with id: " + id));
    }

    // 5. Update karne ke liye
    public Fruit updateFruit(Long id, Fruit updatedFruit) {
        return fruitRepository.findById(id).map(fruit -> {
            fruit.setName(updatedFruit.getName());
            fruit.setPrice(updatedFruit.getPrice());
            fruit.setImg(updatedFruit.getImg());
            fruit.setDescription(updatedFruit.getDescription());
            fruit.setQuantity(updatedFruit.getQuantity());
            fruit.setUnit(updatedFruit.getUnit());
            fruit.setAvailable(updatedFruit.getQuantity() > 0);
            fruit.setShop(updatedFruit.getShop());
            return fruitRepository.save(fruit);
        }).orElseThrow(() -> new RuntimeException("Fruit not found"));
    }

    // 6. Delete karne ke liye
    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }
}