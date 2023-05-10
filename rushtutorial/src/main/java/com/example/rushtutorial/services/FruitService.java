package com.example.rushtutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.FruitEntity;
import com.example.rushtutorial.repositories.FruitRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // mark that bin like a service by annotation "@Service"
public class FruitService {

    private final FruitRepository fruitRepository; // final repository variable

    // public FruitService(FruitRepository fruitRepository) { // inject dependency via constructor
    //     this.fruitRepository = fruitRepository;
    // }

    // created public method (with any name)
    // The method get entity and save it on DB
    public void save(FruitEntity fruitEntity) {
        fruitRepository.save(fruitEntity); // method implementation of injected bean 
    }

    // getting back all entities from DB
    public List<FruitEntity> getAll() {
        return fruitRepository.findAll(); // method implementation of injected bean 
    }

    public void saveAll(List<FruitEntity> fruitEntityList) {
        fruitRepository.saveAll(fruitEntityList);
    }
    
}
