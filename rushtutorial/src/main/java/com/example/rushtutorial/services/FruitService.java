package com.example.rushtutorial.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
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

    // save all fruit entities as list
    public void saveAll(List<FruitEntity> fruitEntityList) {
        fruitRepository.saveAll(fruitEntityList);
    }

    // get back entity instance by id 
    public Optional<FruitEntity> getById(Integer id) {
        return fruitRepository.findById(id);
    }

    // delete entity instance by id
    public void deleteById(Integer id) {
        fruitRepository.deleteById(id);
    }

    // возвращает true or false при поиске в таблице Фруктов объекта который 
    // соответствует типу FruitEntity или принадлежит к типу объекта который
    // наследуется от FruitEntity 
    public Boolean exist(Example<? extends FruitEntity> example) {
        return fruitRepository.exists(example);
    }

    public List<FruitEntity> between(Integer from, Integer to) {
        
        return new ArrayList<>();
    }

    
    
}
